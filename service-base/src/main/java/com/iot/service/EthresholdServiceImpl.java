package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Ethreshold;
import com.iot.bean.Ethresholdv;
import com.iot.mapper.EthresholdMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ethresholdService")
public class EthresholdServiceImpl implements EthresholdService {
    @Resource
    private EthresholdMapper ethresholdMapper;

    public List<Ethreshold> selectAll(){
        return ethresholdMapper.selectAll();
    }

    public List<Ethreshold> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return ethresholdMapper.selectAll();
        else
            return ethresholdMapper.selectBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Ethreshold> selectBySql(String sql){
        return ethresholdMapper.selectBySql(sql);
    }

    public Ethreshold selectByPrimaryKey(Integer id){
        return ethresholdMapper.selectByPrimaryKey(id);
    }

    public List<Ethresholdv> selectVAll(){
        return ethresholdMapper.selectVAll();
    }

    public List<Ethresholdv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return ethresholdMapper.selectVAll();
        else
            return ethresholdMapper.selectVBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Ethresholdv> selectVBySql(String sql){
        return ethresholdMapper.selectVBySql(sql);
    }

    public Ethresholdv selectVByPrimaryKey(Integer id){
        return ethresholdMapper.selectVByPrimaryKey(id);
    }

    public List<Ethreshold> selectSubAll(Integer projectid){
        return ethresholdMapper.selectSubAll(projectid);
    }

    public List<Ethreshold> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "ethreshold").isEmpty())
            return ethresholdMapper.selectSubAll(projectid);
        else
            return ethresholdMapper.selectSubBySql(projectid, CommonUtils.json2sql4sub(filterRules, "ethreshold"));
    }

    public List<Ethreshold> selectSubBySql(Integer projectid, String sql){
        return ethresholdMapper.selectSubBySql(projectid, sql);
    }

    public Ethreshold selectSubByPrimaryKey(Integer projectid, Integer id){
        return ethresholdMapper.selectSubByPrimaryKey(projectid, id);
    }

    public List<Ethresholdv> selectSubVAll(Integer projectid){
        return ethresholdMapper.selectSubVAll(projectid);
    }

    public List<Ethresholdv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "ethreshold").isEmpty())
            return ethresholdMapper.selectSubVAll(projectid);
        else
            return ethresholdMapper.selectSubVBySql(projectid, CommonUtils.json2sql4sub(filterRules, "ethreshold"));
    }

    public List<Ethresholdv> selectSubVBySql(Integer projectid, String sql){
        return ethresholdMapper.selectSubVBySql(projectid, sql);
    }

    public Ethresholdv selectSubVByPrimaryKey(Integer projectid, Integer id){
        return ethresholdMapper.selectSubVByPrimaryKey(projectid, id);
    }

    public int deleteByPrimaryKey(Integer id){
        return ethresholdMapper.deleteByPrimaryKey(id);
    }

    public int insert(Ethreshold record){
        return ethresholdMapper.insert(record);
    }

    public int updateByPrimaryKey(Ethreshold record){
        return ethresholdMapper.updateByPrimaryKey(record);
    }
}