package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.bean.*;
import com.iot.service.EbimService;
import com.iot.service.EdeviceService;
import com.iot.service.EroomService;
import com.iot.service.EuserdeviceService;
import com.iot.util.AuthToken;
import org.apache.commons.beanutils.BeanMap;
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
    private EroomService eroomService;
    @Resource
    private EbimService ebimService;
    @Resource
    private EuserdeviceService euserdeviceService;

    @AuthToken
    @RequestMapping(value = "/insertUserDevice")
    public Map<Object, Object> insertUserDevice(Integer platid, Integer bimid, String bimItem, String longitude, String latitude, Integer roomid, String roomItem, String item, Integer sensorid, String protocol, Integer[] userids) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(bimid == 0){
            List<Ebim> bimList = ebimService.selectBySql("item='" + bimItem + "' and platid=" + platid);
            if(bimList.size() > 0){
                map.put("isSuccess", false);
                map.put("msg", "该节点已存在");
            }else{
                Ebimv bim = ebimService.insert(bimItem, platid, longitude, latitude, "正常", 0, "", "");
                bimid = bim.getId();
                List<Eroom> roomList = eroomService.selectBySql("item='" + roomItem + "' and bimid=" + bimid);
                if(roomList.size() > 0){
                    map.put("isSuccess", false);
                    map.put("msg", "该房间已存在");
                }else {
                    Eroomv room = eroomService.insert(roomItem, bimid, "正常", 0, "", "");
                    roomid = room.getId();
                    if(isValidate(item, sensorid, roomid, 0)){
                        Edevicev device = edeviceService.insert(item, sensorid, roomid, protocol, "正常", 0, "");
                        map.put("isSuccess", true);
                        map.put("object", device);
                        for(int i = 0; i < userids.length; i++){
                            List<Euserdevice> userdeviceList = euserdeviceService.selectBySql("userid=" + userids[i] + " and deviceid=" + device.getId());
                            if(userdeviceList.size() > 0){
                                map.put("msg", "某些用户已关联到设备");
                            }else{
                                euserdeviceService.insert(userids[i], device.getId(), "");
                            }
                        }
                    }else{
                        map.put("isSuccess", false);
                        map.put("msg", "该设备已存在");
                    }
                }
            }
        }else if(roomid == 0){
            List<Eroom> roomList = eroomService.selectBySql("item='" + roomItem + "' and bimid=" + bimid);
            if(roomList.size() > 0){
                map.put("isSuccess", false);
                map.put("msg", "该房间已存在");
            }else {
                Eroomv room = eroomService.insert(roomItem, bimid, "正常", 0, "", "");
                roomid = room.getId();
                if(isValidate(item, sensorid, roomid, 0)){
                    Edevicev device = edeviceService.insert(item, sensorid, roomid, protocol, "正常", 0, "");
                    map.put("isSuccess", true);
                    map.put("object", device);
                    for(int i = 0; i < userids.length; i++){
                        List<Euserdevice> userdeviceList = euserdeviceService.selectBySql("userid=" + userids[i] + " and deviceid=" + device.getId());
                        if(userdeviceList.size() > 0){
                            map.put("msg", "某些用户已关联到设备");
                        }else{
                            euserdeviceService.insert(userids[i], device.getId(), "");
                        }
                    }
                }else{
                    map.put("isSuccess", false);
                    map.put("msg", "该设备已存在");
                }
            }
        }else {
            if (isValidate(item, sensorid, roomid, 0)) {
                Edevicev device = edeviceService.insert(item, sensorid, roomid, protocol, "正常", 0, "");
                map.put("isSuccess", true);
                map.put("object", device);
                for(int i = 0; i < userids.length; i++){
                    List<Euserdevice> userdeviceList = euserdeviceService.selectBySql("userid=" + userids[i] + " and deviceid=" + device.getId());
                    if(userdeviceList.size() > 0){
                        map.put("msg", "某些用户已关联到设备");
                    }else{
                        euserdeviceService.insert(userids[i], device.getId(), "");
                    }
                }
            } else {
                map.put("isSuccess", false);
                map.put("msg", "该设备已存在");
            }
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectUserRoomDevice")
    public Map<Object, Object> selectUserRoomDevice(Integer userid, Integer roomid){
        String sql = "roomid=" + roomid + " and id in (select deviceid from euserdevice where userid=" + userid + ")";
        List<Edevice> list = edeviceService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectAll")
    public Map<Object, Object> selectAll(){
        List<Edevice> list = edeviceService.selectAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPage")
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return edeviceService.selectByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectBySql")
    public Map<Object, Object> selectBySql(String sql){
        List<Edevice> list = edeviceService.selectBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectByPrimaryKey")
    public Map<Object, Object> selectByPrimaryKey(Integer id){
        Edevice object = edeviceService.selectByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVAll")
    public Map<Object, Object> selectVAll(){
        List<Edevicev> list = edeviceService.selectVAll();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPage")
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        return edeviceService.selectVByPage(page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectVBySql")
    public Map<Object, Object> selectVBySql(String sql){
        List<Edevicev> list = edeviceService.selectVBySql(sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectVByPrimaryKey")
    public Map<Object, Object> selectVByPrimaryKey(Integer id){
        Edevicev object = edeviceService.selectVByPrimaryKey(id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubAll")
    public Map<Object, Object> selectSubAll(Integer projectid){
        List<Edevice> list = edeviceService.selectSubAll(projectid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubByPage")
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        return edeviceService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectSubBySql")
    public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
        List<Edevice> list = edeviceService.selectSubBySql(projectid, sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubByPrimaryKey")
    public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
        Edevice object = edeviceService.selectSubByPrimaryKey(projectid, id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVAll")
    public Map<Object, Object> selectSubVAll(Integer projectid){
        List<Edevicev> list = edeviceService.selectSubVAll(projectid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVByPage")
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        return edeviceService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVBySql")
    public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
        List<Edevicev> list = edeviceService.selectSubVBySql(projectid, sql);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("list", list);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/selectSubVByPrimaryKey")
    public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
        Edevicev object = edeviceService.selectSubVByPrimaryKey(projectid, id);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("object", object);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/insert")
    public Map<Object, Object> insert(String item, Integer sensorid, Integer roomid, String protocol, String status, Integer level, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(item, sensorid, roomid, 0)){
            Edevicev device = edeviceService.insert(item, sensorid, roomid, protocol, status, level, note);
            if(device != null)
                map = new BeanMap(device);
        }else{
            map.put("isError", true);
            map.put("msg", "该设备已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/update")
    public Map<Object, Object> update(Integer id, String item, Integer sensorid, Integer roomid, String protocol, String status, Integer level, String note) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(isValidate(item, sensorid, roomid, id)){
            Edevicev device = edeviceService.update(id, item, sensorid, roomid, protocol, status, level, note);
            if(device != null)
                map = new BeanMap(device);
        }else{
            map.put("isError", true);
            map.put("msg", "该设备已存在");
        }
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/delete")
    public Map<Object, Object> delete(Integer id) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if(edeviceService.delete(id) > 0)
            map.put("success", true);
        else
            map.put("success", false);
        return map;
    }

    @AuthToken
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JSONArray list(Integer sensorid, Integer roomid){
        JSONArray jsonArray = new JSONArray();
        List<Edevice> list = edeviceService.selectBySql("sensorid=" + sensorid + " and roomid=" + roomid);
        for(int i = 0; i < list.size(); i++){
            Select select = new Select();
            select.setText(list.get(i).getItem());
            select.setValue(String.valueOf(list.get(i).getId()));
            jsonArray.add(select);
        }
        return jsonArray;
    }

    @AuthToken
    @RequestMapping(value = "/statusList", method = RequestMethod.GET)
    public JSONArray statusList(){
        JSONArray jsonArray = new JSONArray();
        Select select = new Select();
        select.setText("正常");
        select.setValue("正常");
        jsonArray.add(select);
        select = new Select();
        select.setText("维修");
        select.setValue("维修");
        jsonArray.add(select);
        select = new Select();
        select.setText("告警");
        select.setValue("告警");
        jsonArray.add(select);
        return jsonArray;
    }

    public boolean isValidate(String item, Integer sensorid, Integer roomid, Integer id){
        List<Edevice> list = edeviceService.selectBySql("item='" + item + "' and sensorid=" + sensorid + " and roomid=" + roomid + " and id!=" + id);
        if(list.size() > 0)
            return false;
        else
            return true;
    }
}