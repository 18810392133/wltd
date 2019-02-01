package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.iot.bean.Eattr;
import com.iot.bean.Eattrv;
import com.iot.bean.Select;
import com.iot.service.EattrService;
import com.iot.service.EsensorService;
import org.apache.commons.beanutils.BeanMap;
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

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Map<Object, Object> select(){
		List<Eattr> list = eattrService.selectAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectBySql(String sql){
		List<Eattr> list = eattrService.selectBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectByPrimaryKey(Integer id){
		Eattr object = eattrService.selectByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectVAll(){
		List<Eattrv> list = eattrService.selectVAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectVBySql(String sql){
		List<Eattrv> list = eattrService.selectVBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPrimaryKey(Integer id){
		Eattrv object = eattrService.selectVByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubAll(Integer projectid){
		List<Eattr> list = eattrService.selectSubAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
		List<Eattr> list = eattrService.selectSubBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
		Eattr object = eattrService.selectSubByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVAll(Integer projectid){
		List<Eattrv> list = eattrService.selectSubVAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
		List<Eattrv> list = eattrService.selectSubVBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
		Eattrv object = eattrService.selectSubVByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Map<Object, Object> insert(String item, Integer sensorid, String protocol, String type, String unit, String thresholdl, String thresholdm, String thresholdh, String note){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(item, sensorid,0)){
			Eattrv attr = new Eattrv();
			attr.setItem(item);
			attr.setSensorid(sensorid);
			attr.setProtocol(protocol);
			attr.setType(type);
			attr.setUnit(unit);
			attr.setThresholdl(thresholdl);
			attr.setThresholdm(thresholdm);
			attr.setThresholdh(thresholdh);
			attr.setNote(note);
			eattrService.insert(attr);
			attr.setSensor(esensorService.selectVByPrimaryKey(sensorid));
			map = new BeanMap(attr);
		}else{
			map.put("isError", true);
			map.put("msg", "该属性已存在");
		}
		return map;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Map<Object, Object> update(Integer id, String item, Integer sensorid, String protocol, String type, String unit, String thresholdl, String thresholdm, String thresholdh, String note){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(item, sensorid, id)){
			Eattrv attr = eattrService.selectVByPrimaryKey(id);
			if(attr != null){
				attr.setItem(item);
				attr.setSensorid(sensorid);
				attr.setProtocol(protocol);
				attr.setType(type);
				attr.setUnit(unit);
				attr.setThresholdl(thresholdl);
				attr.setThresholdm(thresholdm);
				attr.setThresholdh(thresholdh);
				attr.setNote(note);
				eattrService.updateByPrimaryKey(attr);
				attr.setSensor(esensorService.selectVByPrimaryKey(sensorid));
				map = new BeanMap(attr);
			}
		}else{
			map.put("isError", true);
			map.put("msg", "该属性已存在");
		}
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Map<Object, Object> delete(Integer id){
		Map<Object, Object> map = new HashMap<Object, Object>();
		eattrService.deleteByPrimaryKey(id);
		map.put("success", true);
		return map;
	}

	@RequestMapping("/typeCombobox")
	public JSONArray typeCombobox(){
		JSONArray jsonArray = new JSONArray();
		Select select = new Select();
		select.setText("大于");
		select.setValue("大于");
		jsonArray.add(select);
		select = new Select();
		select.setText("小于");
		select.setValue("小于");
		jsonArray.add(select);
		return jsonArray;
	}

	@RequestMapping(value = "/combobox", method = RequestMethod.GET)
	public JSONArray combobox(Integer sensorid){
		JSONArray jsonArray = new JSONArray();
		List<Eattr> list = eattrService.selectBySql("sensorid=" + sensorid);
		for(int i = 0; i < list.size(); i++){
			Select select = new Select();
			select.setText(list.get(i).getItem());
			select.setValue(String.valueOf(list.get(i).getId()));
			jsonArray.add(select);
		}
		return jsonArray;
	}

	public boolean isValidate(String item, Integer sensorid, Integer id){
		List<Eattr> list = eattrService.selectBySql("item='" + item + "' and sensorid=" + sensorid + " and id!=" + id);
		if(list.size() > 0)
			return false;
		else
			return true;
	}
}