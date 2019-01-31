package com.iot.service;
  
import com.iot.bean.Euser;
import com.iot.bean.Euserv;

import java.util.List;

public interface EuserService {
    public List<Euser> selectAll();

    public List<Euser> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euser> selectBySql(String sql);

    public Euser selectByPrimaryKey(Integer id);

	public List<Euserv> selectVAll();
	
	public List<Euserv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserv> selectVBySql(String sql);

    public Euserv selectVByPrimaryKey(Integer id);

    public List<Euser> selectSubAll(Integer projectid);

    public List<Euser> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euser> selectSubBySql(Integer projectid, String sql);

    public Euser selectSubByPrimaryKey(Integer projectid, Integer id);

    public List<Euserv> selectSubVAll(Integer projectid);

    public List<Euserv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserv> selectSubVBySql(Integer projectid, String sql);

    public Euserv selectSubVByPrimaryKey(Integer projectid, Integer id);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Euser record);

    public int updateByPrimaryKey(Euser record);
} 