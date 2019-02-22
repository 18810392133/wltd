package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.*;
import com.iot.service.EattrService;
import com.iot.service.EbimService;
import com.iot.service.EthresholdService;
import com.iot.service.EprojectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/threshold")
public class EthresholdAction {
    @Resource
    private EthresholdService ethresholdService;
    @Resource
    private EattrService eattrService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Ethreshold> selectAll(){
        return ethresholdService.selectAll();
    }

    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Ethreshold> list = ethresholdService.selectByPage(page, rows, sort, order, filterRules);
        PageInfo<Ethreshold> pageInfo = new PageInfo<Ethreshold>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
    public List<Ethreshold> selectBySql(String sql){
        return ethresholdService.selectBySql(sql);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Ethreshold selectByPrimaryKey(Integer id){
        return ethresholdService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
    public List<Ethresholdv>  selectVAll(){
        return ethresholdService.selectVAll();
    }

    @RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
        List<Ethresholdv> list = ethresholdService.selectVByPage(page, rows, sort, order, filterRules);
        PageInfo<Ethresholdv> pageInfo = new PageInfo<Ethresholdv>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
    public List<Ethresholdv> selectVBySql(String sql){
        return ethresholdService.selectVBySql(sql);
    }

    @RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
    public Ethresholdv selectVByPrimaryKey(Integer id){
        return ethresholdService.selectVByPrimaryKey(id);
    }

    @RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
    public List<Ethreshold> selectSubAll(Integer projectid){
        return ethresholdService.selectSubAll(projectid);
    }

    @RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Ethreshold> list = ethresholdService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Ethreshold> pageInfo = new PageInfo<Ethreshold>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
    public List<Ethreshold> selectSubBySql(Integer projectid, String sql){
        return ethresholdService.selectSubBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
    public Ethreshold selectSubByPrimaryKey(Integer projectid, Integer id){
        return ethresholdService.selectSubByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
    public List<Ethresholdv> selectSubVAll(Integer projectid){
        return ethresholdService.selectSubVAll(projectid);
    }

    @RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
        List<Ethresholdv> list = ethresholdService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
        PageInfo<Ethresholdv> pageInfo = new PageInfo<Ethresholdv>(list);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
    public List<Ethresholdv> selectSubVBySql(Integer projectid, String sql){
        return ethresholdService.selectSubVBySql(projectid, sql);
    }

    @RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
    public Ethresholdv selectSubVByPrimaryKey(Integer projectid, Integer id){
        return ethresholdService.selectSubVByPrimaryKey(projectid, id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Ethresholdv insert(String item, Integer attrid, Integer level, Integer overtime, String note){
        Ethresholdv threshold = new Ethresholdv();
        threshold.setItem(item);
        threshold.setAttrid(attrid);
        threshold.setLevel(level);
        threshold.setOvertime(overtime);
        threshold.setNote(note);
        ethresholdService.insert(threshold);
        threshold.setAttr(eattrService.selectVByPrimaryKey(attrid));
        return threshold;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Ethresholdv update(Integer id, String item, Integer attrid, Integer level, Integer overtime, String note){
        Ethresholdv threshold = ethresholdService.selectVByPrimaryKey(id);
        if(threshold != null) {
            threshold.setItem(item);
            threshold.setAttrid(attrid);
            threshold.setLevel(level);
            threshold.setOvertime(overtime);
            threshold.setNote(note);
            ethresholdService.updateByPrimaryKey(threshold);
            threshold.setAttr(eattrService.selectVByPrimaryKey(attrid));
        }
        return threshold;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int delete(Integer id){
        return ethresholdService.deleteByPrimaryKey(id);
    }
}