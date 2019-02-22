package com.iot.service;

import com.iot.bean.Eattr;
import com.iot.bean.Eattrv;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EattrServiceImpl implements EattrService {

    @Override
    public List<Eattr> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eattr> selectBySql(String sql) {
        return null;
    }

    @Override
    public Eattr selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Eattrv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eattrv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Eattrv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Eattr> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eattr> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Eattr selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Eattrv> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eattrv> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Eattrv selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Eattrv insert(String item, Integer sensorid, String protocol, String compare, String unit, Integer timer, String note) {
        return null;
    }

    @Override
    public Eattrv update(Integer id, String item, Integer sensorid, String protocol, String compare, String unit, Integer timer, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
