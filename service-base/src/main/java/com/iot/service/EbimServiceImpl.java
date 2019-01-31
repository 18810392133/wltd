package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import com.iot.mapper.EbimMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ebimService")
public class EbimServiceImpl implements EbimService {
	@Resource
	private EbimMapper ebimMapper;

	public List<Ebim> selectAll(){
		return ebimMapper.selectAll();
	}

	public List<Ebim> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null)
			return ebimMapper.selectAll();
		else
			return ebimMapper.selectBySql(CommonUtils.json2sql(filterRules));
	}

	public List<Ebim> selectBySql(String sql){
		return ebimMapper.selectBySql(sql);
	}

	public Ebim selectByPrimaryKey(Integer id){
		return ebimMapper.selectByPrimaryKey(id);
	}

	public List<Ebimv> selectVAll(){
		return ebimMapper.selectVAll();
	}

	public List<Ebimv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return ebimMapper.selectVAll();
		else
			return ebimMapper.selectVBySql(CommonUtils.json2sql(filterRules));
	}

	public List<Ebimv> selectVBySql(String sql){
		return ebimMapper.selectVBySql(sql);
	}

	public Ebimv selectVByPrimaryKey(Integer id){
		return ebimMapper.selectVByPrimaryKey(id);
	}

	public List<Ebim> selectSubAll(Integer projectid){
		return ebimMapper.selectSubAll(projectid);
	}

	public List<Ebim> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return ebimMapper.selectSubAll(projectid);
		else
			return ebimMapper.selectSubBySql(projectid, CommonUtils.json2sql(filterRules));
	}

	public List<Ebim> selectSubBySql(Integer projectid, String sql){
		return ebimMapper.selectSubBySql(projectid, sql);
	}

	public Ebim selectSubByPrimaryKey(Integer projectid, Integer id){
		return ebimMapper.selectSubByPrimaryKey(projectid, id);
	}

	public List<Ebimv> selectSubVAll(Integer projectid){
		return ebimMapper.selectSubVAll(projectid);
	}

	public List<Ebimv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return ebimMapper.selectSubVAll(projectid);
		else
			return ebimMapper.selectSubVBySql(projectid, CommonUtils.json2sql(filterRules));
	}

	public List<Ebimv> selectSubVBySql(Integer projectid, String sql){
		return ebimMapper.selectSubVBySql(projectid, sql);
	}

	public Ebimv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return ebimMapper.selectSubVByPrimaryKey(projectid, id);
	}

	public int deleteByPrimaryKey(Integer id){
		return ebimMapper.deleteByPrimaryKey(id);
	}

	public int insert(Ebim record){
		return ebimMapper.insert(record);
	}

	public int updateByPrimaryKey(Ebim record){
		return ebimMapper.updateByPrimaryKey(record);
	}
}