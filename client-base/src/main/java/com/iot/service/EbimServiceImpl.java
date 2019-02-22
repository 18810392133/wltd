package com.iot.service;

import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EbimServiceImpl implements EbimService {

    @Override
    public List<Ebim> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Ebim> selectBySql(String sql) {
        return null;
    }

    @Override
    public Ebim selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Ebimv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Ebimv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Ebimv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Ebim> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Ebim> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Ebim selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Ebimv> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Ebimv> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Ebimv selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Ebimv insert(String item, Integer platid, String longitude, String latitude, String status, Integer level, String modelfile, String note) {
        return null;
    }

    @Override
    public Ebimv update(Integer id, String item, Integer bimid, String longitude, String latitude, String status, Integer level, String modelfile, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
