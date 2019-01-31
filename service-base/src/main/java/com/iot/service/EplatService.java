package com.iot.service;

import com.iot.bean.Eplat;
import com.iot.bean.Eplatv;
import java.util.List;

public interface EplatService {
	public List<Eplat> selectAll();

	public List<Eplat> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eplat> selectBySql(String sql);

	public Eplat selectByPrimaryKey(Integer id);

	public List<Eplatv> selectVAll();

	public List<Eplatv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eplatv> selectVBySql(String sql);

	public Eplatv selectVByPrimaryKey(Integer id);

	public List<Eplat> selectSubAll(Integer projectid);

	public List<Eplat> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eplat> selectSubBySql(Integer projectid, String sql);

	public Eplat selectSubByPrimaryKey(Integer projectid, Integer id);

	public List<Eplatv> selectSubVAll(Integer projectid);

	public List<Eplatv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eplatv> selectSubVBySql(Integer projectid, String sql);

	public Eplatv selectSubVByPrimaryKey(Integer projectid, Integer id);

	public int deleteByPrimaryKey(Integer id);

	public int insert(Eplat record);

	public int updateByPrimaryKey(Eplat record);
} 