package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.iot.bean.Eplat;
import com.iot.bean.Eplatv;
import com.iot.bean.Select;
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
@RequestMapping("/plat")
public class EplatAction {
	@Resource
	private EplatService eplatService;
	@Resource
	private EprojectService eprojectService;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Map<Object, Object> select(){
		List<Eplat> list = eplatService.selectAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectBySql(String sql){
		List<Eplat> list = eplatService.selectBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectByPrimaryKey(Integer id){
		Eplat object = eplatService.selectByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectVAll(){
		List<Eplatv> list = eplatService.selectVAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectVBySql(String sql){
		List<Eplatv> list = eplatService.selectVBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPrimaryKey(Integer id){
		Eplatv object = eplatService.selectVByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubAll(Integer projectid){
		List<Eplat> list = eplatService.selectSubAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
		List<Eplat> list = eplatService.selectSubBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
		Eplat object = eplatService.selectSubByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVAll(Integer projectid){
		List<Eplatv> list = eplatService.selectSubVAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
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
	public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
		List<Eplatv> list = eplatService.selectSubVBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
		Eplatv object = eplatService.selectSubVByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Map<Object, Object> insert(String item, Integer projectid, String province, String city, String longitude, String latitude, String note){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(item, projectid,0)){
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
			map = new BeanMap(plat);
		}else{
			map.put("isError", true);
			map.put("msg", "该区域已存在");
		}
		return map;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Map<Object, Object> update(Integer id, String item, Integer projectid, String province, String city, String longitude, String latitude, String note){
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(item, projectid, id)){
			Eplatv plat = eplatService.selectVByPrimaryKey(id);
			if(plat != null){
				plat.setItem(item);
				plat.setProjectid(projectid);
				plat.setProvince(province);
				plat.setCity(city);
				plat.setLongitude(longitude);
				plat.setLatitude(latitude);
				plat.setNote(note);
				eplatService.updateByPrimaryKey(plat);
				plat.setProject(eprojectService.selectByPrimaryKey(projectid));
				map = new BeanMap(plat);
			}
		}else{
			map.put("isError", true);
			map.put("msg", "该区域已存在");
		}
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Map<Object, Object> delete(Integer id){
		Map<Object, Object> map = new HashMap<Object, Object>();
		eplatService.deleteByPrimaryKey(id);
		map.put("success", true);
		return map;
	}

	@RequestMapping(value = "/provinceCombobox", method = RequestMethod.GET)
	public JSONArray provinceCombobox(){
		JSONArray jsonArray = new JSONArray();
		Select select = new Select();
		select.setText("安徽");
		select.setValue("安徽");
		jsonArray.add(select);
		select = new Select();
		select.setText("澳门");
		select.setValue("澳门");
		jsonArray.add(select);
		select = new Select();
		select.setText("北京");
		select.setValue("北京");
		jsonArray.add(select);
		select = new Select();
		select.setText("重庆");
		select.setValue("重庆");
		jsonArray.add(select);
		select = new Select();
		select.setText("福建");
		select.setValue("福建");
		jsonArray.add(select);
		select = new Select();
		select.setText("甘肃");
		select.setValue("甘肃");
		jsonArray.add(select);
		select = new Select();
		select.setText("广东");
		select.setValue("广东");
		jsonArray.add(select);
		select = new Select();
		select.setText("广西");
		select.setValue("广西");
		jsonArray.add(select);
		select = new Select();
		select.setText("贵州");
		select.setValue("贵州");
		jsonArray.add(select);
		select = new Select();
		select.setText("海南");
		select.setValue("海南");
		jsonArray.add(select);
		select = new Select();
		select.setText("河北");
		select.setValue("河北");
		jsonArray.add(select);
		select = new Select();
		select.setText("黑龙江");
		select.setValue("黑龙江");
		jsonArray.add(select);
		select = new Select();
		select.setText("河南");
		select.setValue("河南");
		jsonArray.add(select);
		select = new Select();
		select.setText("湖北");
		select.setValue("湖北");
		jsonArray.add(select);
		select = new Select();
		select.setText("湖南");
		select.setValue("湖南");
		jsonArray.add(select);
		select = new Select();
		select.setText("江苏");
		select.setValue("江苏");
		jsonArray.add(select);
		select = new Select();
		select.setText("江西");
		select.setValue("江西");
		jsonArray.add(select);
		select = new Select();
		select.setText("吉林");
		select.setValue("吉林");
		jsonArray.add(select);
		select = new Select();
		select.setText("辽宁");
		select.setValue("辽宁");
		jsonArray.add(select);
		select = new Select();
		select.setText("内蒙古");
		select.setValue("内蒙古");
		jsonArray.add(select);
		select = new Select();
		select.setText("宁夏");
		select.setValue("宁夏");
		jsonArray.add(select);
		select = new Select();
		select.setText("青海");
		select.setValue("青海");
		jsonArray.add(select);
		select = new Select();
		select.setText("陕西");
		select.setValue("陕西");
		jsonArray.add(select);
		select = new Select();
		select.setText("山东");
		select.setValue("山东");
		jsonArray.add(select);
		select = new Select();
		select.setText("上海");
		select.setValue("上海");
		jsonArray.add(select);
		select = new Select();
		select.setText("山西");
		select.setValue("山西");
		jsonArray.add(select);
		select = new Select();
		select.setText("四川");
		select.setValue("四川");
		jsonArray.add(select);
		select = new Select();
		select.setText("台湾");
		select.setValue("台湾");
		jsonArray.add(select);
		select = new Select();
		select.setText("天津");
		select.setValue("天津");
		jsonArray.add(select);
		select = new Select();
		select.setText("香港");
		select.setValue("香港");
		jsonArray.add(select);
		select = new Select();
		select.setText("新疆");
		select.setValue("新疆");
		jsonArray.add(select);
		select = new Select();
		select.setText("西藏");
		select.setValue("西藏");
		jsonArray.add(select);
		select = new Select();
		select.setText("云南");
		select.setValue("云南");
		jsonArray.add(select);
		select = new Select();
		select.setText("浙江");
		select.setValue("浙江");
		jsonArray.add(select);
		return jsonArray;
	}

	@RequestMapping(value = "/combobox", method = RequestMethod.GET)
	public JSONArray combobox(Integer projectid){
		JSONArray jsonArray = new JSONArray();
		List<Eplat> list = eplatService.selectBySql("projectid=" + projectid);
		for(int i = 0; i < list.size(); i++){
			Select select = new Select();
			select.setText(list.get(i).getItem());
			select.setValue(String.valueOf(list.get(i).getId()));
			jsonArray.add(select);
		}
		return jsonArray;
	}

	public boolean isValidate(String item, Integer projectid, Integer id){
		List<Eplat> list = eplatService.selectBySql("item='" + item + "' and projectid=" + projectid + " and id!=" + id);
		if(list.size() > 0)
			return false;
		else
			return true;
	}
}