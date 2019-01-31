package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.service.EbimService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/bim")
public class EbimAction {
    @Resource
    private EbimService ebimService;

    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return ebimService.selectByPage(page, rows, sort, order, filterRules);
    }

    @RequestMapping(value = "/selectVByPage")
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return ebimService.selectVByPage(page, rows, sort, order, filterRules);
    }

    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, Integer platid, String longitude, String latitude, String status, String note) {
        return ebimService.insert(item, platid, longitude, latitude, status, note);
    }

    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, Integer platid, String longitude, String latitude, String status, String note) {
        return ebimService.update(id, item, platid, longitude, latitude, status, note);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<Object, Object> delete(Integer id) {
        return ebimService.delete(id);
    }

    @RequestMapping(value = "/statusCombobox")
    public JSONArray statusCombobox() {
        return ebimService.statusCombobox();
    }
}