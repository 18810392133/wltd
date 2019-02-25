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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/common")
public class CommonAction {

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
                map.put("isSuccess", true);
                map.put("code", code);
            }else{
                map.put("isSuccess", false);
                map.put("msg", "验证码发送失败");
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
                map.put("isSuccess", true);
                map.put("code", code);
            }else{
                map.put("isSuccess", false);
                map.put("msg", "验证码发送失败");
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
