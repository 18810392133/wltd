package com.iot.service;

import com.iot.bean.Eplat;
import com.iot.bean.Eplatv;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EplatServiceImpl implements EplatService {

    @Override
    public List<Eplat> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eplat> selectBySql(String sql) {
        return null;
    }

    @Override
    public Eplat selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Eplatv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eplatv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Eplatv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Eplat> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eplat> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Eplat selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Eplatv> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eplatv> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Eplatv selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Eplatv insert(String item, Integer projectid, String province, String city, String longitude, String latitude, String note) {
        return null;
    }

    @Override
    public Eplatv update(Integer id, String item, Integer projectid, String province, String city, String longitude, String latitude, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}