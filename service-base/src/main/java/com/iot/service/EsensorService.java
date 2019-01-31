package com.iot.service;

import com.iot.bean.Esensor;
import com.iot.bean.Esensorv;
import java.util.List;

public interface EsensorService {
    public List<Esensor> selectAll();

    public List<Esensor> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Esensor> selectBySql(String sql);

    public Esensor selectByPrimaryKey(Integer id);

    public List<Esensorv> selectVAll();

    public List<Esensorv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Esensorv> selectVBySql(String sql);

    public Esensorv selectVByPrimaryKey(Integer id);

    public List<Esensor> selectSubAll(Integer projectid);

    public List<Esensor> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Esensor> selectSubBySql(Integer projectid, String sql);

    public Esensor selectSubByPrimaryKey(Integer projectid, Integer id);

    public List<Esensorv> selectSubVAll(Integer projectid);

    public List<Esensorv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Esensorv> selectSubVBySql(Integer projectid, String sql);

    public Esensorv selectSubVByPrimaryKey(Integer projectid, Integer id);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Esensor record);

    public int updateByPrimaryKey(Esensor record);
} 