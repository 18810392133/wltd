package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.iot.bean.Eproject;
import com.iot.bean.Euser;
import com.iot.bean.Euserv;
import com.iot.bean.Select;
import com.iot.service.EprojectService;
import com.iot.service.EuserService;
import com.iot.util.AuthToken;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class EuserAction {  
    @Resource  
    private EuserService euserService;
	@Resource
	private EprojectService eprojectService;

	@RequestMapping(value = "/login")
	public Map<Object, Object> login(String username, String password, String servicename){
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Euser> list = euserService.selectBySql("username='" + username + "'");
		if(list.size() > 0){
			Euser user = list.get(0);
			Eproject project = eprojectService.selectByPrimaryKey(user.getProjectid());
			if(project != null && project.getServicename().equals(servicename)){
				if(list.get(0).getPassword().equals(password)){
					map.put("isSuccess", true);
					map.put("user", list.get(0));
					map.put("projectid", user.getProjectid());
					map.put("servicename", servicename);
					map.put("token", getToken(username, password));
				}else{
					map.put("isSuccess", false);
					map.put("msg", "密码错误");
				}
			}else{
				map.put("isSuccess", false);
				map.put("msg", "用户名错误");
			}
		}else{
			map.put("isSuccess", false);
			map.put("msg", "用户名错误");
		}
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectAll")
	public Map<Object, Object> selectAll(){
		List<Euser> list = euserService.selectAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@AuthToken
    @RequestMapping(value = "/selectByPage")
	public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		return euserService.selectByPage(page, rows, sort, order, filterRules);
	}

	@AuthToken
	@RequestMapping(value = "/selectBySql")
	public Map<Object, Object> selectBySql(String sql){
		List<Euser> list = euserService.selectBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectByPrimaryKey")
	public Map<Object, Object> selectByPrimaryKey(Integer id){
		Euser object = euserService.selectByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectVAll")
	public Map<Object, Object> selectVAll(){
		List<Euserv> list = euserService.selectVAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectVByPage")
	public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		return euserService.selectVByPage(page, rows, sort, order, filterRules);
	}

	@AuthToken
	@RequestMapping(value = "/selectVBySql")
	public Map<Object, Object> selectVBySql(String sql){
		List<Euserv> list = euserService.selectVBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectVByPrimaryKey")
	public Map<Object, Object> selectVByPrimaryKey(Integer id){
		Euserv object = euserService.selectVByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectSubAll")
	public Map<Object, Object> selectSubAll(Integer projectid){
		List<Euser> list = euserService.selectSubAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectSubByPage")
	public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		return euserService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
	}

	@AuthToken
	@RequestMapping(value = "/selectSubBySql")
	public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
		List<Euser> list = euserService.selectSubBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectSubByPrimaryKey")
	public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
		Euser object = euserService.selectSubByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectSubVAll")
	public Map<Object, Object> selectSubVAll(Integer projectid){
		List<Euserv> list = euserService.selectSubVAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectSubVByPage")
	public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		return euserService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
	}

	@AuthToken
	@RequestMapping(value = "/selectSubVBySql")
	public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
		List<Euserv> list = euserService.selectSubVBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/selectSubVByPrimaryKey")
	public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
		Euserv object = euserService.selectSubVByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/insert")
	public Map<Object, Object> insert(String username, String password, Integer projectid, String type, String realname, String phone, String wechat, String time, String status) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(username, 0)){
			Euser user = euserService.insert(username, password, projectid, type, realname, phone, wechat, time, status);
			if(user != null)
				map = new BeanMap(user);
		}else{
			map.put("isError", true);
			map.put("msg", "该用户已存在");
		}
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/update")
	public Map<Object, Object> update(Integer id, String username, String password, Integer projectid, String type, String realname, String phone, String wechat, String time, String status) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(isValidate(username, id)){
			Euser user = euserService.update(id, username, password, projectid, type, realname, phone, wechat, time, status);
			if(user != null)
				map = new BeanMap(user);
		}else{
			map.put("isError", true);
			map.put("msg", "该用户已存在");
		}
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/delete")
	public Map<Object, Object> delete(Integer id) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if(euserService.delete(id) > 0)
			map.put("success", true);
		else
			map.put("success", false);
		return map;
	}

	@AuthToken
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JSONArray list(Integer projectid){
		JSONArray jsonArray = new JSONArray();
		List<Euser> list = euserService.selectBySql("projectid=" + projectid);
		for(int i = 0; i < list.size(); i++){
			Select select = new Select();
			select.setText(list.get(i).getUsername());
			select.setValue(String.valueOf(list.get(i).getId()));
			jsonArray.add(select);
		}
		return jsonArray;
	}

	@AuthToken
	@RequestMapping(value = "/typeList", method = RequestMethod.GET)
	public JSONArray typeList(){
		JSONArray jsonArray = new JSONArray();
		Select select = new Select();
		select.setText("用户");
		select.setValue("用户");
		jsonArray.add(select);
		select = new Select();
		select.setText("工人");
		select.setValue("工人");
		jsonArray.add(select);
		select = new Select();
		select.setText("领导");
		select.setValue("领导");
		jsonArray.add(select);
		select = new Select();
		select.setText("管理员");
		select.setValue("管理员");
		jsonArray.add(select);
		return jsonArray;
	}

	@RequestMapping(value = "/statusList", method = RequestMethod.GET)
	public JSONArray statusList(){
		JSONArray jsonArray = new JSONArray();
		Select select = new Select();
		select.setText("可用");
		select.setValue("可用");
		jsonArray.add(select);
		select = new Select();
		select.setText("不可用");
		select.setValue("不可用");
		jsonArray.add(select);
		return jsonArray;
	}

	public boolean isValidate(String username, Integer id){
		List<Euser> list = euserService.selectBySql("username='" + username + "' and id!=" + id);
		if(list.size() > 0)
			return false;
		else
			return true;
	}

	public String getToken(String username, String password) {
		String token = "";
		token = JWT.create().withAudience(username)
				.withExpiresAt(new Date(System.currentTimeMillis()+60*1000))
				.sign(Algorithm.HMAC256(password));
		return token;
	}
}