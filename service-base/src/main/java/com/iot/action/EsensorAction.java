package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.iot.bean.Esensor;
import com.iot.bean.Esensorv;
import com.iot.bean.Select;
import com.iot.service.EbimService;
import com.iot.service.EsensorService;
import com.iot.service.EplatService;
import com.iot.service.EprojectService;
import org.apache.commons.beanutils.BeanMap;
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
	private EbimService ebimService;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Map<Object, Object> select(){
		List<Esensor> list = esensorService.selectAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectBySql(String sql){
		List<Esensor> list = esensorService.selectBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectByPrimaryKey(Integer id){
		Esensor object = esensorService.selectByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectVAll(){
		List<Esensorv> list = esensorService.selectVAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectVBySql(String sql){
		List<Esensorv> list = esensorService.selectVBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPrimaryKey(Integer id){
		Esensorv object = esensorService.selectVByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubAll(Integer projectid){
		List<Esensor> list = esensorService.selectSubAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
		List<Esensor> list = esensorService.selectSubBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
		Esensor object = esensorService.selectSubByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVAll(Integer projectid){
		List<Esensorv> list = esensorService.selectSubVAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
		List<Esensorv> list = esensorService.selectSubVBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
		Esensorv object = esensorService.selectSubVByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Map<Object, Object> insert(String item, Integer bimid, String protocol, Integer timer, String status, String note){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(item, bimid,0)){
			Esensorv sensor = new Esensorv();
			sensor.setItem(item);
			sensor.setBimid(bimid);
			sensor.setProtocol(protocol);
			sensor.setTimer(timer);
			sensor.setStatus(status);
			sensor.setNote(note);
			esensorService.insert(sensor);
			sensor.setBim(ebimService.selectVByPrimaryKey(bimid));
			map = new BeanMap(sensor);
		}else{
			map.put("isError", true);
			map.put("msg", "该传感器已存在");
		}
		return map;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Map<Object, Object> update(Integer id, String item, Integer bimid, String protocol, Integer timer, String status, String note){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(item, bimid, id)){
			Esensorv sensor = esensorService.selectVByPrimaryKey(id);
			if(sensor != null){
				sensor.setItem(item);
				sensor.setBimid(bimid);
				sensor.setProtocol(protocol);
				sensor.setTimer(timer);
				sensor.setStatus(status);
				sensor.setNote(note);
				esensorService.updateByPrimaryKey(sensor);
				sensor.setBim(ebimService.selectVByPrimaryKey(bimid));
				map = new BeanMap(sensor);
			}
		}else{
			map.put("isError", true);
			map.put("msg", "该用户名已存在");
		}
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Map<Object, Object> delete(Integer id){
		Map<Object, Object> map = new HashMap<Object, Object>();
		esensorService.deleteByPrimaryKey(id);
		map.put("success", true);
		return map;
	}

	@RequestMapping(value = "/statusCombobox", method = RequestMethod.GET)
	public JSONArray statusCombobox(){
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
		select.setText("低级告警");
		select.setValue("低级告警");
		jsonArray.add(select);
		select = new Select();
		select.setText("中级告警");
		select.setValue("中级告警");
		jsonArray.add(select);
		select = new Select();
		select.setText("高级告警");
		select.setValue("高级告警");
		jsonArray.add(select);
		return jsonArray;
	}

	@RequestMapping(value = "/combobox", method = RequestMethod.GET)
	public JSONArray combobox(Integer bimid){
		JSONArray jsonArray = new JSONArray();
		List<Esensor> list = esensorService.selectBySql("bimid=" + bimid);
		for(int i = 0; i < list.size(); i++){
			Select select = new Select();
			select.setText(list.get(i).getItem());
			select.setValue(String.valueOf(list.get(i).getId()));
			jsonArray.add(select);
		}
		return jsonArray;
	}

	public boolean isValidate(String item, Integer bimid, Integer id){
		List<Esensor> list = esensorService.selectBySql("item='" + item + "' and bimid=" + bimid + " and id!=" + id);
		if(list.size() > 0)
			return false;
		else
			return true;
	}
}