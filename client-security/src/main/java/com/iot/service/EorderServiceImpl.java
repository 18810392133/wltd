package com.iot.service;

import com.iot.bean.Eorder;
import com.iot.bean.Eorderv;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EorderServiceImpl implements EorderService {

    @Override
    public List<Eorder> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eorder> selectBySql(String sql) {
        return null;
    }

    @Override
    public Eorder selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Eorderv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eorderv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Eorderv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Eorderv> selectVByDevices(String devices) {
        return null;
    }

    @Override
    public List<Eorderv> selectVByDevice(Integer deviceid) {
        return null;
    }

    @Override
    public Eorderv insert(String item, Integer dataid, Integer userid, String status, Integer level, String type, String time, String note) {
        return null;
    }

    @Override
    public Eorderv update(Integer id, String item, Integer dataid, Integer userid, String status, Integer level, String type, String time, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
