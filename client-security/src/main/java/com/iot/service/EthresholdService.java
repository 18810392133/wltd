package com.iot.service;

import com.iot.bean.Ethreshold;
import com.iot.bean.Ethresholdv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EthresholdServiceImpl.class)
public interface EthresholdService {
    @RequestMapping(value = "/threshold/selectAll", method = RequestMethod.GET)
    public List<Ethreshold> selectAll();

    @RequestMapping(value = "/threshold/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/threshold/selectBySql", method = RequestMethod.GET)
    public List<Ethreshold> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/threshold/selectByPrimaryKey", method = RequestMethod.GET)
    public Ethreshold selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/threshold/selectVAll", method = RequestMethod.GET)
    public List<Ethresholdv> selectVAll();

    @RequestMapping(value = "/threshold/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/threshold/selectVBySql", method = RequestMethod.GET)
    public List<Ethresholdv> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/threshold/selectVByPrimaryKey", method = RequestMethod.GET)
    public Ethresholdv selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/threshold/selectSubAll", method = RequestMethod.GET)
    public List<Ethreshold> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/threshold/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/threshold/selectSubBySql", method = RequestMethod.GET)
    public List<Ethreshold> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/threshold/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Ethreshold selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/threshold/selectSubVAll", method = RequestMethod.GET)
    public List<Ethresholdv> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/threshold/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/threshold/selectSubVBySql", method = RequestMethod.GET)
    public List<Ethresholdv> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/threshold/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Ethresholdv selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/threshold/insert", method = RequestMethod.POST)
    public Ethresholdv insert(@RequestParam("item") String item, @RequestParam("attrid") Integer attrid, @RequestParam("level") Integer level, @RequestParam("overtime") Integer overtime, @RequestParam("note") String note);

    @RequestMapping(value = "/threshold/update", method = RequestMethod.PUT)
    public Ethresholdv update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("attrid") Integer attrid, @RequestParam("level") Integer level, @RequestParam("overtime") Integer overtime, @RequestParam("note") String note);

    @RequestMapping(value = "/threshold/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}