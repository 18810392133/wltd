package com.iot.service;

import com.iot.bean.Esensor;
import com.iot.bean.Esensorv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EsensorServiceImpl.class)
public interface EsensorService {
    @RequestMapping(value = "/sensor/selectAll", method = RequestMethod.GET)
    public List<Esensor> selectAll();

    @RequestMapping(value = "/sensor/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/sensor/selectBySql", method = RequestMethod.GET)
    public List<Esensor> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/sensor/selectByPrimaryKey", method = RequestMethod.GET)
    public Esensor selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/sensor/selectVAll", method = RequestMethod.GET)
    public List<Esensorv> selectVAll();

    @RequestMapping(value = "/sensor/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/sensor/selectVBySql", method = RequestMethod.GET)
    public List<Esensorv> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/sensor/selectVByPrimaryKey", method = RequestMethod.GET)
    public Esensorv selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/sensor/selectSubAll", method = RequestMethod.GET)
    public List<Esensor> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/sensor/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/sensor/selectSubBySql", method = RequestMethod.GET)
    public List<Esensor> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/sensor/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Esensor selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/sensor/selectSubVAll", method = RequestMethod.GET)
    public List<Esensorv> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/sensor/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/sensor/selectSubVBySql", method = RequestMethod.GET)
    public List<Esensorv> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/sensor/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Esensorv selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/sensor/insert", method = RequestMethod.POST)
    public Esensorv insert(@RequestParam("item") String item, @RequestParam("projectid") Integer projectid, @RequestParam("protocol") String protocol, @RequestParam("timer") Integer timer, @RequestParam("note") String note);

    @RequestMapping(value = "/sensor/update", method = RequestMethod.PUT)
    public Esensorv update(@RequestParam("id") Integer id, @RequestParam("item") String item, @RequestParam("projectid") Integer projectid, @RequestParam("protocol") String protocol, @RequestParam("timer") Integer timer, @RequestParam("note") String note);

    @RequestMapping(value = "/sensor/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}