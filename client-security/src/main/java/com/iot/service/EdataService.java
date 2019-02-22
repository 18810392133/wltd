package com.iot.service;

import com.iot.bean.Edata;
import com.iot.bean.Edatav;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@FeignClient(value = "service-security", fallback = EdataServiceImpl.class)
public interface EdataService {
    @RequestMapping(value = "/data/selectAll", method = RequestMethod.GET)
    public List<Edata> selectAll();

    @RequestMapping(value = "/data/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/data/selectBySql", method = RequestMethod.GET)
    public List<Edata> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/data/selectByPrimaryKey", method = RequestMethod.GET)
    public Edata selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/data/selectVAll", method = RequestMethod.GET)
    public List<Edatav> selectVAll();

    @RequestMapping(value = "/data/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/data/selectVBySql", method = RequestMethod.GET)
    public List<Edatav> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/data/selectVByPrimaryKey", method = RequestMethod.GET)
    public Edatav selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/data/insert", method = RequestMethod.POST)
    public Edatav insert(@RequestParam("item") String item, @RequestParam("deviceid") Integer deviceid, @RequestParam("attrid") Integer attrid, @RequestParam("time") String time, @RequestParam("note") String note);

    @RequestMapping(value = "/data/update", method = RequestMethod.PUT)
    public Edatav update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("deviceid") Integer deviceid, @RequestParam("attrid") Integer attrid, @RequestParam("time") String time, @RequestParam("note") String note);

    @RequestMapping(value = "/data/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}