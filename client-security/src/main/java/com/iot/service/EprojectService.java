package com.iot.service;

import com.iot.bean.Eproject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EprojectServiceImpl.class)
public interface EprojectService {
    @RequestMapping(value = "/project/selectAll", method = RequestMethod.GET)
    public List<Eproject> selectAll();

    @RequestMapping(value = "/project/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/project/selectBySql", method = RequestMethod.GET)
    public List<Eproject> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/project/selectByPrimaryKey", method = RequestMethod.GET)
    public Eproject selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/project/insert", method = RequestMethod.POST)
    public Eproject insert(@RequestParam("item") String item, @RequestParam("fileurl") String fileurl, @RequestParam("servicename") String servicename, @RequestParam("dburl") String dburl, @RequestParam("detail") String detail);

    @RequestMapping(value = "/project/update", method = RequestMethod.PUT)
    public Eproject update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("fileurl") String fileurl, @RequestParam("servicename") String servicename, @RequestParam("dburl") String dburl, @RequestParam("detail") String detail);

    @RequestMapping(value = "/project/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}