package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Eattr;
import com.iot.bean.Eattrv;
import com.iot.mapper.EattrMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("eattrService")
public class EattrServiceImpl implements EattrService {
	@Resource
	private EattrMapper eattrMapper;

	public List<Eattr> selectAll(){
		return eattrMapper.selectAll();
	}

	public List<Eattr> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return eattrMapper.selectAll();
		else
			return eattrMapper.selectBySql(CommonUtils.json2sql(filterRules));
	}

	public List<Eattr> selectBySql(String sql){
		return eattrMapper.selectBySql(sql);
	}

	public Eattr selectByPrimaryKey(Integer id){
		return eattrMapper.selectByPrimaryKey(id);
	}

	public List<Eattrv> selectVAll(){
		return eattrMapper.selectVAll();
	}

	public List<Eattrv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return eattrMapper.selectVAll();
		else
			return eattrMapper.selectVBySql(CommonUtils.json2sql(filterRules));
	}

	public List<Eattrv> selectVBySql(String sql){
		return eattrMapper.selectVBySql(sql);
	}

	public Eattrv selectVByPrimaryKey(Integer id){
		return eattrMapper.selectVByPrimaryKey(id);
	}

	public List<Eattr> selectSubAll(Integer projectid){
		return eattrMapper.selectSubAll(projectid);
	}

	public List<Eattr> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "eattr").isEmpty())
			return eattrMapper.selectSubAll(projectid);
		else
			return eattrMapper.selectSubBySql(projectid, CommonUtils.json2sql4sub(filterRules, "eattr"));
	}

	public List<Eattr> selectSubBySql(Integer projectid, String sql){
		return eattrMapper.selectSubBySql(projectid, sql);
	}

	public Eattr selectSubByPrimaryKey(Integer projectid, Integer id){
		return eattrMapper.selectSubByPrimaryKey(projectid, id);
	}

	public List<Eattrv> selectSubVAll(Integer projectid){
		return eattrMapper.selectSubVAll(projectid);
	}

	public List<Eattrv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "eattr").isEmpty())
			return eattrMapper.selectSubVAll(projectid);
		else
			return eattrMapper.selectSubVBySql(projectid, CommonUtils.json2sql4sub(filterRules, "eattr"));
	}

	public List<Eattrv> selectSubVBySql(Integer projectid, String sql){
		return eattrMapper.selectSubVBySql(projectid, sql);
	}

	public Eattrv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return eattrMapper.selectSubVByPrimaryKey(projectid, id);
	}

	public int deleteByPrimaryKey(Integer id){
		return eattrMapper.deleteByPrimaryKey(id);
	}

	public int insert(Eattr record){
		return eattrMapper.insert(record);
	}

	public int updateByPrimaryKey(Eattr record){
		return eattrMapper.updateByPrimaryKey(record);
	}
}