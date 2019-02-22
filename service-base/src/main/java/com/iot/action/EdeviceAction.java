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
@RequestMapping("/device")
public class EdeviceAction {
    @Resource
    private EdeviceService edeviceService;
    @Resource
    private EsensorService esensorService;
    @Resource
    private EroomService eroomService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Edevice> selectAll(){
        return edeviceService.selectAll();
    }

    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Edevice> list = edeviceService.selectByPage(page, rows, sort, order, filterRules);
        PageInfo<Edevice> pageInfo = new PageInfo<Edevice>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
    public List<Edevice> selectBySql(String sql){
        return edeviceService.selectBySql(sql);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Edevice selectByPrimaryKey(Integer id){
        return edeviceService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
    public List<Edevicev>  selectVAll(){
        return edeviceService.selectVAll();
    }

    @RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Edevicev> list = edeviceService.selectVByPage(page, rows, sort, order, filterRules);
        PageInfo<Edevicev> pageInfo = new PageInfo<Edevicev>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
    public List<Edevicev> selectVBySql(String sql){
        return edeviceService.selectVBySql(sql);
    }

    @RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
    public Edevicev selectVByPrimaryKey(Integer id){
        return edeviceService.selectVByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
    public List<Edevice> selectSubAll(Integer projectid){
        return edeviceService.selectSubAll(projectid);
    }

    @RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Edevice> list = edeviceService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Edevice> pageInfo = new PageInfo<Edevice>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
    public List<Edevice> selectSubBySql(Integer projectid, String sql){
        return edeviceService.selectSubBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Edevice selectSubByPrimaryKey(Integer projectid, Integer id){
        return edeviceService.selectSubByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
    public List<Edevicev> selectSubVAll(Integer projectid){
        return edeviceService.selectSubVAll(projectid);
    }

    @RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Edevicev> list = edeviceService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Edevicev> pageInfo = new PageInfo<Edevicev>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
    public List<Edevicev> selectSubVBySql(Integer projectid, String sql){
        return edeviceService.selectSubVBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Edevicev selectSubVByPrimaryKey(Integer projectid, Integer id){
        return edeviceService.selectSubVByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Edevicev insert(String item, Integer sensorid, Integer roomid, String protocol, String status, String note){
        Edevicev device = new Edevicev();
        device.setItem(item);
        device.setSensorid(sensorid);
        device.setRoomid(roomid);
        device.setProtocol(protocol);
        device.setStatus(status);
        device.setNote(note);
        edeviceService.insert(device);
        device.setSensor(esensorService.selectVByPrimaryKey(sensorid));
        device.setRoom(eroomService.selectVByPrimaryKey(roomid));
        return device;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Edevicev update(Integer id, String item, Integer sensorid, Integer roomid, String protocol, String status, String note){
        Edevicev device = edeviceService.selectVByPrimaryKey(id);
        if(device != null){
            device.setItem(item);
            device.setSensorid(sensorid);
            device.setRoomid(roomid);
            device.setProtocol(protocol);
            device.setStatus(status);
            device.setNote(note);
            edeviceService.updateByPrimaryKey(device);
            device.setSensor(esensorService.selectVByPrimaryKey(sensorid));
            device.setRoom(eroomService.selectVByPrimaryKey(roomid));
        }
        return device;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int delete(Integer id){
        return edeviceService.deleteByPrimaryKey(id);
    }
}