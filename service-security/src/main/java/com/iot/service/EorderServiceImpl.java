package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Eorder;
import com.iot.bean.Eorderv;
import com.iot.mapper.EorderMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("eorderService")
public class EorderServiceImpl implements EorderService {
    @Resource
    private EorderMapper eorderMapper;

    public List<Eorder> selectAll(){
        return eorderMapper.selectAll();
    }

    public List<Eorder> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return eorderMapper.selectAll();
        else
            return eorderMapper.selectBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Eorder> selectBySql(String sql){
        return eorderMapper.selectBySql(sql);
    }

    public Eorder selectByPrimaryKey(Integer id){
        return eorderMapper.selectByPrimaryKey(id);
    }

    public List<Eorderv> selectVAll(){
        return eorderMapper.selectVAll();
    }

    public List<Eorderv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return eorderMapper.selectVAll();
        else
            return eorderMapper.selectVBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Eorderv> selectVBySql(String sql){
        return eorderMapper.selectVBySql(sql);
    }

    public Eorderv selectVByPrimaryKey(Integer id){
        return eorderMapper.selectVByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(Integer id){
        return eorderMapper.deleteByPrimaryKey(id);
    }

    public int insert(Eorder record){
        return eorderMapper.insert(record);
    }

    public int updateByPrimaryKey(Eorder record){
        return eorderMapper.updateByPrimaryKey(record);
    }
}