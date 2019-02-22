package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.iot.bean.*;
import com.iot.service.EbimService;
import com.iot.service.EplatService;
import com.iot.service.EprojectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bim")
public class EbimAction {
	@Resource
	private EbimService ebimService;
	@Resource
	private EplatService eplatService;

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Ebim> selectAll(){
		return ebimService.selectAll();
	}

	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Ebim> list = ebimService.selectByPage(page, rows, sort, order, filterRules);
		PageInfo<Ebim> pageInfo = new PageInfo<Ebim>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
	public List<Ebim> selectBySql(String sql){
		return ebimService.selectBySql(sql);
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Ebim selectByPrimaryKey(Integer id){
		return ebimService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public List<Ebimv>  selectVAll(){
		return ebimService.selectVAll();
	}

	@RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Ebimv> list = ebimService.selectVByPage(page, rows, sort, order, filterRules);
		PageInfo<Ebimv> pageInfo = new PageInfo<Ebimv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
	public List<Ebimv> selectVBySql(String sql){
		return ebimService.selectVBySql(sql);
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Ebimv selectVByPrimaryKey(Integer id){
		return ebimService.selectVByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public List<Ebim> selectSubAll(Integer projectid){
		return ebimService.selectSubAll(projectid);
	}

	@RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Ebim> list = ebimService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Ebim> pageInfo = new PageInfo<Ebim>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
	public List<Ebim> selectSubBySql(Integer projectid, String sql){
		return ebimService.selectSubBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Ebim selectSubByPrimaryKey(Integer projectid, Integer id){
		return ebimService.selectSubByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public List<Ebimv> selectSubVAll(Integer projectid){
		return ebimService.selectSubVAll(projectid);
	}

	@RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Ebimv> list = ebimService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Ebimv> pageInfo = new PageInfo<Ebimv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
	public List<Ebimv> selectSubVBySql(Integer projectid, String sql){
		return ebimService.selectSubVBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Ebimv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return ebimService.selectSubVByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Ebimv insert(String item, Integer platid, String longitude, String latitude, String status, String modelfile, String note){
		Ebimv bim = new Ebimv();
		bim.setItem(item);
		bim.setPlatid(platid);
		bim.setLongitude(longitude);
		bim.setLatitude(latitude);
		bim.setStatus(status);
		bim.setModelfile(modelfile);
		bim.setNote(note);
		ebimService.insert(bim);
		bim.setPlat(eplatService.selectVByPrimaryKey(platid));
		return bim;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Ebimv update(Integer id, String item, Integer platid, String longitude, String latitude, String status, String modelfile, String note){
		Ebimv bim = ebimService.selectVByPrimaryKey(id);
		if(bim != null){
			bim.setItem(item);
			bim.setPlatid(platid);
			bim.setLongitude(longitude);
			bim.setLatitude(latitude);
			bim.setStatus(status);
			bim.setModelfile(modelfile);
			bim.setNote(note);
			ebimService.updateByPrimaryKey(bim);
			bim.setPlat(eplatService.selectVByPrimaryKey(platid));
		}
		return bim;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public int delete(Integer id){
		return ebimService.deleteByPrimaryKey(id);
	}
}