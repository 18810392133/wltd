package com.iot.service;

import com.iot.bean.Euserdevice;
import com.iot.bean.Euserdevicev;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EuserdeviceServiceImpl implements EuserdeviceService {

    @Override
    public List<Euserdevice> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserdevice> selectBySql(String sql) {
        return null;
    }

    @Override
    public Euserdevice selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Euserdevicev> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserdevicev> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Euserdevicev selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Euserdevice> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserdevice> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Euserdevice selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Euserdevicev> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserdevicev> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Euserdevicev selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Euserdevicev insert(Integer userid, Integer deviceid, String note) {
        return null;
    }

    @Override
    public Euserdevicev update(Integer id, Integer userid, Integer deviceid, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
