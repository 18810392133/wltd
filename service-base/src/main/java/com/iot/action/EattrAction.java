package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.*;
import com.iot.service.EattrService;
import com.iot.service.EsensorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attr")
public class EattrAction {
	@Resource
	private EattrService eattrService;
	@Resource
	private EsensorService esensorService;

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Eattr> selectAll(){
		return eattrService.selectAll();
	}

	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Eattr> list = eattrService.selectByPage(page, rows, sort, order, filterRules);
		PageInfo<Eattr> pageInfo = new PageInfo<Eattr>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
	public List<Eattr> selectBySql(String sql){
		return eattrService.selectBySql(sql);
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Eattr selectByPrimaryKey(Integer id){
		return eattrService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public List<Eattrv>  selectVAll(){
		return eattrService.selectVAll();
	}

	@RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Eattrv> list = eattrService.selectVByPage(page, rows, sort, order, filterRules);
		PageInfo<Eattrv> pageInfo = new PageInfo<Eattrv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
	public List<Eattrv> selectVBySql(String sql){
		return eattrService.selectVBySql(sql);
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Eattrv selectVByPrimaryKey(Integer id){
		return eattrService.selectVByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public List<Eattr> selectSubAll(Integer projectid){
		return eattrService.selectSubAll(projectid);
	}

	@RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Eattr> list = eattrService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Eattr> pageInfo = new PageInfo<Eattr>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
	public List<Eattr> selectSubBySql(Integer projectid, String sql){
		return eattrService.selectSubBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Eattr selectSubByPrimaryKey(Integer projectid, Integer id){
		return eattrService.selectSubByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public List<Eattrv> selectSubVAll(Integer projectid){
		return eattrService.selectSubVAll(projectid);
	}

	@RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Eattrv> list = eattrService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Eattrv> pageInfo = new PageInfo<Eattrv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
	public List<Eattrv> selectSubVBySql(Integer projectid, String sql){
		return eattrService.selectSubVBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Eattrv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return eattrService.selectSubVByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Eattrv insert(String item, Integer sensorid, String protocol, String compare, String unit, Integer timer, String note){
		Eattrv attr = new Eattrv();
		attr.setItem(item);
		attr.setSensorid(sensorid);
		attr.setProtocol(protocol);
		attr.setCompare(compare);
		attr.setUnit(unit);
		attr.setTimer(timer);
		attr.setNote(note);
		eattrService.insert(attr);
		attr.setSensor(esensorService.selectVByPrimaryKey(sensorid));
		return attr;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Eattrv update(Integer id, String item, Integer sensorid, String protocol, String compare, String unit, Integer timer, String note){
		Eattrv attr = eattrService.selectVByPrimaryKey(id);
		if(attr != null){
			attr.setItem(item);
			attr.setSensorid(sensorid);
			attr.setProtocol(protocol);
			attr.setCompare(compare);
			attr.setUnit(unit);
			attr.setTimer(timer);
			attr.setNote(note);
			eattrService.updateByPrimaryKey(attr);
			attr.setSensor(esensorService.selectVByPrimaryKey(sensorid));
		}
		return attr;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public int delete(Integer id){
		return eattrService.deleteByPrimaryKey(id);
	}
}