package com.iot.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EuserServiceImpl.class)
public interface EuserService {
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public Map<Object, Object> login(@RequestParam("request") HttpServletRequest request, @RequestParam("item") String item, @RequestParam("password") String password, @RequestParam("servicename") String servicename);

    @RequestMapping(value = "/user/select", method = RequestMethod.GET)
    public Map<Object, Object> select();

    @RequestMapping(value = "/user/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/user/selectBySql", method = RequestMethod.GET)
    public Map<Object, Object> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/user/selectByPrimaryKey", method = RequestMethod.GET)
    public Map<Object, Object> selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/user/selectVAll", method = RequestMethod.GET)
    public Map<Object, Object> selectVAll();

    @RequestMapping(value = "/user/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/user/selectVBySql", method = RequestMethod.GET)
    public Map<Object, Object> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/user/selectVByPrimaryKey", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/user/selectSubAll", method = RequestMethod.GET)
    public Map<Object, Object> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/user/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/user/selectSubBySql", method = RequestMethod.GET)
    public Map<Object, Object> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/user/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/user/selectSubVAll", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/user/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/user/selectSubVBySql", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/user/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    public Map<Object, Object> insert(@RequestParam("item") String item, @RequestParam("password") String password, @RequestParam("projectid") Integer projectid, @RequestParam("type") String type, @RequestParam("realname") String realname, @RequestParam("age") Integer age, @RequestParam("time") String time, @RequestParam("status") String status);

    @RequestMapping(value = "/user/update", method = RequestMethod.PUT)
    public Map<Object, Object> update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("password") String password, @RequestParam("projectid") Integer projectid, @RequestParam("type") String type, @RequestParam("realname") String realname, @RequestParam("age") Integer age, @RequestParam("time") String time, @RequestParam("status") String status);

    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
    public Map<Object, Object> delete(@RequestParam("id") Integer id);

    @RequestMapping(value = "/user/typeCombobox", method = RequestMethod.GET)
    public JSONArray typeCombobox();

    @RequestMapping(value = "/user/statusCombobox", method = RequestMethod.GET)
    public JSONArray statusCombobox();
}