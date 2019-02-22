package com.iot.service;

import com.iot.bean.Eroom;
import com.iot.bean.Eroomv;
import java.util.List;

public interface EroomService {
    public List<Eroom> selectAll();

    public List<Eroom> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Eroom> selectBySql(String sql);

    public Eroom selectByPrimaryKey(Integer id);

    public List<Eroomv> selectVAll();

    public List<Eroomv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Eroomv> selectVBySql(String sql);

    public Eroomv selectVByPrimaryKey(Integer id);

    public List<Eroom> selectSubAll(Integer projectid);

    public List<Eroom> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Eroom> selectSubBySql(Integer projectid, String sql);

    public Eroom selectSubByPrimaryKey(Integer projectid, Integer id);

    public List<Eroomv> selectSubVAll(Integer projectid);

    public List<Eroomv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Eroomv> selectSubVBySql(Integer projectid, String sql);

    public Eroomv selectSubVByPrimaryKey(Integer projectid, Integer id);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Eroom record);

    public int updateByPrimaryKey(Eroom record);
} 