package com.iot.service;

import com.iot.bean.Edata;
import com.iot.bean.Edatav;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EdataServiceImpl implements EdataService {

    @Override
    public List<Edata> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Edata> selectBySql(String sql) {
        return null;
    }

    @Override
    public Edata selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Edatav> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Edatav> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Edatav selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Edatav insert(String item, Integer deviceid, Integer attrid, String time, String note) {
        return null;
    }

    @Override
    public Edatav update(Integer id, String item, Integer deviceid, Integer attrid, String time, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
