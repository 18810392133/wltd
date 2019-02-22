package com.iot.service;

import com.iot.bean.Euserdevice;
import com.iot.bean.Euserdevicev;
import java.util.List;

public interface EuserdeviceService {
    public List<Euserdevice> selectAll();

    public List<Euserdevice> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserdevice> selectBySql(String sql);

    public Euserdevice selectByPrimaryKey(Integer id);

    public List<Euserdevicev> selectVAll();

    public List<Euserdevicev> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserdevicev> selectVBySql(String sql);

    public Euserdevicev selectVByPrimaryKey(Integer id);

    public List<Euserdevice> selectSubAll(Integer projectid);

    public List<Euserdevice> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserdevice> selectSubBySql(Integer projectid, String sql);

    public Euserdevice selectSubByPrimaryKey(Integer projectid, Integer id);

    public List<Euserdevicev> selectSubVAll(Integer projectid);

    public List<Euserdevicev> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserdevicev> selectSubVBySql(Integer projectid, String sql);

    public Euserdevicev selectSubVByPrimaryKey(Integer projectid, Integer id);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Euserdevice record);

    public int updateByPrimaryKey(Euserdevice record);
} 