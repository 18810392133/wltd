package com.iot.service;

import com.iot.bean.Eorder;
import com.iot.bean.Eorderv;
import java.util.List;

public interface EorderService {
    public List<Eorder> selectAll();

    public List<Eorder> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Eorder> selectBySql(String sql);

    public Eorder selectByPrimaryKey(Integer id);

    public List<Eorderv> selectVAll();

    public List<Eorderv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Eorderv> selectVBySql(String sql);

    public Eorderv selectVByPrimaryKey(Integer id);

    public List<Eorderv> selectVByDevices(String devices);

    public List<Eorderv> selectVByDevice(Integer deviceid);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Eorder record);

    public int updateByPrimaryKey(Eorder record);
} 