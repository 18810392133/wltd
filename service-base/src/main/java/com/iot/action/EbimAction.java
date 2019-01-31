package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import com.iot.bean.Eplat;
import com.iot.bean.Select;
import com.iot.service.EbimService;
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
@RequestMapping("/bim")
public class EbimAction {
	@Resource
	private EbimService ebimService;
	@Resource
	private EplatService eplatService;
	@Resource
	private EprojectService eprojectService;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Map<Object, Object> select(){
		List<Ebim> list = ebimService.selectAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectBySql(String sql){
		List<Ebim> list = ebimService.selectBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectByPrimaryKey(Integer id){
		Ebim object = ebimService.selectByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectVAll(){
		List<Ebimv> list = ebimService.selectVAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectVBySql(String sql){
		List<Ebimv> list = ebimService.selectVBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPrimaryKey(Integer id){
		Ebimv object = ebimService.selectVByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubAll(Integer projectid){
		List<Ebim> list = ebimService.selectSubAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
		List<Ebim> list = ebimService.selectSubBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
		Ebim object = ebimService.selectSubByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVAll(Integer projectid){
		List<Ebimv> list = ebimService.selectSubVAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
		List<Ebimv> list = ebimService.selectSubVBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
		Ebimv object = ebimService.selectSubVByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Map<Object, Object> insert(String item, Integer platid, String longitude, String latitude, String status, String note){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(item, platid,0)){
			Ebimv bim = new Ebimv();
			bim.setItem(item);
			bim.setPlatid(platid);
			bim.setLongitude(longitude);
			bim.setLatitude(latitude);
			bim.setStatus(status);
			bim.setNote(note);
			ebimService.insert(bim);
			bim.setPlat(eplatService.selectVByPrimaryKey(platid));
			map = new BeanMap(bim);
		}else{
			map.put("isError", true);
			map.put("msg", "该地点已存在");
		}
		return map;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Map<Object, Object> update(Integer id, String item, Integer platid, String longitude, String latitude, String status, String note){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(item, platid, id)){
			Ebimv bim = ebimService.selectVByPrimaryKey(id);
			if(bim != null){
				bim.setItem(item);
				bim.setPlatid(platid);
				bim.setLongitude(longitude);
				bim.setLatitude(latitude);
				bim.setStatus(status);
				bim.setNote(note);
				ebimService.updateByPrimaryKey(bim);
				bim.setPlat(eplatService.selectVByPrimaryKey(platid));
				map = new BeanMap(bim);
			}
		}else{
			map.put("isError", true);
			map.put("msg", "该地点已存在");
		}
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Map<Object, Object> delete(Integer id){
		Map<Object, Object> map = new HashMap<Object, Object>();
		ebimService.deleteByPrimaryKey(id);
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
	public JSONArray combobox(Integer platid){
		JSONArray jsonArray = new JSONArray();
		List<Ebim> list = ebimService.selectBySql("platid=" + platid);
		for(int i = 0; i < list.size(); i++){
			Select select = new Select();
			select.setText(list.get(i).getItem());
			select.setValue(String.valueOf(list.get(i).getId()));
			jsonArray.add(select);
		}
		return jsonArray;
	}

	public boolean isValidate(String item, Integer platid, Integer id){
		List<Ebim> list = ebimService.selectBySql("item='" + item + "' and platid=" + platid + " and id!=" + id);
		if(list.size() > 0)
			return false;
		else
			return true;
	}
}