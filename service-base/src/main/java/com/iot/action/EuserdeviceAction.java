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
@RequestMapping("/userdevice")
public class EuserdeviceAction {
    @Resource
    private EuserdeviceService euserdeviceService;
    @Resource
    private EuserService euserService;
    @Resource
    private EdeviceService edeviceService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Euserdevice> selectAll(){
        return euserdeviceService.selectAll();
    }

    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Euserdevice> list = euserdeviceService.selectByPage(page, rows, sort, order, filterRules);
        PageInfo<Euserdevice> pageInfo = new PageInfo<Euserdevice>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
    public List<Euserdevice> selectBySql(String sql){
        return euserdeviceService.selectBySql(sql);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Euserdevice selectByPrimaryKey(Integer id){
        return euserdeviceService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
    public List<Euserdevicev>  selectVAll(){
        return euserdeviceService.selectVAll();
    }

    @RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Euserdevicev> list = euserdeviceService.selectVByPage(page, rows, sort, order, filterRules);
        PageInfo<Euserdevicev> pageInfo = new PageInfo<Euserdevicev>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
    public List<Euserdevicev> selectVBySql(String sql){
        return euserdeviceService.selectVBySql(sql);
    }

    @RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
    public Euserdevicev selectVByPrimaryKey(Integer id){
        return euserdeviceService.selectVByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
    public List<Euserdevice> selectSubAll(Integer projectid){
        return euserdeviceService.selectSubAll(projectid);
    }

    @RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Euserdevice> list = euserdeviceService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Euserdevice> pageInfo = new PageInfo<Euserdevice>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
    public List<Euserdevice> selectSubBySql(Integer projectid, String sql){
        return euserdeviceService.selectSubBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Euserdevice selectSubByPrimaryKey(Integer projectid, Integer id){
        return euserdeviceService.selectSubByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
    public List<Euserdevicev> selectSubVAll(Integer projectid){
        return euserdeviceService.selectSubVAll(projectid);
    }

    @RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Euserdevicev> list = euserdeviceService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Euserdevicev> pageInfo = new PageInfo<Euserdevicev>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
    public List<Euserdevicev> selectSubVBySql(Integer projectid, String sql){
        return euserdeviceService.selectSubVBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Euserdevicev selectSubVByPrimaryKey(Integer projectid, Integer id){
        return euserdeviceService.selectSubVByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Euserdevicev insert(Integer userid, Integer deviceid, String note){
        Euserdevicev userdevice = new Euserdevicev();
        userdevice.setUserid(userid);
        userdevice.setDeviceid(deviceid);
        userdevice.setNote(note);
        euserdeviceService.insert(userdevice);
        userdevice.setUser(euserService.selectVByPrimaryKey(userid));
        userdevice.setDevice(edeviceService.selectVByPrimaryKey(deviceid));
        return userdevice;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Euserdevicev update(Integer id, Integer userid, Integer deviceid, String note){
        Euserdevicev userdevice = euserdeviceService.selectVByPrimaryKey(id);
        if(userdevice != null){
            userdevice.setUserid(userid);
            userdevice.setDeviceid(deviceid);
            userdevice.setNote(note);
            euserdeviceService.updateByPrimaryKey(userdevice);
            userdevice.setUser(euserService.selectVByPrimaryKey(userid));
            userdevice.setDevice(edeviceService.selectVByPrimaryKey(deviceid));
        }
        return userdevice;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int delete(Integer id){
        return euserdeviceService.deleteByPrimaryKey(id);
    }
}