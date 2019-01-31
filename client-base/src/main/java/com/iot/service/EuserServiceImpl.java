package com.iot.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class EuserServiceImpl implements EuserService {

    @Override
    public Map<Object, Object> login(HttpServletRequest request, String item, String password, String servicename) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> select() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectBySql(String sql) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectByPrimaryKey(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectVAll() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectVBySql(String sql) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectVByPrimaryKey(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectSubAll(Integer projectid) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectSubBySql(Integer projectid, String sql) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectSubVAll(Integer projectid) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectSubVBySql(Integer projectid, String sql) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> insert(String item, String password, Integer projectid, String type, String realname, Integer age, String time, String status) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> update(Integer id, String item, String password, Integer projectid, String type, String realname, Integer age, String time, String status) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public Map<Object, Object> delete(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("msg", "服务暂停");
        return map;
    }

    @Override
    public JSONArray typeCombobox() {
        return null;
    }

    @Override
    public JSONArray statusCombobox() {
        return null;
    }
}