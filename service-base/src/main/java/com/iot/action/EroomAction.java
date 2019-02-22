package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.*;
import com.iot.service.EbimService;
import com.iot.service.EroomService;
import com.iot.service.EprojectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class EroomAction {
    @Resource
    private EroomService eroomService;
    @Resource
    private EbimService ebimService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Eroom> selectAll(){
        return eroomService.selectAll();
    }

    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Eroom> list = eroomService.selectByPage(page, rows, sort, order, filterRules);
        PageInfo<Eroom> pageInfo = new PageInfo<Eroom>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
    public List<Eroom> selectBySql(String sql){
        return eroomService.selectBySql(sql);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Eroom selectByPrimaryKey(Integer id){
        return eroomService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
    public List<Eroomv>  selectVAll(){
        return eroomService.selectVAll();
    }

    @RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Eroomv> list = eroomService.selectVByPage(page, rows, sort, order, filterRules);
        PageInfo<Eroomv> pageInfo = new PageInfo<Eroomv>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
    public List<Eroomv> selectVBySql(String sql){
        return eroomService.selectVBySql(sql);
    }

    @RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
    public Eroomv selectVByPrimaryKey(Integer id){
        return eroomService.selectVByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
    public List<Eroom> selectSubAll(Integer projectid){
        return eroomService.selectSubAll(projectid);
    }

    @RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Eroom> list = eroomService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Eroom> pageInfo = new PageInfo<Eroom>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
    public List<Eroom> selectSubBySql(Integer projectid, String sql){
        return eroomService.selectSubBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Eroom selectSubByPrimaryKey(Integer projectid, Integer id){
        return eroomService.selectSubByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
    public List<Eroomv> selectSubVAll(Integer projectid){
        return eroomService.selectSubVAll(projectid);
    }

    @RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Eroomv> list = eroomService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Eroomv> pageInfo = new PageInfo<Eroomv>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
    public List<Eroomv> selectSubVBySql(Integer projectid, String sql){
        return eroomService.selectSubVBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Eroomv selectSubVByPrimaryKey(Integer projectid, Integer id){
        return eroomService.selectSubVByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Eroomv insert(String item, Integer bimid, String status, Integer level, String modelfile, String note){
        Eroomv room = new Eroomv();
        room.setItem(item);
        room.setBimid(bimid);
        room.setStatus(status);
        room.setLevel(level);
        room.setModelfile(modelfile);
        room.setNote(note);
        eroomService.insert(room);
        room.setBim(ebimService.selectVByPrimaryKey(bimid));
        return room;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Eroomv update(Integer id, String item, Integer bimid, String status, Integer level, String modelfile, String note){
        Eroomv room = eroomService.selectVByPrimaryKey(id);
        if(room != null) {
            room.setItem(item);
            room.setBimid(bimid);
            room.setStatus(status);
            room.setLevel(level);
            room.setModelfile(modelfile);
            room.setNote(note);
            eroomService.updateByPrimaryKey(room);
            room.setBim(ebimService.selectVByPrimaryKey(bimid));
        }
        return room;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int delete(Integer id){
        return eroomService.deleteByPrimaryKey(id);
    }
}