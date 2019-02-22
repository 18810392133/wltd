package com.iot.service;

import com.iot.bean.Euserthreshold;
import com.iot.bean.Euserthresholdv;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EuserthresholdServiceImpl implements EuserthresholdService {

    @Override
    public List<Euserthreshold> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserthreshold> selectBySql(String sql) {
        return null;
    }

    @Override
    public Euserthreshold selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Euserthresholdv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserthresholdv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Euserthresholdv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Euserthreshold> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserthreshold> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Euserthreshold selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Euserthresholdv> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserthresholdv> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Euserthresholdv selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Euserthresholdv insert(Integer userid, Integer thresholdid, String note) {
        return null;
    }

    @Override
    public Euserthresholdv update(Integer id, Integer userid, Integer thresholdid, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
