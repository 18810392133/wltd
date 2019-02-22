package com.iot.service;

import com.iot.bean.Euser;
import com.iot.bean.Euserv;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EuserServiceImpl implements EuserService {

    @Override
    public List<Euser> selectAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euser> selectBySql(String sql) {
        return null;
    }

    @Override
    public Euser selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Euserv> selectVAll() {
        return null;
    }

    @Override
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserv> selectVBySql(String sql) {
        return null;
    }

    @Override
    public Euserv selectVByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Euser> selectSubAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euser> selectSubBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Euser selectSubByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public List<Euserv> selectSubVAll(Integer projectid) {
        return null;
    }

    @Override
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules) {
        return null;
    }

    @Override
    public List<Euserv> selectSubVBySql(Integer projectid, String sql) {
        return null;
    }

    @Override
    public Euserv selectSubVByPrimaryKey(Integer projectid, Integer id) {
        return null;
    }

    @Override
    public Euserv insert(String username, String password, Integer projectid, String type, String realname, String phone, String wechat, String time, String status) {
        return null;
    }

    @Override
    public Euserv update(Integer id, String username, String password, Integer projectid, String type, String realname, String phone, String wechat, String time, String status) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}