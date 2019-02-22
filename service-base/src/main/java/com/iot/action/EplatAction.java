package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.*;
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
@RequestMapping("/plat")
public class EplatAction {
	@Resource
	private EplatService eplatService;
	@Resource
	private EprojectService eprojectService;

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Eplat> selectAll(){
		return eplatService.selectAll();
	}

	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Eplat> list = eplatService.selectByPage(page, rows, sort, order, filterRules);
		PageInfo<Eplat> pageInfo = new PageInfo<Eplat>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
	public List<Eplat> selectBySql(String sql){
		return eplatService.selectBySql(sql);
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Eplat selectByPrimaryKey(Integer id){
		return eplatService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public List<Eplatv>  selectVAll(){
		return eplatService.selectVAll();
	}

	@RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Eplatv> list = eplatService.selectVByPage(page, rows, sort, order, filterRules);
		PageInfo<Eplatv> pageInfo = new PageInfo<Eplatv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
	public List<Eplatv> selectVBySql(String sql){
		return eplatService.selectVBySql(sql);
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Eplatv selectVByPrimaryKey(Integer id){
		return eplatService.selectVByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public List<Eplat> selectSubAll(Integer projectid){
		return eplatService.selectSubAll(projectid);
	}

	@RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Eplat> list = eplatService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Eplat> pageInfo = new PageInfo<Eplat>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
	public List<Eplat> selectSubBySql(Integer projectid, String sql){
		return eplatService.selectSubBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Eplat selectSubByPrimaryKey(Integer projectid, Integer id){
		return eplatService.selectSubByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public List<Eplatv> selectSubVAll(Integer projectid){
		return eplatService.selectSubVAll(projectid);
	}

	@RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Eplatv> list = eplatService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Eplatv> pageInfo = new PageInfo<Eplatv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
	public List<Eplatv> selectSubVBySql(Integer projectid, String sql){
		return eplatService.selectSubVBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Eplatv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return eplatService.selectSubVByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Eplatv insert(String item, Integer projectid, String province, String city, String longitude, String latitude, String note){
		Eplatv plat = new Eplatv();
		plat.setItem(item);
		plat.setProjectid(projectid);
		plat.setProvince(province);
		plat.setCity(city);
		plat.setLongitude(longitude);
		plat.setLatitude(latitude);
		plat.setNote(note);
		eplatService.insert(plat);
		plat.setProject(eprojectService.selectByPrimaryKey(projectid));
		return plat;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Eplatv update(Integer id, String item, Integer projectid, String province, String city, String longitude, String latitude, String note){
		Eplatv plat = eplatService.selectVByPrimaryKey(id);
		if(plat != null) {
			plat.setItem(item);
			plat.setProjectid(projectid);
			plat.setProvince(province);
			plat.setCity(city);
			plat.setLongitude(longitude);
			plat.setLatitude(latitude);
			plat.setNote(note);
			eplatService.updateByPrimaryKey(plat);
			plat.setProject(eprojectService.selectByPrimaryKey(projectid));
		}
		return plat;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public int delete(Integer id){
		return eplatService.deleteByPrimaryKey(id);
	}
}