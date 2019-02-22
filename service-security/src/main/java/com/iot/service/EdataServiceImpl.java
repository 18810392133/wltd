package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Edata;
import com.iot.bean.Edatav;
import com.iot.mapper.EdataMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("edataService")
public class EdataServiceImpl implements EdataService {
    @Resource
    private EdataMapper edataMapper;

    public List<Edata> selectAll(){
        return edataMapper.selectAll();
    }

    public List<Edata> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return edataMapper.selectAll();
        else
            return edataMapper.selectBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Edata> selectBySql(String sql){
        return edataMapper.selectBySql(sql);
    }

    public Edata selectByPrimaryKey(Integer id){
        return edataMapper.selectByPrimaryKey(id);
    }

    public List<Edatav> selectVAll(){
        return edataMapper.selectVAll();
    }

    public List<Edatav> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return edataMapper.selectVAll();
        else
            return edataMapper.selectVBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Edatav> selectVBySql(String sql){
        return edataMapper.selectVBySql(sql);
    }

    public Edatav selectVByPrimaryKey(Integer id){
        return edataMapper.selectVByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(Integer id){
        return edataMapper.deleteByPrimaryKey(id);
    }

    public int insert(Edata record){
        return edataMapper.insert(record);
    }

    public int updateByPrimaryKey(Edata record){
        return edataMapper.updateByPrimaryKey(record);
    }
}