package com.iot.runnable;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.iot.bean.*;
import com.iot.service.*;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DataRunnable implements Runnable {
    private EdataService edataService;
    private EorderService eorderService;
    private EattrService eattrService;
    private EdeviceService edeviceService;
    private EuserdeviceService euserdeviceService;
    private EuserthresholdService euserthresholdService;
    private EroomService eroomService;
    private EbimService ebimService;
    private EthresholdService ethresholdService;
    private Integer id;

    public DataRunnable(Integer id, EdataService edataService, EorderService eorderService, EattrService eattrService, EdeviceService edeviceService, EuserdeviceService euserdeviceService, EuserthresholdService euserthresholdService, EroomService eroomService, EbimService ebimService, EthresholdService ethresholdService){
        this.edataService = edataService;
        this.eorderService = eorderService;
        this.eattrService = eattrService;
        this.edeviceService = edeviceService;
        this.euserdeviceService = euserdeviceService;
        this.euserthresholdService = euserthresholdService;
        this.eroomService = eroomService;
        this.ebimService = ebimService;
        this.ethresholdService = ethresholdService;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(id);
        List<Eattr> attrList = eattrService.selectBySql("sensorid=" + id);
        List<Edevice> deviceList = edeviceService.selectBySql("sensorid=" + id);
        for(int i = 0; i < deviceList.size(); i++){
            try {
                MqttClient client = new MqttClient("tcp://129.204.174.96:3883", "wuliantiandi", new MemoryPersistence());
                MqttConnectOptions options = new MqttConnectOptions();
                options.setCleanSession(true);
                options.setUserName("wuliantiandi");
                options.setPassword("GHkAHs8421La".toCharArray());
                options.setConnectionTimeout(10);
                options.setKeepAliveInterval(20);
                client.setCallback(new MqttCallback() {
                    public void connectionLost(Throwable cause) {
                        System.out.println("connectionLost");
                    }
                    public void messageArrived(String topic, MqttMessage message) throws Exception {
                        JSONObject res = JSONObject.parseObject(new String(message.getPayload()));
                        String mac = res.getString("mac");
                        if(mac != null && !mac.isEmpty()){
                            List<Edevice> devices = edeviceService.selectBySql("sensorid=" + id + " and protocol='" + mac + "'");
                            if(devices.size() > 0){
                                Integer deviceid = devices.get(0).getId();
                                for(int j = 0; j < attrList.size(); j++){
                                    String dataItem = res.getString(attrList.get(j).getProtocol());
                                    if(dataItem != null && !dataItem.isEmpty()){
                                        Integer attrid = attrList.get(j).getId();
                                        SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                                        String time = frm.format(new Date());
                                        Edatav data = edataService.insert(dataItem, deviceid, attrid, time, "");
                                        Edevicev device = edeviceService.selectVByPrimaryKey(deviceid);
                                        String orderItem = device.getRoom().getBim().getPlat().getItem() + " "
                                                + device.getRoom().getBim().getItem() + " " + device.getRoom().getItem() + " "
                                                + device.getSensor().getItem() + " " + device.getItem() + "" + attrList.get(j).getItem();
                                        int level = 0;
                                        List<Ethreshold> thresholdList = ethresholdService.selectBySql("attrid=" + attrList.get(j).getId() + " order by level asc");
                                        for(int k = 0; k < thresholdList.size(); k++){
                                            if(attrList.get(j).getCompare().equals(">") && Integer.parseInt(dataItem) > Integer.parseInt(thresholdList.get(k).getItem()) ||
                                                    attrList.get(j).getCompare().equals("<") && Integer.parseInt(dataItem) < Integer.parseInt(thresholdList.get(k).getItem()) ||
                                                    attrList.get(j).getCompare().equals(">=") && Integer.parseInt(dataItem) >= Integer.parseInt(thresholdList.get(k).getItem()) ||
                                                    attrList.get(j).getCompare().equals("<=") && Integer.parseInt(dataItem) <= Integer.parseInt(thresholdList.get(k).getItem()) ||
                                                    attrList.get(j).getCompare().equals("=") && Integer.parseInt(dataItem) == Integer.parseInt(thresholdList.get(k).getItem())){
                                                level = thresholdList.get(k).getLevel();
                                            }
                                        }
                                        if(level > 0) {
                                            orderItem += " 告警";
                                            List<Eorder> orderList = eorderService.selectBySql("item='" + orderItem + "' and status!='完成' order by time desc");
                                            if (orderList.size() > 0) {
                                                Eorder order = orderList.get(0);
                                                if (order.getLevel() < level) {
                                                    order = eorderService.insert(orderItem, data.getId(), null, "告警", level, "正常", time, "");
                                                    if(order != null) {
                                                        sendMsgs(deviceid, attrid, orderItem, level, time);
                                                        setAllStatus(deviceid);
                                                    }
                                                }
                                            } else {
                                                Eorder order = eorderService.insert(orderItem, data.getId(), null, "告警", level, "正常", time, "");
                                                if(order != null) {
                                                    sendMsgs(deviceid, attrid, orderItem, level, time);
                                                    setAllStatus(deviceid);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    public void deliveryComplete(IMqttDeliveryToken token) {
                        System.out.println("deliveryComplete---------"+ token.isComplete());
                    }
                });
                client.connect(options);
                client.subscribe(deviceList.get(i).getProtocol(), 1);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsgs(Integer deviceid, Integer attrid, String item, Integer level, String time){
        List<Euserdevicev> userdeviceList = euserdeviceService.selectVBySql("deviceid=" + deviceid);
        String phone = "";
        for(int i = 0; i < userdeviceList.size(); i++){
            List<Euserthresholdv> userthresholdList = euserthresholdService.selectVByUserAttr(userdeviceList.get(i).getUserid(), attrid);
            if(userthresholdList.size() > 0){
                Euserthresholdv userthreshold = userthresholdList.get(0);
                if(level >= userthreshold.getThreshold().getLevel()){
                    sendMsg(userdeviceList.get(i).getUser().getPhone(), item, level ,time);
                }
            }else{
                sendMsg(userdeviceList.get(i).getUser().getPhone(), item, level ,time);
            }
        }
    }

    public void sendMsg(String phone, String item, Integer level, String time){
        if(phone != null && !phone.isEmpty()){
            DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIXpoDTXW3Cvat", "0nsk97XkQwGAe8DZLg4rLp5qtBvN8Z");
            IAcsClient client = new DefaultAcsClient(profile);
            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain("dysmsapi.aliyuncs.com");
            request.setVersion("2017-05-25");
            request.setAction("SendSms");
            request.putQueryParameter("PhoneNumbers", phone);
            request.putQueryParameter("SignName", "物联天地");
            request.putQueryParameter("TemplateCode", "SMS_158547302");
            request.putQueryParameter("TemplateParam", "{\"item\":\"" + item + "\", \"level\": " + level + ", \"time\":\"" + time + "\"}");
            try {
                CommonResponse response = client.getCommonResponse(request);
                JSONObject data = JSONObject.parseObject(response.getData());
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAllStatus(Integer deviceid){
        List<Eorderv> list = eorderService.selectVByDevice(deviceid);
        String status = "正常";
        int level = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getStatus().equals("告警")) {
                status = "告警";
                if(list.get(i).getLevel() > level)
                    level = list.get(i).getLevel();
            }else if(list.get(i).getStatus().equals("维修")){
                if(status.equals("正常"))
                    status = "维修";
                if(list.get(i).getLevel() > level)
                    level = list.get(i).getLevel();
            }
        }
        Edevicev device = edeviceService.selectVByPrimaryKey(deviceid);
        device = edeviceService.update(device.getId(), device.getItem(), device.getSensorid(), device.getRoomid(), device.getProtocol(), status, level, device.getNote());
        if(device != null) {
            List<Edevicev> deviceList = edeviceService.selectVBySql("roomid=" + device.getRoomid());
            status = "正常";
            level = 0;
            for(int i = 0; i < deviceList.size(); i++){
                if(deviceList.get(i).getStatus().equals("告警")) {
                    status = "告警";
                    if(deviceList.get(i).getLevel() > level)
                        level = deviceList.get(i).getLevel();
                }else if(deviceList.get(i).getStatus().equals("维修")){
                    if(status.equals("正常"))
                        status = "维修";
                    if(deviceList.get(i).getLevel() > level)
                        level = deviceList.get(i).getLevel();
                }
            }
            Eroomv room = eroomService.selectVByPrimaryKey(device.getRoomid());
            room = eroomService.update(room.getId(), room.getItem(), room.getBimid(), status, level, room.getModelfile(), room.getNote());
            if(room != null){
                List<Eroomv> roomList = eroomService.selectVBySql("bimid=" + room.getBimid());
                status = "正常";
                level = 0;
                for(int i = 0; i < roomList.size(); i++){
                    if(roomList.get(i).getStatus().equals("告警")) {
                        status = "告警";
                        if(roomList.get(i).getLevel() > level)
                            level = roomList.get(i).getLevel();
                    }else if(roomList.get(i).getStatus().equals("维修")){
                        if(status.equals("正常"))
                            status = "维修";
                        if(roomList.get(i).getLevel() > level)
                            level = roomList.get(i).getLevel();
                    }
                }
                Ebimv bim = ebimService.selectVByPrimaryKey(room.getBimid());
                ebimService.update(bim.getId(), bim.getItem(), bim.getPlatid(), bim.getLongitude(), bim.getLatitude(), status, level, bim.getModelfile(), bim.getNote());
            }
        }
    }
}
