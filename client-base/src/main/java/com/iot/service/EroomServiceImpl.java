package com.iot.service;

import com.iot.bean.Eroom;
import com.iot.bean.Eroomv;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EroomServiceImpl implements EroomService {
    @Override
    public List<Eroom> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eroom> selectBySql(String sql) {
        return null;
    }

    @Override
    public Eroom selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Eroomv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eroomv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Eroomv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Eroom> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eroom> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Eroom selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Eroomv> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eroomv> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Eroomv selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Eroomv insert(String item, Integer bimid, String status, String modelfile, String note) {
        return null;
    }

    @Override
    public Eroomv update(Integer id, String item, Integer bimid, String status, String modelfile, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
