package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import com.iot.bean.Select;
import com.iot.service.EbimService;
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
@RequestMapping("/bim")
public class EbimAction {
    @Resource
    private EbimService ebimService;

    @AuthToken
    @RequestMapping(value = "/selectUserBim")
    public Map<Object, Object> selectUserBim(Integer userid){
        String sql = "id in (select bimid from eroom where id in (select roomid from edevice where id in (select deviceid from euserdevice where userid=" + userid + ")))";
        List<Ebim> list = ebimService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectAll")
    public Map<Object, Object> selectAll(){
        List<Ebim> list = ebimService.selectAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return ebimService.selectByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectBySql")
    public Map<Object, Object> selectBySql(String sql){
        List<Ebim> list = ebimService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPrimaryKey")
    public Map<Object, Object> selectByPrimaryKey(Integer id){
        Ebim object = ebimService.selectByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVAll")
    public Map<Object, Object> selectVAll(){
        List<Ebimv> list = ebimService.selectVAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPage")
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return ebimService.selectVByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectVBySql")
    public Map<Object, Object> selectVBySql(String sql){
        List<Ebimv> list = ebimService.selectVBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPrimaryKey")
    public Map<Object, Object> selectVByPrimaryKey(Integer id){
        Ebimv object = ebimService.selectVByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubAll")
    public Map<Object, Object> selectSubAll(Integer projectid){
        List<Ebim> list = ebimService.selectSubAll(projectid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubByPage")
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        return ebimService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectSubBySql")
    public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
        List<Ebim> list = ebimService.selectSubBySql(projectid, sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubByPrimaryKey")
    public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
        Ebim object = ebimService.selectSubByPrimaryKey(projectid, id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVAll")
    public Map<Object, Object> selectSubVAll(Integer projectid){
        List<Ebimv> list = ebimService.selectSubVAll(projectid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVByPage")
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        return ebimService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVBySql")
    public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
        List<Ebimv> list = ebimService.selectSubVBySql(projectid, sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVByPrimaryKey")
    public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
        Ebimv object = ebimService.selectSubVByPrimaryKey(projectid, id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, Integer platid, String longitude, String latitude, String status, Integer level, String modelfile, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(item, platid, 0)){
            Ebimv bim = ebimService.insert(item, platid, longitude, latitude, status, level, modelfile, note);
            if(bim != null)
                map = new BeanMap(bim);
        }else{
            map.put("isError", true);
            map.put("msg", "该节点已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, Integer platid, String longitude, String latitude, String status, Integer level, String modelfile, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(item, platid, id)){
            Ebimv bim = ebimService.update(id, item, platid, longitude, latitude, status, level, modelfile, note);
            if(bim != null)
                map = new BeanMap(bim);
        }else{
            map.put("isError", true);
            map.put("msg", "该节点已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/delete")
    public Map<Object, Object> delete(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(ebimService.delete(id) > 0)
            map.put("success", true);
        else
            map.put("success", false);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JSONArray list(Integer platid){
        JSONArray jsonArray = new JSONArray();
        List<Ebim> list = ebimService.selectBySql("platid=" + platid);
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

    public boolean isValidate(String item, Integer platid, Integer id){
        List<Ebim> list = ebimService.selectBySql("item='" + item + "' and platid=" + platid + " and id!=" + id);
        if(list.size() > 0)
            return false;
        else
            return true;
    }
}