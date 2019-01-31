package com.iot.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class EprojectServiceImpl implements EprojectService {
    @Override
    public Map<Object, Object> select(){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> insert(String item, String fileurl, String servicename, String dburl, String detail){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> update(Integer id, String item, String fileurl, String servicename, String dburl, String detail){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> delete(Integer id){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public JSONArray combobox(){
        return null;
    }
}