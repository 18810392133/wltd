package com.iot.service;

import com.iot.bean.Eproject;

import java.util.List;

public interface EprojectService {  
     
	public List<Eproject> selectAll();
	
	public List<Eproject> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

	public List<Eproject> selectBySql(String sql);

    public Eproject selectByPrimaryKey(Integer id);
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(Eproject record);

    public int updateByPrimaryKey(Eproject record);
} 