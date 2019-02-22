package com.iot.service;

import com.iot.bean.Edata;
import com.iot.bean.Edatav;
import java.util.List;

public interface EdataService {
    public List<Edata> selectAll();

    public List<Edata> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Edata> selectBySql(String sql);

    public Edata selectByPrimaryKey(Integer id);

    public List<Edatav> selectVAll();

    public List<Edatav> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Edatav> selectVBySql(String sql);

    public Edatav selectVByPrimaryKey(Integer id);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Edata record);

    public int updateByPrimaryKey(Edata record);
} 