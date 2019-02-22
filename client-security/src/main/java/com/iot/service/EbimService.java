package com.iot.service;

import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EbimServiceImpl.class)
public interface EbimService {
    @RequestMapping(value = "/bim/selectAll", method = RequestMethod.GET)
    public List<Ebim> selectAll();

    @RequestMapping(value = "/bim/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/bim/selectBySql", method = RequestMethod.GET)
    public List<Ebim> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/bim/selectByPrimaryKey", method = RequestMethod.GET)
    public Ebim selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/bim/selectVAll", method = RequestMethod.GET)
    public List<Ebimv> selectVAll();

    @RequestMapping(value = "/bim/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/bim/selectVBySql", method = RequestMethod.GET)
    public List<Ebimv> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/bim/selectVByPrimaryKey", method = RequestMethod.GET)
    public Ebimv selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/bim/selectSubAll", method = RequestMethod.GET)
    public List<Ebim> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/bim/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/bim/selectSubBySql", method = RequestMethod.GET)
    public List<Ebim> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/bim/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Ebim selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/bim/selectSubVAll", method = RequestMethod.GET)
    public List<Ebimv> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/bim/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/bim/selectSubVBySql", method = RequestMethod.GET)
    public List<Ebimv> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/bim/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Ebimv selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/bim/insert", method = RequestMethod.POST)
    public Ebimv insert(@RequestParam("item") String item, @RequestParam("platid") Integer platid, @RequestParam("longitude") String longitude, @RequestParam("latitude") String latitude, @RequestParam("status") String status, @RequestParam("level") Integer level, @RequestParam("modelfile") String modelfile, @RequestParam("note") String note);

    @RequestMapping(value = "/bim/update", method = RequestMethod.PUT)
    public Ebimv update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("bimid") Integer bimid, @RequestParam("longitude") String longitude, @RequestParam("latitude") String latitude, @RequestParam("status") String status, @RequestParam("level") Integer level, @RequestParam("modelfile") String modelfile, @RequestParam("note") String note);

    @RequestMapping(value = "/bim/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}