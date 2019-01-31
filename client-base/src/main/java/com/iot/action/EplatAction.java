package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.service.EplatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/plat")
public class EplatAction {
    @Resource
    private EplatService eplatService;

    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return eplatService.selectByPage(page, rows, sort, order, filterRules);
    }

    @RequestMapping(value = "/selectVByPage")
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return eplatService.selectVByPage(page, rows, sort, order, filterRules);
    }

    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, Integer projectid, String province, String city, String longitude, String latitude, String note) {
        return eplatService.insert(item, projectid, province, city, longitude, latitude, note);
    }

    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, Integer projectid, String province, String city, String longitude, String latitude, String note) {
        return eplatService.update(id, item, projectid, province, city, longitude, latitude, note);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<Object, Object> delete(Integer id) {
        return eplatService.delete(id);
    }

    @RequestMapping(value = "/provinceCombobox")
    public JSONArray provinceCombobox() {
        return eplatService.provinceCombobox();
    }

    @RequestMapping(value = "/combobox")
    public JSONArray combobox(Integer projectid) {
        return eplatService.combobox(projectid);
    }
}