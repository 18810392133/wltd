package com.iot.service;

import com.iot.bean.Eorder;
import com.iot.bean.Eorderv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@FeignClient(value = "service-security", fallback = EorderServiceImpl.class)
public interface EorderService {
    @RequestMapping(value = "/order/selectAll", method = RequestMethod.GET)
    public List<Eorder> selectAll();

    @RequestMapping(value = "/order/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/order/selectBySql", method = RequestMethod.GET)
    public List<Eorder> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/order/selectByPrimaryKey", method = RequestMethod.GET)
    public Eorder selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/order/selectVAll", method = RequestMethod.GET)
    public List<Eorderv> selectVAll();

    @RequestMapping(value = "/order/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/order/selectVBySql", method = RequestMethod.GET)
    public List<Eorderv> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/order/selectVByPrimaryKey", method = RequestMethod.GET)
    public Eorderv selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/order/insert", method = RequestMethod.POST)
    public Eorderv insert(@RequestParam("item") String item, @RequestParam("dataid") Integer dataid, @RequestParam("userid") Integer userid, @RequestParam("status") String status, @RequestParam("level") Integer level, @RequestParam("type") String type, @RequestParam("time") String time, @RequestParam("note") String note);

    @RequestMapping(value = "/order/update", method = RequestMethod.PUT)
    public Eorderv update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("dataid") Integer dataid, @RequestParam("userid") Integer userid, @RequestParam("status") String status, @RequestParam("level") Integer level, @RequestParam("type") String type, @RequestParam("time") String time, @RequestParam("note") String note);

    @RequestMapping(value = "/order/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}