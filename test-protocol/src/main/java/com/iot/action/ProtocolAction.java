package com.iot.action;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/protocol")
public class ProtocolAction {
    private static MqttClient client;

    @RequestMapping(value = "/start")
    public Map<Object, Object> start(){
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            client = new MqttClient("tcp://129.204.174.96:3883", "wltd", new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName("wuliantiandi");
            options.setPassword("GHkAHs8421La".toCharArray());
            options.setConnectionTimeout(5000);
            options.setKeepAliveInterval(10000);
            client.connect(options);
            String[] topic = {"864814048247505", "867900046839745"};
            int[] Qos  = {2, 2};
            client.subscribe(topic, Qos);
//            client.subscribe(id, 2);
            client.setCallback(new MqttCallback() {
                public void connectionLost(Throwable cause) {
                    System.out.println("connectionLost");
                }
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    JSONObject data = JSONObject.parseObject(new String(message.getPayload()));
                    System.out.println("data=" + new String(message.getPayload()));
                }
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("deliveryComplete---------"+ token.isComplete());
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return map;
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
}