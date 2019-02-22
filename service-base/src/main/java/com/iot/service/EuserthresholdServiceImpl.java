package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Euserthreshold;
import com.iot.bean.Euserthresholdv;
import com.iot.mapper.EuserthresholdMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("euserthresholdService")
public class EuserthresholdServiceImpl implements EuserthresholdService {
    @Resource
    private EuserthresholdMapper euserthresholdMapper;

    public List<Euserthreshold> selectAll(){
        return euserthresholdMapper.selectAll();
    }

    public List<Euserthreshold> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return euserthresholdMapper.selectAll();
        else
            return euserthresholdMapper.selectBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Euserthreshold> selectBySql(String sql){
        return euserthresholdMapper.selectBySql(sql);
    }

    public Euserthreshold selectByPrimaryKey(Integer id){
        return euserthresholdMapper.selectByPrimaryKey(id);
    }

    public List<Euserthresholdv> selectVAll(){
        return euserthresholdMapper.selectVAll();
    }

    public List<Euserthresholdv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return euserthresholdMapper.selectVAll();
        else
            return euserthresholdMapper.selectVBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Euserthresholdv> selectVBySql(String sql){
        return euserthresholdMapper.selectVBySql(sql);
    }

    public Euserthresholdv selectVByPrimaryKey(Integer id){
        return euserthresholdMapper.selectVByPrimaryKey(id);
    }

    public List<Euserthreshold> selectSubAll(Integer projectid){
        return euserthresholdMapper.selectSubAll(projectid);
    }

    public List<Euserthreshold> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "euserthreshold").isEmpty())
            return euserthresholdMapper.selectSubAll(projectid);
        else
            return euserthresholdMapper.selectSubBySql(projectid, CommonUtils.json2sql4sub(filterRules, "euserthreshold"));
    }

    public List<Euserthreshold> selectSubBySql(Integer projectid, String sql){
        return euserthresholdMapper.selectSubBySql(projectid, sql);
    }

    public Euserthreshold selectSubByPrimaryKey(Integer projectid, Integer id){
        return euserthresholdMapper.selectSubByPrimaryKey(projectid, id);
    }

    public List<Euserthresholdv> selectSubVAll(Integer projectid){
        return euserthresholdMapper.selectSubVAll(projectid);
    }

    public List<Euserthresholdv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "euserthreshold").isEmpty())
            return euserthresholdMapper.selectSubVAll(projectid);
        else
            return euserthresholdMapper.selectSubVBySql(projectid, CommonUtils.json2sql4sub(filterRules, "euserthreshold"));
    }

    public List<Euserthresholdv> selectSubVBySql(Integer projectid, String sql){
        return euserthresholdMapper.selectSubVBySql(projectid, sql);
    }

    public Euserthresholdv selectSubVByPrimaryKey(Integer projectid, Integer id){
        return euserthresholdMapper.selectSubVByPrimaryKey(projectid, id);
    }

    public int deleteByPrimaryKey(Integer id){
        return euserthresholdMapper.deleteByPrimaryKey(id);
    }

    public int insert(Euserthreshold record){
        return euserthresholdMapper.insert(record);
    }

    public int updateByPrimaryKey(Euserthreshold record){
        return euserthresholdMapper.updateByPrimaryKey(record);
    }
}