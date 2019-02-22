package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.bean.*;
import com.iot.service.EattrService;
import com.iot.service.EdataService;
import com.iot.service.EdeviceService;
import com.iot.util.AuthToken;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class EdataAction {
    @Resource
    private EdataService edataService;
    @Resource
    private EattrService eattrService;
    @Resource
    private EdeviceService edeviceService;

    @AuthToken
    @RequestMapping(value = "/selectRealData")
    public Map<Object, Object> selectRealData(Integer deviceid, String time){
        Map<Object, Object> map = new HashMap<Object, Object>();
        List list = new ArrayList();
        String sql = "sensorid=(select sensorid from edevice where id=" + deviceid + ")";
        List<Eattr> attrList = eattrService.selectBySql(sql);
        for(int i = 0; i < attrList.size(); i++){
            Map<Object, Object> attrMap = new HashMap<Object, Object>();
            attrMap.put("attr", attrList.get(i));
            List<Edata> dataList = edataService.selectBySql("deviceid=" + deviceid + " and attrid=" + attrList.get(i).getId() + " and time>'" + time + "'");
            attrMap.put("dataList", dataList);
            list.add(attrMap);
        }
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectNewData")
    public Map<Object, Object> selectNewData(Integer deviceid){
        Map<Object, Object> map = new HashMap<Object, Object>();
        Edevicev device = edeviceService.selectVByPrimaryKey(deviceid);
        map.put("object", device);
        List list = new ArrayList();
        String sql = "sensorid=(select sensorid from edevice where id=" + deviceid + ")";
        List<Eattr> attrList = eattrService.selectBySql(sql);
        for(int i = 0; i < attrList.size(); i++){
            Map<Object, Object> attrMap = new HashMap<Object, Object>();
            attrMap.put("attr", attrList.get(i));
            List<Edata> dataList = edataService.selectBySql("deviceid=" + deviceid + " and attrid=" + attrList.get(i).getId() + " order by time desc limit 1");
            if(dataList.size() > 0)
                attrMap.put("data", dataList.get(0));
            list.add(attrMap);
        }
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectAll")
    public Map<Object, Object> selectAll(){
        List<Edata> list = edataService.selectAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return edataService.selectByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectBySql")
    public Map<Object, Object> selectBySql(String sql){
        List<Edata> list = edataService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPrimaryKey")
    public Map<Object, Object> selectByPrimaryKey(Integer id){
        Edata object = edataService.selectByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVAll")
    public Map<Object, Object> selectVAll(){
        List<Edatav> list = edataService.selectVAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPage")
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return edataService.selectVByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectVBySql")
    public Map<Object, Object> selectVBySql(String sql){
        List<Edatav> list = edataService.selectVBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPrimaryKey")
    public Map<Object, Object> selectVByPrimaryKey(Integer id){
        Edatav object = edataService.selectVByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, Integer deviceid, Integer attrid, String time, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(deviceid, attrid, time, 0)){
            Edatav data = edataService.insert(item, deviceid, attrid, time, note);
            if(data != null)
                map = new BeanMap(data);
        }else{
            map.put("isError", true);
            map.put("msg", "该数据已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, Integer deviceid, Integer attrid, String time, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(deviceid, attrid, time, id)){
            Edatav data = edataService.update(id, item, deviceid, attrid, time, note);
            if(data != null)
                map = new BeanMap(data);
        }else{
            map.put("isError", true);
            map.put("msg", "该数据已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/delete")
    public Map<Object, Object> delete(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(edataService.delete(id) > 0)
            map.put("success", true);
        else
            map.put("success", false);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JSONArray list(Integer deviceid, Integer attrid){
        JSONArray jsonArray = new JSONArray();
        List<Edata> list = edataService.selectBySql("deviceid=" + deviceid + " and attrid=" + attrid);
        for(int i = 0; i < list.size(); i++){
            Select select = new Select();
            select.setText(list.get(i).getItem());
            select.setValue(String.valueOf(list.get(i).getId()));
            jsonArray.add(select);
        }
        return jsonArray;
    }

    public boolean isValidate(Integer deviceid, Integer attrid, String time, Integer id){
        List<Edata> list = edataService.selectBySql("deviceid=" + deviceid + " and attrid=" + attrid + " and time='" + time + "' and id!=" + id);
        if(list.size() > 0)
            return false;
        else
            return true;
    }
}