package com.iot.action;

import com.alibaba.fastjson.JSONArray;
import com.iot.service.EuserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class EuserAction {  
    @Resource  
    private EuserService euserService;

	@RequestMapping(value = "/login")
	public Map<Object, Object> login(HttpServletRequest request, String item, String password, String servicename){
		return euserService.login(request, item, password, servicename);
	}

	@RequestMapping(value = "/info")
	public Map<Object, Object> info(HttpServletRequest request){
		Map<Object, Object> map = new HashMap<Object, Object>();
		HttpSession session = request.getSession();
		if(session.getAttribute("item") != null && !session.getAttribute("item").toString().isEmpty())
			map.put("isSuccess", true);
		else
			map.put("isSuccess", false);
		return map;
	}

    @RequestMapping(value = "/selectByPage")
	public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		return euserService.selectByPage(page, rows, sort, order, filterRules);
	}

	@RequestMapping(value = "/selectVByPage")
	public Map<Object, Object> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules){
		return euserService.selectVByPage(page, rows, sort, order, filterRules);
	}

	@RequestMapping(value = "/insert")
	public Map<Object, Object> insert(String item, String password, Integer projectid, String type, String realname, Integer age, String time, String status) {
		return euserService.insert(item, password, projectid, type, realname, age, time, status);
	}

	@RequestMapping(value = "/update")
	public Map<Object, Object> update(Integer id, String item, String password, Integer projectid, String type, String realname, Integer age, String time, String status) {
		return euserService.update(id, item, password, projectid, type, realname, age, time, status);
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public Map<Object, Object> delete(Integer id) {
		return euserService.delete(id);
	}

    @RequestMapping(value = "/typeCombobox")
    public JSONArray typeCombobox() {
        return euserService.typeCombobox();
    }

	@RequestMapping(value = "/statusCombobox")
	public JSONArray statusCombobox() {
		return euserService.statusCombobox();
	}
}