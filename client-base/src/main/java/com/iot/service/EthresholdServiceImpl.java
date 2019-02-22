package com.iot.service;

import com.iot.bean.Ethreshold;
import com.iot.bean.Ethresholdv;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EthresholdServiceImpl implements EthresholdService {

    @Override
    public List<Ethreshold> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Ethreshold> selectBySql(String sql) {
        return null;
    }

    @Override
    public Ethreshold selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Ethresholdv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Ethresholdv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Ethresholdv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Ethreshold> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Ethreshold> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Ethreshold selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Ethresholdv> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Ethresholdv> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Ethresholdv selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Ethresholdv insert(String item, Integer attrid, Integer level, Integer overtime, String note) {
        return null;
    }

    @Override
    public Ethresholdv update(Integer id, String item, Integer attrid, Integer level, Integer overtime, String note) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
