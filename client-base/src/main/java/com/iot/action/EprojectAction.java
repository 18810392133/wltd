package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.bean.Eproject;
import com.iot.bean.Select;
import com.iot.service.EprojectService;
import com.iot.util.AuthToken;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class EprojectAction {
    @Resource
    private EprojectService eprojectService;

    @CrossOrigin
    @AuthToken
    @RequestMapping(value = "/selectAll")
    public Map<Object, Object> selectAll(){
        List<Eproject> list = eprojectService.selectAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }
    @CrossOrigin
    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return eprojectService.selectByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectBySql")
    public Map<Object, Object> selectBySql(String sql){
        List<Eproject> list = eprojectService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPrimaryKey")
    public Map<Object, Object> selectByPrimaryKey(Integer id){
        Eproject object = eprojectService.selectByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, String fileurl, String servicename, String dburl, String detail){
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(item, 0)){
            Eproject project = eprojectService.insert(item, fileurl, servicename, dburl, detail);
            if(project != null)
                map = new BeanMap(project);
        }else{
            map.put("isError", true);
            map.put("msg", "该项目已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, String fileurl, String servicename, String dburl, String detail){
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(item, id)){
            Eproject project = eprojectService.update(id, item, fileurl, servicename, dburl, detail);
            if(project != null)
                map = new BeanMap(project);
        }else{
            map.put("isError", true);
            map.put("msg", "该项目已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/delete")
    public Map<Object, Object> delete(Integer id){
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(eprojectService.delete(id) > 0)
            map.put("success", true);
        else
            map.put("success", false);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JSONArray list(){
        JSONArray jsonArray = new JSONArray();
        List<Eproject> list = eprojectService.selectAll();
        for(int i = 0; i < list.size(); i++){
            Select select = new Select();
            select.setText(list.get(i).getItem());
            select.setValue(String.valueOf(list.get(i).getId()));
            jsonArray.add(select);
        }
        return jsonArray;
    }

    public boolean isValidate(String item, Integer id){
        List<Eproject> list = eprojectService.selectBySql("item='" + item + "' and id!=" + id);
        if(list.size() > 0)
            return false;
        else
            return true;
    }
}