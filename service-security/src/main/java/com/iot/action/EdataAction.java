package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.Edata;
import com.iot.bean.Edatav;
import com.iot.service.EdataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class EdataAction {
    @Resource
    private EdataService edataService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Edata> selectAll(){
        return edataService.selectAll();
    }

    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Edata> list = edataService.selectByPage(page, rows, sort, order, filterRules);
        PageInfo<Edata> pageInfo = new PageInfo<Edata>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
    public List<Edata> selectBySql(String sql){
        return edataService.selectBySql(sql);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Edata selectByPrimaryKey(Integer id){
        return edataService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
    public List<Edatav>  selectVAll(){
        return edataService.selectVAll();
    }

    @RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Edatav> list = edataService.selectVByPage(page, rows, sort, order, filterRules);
        PageInfo<Edatav> pageInfo = new PageInfo<Edatav>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
    public List<Edatav> selectVBySql(String sql){
        return edataService.selectVBySql(sql);
    }

    @RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
    public Edatav selectVByPrimaryKey(Integer id){
        return edataService.selectVByPrimaryKey(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Edatav insert(String item, Integer deviceid, Integer attrid, String time, String note){
        Edatav data = new Edatav();
        data.setItem(item);
        data.setDeviceid(deviceid);
        data.setAttrid(attrid);
        data.setTime(time);
        data.setNote(note);
        edataService.insert(data);
        return data;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Edatav update(Integer id, String item, Integer attrid, String time, String note){
        Edatav data = edataService.selectVByPrimaryKey(id);
        if(data != null){
            data.setItem(item);
            data.setAttrid(attrid);
            data.setTime(time);
            data.setNote(note);
            edataService.updateByPrimaryKey(data);
        }
        return data;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int delete(Integer id){
        return edataService.deleteByPrimaryKey(id);
    }
}