package com.iot.service;

import com.iot.bean.Edevice;
import com.iot.bean.Edevicev;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EdeviceServiceImpl implements EdeviceService {

    @Override
    public List<Edevice> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Edevice> selectBySql(String sql) {
        return null;
    }

    @Override
    public Edevice selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Edevicev> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Edevicev> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Edevicev selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Edevice> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Edevice> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Edevice selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Edevicev> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Edevicev> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Edevicev selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Edevicev insert(String item, Integer sensorid, Integer roomid, String protocol, String status, Integer level, String note) {
        return null;
    }

    @Override
    public Edevicev update(Integer id, String item, Integer sensorid, Integer roomid, String protocol, String status, Integer level, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
