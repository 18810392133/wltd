package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.iot.bean.Euser;
import com.iot.bean.Euserv;
import com.iot.bean.Select;
import com.iot.service.EprojectService;
import com.iot.service.EuserService;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Map<Object, Object> login(HttpServletRequest request, String item, String password, String servicename){
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Euserv> list = euserService.selectVBySql("item='" + item + "'");
		if(list.size() > 0 && list.get(0).getProject().getServicename().equals(servicename)){
			if(list.get(0).getPassword().equals(password)){
				map.put("isSuccess", true);
				Integer projectid =  list.get(0).getProjectid();
				map.put("projectid", projectid);
				map.put("servicename", servicename);
				HttpSession session = request.getSession();
				session.setAttribute("item", item);
				session.setAttribute("projectid", projectid);
				session.setAttribute("servicename", servicename);
			}else{
				map.put("isSuccess", false);
				map.put("msg", "密码错误");
			}
		}else{
			map.put("isSuccess", false);
			map.put("msg", "用户名错误");
		}
		return map;
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Map<Object, Object> select(){
		List<Euser> list = euserService.selectAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		List<Euser> list = euserService.selectByPage(page, rows, sort, order, filterRules);
		PageInfo<Euser> pageInfo = new PageInfo<Euser>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
	public Map<Object, Object> selectBySql(String sql){
		List<Euser> list = euserService.selectBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectByPrimaryKey(Integer id){
		Euser object = euserService.selectByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectVAll(){
		List<Euserv> list = euserService.selectVAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

    @RequestMapping(value = "/selectVByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
    	List<Euserv> list = euserService.selectVByPage(page, rows, sort, order, filterRules);
    	PageInfo<Euserv> pageInfo = new PageInfo<Euserv>(list);
    	Map<Object, Object> map = new HashMap<Object, Object>();
    	map.put("total", pageInfo.getTotal());
    	map.put("rows", list);
        return map;
    }

	@RequestMapping(value = "/selectVBySql", method = RequestMethod.GET)
	public Map<Object, Object> selectVBySql(String sql){
		List<Euserv> list = euserService.selectVBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectVByPrimaryKey(Integer id){
		Euserv object = euserService.selectVByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubAll(Integer projectid){
		List<Euser> list = euserService.selectSubAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Euser> list = euserService.selectSubByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Euser> pageInfo = new PageInfo<Euser>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubBySql", method = RequestMethod.GET)
	public Map<Object, Object> selectSubBySql(Integer projectid, String sql){
		List<Euser> list = euserService.selectSubBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubByPrimaryKey(Integer projectid, Integer id){
		Euser object = euserService.selectSubByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVAll(Integer projectid){
		List<Euserv> list = euserService.selectSubVAll(projectid);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVByPage", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules){
		List<Euserv> list = euserService.selectSubVByPage(projectid, page, rows, sort, order, filterRules);
		PageInfo<Euserv> pageInfo = new PageInfo<Euserv>(list);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVBySql", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVBySql(Integer projectid, String sql){
		List<Euserv> list = euserService.selectSubVBySql(projectid, sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectSubVByPrimaryKey(Integer projectid, Integer id){
		Euserv object = euserService.selectSubVByPrimaryKey(projectid, id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Map<Object, Object> insert(String item, String password, Integer projectid, String type, String realname, Integer age, String time, String status){
    	Map<Object, Object> map = new HashMap<Object, Object>();
    	if(isValidate(item, 0)){
    		Euserv user = new Euserv();
            user.setItem(item);  
            user.setPassword(password);  
            user.setProjectid(projectid);
            user.setType(type);
            user.setRealname(realname);  
            user.setAge(age);
            user.setTime(time);
            user.setStatus(status);
            euserService.insert(user);
			user.setProject(eprojectService.selectByPrimaryKey(projectid));
            map = new BeanMap(user);
    	}else{
    		map.put("isError", true);
    		map.put("msg", "该用户名已存在");
    	}
        return map;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Map<Object, Object> update(Integer id, String item, String password, Integer projectid, String type, String realname, Integer age, String time, String status){
    	Map<Object, Object> map = new HashMap<Object, Object>();
    	if(isValidate(item, id)){
    		Euserv user = euserService.selectVByPrimaryKey(id);
    		if(user != null){
	            user.setItem(item);  
	            user.setPassword(password); 
	            user.setProjectid(projectid);
	            user.setType(type);
	            user.setRealname(realname);  
	            user.setAge(age);
	            user.setTime(time);
	            user.setStatus(status);
	            euserService.updateByPrimaryKey(user);
				user.setProject(eprojectService.selectByPrimaryKey(projectid));
	            map = new BeanMap(user);
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
    	euserService.deleteByPrimaryKey(id);
    	map.put("success", true);
        return map;
    }

	@RequestMapping(value = "/typeCombobox", method = RequestMethod.GET)
	public JSONArray typeCombobox(){
		JSONArray jsonArray = new JSONArray();
		Select select = new Select();
		select.setText("管理员");
		select.setValue("管理员");
		jsonArray.add(select);
		select = new Select();
		select.setText("工人");
		select.setValue("工人");
		jsonArray.add(select);
		select = new Select();
		select.setText("一级");
		select.setValue("一级");
		jsonArray.add(select);
		select = new Select();
		select.setText("二级");
		select.setValue("二级");
		jsonArray.add(select);
		select = new Select();
		select.setText("三级");
		select.setValue("三级");
		jsonArray.add(select);
		return jsonArray;
	}

    @RequestMapping(value = "/statusCombobox", method = RequestMethod.GET)
    public JSONArray statusCombobox(){
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
    
    public boolean isValidate(String item, Integer id){
    	List<Euser> list = euserService.selectBySql("item='" + item + "' and id!=" + id);
    	if(list.size() > 0)
    		return false;
    	else
    		return true;
	}
}