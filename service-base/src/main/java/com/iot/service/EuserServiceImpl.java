package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Euser;
import com.iot.bean.Euserv;
import com.iot.mapper.EuserMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("euserService")
public class EuserServiceImpl implements EuserService {  
    @Resource  
    private EuserMapper euserMapper;

	public List<Euser> selectAll(){
		return euserMapper.selectAll();
	}

	public List<Euser> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null)
			return euserMapper.selectAll();
		else
			return euserMapper.selectBySql(CommonUtils.json2sql(filterRules));
	}

	public List<Euser> selectBySql(String sql){
		return euserMapper.selectBySql(sql);
	}

	public Euser selectByPrimaryKey(Integer id){
		return euserMapper.selectByPrimaryKey(id);
	}

    public List<Euserv> selectVAll(){
    	return euserMapper.selectVAll();
    }
    
    public List<Euserv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
    	if(page == null) page = 1;
    	if(rows == null) rows = 20;
    	if(sort == null) sort = "id";
    	if(order == null) order = "desc";
    	PageHelper.startPage(page, rows, sort + " " + order);
    	if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
    		return euserMapper.selectVAll();
    	else
			return euserMapper.selectVBySql(CommonUtils.json2sql(filterRules));
 	}

    public List<Euserv> selectVBySql(String sql){
    	return euserMapper.selectVBySql(sql);
    }

	public Euserv selectVByPrimaryKey(Integer id){
		return euserMapper.selectVByPrimaryKey(id);
	}

	public List<Euser> selectSubAll(Integer projectid){
		return euserMapper.selectSubAll(projectid);
	}

	public List<Euser> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return euserMapper.selectSubAll(projectid);
		else
			return euserMapper.selectSubBySql(projectid, CommonUtils.json2sql(filterRules));
	}

	public List<Euser> selectSubBySql(Integer projectid, String sql){
		return euserMapper.selectSubBySql(projectid, sql);
	}

	public Euser selectSubByPrimaryKey(Integer projectid, Integer id){
		return euserMapper.selectSubByPrimaryKey(projectid, id);
	}

	public List<Euserv> selectSubVAll(Integer projectid){
		return euserMapper.selectSubVAll(projectid);
	}

	public List<Euserv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		if(page == null) page = 1;
		if(rows == null) rows = 20;
		if(sort == null) sort = "id";
		if(order == null) order = "desc";
		PageHelper.startPage(page, rows, sort + " " + order);
		if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
			return euserMapper.selectSubVAll(projectid);
		else
			return euserMapper.selectSubVBySql(projectid, CommonUtils.json2sql(filterRules));
	}

	public List<Euserv> selectSubVBySql(Integer projectid, String sql){
		return euserMapper.selectSubVBySql(projectid, sql);
	}

	public Euserv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return euserMapper.selectSubVByPrimaryKey(projectid, id);
	}

    public int deleteByPrimaryKey(Integer id){
    	return euserMapper.deleteByPrimaryKey(id);
    }

    public int insert(Euser record){
    	return euserMapper.insert(record);
    }

    public int updateByPrimaryKey(Euser record){
    	return euserMapper.updateByPrimaryKey(record);
    }
}