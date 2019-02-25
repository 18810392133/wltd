package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.bean.Euserthreshold;
import com.iot.bean.Euserthresholdv;
import com.iot.bean.Select;
import com.iot.service.EuserthresholdService;
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
@RequestMapping("/userthreshold")
public class EuserthresholdAction {
    @Resource
    private EuserthresholdService euserthresholdService;

    @AuthToken
    @RequestMapping(value = "/selectAll")
    public Map<Object, Object> selectAll(){
        List<Euserthreshold> list = euserthresholdService.selectAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return euserthresholdService.selectByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectBySql")
    public Map<Object, Object> selectBySql(String sql){
        List<Euserthreshold> list = euserthresholdService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPrimaryKey")
    public Map<Object, Object> selectByPrimaryKey(Integer id){
        Euserthreshold object = euserthresholdService.selectByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVAll")
    public Map<Object, Object> selectVAll(){
        List<Euserthresholdv> list = euserthresholdService.selectVAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPage")
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return euserthresholdService.selectVByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectVBySql")
    public Map<Object, Object> selectVBySql(String sql){
        List<Euserthresholdv> list = euserthresholdService.selectVBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPrimaryKey")
    public Map<Object, Object> selectVByPrimaryKey(Integer id){
        Euserthresholdv object = euserthresholdService.selectVByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByUserAttr")
    public Map<Object, Object> selectVByUserAttr(Integer userid, Integer attrid){
        List<Euserthresholdv> list = euserthresholdService.selectVByUserAttr(userid, attrid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubAll")
    public Map<Object, Object> selectSubAll(Integer projectid){
        List<Euserthreshold> list = euserthresholdService.selectSubAll(projectid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubByPage")
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        return euserthresholdService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectSubBySql")
    public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
        List<Euserthreshold> list = euserthresholdService.selectSubBySql(projectid, sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubByPrimaryKey")
    public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
        Euserthreshold object = euserthresholdService.selectSubByPrimaryKey(projectid, id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVAll")
    public Map<Object, Object> selectSubVAll(Integer projectid){
        List<Euserthresholdv> list = euserthresholdService.selectSubVAll(projectid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVByPage")
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        return euserthresholdService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVBySql")
    public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
        List<Euserthresholdv> list = euserthresholdService.selectSubVBySql(projectid, sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVByPrimaryKey")
    public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
        Euserthresholdv object = euserthresholdService.selectSubVByPrimaryKey(projectid, id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(Integer userid, Integer thresholdid, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(userid, thresholdid, 0)){
            Euserthresholdv userthreshold = euserthresholdService.insert(userid, thresholdid, note);
            if(userthreshold != null)
                map = new BeanMap(userthreshold);
        }else{
            map.put("isError", true);
            map.put("msg", "该用户阈值已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, Integer userid, Integer thresholdid, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(userid, thresholdid, id)){
            Euserthresholdv userthreshold = euserthresholdService.update(id, userid, thresholdid, note);
            if(userthreshold != null)
                map = new BeanMap(userthreshold);
        }else{
            map.put("isError", true);
            map.put("msg", "该用户阈值已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/delete")
    public Map<Object, Object> delete(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(euserthresholdService.delete(id) > 0)
            map.put("success", true);
        else
            map.put("success", false);
        return map;
    }

    public boolean isValidate(Integer userid, Integer thresholdid, Integer id){
        List<Euserthreshold> list = euserthresholdService.selectBySql("userid=" + userid + " and thresholdid=" + thresholdid + " and id!=" + id);
        if(list.size() > 0)
            return false;
        else
            return true;
    }
}