package com.iot.action;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/common")
public class CommonAction {
    @Resource
    private EdeviceService edeviceService;
    @Resource
    private EroomService eroomService;
    @Resource
    private EbimService ebimService;
    @Resource
    private EsensorService esensorService;
    @Resource
    private EattrService eattrService;
    @Resource
    private EthresholdService ethresholdService;
    @Resource
    private EdataService edataService;
    @Resource
    private EorderService eorderService;
    @Resource
    private EuserdeviceService euserdeviceService;
    @Resource
    private EuserthresholdService euserthresholdService;
    private static MqttClient client;

    @RequestMapping(value = "/start")
    public Map<Object, Object> start(Integer projectid) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        List<Esensor> sensorList = esensorService.selectSubAll(projectid);
        List<Integer> sensoridList = new ArrayList<Integer>();
        for(int i = 0; i < sensorList.size(); i++){
            if(sensorList.get(i).getProtocol().equals("smoke") || sensorList.get(i).getProtocol().equals("gas")){
                sensoridList.add(sensorList.get(i).getId());
            }
        }
        map = smokeAndGas(sensoridList);
        return map;
    }

    public Map<Object, Object> smokeAndGas(List<Integer> sensoridList){
        Map<Object, Object> map = new HashMap<Object, Object>();
        String sql = "";
        for(int i = 0; i < sensoridList.size(); i++){
            if(i > 0)
                sql += " or ";
            sql += "sensorid=" + sensoridList.get(i);
        }
        if(!sql.isEmpty()) {
            List<Edevice> deviceList = edeviceService.selectBySql(sql);
            if(deviceList.size() > 0){
                String[] topic = new String[deviceList.size()];
                int[] QoS  = new int[deviceList.size()];
                for(int i = 0; i < deviceList.size(); i++){
                    topic[i] = deviceList.get(i).getProtocol();
                    QoS[i] = 2;
                }
                map.put("topic", topic);
                try {
                    if(client != null)
                        client.disconnect();
                    client = new MqttClient("tcp://129.204.174.96:3883", "wuliantiandi", new MemoryPersistence());
                    MqttConnectOptions options = new MqttConnectOptions();
                    options.setCleanSession(true);
                    options.setUserName("wuliantiandi");
                    options.setPassword("GHkAHs8421La".toCharArray());
                    options.setConnectionTimeout(10);
                    options.setKeepAliveInterval(20);
                    client.connect(options);
                    client.subscribe(topic, QoS);
                    client.setCallback(new MqttCallback() {
                        public void connectionLost(Throwable cause) {
                            System.out.println("connectionLost");
                        }
                        public void messageArrived(String topic, MqttMessage message) throws Exception {
                            JSONObject res = JSONObject.parseObject(new String(message.getPayload()));
                            String deviceProtocol = res.getString("mac");
                            String sensorProtocol = res.getString("serviceType");
                            if(deviceProtocol != null && !deviceProtocol.isEmpty()){
                                List<Edevicev> deviceList = edeviceService.selectVBySql("protocol like '%" + deviceProtocol + "%'");
                                if(deviceList.size() > 0){
                                    Edevicev device = deviceList.get(0);
                                    List<Eattr> attrList = eattrService.selectBySql("sensorid=" + device.getSensorid());
                                    for(int i = 0; i < attrList.size(); i++){
                                        String dataItem = res.getString(attrList.get(i).getProtocol());
                                        if(dataItem != null && !dataItem.isEmpty()) {
                                            if(attrList.get(i).getProtocol().equals("alarmType")) {
                                                if(sensorProtocol.equals("smoke")){
                                                    if(dataItem.equals("15") || dataItem.equals("20"))
                                                        dataItem = "1";
                                                    else if(dataItem.equals("69") || dataItem.equals("102") || dataItem.equals("194"))
                                                        dataItem = "2";
                                                    else if(dataItem.equals("14"))
                                                        dataItem = "3";
                                                    else if(dataItem.equals("67"))
                                                        dataItem = "4";
                                                    else if(dataItem.equals("193"))
                                                        dataItem = "5";
                                                    else if(dataItem.equals("202"))
                                                        dataItem = "6";
                                                    else
                                                        dataItem = "0";
                                                }else if(sensorProtocol.equals("gas")){
                                                    if(dataItem.equals("136"))
                                                        dataItem = "1";
                                                    else if(dataItem.equals("76"))
                                                        dataItem = "2";
                                                    else if(dataItem.equals("2"))
                                                        dataItem = "3";
                                                    else
                                                        dataItem = "0";
                                                }
                                            }
                                            SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                                            String time = frm.format(new Date());
                                            Edatav data = edataService.insert(dataItem, device.getId(), attrList.get(i).getId(), time, "");
                                            String orderItem = device.getRoom().getBim().getPlat().getItem() + " "
                                                    + device.getRoom().getBim().getItem() + " " + device.getRoom().getItem() + " "
                                                    + device.getSensor().getItem() + " " + device.getItem() + "" + attrList.get(i).getItem();
                                            int level = 0;
                                            List<Ethreshold> thresholdList = ethresholdService.selectBySql("attrid=" + attrList.get(i).getId() + " order by level asc");
                                            for(int j = 0; j < thresholdList.size(); j++){
                                                if(attrList.get(i).getCompare().equals(">") && Integer.parseInt(dataItem) > Integer.parseInt(thresholdList.get(j).getItem()) ||
                                                        attrList.get(i).getCompare().equals("<") && Integer.parseInt(dataItem) < Integer.parseInt(thresholdList.get(j).getItem()) ||
                                                        attrList.get(i).getCompare().equals(">=") && Integer.parseInt(dataItem) >= Integer.parseInt(thresholdList.get(j).getItem()) ||
                                                        attrList.get(i).getCompare().equals("<=") && Integer.parseInt(dataItem) <= Integer.parseInt(thresholdList.get(j).getItem()) ||
                                                        attrList.get(i).getCompare().equals("=") && Integer.parseInt(dataItem) == Integer.parseInt(thresholdList.get(j).getItem())){
                                                    level = thresholdList.get(j).getLevel();
                                                }
                                            }
                                            if(level > 0) {
                                                List<Eorder> orderList = eorderService.selectBySql("item='" + orderItem + "' and status!='完成' order by time desc");
                                                if (orderList.size() > 0) {
                                                    Eorder order = orderList.get(0);
                                                    if (order.getLevel() < level) {
                                                        order = eorderService.insert(orderItem, data.getId(), null, "告警", level, "正常", time, "");
                                                        if(order != null) {
                                                            sendMsgs(device.getId(), attrList.get(i).getId(), orderItem, level, time);
                                                            setAllStatus(device.getId());
                                                        }
                                                    }
                                                } else {
                                                    Eorder order = eorderService.insert(orderItem, data.getId(), null, "告警", level, "正常", time, "");
                                                    if(order != null) {
                                                        sendMsgs(device.getId(), attrList.get(i).getId(), orderItem, level, time);
                                                        setAllStatus(device.getId());
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
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
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

    @RequestMapping(value = "/stop")
    public Map<Object, Object> stop() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/registCode")
    public Map<Object, Object> registCode(String phone){
        Map<Object, Object> map = new HashMap<Object, Object>();
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIXpoDTXW3Cvat", "0nsk97XkQwGAe8DZLg4rLp5qtBvN8Z");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "物联天地");
        request.putQueryParameter("TemplateCode", "SMS_158492592");
        String code = getCode(6);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            JSONObject data = JSONObject.parseObject(response.getData());
            if(data.getString("Code").equals("OK")){
                map.put("status", 260);
                map.put("code", code);
            }else{
                map.put("status", 240);
                map.put("message", "验证码发送失败");
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/lostCode")
    public Map<Object, Object> lostCode(String phone){
        Map<Object, Object> map = new HashMap<Object, Object>();
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIXpoDTXW3Cvat", "0nsk97XkQwGAe8DZLg4rLp5qtBvN8Z");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "物联天地");
        request.putQueryParameter("TemplateCode", "SMS_158492599");
        String code = getCode(6);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            JSONObject data = JSONObject.parseObject(response.getData());
            if(data.getString("Code").equals("OK")){
                map.put("status", 260);
                map.put("code", code);
            }else{
                map.put("status", 240);
                map.put("message", "验证码发送失败");
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return map;
    }

    public String getCode(int num){
        Random random = new Random();
        String code="";
        for (int i = 0; i < num; i++)
        {
            code += random.nextInt(10);
        }
        return code;
    }
}
