package com.iot.service;

import com.iot.bean.Ethreshold;
import com.iot.bean.Ethresholdv;
import java.util.List;

public interface EthresholdService {
    public List<Ethreshold> selectAll();

    public List<Ethreshold> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Ethreshold> selectBySql(String sql);

    public Ethreshold selectByPrimaryKey(Integer id);

    public List<Ethresholdv> selectVAll();

    public List<Ethresholdv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Ethresholdv> selectVBySql(String sql);

    public Ethresholdv selectVByPrimaryKey(Integer id);

    public List<Ethreshold> selectSubAll(Integer projectid);

    public List<Ethreshold> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Ethreshold> selectSubBySql(Integer projectid, String sql);

    public Ethreshold selectSubByPrimaryKey(Integer projectid, Integer id);

    public List<Ethresholdv> selectSubVAll(Integer projectid);

    public List<Ethresholdv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Ethresholdv> selectSubVBySql(Integer projectid, String sql);

    public Ethresholdv selectSubVByPrimaryKey(Integer projectid, Integer id);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Ethreshold record);

    public int updateByPrimaryKey(Ethreshold record);
} 