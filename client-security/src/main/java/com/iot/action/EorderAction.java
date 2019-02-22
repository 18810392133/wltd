package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.bean.Eorder;
import com.iot.bean.Eorderv;
import com.iot.bean.Select;
import com.iot.service.EorderService;
import com.iot.util.AuthToken;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class EorderAction {
    @Resource
    private EorderService eorderService;

    @AuthToken
    @RequestMapping(value = "/selectAll")
    public Map<Object, Object> selectAll(){
        List<Eorder> list = eorderService.selectAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return eorderService.selectByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectBySql")
    public Map<Object, Object> selectBySql(String sql){
        List<Eorder> list = eorderService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPrimaryKey")
    public Map<Object, Object> selectByPrimaryKey(Integer id){
        Eorder object = eorderService.selectByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVAll")
    public Map<Object, Object> selectVAll(){
        List<Eorderv> list = eorderService.selectVAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPage")
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return eorderService.selectVByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectVBySql")
    public Map<Object, Object> selectVBySql(String sql){
        List<Eorderv> list = eorderService.selectVBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPrimaryKey")
    public Map<Object, Object> selectVByPrimaryKey(Integer id){
        Eorderv object = eorderService.selectVByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, Integer dataid, Integer userid, String status, Integer level, String type, String time, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(dataid, 0)){
            Eorderv order = eorderService.insert(item, dataid, userid, status, level, type, time, note);
            if(order != null)
                map = new BeanMap(order);
        }else{
            map.put("isError", true);
            map.put("msg", "该工单已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, Integer dataid, Integer userid, String status, Integer level, String type, String time, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(dataid, id)){
            Eorderv order = eorderService.update(id, item, dataid, userid, status, level, type, time, note);
            if(order != null)
                map = new BeanMap(order);
        }else{
            map.put("isError", true);
            map.put("msg", "该工单已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/delete")
    public Map<Object, Object> delete(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(eorderService.delete(id) > 0)
            map.put("success", true);
        else
            map.put("success", false);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JSONArray list(Integer dataid){
        JSONArray jsonArray = new JSONArray();
        List<Eorder> list = eorderService.selectBySql("dataid=" + dataid);
        for(int i = 0; i < list.size(); i++){
            Select select = new Select();
            select.setText(list.get(i).getItem());
            select.setValue(String.valueOf(list.get(i).getId()));
            jsonArray.add(select);
        }
        return jsonArray;
    }

    @AuthToken
    @RequestMapping(value = "/statusList", method = RequestMethod.GET)
    public JSONArray statusList(){
        JSONArray jsonArray = new JSONArray();
        Select select = new Select();
        select.setText("告警");
        select.setValue("告警");
        jsonArray.add(select);
        select = new Select();
        select.setText("维修");
        select.setValue("维修");
        jsonArray.add(select);
        select = new Select();
        select.setText("完成");
        select.setValue("完成");
        jsonArray.add(select);
        return jsonArray;
    }

    @AuthToken
    @RequestMapping(value = "/typeList", method = RequestMethod.GET)
    public JSONArray typeList(){
        JSONArray jsonArray = new JSONArray();
        Select select = new Select();
        select.setText("正常");
        select.setValue("正常");
        jsonArray.add(select);
        select = new Select();
        select.setText("异常");
        select.setValue("异常");
        jsonArray.add(select);
        select = new Select();
        select.setText("超时");
        select.setValue("超时");
        jsonArray.add(select);
        return jsonArray;
    }

    public boolean isValidate(Integer dataid, Integer id){
        List<Eorder> list = eorderService.selectBySql("dataid=" + dataid + " and id!=" + id);
        if(list.size() > 0)
            return false;
        else
            return true;
    }
}