package com.iot.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EplatServiceImpl.class)
public interface EplatService {
    @RequestMapping(value = "/plat/select", method = RequestMethod.GET)
    public Map<Object, Object> select();

    @RequestMapping(value = "/plat/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/plat/selectBySql", method = RequestMethod.GET)
    public Map<Object, Object> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/plat/selectByPrimaryKey", method = RequestMethod.GET)
    public Map<Object, Object> selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/plat/selectVAll", method = RequestMethod.GET)
    public Map<Object, Object> selectVAll();

    @RequestMapping(value = "/plat/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/plat/selectVBySql", method = RequestMethod.GET)
    public Map<Object, Object> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/plat/selectVByPrimaryKey", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/plat/selectSubAll", method = RequestMethod.GET)
    public Map<Object, Object> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/plat/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/plat/selectSubBySql", method = RequestMethod.GET)
    public Map<Object, Object> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/plat/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/plat/selectSubVAll", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/plat/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/plat/selectSubVBySql", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/plat/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/plat/insert", method = RequestMethod.POST)
    public Map<Object, Object> insert(@RequestParam("item") String item, @RequestParam("projectid") Integer projectid, @RequestParam("province") String province, @RequestParam("city") String city, @RequestParam("longitude") String longitude, @RequestParam("latitude") String latitude, @RequestParam("note") String note);

    @RequestMapping(value = "/plat/update", method = RequestMethod.PUT)
    public Map<Object, Object> update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("projectid") Integer projectid, @RequestParam("province") String province, @RequestParam("city") String city, @RequestParam("longitude") String longitude, @RequestParam("latitude") String latitude, @RequestParam("note") String note);

    @RequestMapping(value = "/plat/delete", method = RequestMethod.DELETE)
    public Map<Object, Object> delete(@RequestParam("id") Integer id);

    @RequestMapping(value = "/plat/provinceCombobox", method = RequestMethod.GET)
    public JSONArray provinceCombobox();

    @RequestMapping(value = "/plat/combobox", method = RequestMethod.GET)
    public JSONArray combobox(@RequestParam("projectid") Integer projectid);
}