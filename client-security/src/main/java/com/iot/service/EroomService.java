package com.iot.service;

import com.iot.bean.Eroom;
import com.iot.bean.Eroomv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EroomServiceImpl.class)
public interface EroomService {
    @RequestMapping(value = "/room/selectAll", method = RequestMethod.GET)
    public List<Eroom> selectAll();

    @RequestMapping(value = "/room/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/room/selectBySql", method = RequestMethod.GET)
    public List<Eroom> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/room/selectByPrimaryKey", method = RequestMethod.GET)
    public Eroom selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/room/selectVAll", method = RequestMethod.GET)
    public List<Eroomv> selectVAll();

    @RequestMapping(value = "/room/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/room/selectVBySql", method = RequestMethod.GET)
    public List<Eroomv> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/room/selectVByPrimaryKey", method = RequestMethod.GET)
    public Eroomv selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/room/selectSubAll", method = RequestMethod.GET)
    public List<Eroom> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/room/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/room/selectSubBySql", method = RequestMethod.GET)
    public List<Eroom> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/room/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Eroom selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/room/selectSubVAll", method = RequestMethod.GET)
    public List<Eroomv> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/room/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/room/selectSubVBySql", method = RequestMethod.GET)
    public List<Eroomv> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/room/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Eroomv selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/room/insert", method = RequestMethod.POST)
    public Eroomv insert(@RequestParam("item") String item, @RequestParam("bimid") Integer bimid, @RequestParam("status") String status, @RequestParam("modelfile") String modelfile, @RequestParam("note") String note);

    @RequestMapping(value = "/room/update", method = RequestMethod.PUT)
    public Eroomv update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("bimid") Integer bimid, @RequestParam("status") String status, @RequestParam("modelfile") String modelfile, @RequestParam("note") String note);

    @RequestMapping(value = "/room/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}