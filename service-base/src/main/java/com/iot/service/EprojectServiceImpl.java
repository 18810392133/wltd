package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Eproject;
import com.iot.mapper.EprojectMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("eprojectService")
public class EprojectServiceImpl implements EprojectService {
    @Resource  
    private EprojectMapper eprojectMapper;
    
    public List<Eproject> selectAll(){
    	return eprojectMapper.selectAll();
    }
    
    public List<Eproject> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
    	if(page == null) page = 1;
    	if(rows == null) rows = 20;
    	if(sort == null) sort = "id";
    	if(order == null) order = "desc";
    	PageHelper.startPage(page, rows, sort + " " + order);
    	if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
    		return eprojectMapper.selectAll();
    	else
    		return eprojectMapper.selectBySql(CommonUtils.json2sql(filterRules));
 	}
	
    public List<Eproject> selectBySql(String sql){
    	return eprojectMapper.selectBySql(sql);
    }

	public Eproject selectByPrimaryKey(Integer id){
		return eprojectMapper.selectByPrimaryKey(id);
	}

    public int deleteByPrimaryKey(Integer id){
    	return eprojectMapper.deleteByPrimaryKey(id);
    }

    public int insert(Eproject record){
    	return eprojectMapper.insert(record);
    }

    public int updateByPrimaryKey(Eproject record){
    	return eprojectMapper.updateByPrimaryKey(record);
    }
}