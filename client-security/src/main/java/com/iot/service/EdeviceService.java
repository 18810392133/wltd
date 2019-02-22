package com.iot.service;

import com.iot.bean.Edevice;
import com.iot.bean.Edevicev;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EdeviceServiceImpl.class)
public interface EdeviceService {
    @RequestMapping(value = "/device/selectAll", method = RequestMethod.GET)
    public List<Edevice> selectAll();

    @RequestMapping(value = "/device/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/device/selectBySql", method = RequestMethod.GET)
    public List<Edevice> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/device/selectByPrimaryKey", method = RequestMethod.GET)
    public Edevice selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/device/selectVAll", method = RequestMethod.GET)
    public List<Edevicev> selectVAll();

    @RequestMapping(value = "/device/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/device/selectVBySql", method = RequestMethod.GET)
    public List<Edevicev> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/device/selectVByPrimaryKey", method = RequestMethod.GET)
    public Edevicev selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/device/selectSubAll", method = RequestMethod.GET)
    public List<Edevice> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/device/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/device/selectSubBySql", method = RequestMethod.GET)
    public List<Edevice> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/device/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Edevice selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/device/selectSubVAll", method = RequestMethod.GET)
    public List<Edevicev> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/device/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/device/selectSubVBySql", method = RequestMethod.GET)
    public List<Edevicev> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/device/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Edevicev selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/device/insert", method = RequestMethod.POST)
    public Edevicev insert(@RequestParam("item") String item, @RequestParam("sensorid") Integer sensorid, @RequestParam("roomid") Integer roomid, @RequestParam("protocol") String protocol, @RequestParam("status") String status, @RequestParam("level") Integer level, @RequestParam("note") String note);

    @RequestMapping(value = "/device/update", method = RequestMethod.PUT)
    public Edevicev update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("sensorid") Integer sensorid, @RequestParam("roomid") Integer roomid, @RequestParam("protocol") String protocol, @RequestParam("status") String status, @RequestParam("level") Integer level, @RequestParam("note") String note);

    @RequestMapping(value = "/device/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}