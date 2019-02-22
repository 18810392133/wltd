package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Euserdevice;
import com.iot.bean.Euserdevicev;
import com.iot.mapper.EuserdeviceMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("euserdeviceService")
public class EuserdeviceServiceImpl implements EuserdeviceService {
    @Resource
    private EuserdeviceMapper euserdeviceMapper;

    public List<Euserdevice> selectAll(){
        return euserdeviceMapper.selectAll();
    }

    public List<Euserdevice> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return euserdeviceMapper.selectAll();
        else
            return euserdeviceMapper.selectBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Euserdevice> selectBySql(String sql){
        return euserdeviceMapper.selectBySql(sql);
    }

    public Euserdevice selectByPrimaryKey(Integer id){
        return euserdeviceMapper.selectByPrimaryKey(id);
    }

    public List<Euserdevicev> selectVAll(){
        return euserdeviceMapper.selectVAll();
    }

    public List<Euserdevicev> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return euserdeviceMapper.selectVAll();
        else
            return euserdeviceMapper.selectVBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Euserdevicev> selectVBySql(String sql){
        return euserdeviceMapper.selectVBySql(sql);
    }

    public Euserdevicev selectVByPrimaryKey(Integer id){
        return euserdeviceMapper.selectVByPrimaryKey(id);
    }

    public List<Euserdevice> selectSubAll(Integer projectid){
        return euserdeviceMapper.selectSubAll(projectid);
    }

    public List<Euserdevice> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "euserdevice").isEmpty())
            return euserdeviceMapper.selectSubAll(projectid);
        else
            return euserdeviceMapper.selectSubBySql(projectid, CommonUtils.json2sql4sub(filterRules, "euserdevice"));
    }

    public List<Euserdevice> selectSubBySql(Integer projectid, String sql){
        return euserdeviceMapper.selectSubBySql(projectid, sql);
    }

    public Euserdevice selectSubByPrimaryKey(Integer projectid, Integer id){
        return euserdeviceMapper.selectSubByPrimaryKey(projectid, id);
    }

    public List<Euserdevicev> selectSubVAll(Integer projectid){
        return euserdeviceMapper.selectSubVAll(projectid);
    }

    public List<Euserdevicev> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "euserdevice").isEmpty())
            return euserdeviceMapper.selectSubVAll(projectid);
        else
            return euserdeviceMapper.selectSubVBySql(projectid, CommonUtils.json2sql4sub(filterRules, "euserdevice"));
    }

    public List<Euserdevicev> selectSubVBySql(Integer projectid, String sql){
        return euserdeviceMapper.selectSubVBySql(projectid, sql);
    }

    public Euserdevicev selectSubVByPrimaryKey(Integer projectid, Integer id){
        return euserdeviceMapper.selectSubVByPrimaryKey(projectid, id);
    }

    public int deleteByPrimaryKey(Integer id){
        return euserdeviceMapper.deleteByPrimaryKey(id);
    }

    public int insert(Euserdevice record){
        return euserdeviceMapper.insert(record);
    }

    public int updateByPrimaryKey(Euserdevice record){
        return euserdeviceMapper.updateByPrimaryKey(record);
    }
}