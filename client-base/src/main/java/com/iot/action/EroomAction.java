package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.bean.Eroom;
import com.iot.bean.Eroomv;
import com.iot.bean.Select;
import com.iot.service.EroomService;
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
@RequestMapping("/room")
public class EroomAction {
    @Resource
    private EroomService eroomService;

    @AuthToken
    @RequestMapping(value = "/selectUserBimRoom")
    public Map<Object, Object> selectUserBimRoom(Integer userid, Integer bimid){
        String sql = "bimid=" + bimid + " and id in (select roomid from edevice where id in (select deviceid from euserdevice where userid=" + userid + "))";
        List<Eroom> list = eroomService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectAll")
    public Map<Object, Object> selectAll(){
        List<Eroom> list = eroomService.selectAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return eroomService.selectByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectBySql")
    public Map<Object, Object> selectBySql(String sql){
        List<Eroom> list = eroomService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPrimaryKey")
    public Map<Object, Object> selectByPrimaryKey(Integer id){
        Eroom object = eroomService.selectByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVAll")
    public Map<Object, Object> selectVAll(){
        List<Eroomv> list = eroomService.selectVAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPage")
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return eroomService.selectVByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectVBySql")
    public Map<Object, Object> selectVBySql(String sql){
        List<Eroomv> list = eroomService.selectVBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPrimaryKey")
    public Map<Object, Object> selectVByPrimaryKey(Integer id){
        Eroomv object = eroomService.selectVByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubAll")
    public Map<Object, Object> selectSubAll(Integer projectid){
        List<Eroom> list = eroomService.selectSubAll(projectid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubByPage")
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        return eroomService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectSubBySql")
    public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
        List<Eroom> list = eroomService.selectSubBySql(projectid, sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubByPrimaryKey")
    public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
        Eroom object = eroomService.selectSubByPrimaryKey(projectid, id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVAll")
    public Map<Object, Object> selectSubVAll(Integer projectid){
        List<Eroomv> list = eroomService.selectSubVAll(projectid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVByPage")
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        return eroomService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVBySql")
    public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
        List<Eroomv> list = eroomService.selectSubVBySql(projectid, sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVByPrimaryKey")
    public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
        Eroomv object = eroomService.selectSubVByPrimaryKey(projectid, id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, Integer bimid, String status, Integer level, String modelfile, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(item, bimid, 0)){
            Eroomv room = eroomService.insert(item, bimid, status, level, modelfile, note);
            if(room != null)
                map = new BeanMap(room);
        }else{
            map.put("isError", true);
            map.put("msg", "该房间已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, Integer bimid, String status, Integer level, String modelfile, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(item, bimid, id)){
            Eroomv room = eroomService.update(id, item, bimid, status, level, modelfile, note);
            if(room != null)
                map = new BeanMap(room);
        }else{
            map.put("isError", true);
            map.put("msg", "该房间已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/delete")
    public Map<Object, Object> delete(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(eroomService.delete(id) > 0)
            map.put("success", true);
        else
            map.put("success", false);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JSONArray list(Integer bimid){
        JSONArray jsonArray = new JSONArray();
        List<Eroom> list = eroomService.selectBySql("bimid=" + bimid);
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
        select.setText("正常");
        select.setValue("正常");
        jsonArray.add(select);
        select = new Select();
        select.setText("维修");
        select.setValue("维修");
        jsonArray.add(select);
        select = new Select();
        select.setText("告警");
        select.setValue("告警");
        jsonArray.add(select);
        return jsonArray;
    }

    public boolean isValidate(String item, Integer bimid, Integer id){
        List<Eroom> list = eroomService.selectBySql("item='" + item + "' and bimid=" + bimid + " and id!=" + id);
        if(list.size() > 0)
            return false;
        else
            return true;
    }
}