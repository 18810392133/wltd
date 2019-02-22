package com.iot.service;

import com.iot.bean.Esensor;
import com.iot.bean.Esensorv;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EsensorServiceImpl implements EsensorService {

    @Override
    public List<Esensor> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Esensor> selectBySql(String sql) {
        return null;
    }

    @Override
    public Esensor selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Esensorv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Esensorv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Esensorv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Esensor> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Esensor> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Esensor selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Esensorv> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Esensorv> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Esensorv selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Esensorv insert(String item, Integer projectid, String protocol, Integer timer, String note) {
        return null;
    }

    @Override
    public Esensorv update(Integer id, String item, Integer projectid, String protocol, Integer timer, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
