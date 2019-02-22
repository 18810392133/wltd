package com.iot.service;

import com.iot.bean.Eproject;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class EprojectServiceImpl implements EprojectService {

    @Override
    public List<Eproject> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Eproject> selectBySql(String sql) {
        return null;
    }

    @Override
    public Eproject selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Eproject insert(String item, String fileurl, String servicename, String dburl, String detail) {
        return null;
    }

    @Override
    public Eproject update(Integer id, String item, String fileurl, String servicename, String dburl, String detail) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}