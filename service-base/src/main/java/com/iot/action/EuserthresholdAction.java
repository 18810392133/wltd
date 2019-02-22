package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.*;
import com.iot.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userthreshold")
public class EuserthresholdAction {
    @Resource
    private EuserthresholdService euserthresholdService;
    @Resource
    private EuserService euserService;
    @Resource
    private EthresholdService ethresholdService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Euserthreshold> selectAll(){
        return euserthresholdService.selectAll();
    }

    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Euserthreshold> list = euserthresholdService.selectByPage(page, rows, sort, order, filterRules);
        PageInfo<Euserthreshold> pageInfo = new PageInfo<Euserthreshold>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
    public List<Euserthreshold> selectBySql(String sql){
        return euserthresholdService.selectBySql(sql);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Euserthreshold selectByPrimaryKey(Integer id){
        return euserthresholdService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
    public List<Euserthresholdv>  selectVAll(){
        return euserthresholdService.selectVAll();
    }

    @RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Euserthresholdv> list = euserthresholdService.selectVByPage(page, rows, sort, order, filterRules);
        PageInfo<Euserthresholdv> pageInfo = new PageInfo<Euserthresholdv>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
    public List<Euserthresholdv> selectVBySql(String sql){
        return euserthresholdService.selectVBySql(sql);
    }

    @RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
    public Euserthresholdv selectVByPrimaryKey(Integer id){
        return euserthresholdService.selectVByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
    public List<Euserthreshold> selectSubAll(Integer projectid){
        return euserthresholdService.selectSubAll(projectid);
    }

    @RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Euserthreshold> list = euserthresholdService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Euserthreshold> pageInfo = new PageInfo<Euserthreshold>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
    public List<Euserthreshold> selectSubBySql(Integer projectid, String sql){
        return euserthresholdService.selectSubBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Euserthreshold selectSubByPrimaryKey(Integer projectid, Integer id){
        return euserthresholdService.selectSubByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
    public List<Euserthresholdv> selectSubVAll(Integer projectid){
        return euserthresholdService.selectSubVAll(projectid);
    }

    @RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Euserthresholdv> list = euserthresholdService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Euserthresholdv> pageInfo = new PageInfo<Euserthresholdv>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
    public List<Euserthresholdv> selectSubVBySql(Integer projectid, String sql){
        return euserthresholdService.selectSubVBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Euserthresholdv selectSubVByPrimaryKey(Integer projectid, Integer id){
        return euserthresholdService.selectSubVByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Euserthresholdv insert(Integer userid, Integer thresholdid, String note){
        Euserthresholdv userthreshold = new Euserthresholdv();
        userthreshold.setUserid(userid);
        userthreshold.setThresholdid(thresholdid);
        userthreshold.setNote(note);
        euserthresholdService.insert(userthreshold);
        userthreshold.setUser(euserService.selectVByPrimaryKey(userid));
        userthreshold.setThreshold(ethresholdService.selectVByPrimaryKey(thresholdid));
        return userthreshold;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Euserthresholdv update(Integer id, Integer userid, Integer thresholdid, String note){
        Euserthresholdv userthreshold = euserthresholdService.selectVByPrimaryKey(id);
        if(userthreshold != null){
            userthreshold.setUserid(userid);
            userthreshold.setThresholdid(thresholdid);
            userthreshold.setNote(note);
            euserthresholdService.updateByPrimaryKey(userthreshold);
            userthreshold.setUser(euserService.selectVByPrimaryKey(userid));
            userthreshold.setThreshold(ethresholdService.selectVByPrimaryKey(thresholdid));
        }
        return userthreshold;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int delete(Integer id){
        return euserthresholdService.deleteByPrimaryKey(id);
    }
}