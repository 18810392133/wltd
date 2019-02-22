package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.Eorder;
import com.iot.bean.Eorderv;
import com.iot.service.EdataService;
import com.iot.service.EorderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class EorderAction {
    @Resource
    private EorderService eorderService;
    @Resource
    private EdataService edataService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Eorder> selectAll(){
        return eorderService.selectAll();
    }

    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Eorder> list = eorderService.selectByPage(page, rows, sort, order, filterRules);
        PageInfo<Eorder> pageInfo = new PageInfo<Eorder>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
    public List<Eorder> selectBySql(String sql){
        return eorderService.selectBySql(sql);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Eorder selectByPrimaryKey(Integer id){
        return eorderService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
    public List<Eorderv>  selectVAll(){
        return eorderService.selectVAll();
    }

    @RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Eorderv> list = eorderService.selectVByPage(page, rows, sort, order, filterRules);
        PageInfo<Eorderv> pageInfo = new PageInfo<Eorderv>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
    public List<Eorderv> selectVBySql(String sql){
        return eorderService.selectVBySql(sql);
    }

    @RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
    public Eorderv selectVByPrimaryKey(Integer id){
        return eorderService.selectVByPrimaryKey(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Eorderv insert(String item, Integer dataid, Integer userid, String status, Integer level, String type, String time, String note){
        Eorderv order = new Eorderv();
        order.setItem(item);
        order.setDataid(dataid);
        order.setUserid(userid);
        order.setStatus(status);
        order.setLevel(level);
        order.setType(type);
        order.setTime(time);
        order.setNote(note);
        eorderService.insert(order);
        order.setData(edataService.selectVByPrimaryKey(dataid));
        return order;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Eorderv update(Integer id, String item, Integer dataid, Integer userid, String status, Integer level, String type, String time, String note){
        Eorderv order = eorderService.selectVByPrimaryKey(id);
        if(order != null){
            order.setItem(item);
            order.setDataid(dataid);
            order.setUserid(userid);
            order.setStatus(status);
            order.setLevel(level);
            order.setType(type);
            order.setTime(time);
            order.setNote(note);
            eorderService.updateByPrimaryKey(order);
            order.setData(edataService.selectVByPrimaryKey(dataid));
        }
        return order;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int delete(Integer id){
        return eorderService.deleteByPrimaryKey(id);
    }
}