package com.iot.service;

import com.iot.bean.Euserthreshold;
import com.iot.bean.Euserthresholdv;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@FeignClient(value = "service-base", fallback = EuserthresholdServiceImpl.class)
public interface EuserthresholdService {
    @RequestMapping(value = "/userthreshold/selectAll", method = RequestMethod.GET)
    public List<Euserthreshold> selectAll();

    @RequestMapping(value = "/userthreshold/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/userthreshold/selectBySql", method = RequestMethod.GET)
    public List<Euserthreshold> selectBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/userthreshold/selectByPrimaryKey", method = RequestMethod.GET)
    public Euserthreshold selectByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/userthreshold/selectVAll", method = RequestMethod.GET)
    public List<Euserthresholdv> selectVAll();

    @RequestMapping(value = "/userthreshold/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/userthreshold/selectVBySql", method = RequestMethod.GET)
    public List<Euserthresholdv> selectVBySql(@RequestParam("sql") String sql);

    @RequestMapping(value = "/userthreshold/selectVByPrimaryKey", method = RequestMethod.GET)
    public Euserthresholdv selectVByPrimaryKey(@RequestParam("id") Integer id);

    @RequestMapping(value = "/userthreshold/selectVByUserAttr", method = RequestMethod.GET)
    public List<Euserthresholdv> selectVByUserAttr(@RequestParam("userid") Integer userid, @RequestParam("attrid") Integer attrid);

    @RequestMapping(value = "/userthreshold/selectSubAll", method = RequestMethod.GET)
    public List<Euserthreshold> selectSubAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/userthreshold/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/userthreshold/selectSubBySql", method = RequestMethod.GET)
    public List<Euserthreshold> selectSubBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/userthreshold/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Euserthreshold selectSubByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/userthreshold/selectSubVAll", method = RequestMethod.GET)
    public List<Euserthresholdv> selectSubVAll(@RequestParam("projectid") Integer projectid);

    @RequestMapping(value = "/userthreshold/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(@RequestParam("projectid") Integer projectid, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestParam("sort") String sort, @RequestParam("order") String order, @RequestParam("filterRules") String filterRules);

    @RequestMapping(value = "/userthreshold/selectSubVBySql", method = RequestMethod.GET)
    public List<Euserthresholdv> selectSubVBySql(@RequestParam("projectid") Integer projectid, @RequestParam("sql") String sql);

    @RequestMapping(value = "/userthreshold/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Euserthresholdv selectSubVByPrimaryKey(@RequestParam("projectid") Integer projectid, @RequestParam("id") Integer id);

    @RequestMapping(value = "/userthreshold/insert", method = RequestMethod.POST)
    public Euserthresholdv insert(@RequestParam("userid") Integer userid, @RequestParam("thresholdid") Integer thresholdid, @RequestParam("note") String note);

    @RequestMapping(value = "/userthreshold/update", method = RequestMethod.PUT)
    public Euserthresholdv update(@RequestParam("id") Integer id, @RequestParam("userid") Integer userid, @RequestParam("thresholdid") Integer thresholdid, @RequestParam("note") String note);

    @RequestMapping(value = "/userthreshold/delete", method = RequestMethod.DELETE)
    public int delete(@RequestParam("id") Integer id);
}