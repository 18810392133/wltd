package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.service.EprojectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class EprojectAction {
    @Resource
    private EprojectService eprojectService;

    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return eprojectService.selectByPage(page, rows, sort, order, filterRules);
    }

    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, String fileurl, String servicename, String dburl, String detail){
        return eprojectService.insert(item, fileurl, servicename, dburl, detail);
    }

    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, String fileurl, String servicename, String dburl, String detail){
        return eprojectService.update(id, item, fileurl, servicename, dburl, detail);
    }

    @RequestMapping(value = "/delete")
    public Map<Object, Object> delete(Integer id){
        return eprojectService.delete(id);
    }

    @RequestMapping(value = "/combobox")
    public JSONArray combobox() {
        return eprojectService.combobox();
    }
}