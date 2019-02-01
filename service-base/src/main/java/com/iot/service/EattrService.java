package com.iot.service;

import com.iot.bean.Eattr;
import com.iot.bean.Eattrv;
import java.util.List;

public interface EattrService {
	public List<Eattr> selectAll();

	public List<Eattr> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eattr> selectBySql(String sql);

	public Eattr selectByPrimaryKey(Integer id);

	public List<Eattrv> selectVAll();

	public List<Eattrv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eattrv> selectVBySql(String sql);

	public Eattrv selectVByPrimaryKey(Integer id);

	public List<Eattr> selectSubAll(Integer projectid);

	public List<Eattr> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eattr> selectSubBySql(Integer projectid, String sql);

	public Eattr selectSubByPrimaryKey(Integer projectid, Integer id);

	public List<Eattrv> selectSubVAll(Integer projectid);

	public List<Eattrv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eattrv> selectSubVBySql(Integer projectid, String sql);

	public Eattrv selectSubVByPrimaryKey(Integer projectid, Integer id);

	public int deleteByPrimaryKey(Integer id);

	public int insert(Eattr record);

	public int updateByPrimaryKey(Eattr record);
} 