package com.iot.service;

import com.iot.bean.Edevice;
import com.iot.bean.Edevicev;
import java.util.List;

public interface EdeviceService {
    public List<Edevice> selectAll();

    public List<Edevice> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Edevice> selectBySql(String sql);

    public Edevice selectByPrimaryKey(Integer id);

    public List<Edevicev> selectVAll();

    public List<Edevicev> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Edevicev> selectVBySql(String sql);

    public Edevicev selectVByPrimaryKey(Integer id);

    public List<Edevice> selectSubAll(Integer projectid);

    public List<Edevice> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Edevice> selectSubBySql(Integer projectid, String sql);

    public Edevice selectSubByPrimaryKey(Integer projectid, Integer id);

    public List<Edevicev> selectSubVAll(Integer projectid);

    public List<Edevicev> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Edevicev> selectSubVBySql(Integer projectid, String sql);

    public Edevicev selectSubVByPrimaryKey(Integer projectid, Integer id);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Edevice record);

    public int updateByPrimaryKey(Edevice record);
} 