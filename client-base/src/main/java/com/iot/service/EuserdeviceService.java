package com.iot.service;

import com.iot.bean.Euserdevice;
import com.iot.bean.Euserdevicev;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EuserdeviceServiceImpl.class)
public interface EuserdeviceService {
    @RequestMapping(value = "/userdevice/selectAll", method = RequestMethod.GET)
    public List<Euserdevice> selectAll();

    @RequestMapping(value = "/userdevice/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/userdevice/selectBySql", method = RequestMethod.GET)
    public List<Euserdevice> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/userdevice/selectByPrimaryKey", method = RequestMethod.GET)
    public Euserdevice selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/userdevice/selectVAll", method = RequestMethod.GET)
    public List<Euserdevicev> selectVAll();

    @RequestMapping(value = "/userdevice/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/userdevice/selectVBySql", method = RequestMethod.GET)
    public List<Euserdevicev> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/userdevice/selectVByPrimaryKey", method = RequestMethod.GET)
    public Euserdevicev selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/userdevice/selectSubAll", method = RequestMethod.GET)
    public List<Euserdevice> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/userdevice/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/userdevice/selectSubBySql", method = RequestMethod.GET)
    public List<Euserdevice> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/userdevice/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Euserdevice selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/userdevice/selectSubVAll", method = RequestMethod.GET)
    public List<Euserdevicev> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/userdevice/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/userdevice/selectSubVBySql", method = RequestMethod.GET)
    public List<Euserdevicev> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/userdevice/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Euserdevicev selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/userdevice/insert", method = RequestMethod.POST)
    public Euserdevicev insert(@RequestParam("userid") Integer userid, @RequestParam("deviceid") Integer deviceid, @RequestParam("note") String note);

    @RequestMapping(value = "/userdevice/update", method = RequestMethod.PUT)
    public Euserdevicev update(@RequestParam("id") Integer id, @RequestParam("userid") Integer userid, @RequestParam("deviceid") Integer deviceid, @RequestParam("note") String note);

    @RequestMapping(value = "/userdevice/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}