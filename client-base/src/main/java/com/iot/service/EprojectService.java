package com.iot.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "service-base", fallback = EprojectServiceImpl.class)
public interface EprojectService {
    @RequestMapping(value = "/project/select", method = RequestMethod.GET)
    public Map<Object, Object> select();

    @RequestMapping(value = "/project/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/project/insert", method = RequestMethod.POST)
    public Map<Object, Object> insert(@RequestParam("item") String item, @RequestParam("fileurl") String fileurl, @RequestParam("servicename") String servicename, @RequestParam("dburl") String dburl, @RequestParam("detail") String detail);

    @RequestMapping(value = "/project/update", method = RequestMethod.PUT)
    public Map<Object, Object> update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("fileurl") String fileurl, @RequestParam("servicename") String servicename, @RequestParam("dburl") String dburl, @RequestParam("detail") String detail);

    @RequestMapping(value = "/project/delete", method = RequestMethod.DELETE)
    public Map<Object, Object> delete(@RequestParam("id") Integer id);

    @RequestMapping(value = "/project/combobox", method = RequestMethod.GET)
    public JSONArray combobox();
}