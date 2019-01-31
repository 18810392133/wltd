package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Eplat;
import com.iot.bean.Eplatv;
import com.iot.mapper.EplatMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("eplatService")
public class EplatServiceImpl implements EplatService {
	@Resource
	private EplatMapper eplatMapper;

	public List<Eplat> selectAll(){
		return eplatMapper.selectAll();
	}

	public List<Eplat> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null)
			return eplatMapper.selectAll();
		else
			return eplatMapper.selectBySql(CommonUtils.json2sql(filterRules));
	}

	public List<Eplat> selectBySql(String sql){
		return eplatMapper.selectBySql(sql);
	}

	public Eplat selectByPrimaryKey(Integer id){
		return eplatMapper.selectByPrimaryKey(id);
	}

	public List<Eplatv> selectVAll(){
		return eplatMapper.selectVAll();
	}

	public List<Eplatv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return eplatMapper.selectVAll();
		else
			return eplatMapper.selectVBySql(CommonUtils.json2sql(filterRules));
	}

	public List<Eplatv> selectVBySql(String sql){
		return eplatMapper.selectVBySql(sql);
	}

	public Eplatv selectVByPrimaryKey(Integer id){
		return eplatMapper.selectVByPrimaryKey(id);
	}

	public List<Eplat> selectSubAll(Integer projectid){
		return eplatMapper.selectSubAll(projectid);
	}

	public List<Eplat> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return eplatMapper.selectSubAll(projectid);
		else
			return eplatMapper.selectSubBySql(projectid, CommonUtils.json2sql(filterRules));
	}

	public List<Eplat> selectSubBySql(Integer projectid, String sql){
		return eplatMapper.selectSubBySql(projectid, sql);
	}

	public Eplat selectSubByPrimaryKey(Integer projectid, Integer id){
		return eplatMapper.selectSubByPrimaryKey(projectid, id);
	}

	public List<Eplatv> selectSubVAll(Integer projectid){
		return eplatMapper.selectSubVAll(projectid);
	}

	public List<Eplatv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return eplatMapper.selectSubVAll(projectid);
		else
			return eplatMapper.selectSubVBySql(projectid, CommonUtils.json2sql(filterRules));
	}

	public List<Eplatv> selectSubVBySql(Integer projectid, String sql){
		return eplatMapper.selectSubVBySql(projectid, sql);
	}

	public Eplatv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return eplatMapper.selectSubVByPrimaryKey(projectid, id);
	}

	public int deleteByPrimaryKey(Integer id){
		return eplatMapper.deleteByPrimaryKey(id);
	}

	public int insert(Eplat record){
		return eplatMapper.insert(record);
	}

	public int updateByPrimaryKey(Eplat record){
		return eplatMapper.updateByPrimaryKey(record);
	}
}