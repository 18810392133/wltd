package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Esensor;
import com.iot.bean.Esensorv;
import com.iot.mapper.EsensorMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("esensorService")
public class EsensorServiceImpl implements EsensorService {
    @Resource
    private EsensorMapper esensorMapper;

    public List<Esensor> selectAll(){
        return esensorMapper.selectAll();
    }

    public List<Esensor> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null)
            return esensorMapper.selectAll();
        else
            return esensorMapper.selectBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Esensor> selectBySql(String sql){
        return esensorMapper.selectBySql(sql);
    }

    public Esensor selectByPrimaryKey(Integer id){
        return esensorMapper.selectByPrimaryKey(id);
    }

    public List<Esensorv> selectVAll(){
        return esensorMapper.selectVAll();
    }

    public List<Esensorv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return esensorMapper.selectVAll();
        else
            return esensorMapper.selectVBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Esensorv> selectVBySql(String sql){
        return esensorMapper.selectVBySql(sql);
    }

    public Esensorv selectVByPrimaryKey(Integer id){
        return esensorMapper.selectVByPrimaryKey(id);
    }

    public List<Esensor> selectSubAll(Integer projectid){
        return esensorMapper.selectSubAll(projectid);
    }

    public List<Esensor> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return esensorMapper.selectSubAll(projectid);
        else
            return esensorMapper.selectSubBySql(projectid, CommonUtils.json2sql(filterRules));
    }

    public List<Esensor> selectSubBySql(Integer projectid, String sql){
        return esensorMapper.selectSubBySql(projectid, sql);
    }

    public Esensor selectSubByPrimaryKey(Integer projectid, Integer id){
        return esensorMapper.selectSubByPrimaryKey(projectid, id);
    }

    public List<Esensorv> selectSubVAll(Integer projectid){
        return esensorMapper.selectSubVAll(projectid);
    }

    public List<Esensorv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return esensorMapper.selectSubVAll(projectid);
        else
            return esensorMapper.selectSubVBySql(projectid, CommonUtils.json2sql(filterRules));
    }

    public List<Esensorv> selectSubVBySql(Integer projectid, String sql){
        return esensorMapper.selectSubVBySql(projectid, sql);
    }

    public Esensorv selectSubVByPrimaryKey(Integer projectid, Integer id){
        return esensorMapper.selectSubVByPrimaryKey(projectid, id);
    }

    public int deleteByPrimaryKey(Integer id){
        return esensorMapper.deleteByPrimaryKey(id);
    }

    public int insert(Esensor record){
        return esensorMapper.insert(record);
    }

    public int updateByPrimaryKey(Esensor record){
        return esensorMapper.updateByPrimaryKey(record);
    }
}