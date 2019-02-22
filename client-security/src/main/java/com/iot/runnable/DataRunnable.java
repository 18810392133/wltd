package com.iot.runnable;

import com.alibaba.fastjson.JSONObject;
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
    private EthresholdService ethresholdService;
    private Integer id;

    public DataRunnable(Integer id, EdataService edataService, EorderService eorderService, EattrService eattrService, EdeviceService edeviceService, EthresholdService ethresholdService){
        this.edataService = edataService;
        this.eorderService = eorderService;
        this.eattrService = eattrService;
        this.edeviceService = edeviceService;
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
                                                + device.getItem() + "" + attrList.get(j).getItem();
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
                                        if(level > 0){
                                            orderItem += " " +level + "级告警";
                                            eorderService.insert(orderItem, data.getId(), null, "告警", level, "正常", time, "");
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
}
