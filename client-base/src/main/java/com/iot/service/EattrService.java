package com.iot.service;

import com.iot.bean.Eattr;
import com.iot.bean.Eattrv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EattrServiceImpl.class)
public interface EattrService {
    @RequestMapping(value = "/attr/selectAll", method = RequestMethod.GET)
    public List<Eattr> selectAll();

    @RequestMapping(value = "/attr/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/attr/selectBySql", method = RequestMethod.GET)
    public List<Eattr> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/attr/selectByPrimaryKey", method = RequestMethod.GET)
    public Eattr selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/attr/selectVAll", method = RequestMethod.GET)
    public List<Eattrv> selectVAll();

    @RequestMapping(value = "/attr/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/attr/selectVBySql", method = RequestMethod.GET)
    public List<Eattrv> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/attr/selectVByPrimaryKey", method = RequestMethod.GET)
    public Eattrv selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/attr/selectSubAll", method = RequestMethod.GET)
    public List<Eattr> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/attr/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/attr/selectSubBySql", method = RequestMethod.GET)
    public List<Eattr> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/attr/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Eattr selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/attr/selectSubVAll", method = RequestMethod.GET)
    public List<Eattrv> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/attr/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/attr/selectSubVBySql", method = RequestMethod.GET)
    public List<Eattrv> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/attr/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Eattrv selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/attr/insert", method = RequestMethod.POST)
    public Eattrv insert(@RequestParam("item") String item, @RequestParam("sensorid") Integer sensorid, @RequestParam("protocol") String protocol, @RequestParam("compare") String compare, @RequestParam("unit") String unit, @RequestParam("timer") Integer timer, @RequestParam("note") String note);

    @RequestMapping(value = "/attr/update", method = RequestMethod.PUT)
    public Eattrv update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("sensorid") Integer sensorid, @RequestParam("protocol") String protocol, @RequestParam("compare") String compare, @RequestParam("unit") String unit, @RequestParam("timer") Integer timer, @RequestParam("note") String note);

    @RequestMapping(value = "/attr/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}