package com.iot.service;

import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import java.util.List;

public interface EbimService {
	public List<Ebim> selectAll();

	public List<Ebim> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Ebim> selectBySql(String sql);

	public Ebim selectByPrimaryKey(Integer id);

	public List<Ebimv> selectVAll();

	public List<Ebimv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Ebimv> selectVBySql(String sql);

	public Ebimv selectVByPrimaryKey(Integer id);

	public List<Ebim> selectSubAll(Integer projectid);

	public List<Ebim> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Ebim> selectSubBySql(Integer projectid, String sql);

	public Ebim selectSubByPrimaryKey(Integer projectid, Integer id);

	public List<Ebimv> selectSubVAll(Integer projectid);

	public List<Ebimv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Ebimv> selectSubVBySql(Integer projectid, String sql);

	public Ebimv selectSubVByPrimaryKey(Integer projectid, Integer id);

	public int deleteByPrimaryKey(Integer id);

	public int insert(Ebim record);

	public int updateByPrimaryKey(Ebim record);
} 