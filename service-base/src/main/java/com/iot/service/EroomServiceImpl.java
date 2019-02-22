package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Eroom;
import com.iot.bean.Eroomv;
import com.iot.mapper.EroomMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("eroomService")
public class EroomServiceImpl implements EroomService {
    @Resource
    private EroomMapper eroomMapper;

    public List<Eroom> selectAll(){
        return eroomMapper.selectAll();
    }

    public List<Eroom> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return eroomMapper.selectAll();
        else
            return eroomMapper.selectBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Eroom> selectBySql(String sql){
        return eroomMapper.selectBySql(sql);
    }

    public Eroom selectByPrimaryKey(Integer id){
        return eroomMapper.selectByPrimaryKey(id);
    }

    public List<Eroomv> selectVAll(){
        return eroomMapper.selectVAll();
    }

    public List<Eroomv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return eroomMapper.selectVAll();
        else
            return eroomMapper.selectVBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Eroomv> selectVBySql(String sql){
        return eroomMapper.selectVBySql(sql);
    }

    public Eroomv selectVByPrimaryKey(Integer id){
        return eroomMapper.selectVByPrimaryKey(id);
    }

    public List<Eroom> selectSubAll(Integer projectid){
        return eroomMapper.selectSubAll(projectid);
    }

    public List<Eroom> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "eroom").isEmpty())
            return eroomMapper.selectSubAll(projectid);
        else
            return eroomMapper.selectSubBySql(projectid, CommonUtils.json2sql4sub(filterRules, "eroom"));
    }

    public List<Eroom> selectSubBySql(Integer projectid, String sql){
        return eroomMapper.selectSubBySql(projectid, sql);
    }

    public Eroom selectSubByPrimaryKey(Integer projectid, Integer id){
        return eroomMapper.selectSubByPrimaryKey(projectid, id);
    }

    public List<Eroomv> selectSubVAll(Integer projectid){
        return eroomMapper.selectSubVAll(projectid);
    }

    public List<Eroomv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "eroom").isEmpty())
            return eroomMapper.selectSubVAll(projectid);
        else
            return eroomMapper.selectSubVBySql(projectid, CommonUtils.json2sql4sub(filterRules, "eroom"));
    }

    public List<Eroomv> selectSubVBySql(Integer projectid, String sql){
        return eroomMapper.selectSubVBySql(projectid, sql);
    }

    public Eroomv selectSubVByPrimaryKey(Integer projectid, Integer id){
        return eroomMapper.selectSubVByPrimaryKey(projectid, id);
    }

    public int deleteByPrimaryKey(Integer id){
        return eroomMapper.deleteByPrimaryKey(id);
    }

    public int insert(Eroom record){
        return eroomMapper.insert(record);
    }

    public int updateByPrimaryKey(Eroom record){
        return eroomMapper.updateByPrimaryKey(record);
    }
}