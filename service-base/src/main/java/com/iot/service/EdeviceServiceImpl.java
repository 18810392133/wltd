package com.iot.service;

import com.github.pagehelper.PageHelper;
import com.iot.bean.Edevice;
import com.iot.bean.Edevicev;
import com.iot.mapper.EdeviceMapper;
import com.iot.util.CommonUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("edeviceService")
public class EdeviceServiceImpl implements EdeviceService {
    @Resource
    private EdeviceMapper edeviceMapper;

    public List<Edevice> selectAll(){
        return edeviceMapper.selectAll();
    }

    public List<Edevice> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return edeviceMapper.selectAll();
        else
            return edeviceMapper.selectBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Edevice> selectBySql(String sql){
        return edeviceMapper.selectBySql(sql);
    }

    public Edevice selectByPrimaryKey(Integer id){
        return edeviceMapper.selectByPrimaryKey(id);
    }

    public List<Edevicev> selectVAll(){
        return edeviceMapper.selectVAll();
    }

    public List<Edevicev> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql(filterRules).isEmpty())
            return edeviceMapper.selectVAll();
        else
            return edeviceMapper.selectVBySql(CommonUtils.json2sql(filterRules));
    }

    public List<Edevicev> selectVBySql(String sql){
        return edeviceMapper.selectVBySql(sql);
    }

    public Edevicev selectVByPrimaryKey(Integer id){
        return edeviceMapper.selectVByPrimaryKey(id);
    }

    public List<Edevice> selectSubAll(Integer projectid){
        return edeviceMapper.selectSubAll(projectid);
    }

    public List<Edevice> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "edevice").isEmpty())
            return edeviceMapper.selectSubAll(projectid);
        else
            return edeviceMapper.selectSubBySql(projectid, CommonUtils.json2sql4sub(filterRules, "edevice"));
    }

    public List<Edevice> selectSubBySql(Integer projectid, String sql){
        return edeviceMapper.selectSubBySql(projectid, sql);
    }

    public Edevice selectSubByPrimaryKey(Integer projectid, Integer id){
        return edeviceMapper.selectSubByPrimaryKey(projectid, id);
    }

    public List<Edevicev> selectSubVAll(Integer projectid){
        return edeviceMapper.selectSubVAll(projectid);
    }

    public List<Edevicev> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        if(page == null) page = 1;
        if(rows == null) rows = 20;
        if(sort == null) sort = "id";
        if(order == null) order = "desc";
        PageHelper.startPage(page, rows, sort + " " + order);
        if(filterRules == null || CommonUtils.json2sql4sub(filterRules, "edevice").isEmpty())
            return edeviceMapper.selectSubVAll(projectid);
        else
            return edeviceMapper.selectSubVBySql(projectid, CommonUtils.json2sql4sub(filterRules, "edevice"));
    }

    public List<Edevicev> selectSubVBySql(Integer projectid, String sql){
        return edeviceMapper.selectSubVBySql(projectid, sql);
    }

    public Edevicev selectSubVByPrimaryKey(Integer projectid, Integer id){
        return edeviceMapper.selectSubVByPrimaryKey(projectid, id);
    }

    public int deleteByPrimaryKey(Integer id){
        return edeviceMapper.deleteByPrimaryKey(id);
    }

    public int insert(Edevice record){
        return edeviceMapper.insert(record);
    }

    public int updateByPrimaryKey(Edevice record){
        return edeviceMapper.updateByPrimaryKey(record);
    }
}