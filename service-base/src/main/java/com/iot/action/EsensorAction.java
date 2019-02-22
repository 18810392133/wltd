package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.*;
import com.iot.service.EsensorService;
import com.iot.service.EprojectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sensor")
public class EsensorAction {
	@Resource
	private EsensorService esensorService;
	@Resource
	private EprojectService eprojectService;

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Esensor> selectAll(){
		return esensorService.selectAll();
	}

	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Esensor> list = esensorService.selectByPage(page, rows, sort, order, filterRules);
		PageInfo<Esensor> pageInfo = new PageInfo<Esensor>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
	public List<Esensor> selectBySql(String sql){
		return esensorService.selectBySql(sql);
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Esensor selectByPrimaryKey(Integer id){
		return esensorService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public List<Esensorv>  selectVAll(){
		return esensorService.selectVAll();
	}

	@RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Esensorv> list = esensorService.selectVByPage(page, rows, sort, order, filterRules);
		PageInfo<Esensorv> pageInfo = new PageInfo<Esensorv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
	public List<Esensorv> selectVBySql(String sql){
		return esensorService.selectVBySql(sql);
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Esensorv selectVByPrimaryKey(Integer id){
		return esensorService.selectVByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public List<Esensor> selectSubAll(Integer projectid){
		return esensorService.selectSubAll(projectid);
	}

	@RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Esensor> list = esensorService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Esensor> pageInfo = new PageInfo<Esensor>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
	public List<Esensor> selectSubBySql(Integer projectid, String sql){
		return esensorService.selectSubBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Esensor selectSubByPrimaryKey(Integer projectid, Integer id){
		return esensorService.selectSubByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public List<Esensorv> selectSubVAll(Integer projectid){
		return esensorService.selectSubVAll(projectid);
	}

	@RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Esensorv> list = esensorService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Esensorv> pageInfo = new PageInfo<Esensorv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
	public List<Esensorv> selectSubVBySql(Integer projectid, String sql){
		return esensorService.selectSubVBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Esensorv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return esensorService.selectSubVByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Esensorv insert(String item, Integer projectid, String protocol, Integer timer, String note){
		Esensorv sensor = new Esensorv();
		sensor.setItem(item);
		sensor.setProjectid(projectid);
		sensor.setProtocol(protocol);
		sensor.setTimer(timer);
		sensor.setNote(note);
		esensorService.insert(sensor);
		sensor.setProject(eprojectService.selectByPrimaryKey(projectid));
		return sensor;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Esensorv update(Integer id, String item, Integer projectid, String protocol, Integer timer, String note){
		Esensorv sensor = esensorService.selectVByPrimaryKey(id);
		if(sensor != null) {
			sensor.setItem(item);
			sensor.setProjectid(projectid);
			sensor.setProtocol(protocol);
			sensor.setTimer(timer);
			sensor.setNote(note);
			esensorService.updateByPrimaryKey(sensor);
			sensor.setProject(eprojectService.selectByPrimaryKey(projectid));
		}
		return sensor;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public int delete(Integer id){
		return esensorService.deleteByPrimaryKey(id);
	}
}