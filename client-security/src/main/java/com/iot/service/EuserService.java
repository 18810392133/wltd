package com.iot.service;

import com.iot.bean.Euser;
import com.iot.bean.Euserv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EuserServiceImpl.class)
public interface EuserService {
    @RequestMapping(value = "/user/selectAll", method = RequestMethod.GET)
    public List<Euser> selectAll();

    @RequestMapping(value = "/user/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/user/selectBySql", method = RequestMethod.GET)
    public List<Euser> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/user/selectByPrimaryKey", method = RequestMethod.GET)
    public Euser selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/user/selectVAll", method = RequestMethod.GET)
    public List<Euserv> selectVAll();

    @RequestMapping(value = "/user/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/user/selectVBySql", method = RequestMethod.GET)
    public List<Euserv> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/user/selectVByPrimaryKey", method = RequestMethod.GET)
    public Euserv selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/user/selectSubAll", method = RequestMethod.GET)
    public List<Euser> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/user/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/user/selectSubBySql", method = RequestMethod.GET)
    public List<Euser> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/user/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Euser selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/user/selectSubVAll", method = RequestMethod.GET)
    public List<Euserv> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/user/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/user/selectSubVBySql", method = RequestMethod.GET)
    public List<Euserv> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/user/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Euserv selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    public Euserv insert(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("projectid") Integer projectid, @RequestParam("type") String type, @RequestParam("realname") String realname, @RequestParam("phone") String phone, @RequestParam("wechat") String wechat, @RequestParam("time") String time, @RequestParam("status") String status);

    @RequestMapping(value = "/user/update", method = RequestMethod.PUT)
    public Euserv update(@RequestParam("id") Integer id, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("projectid") Integer projectid, @RequestParam("type") String type, @RequestParam("realname") String realname, @RequestParam("phone") String phone, @RequestParam("wechat") String wechat, @RequestParam("time") String time, @RequestParam("status") String status);

    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}