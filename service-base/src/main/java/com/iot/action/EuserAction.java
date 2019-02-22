package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.Euser;
import com.iot.bean.Euserv;
import com.iot.service.EprojectService;
import com.iot.service.EuserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
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

	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Euser> selectAll(){
		return euserService.selectAll();
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
	public List<Euser> selectBySql(String sql){
		return euserService.selectBySql(sql);
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Euser selectByPrimaryKey(Integer id){
		return euserService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectVAll", method = RequestMethod.GET)
	public List<Euserv>  selectVAll(){
		return euserService.selectVAll();
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
	public List<Euserv> selectVBySql(String sql){
		return euserService.selectVBySql(sql);
	}

	@RequestMapping(value = "/selectVByPrimaryKey", method = RequestMethod.GET)
	public Euserv selectVByPrimaryKey(Integer id){
		return euserService.selectVByPrimaryKey(id);
	}

	@RequestMapping(value = "/selectSubAll", method = RequestMethod.GET)
	public List<Euser> selectSubAll(Integer projectid){
		return euserService.selectSubAll(projectid);
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
	public List<Euser> selectSubBySql(Integer projectid, String sql){
		return euserService.selectSubBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubByPrimaryKey", method = RequestMethod.GET)
	public Euser selectSubByPrimaryKey(Integer projectid, Integer id){
		return euserService.selectSubByPrimaryKey(projectid, id);
	}

	@RequestMapping(value = "/selectSubVAll", method = RequestMethod.GET)
	public List<Euserv> selectSubVAll(Integer projectid){
		return euserService.selectSubVAll(projectid);
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
	public List<Euserv> selectSubVBySql(Integer projectid, String sql){
		return euserService.selectSubVBySql(projectid, sql);
	}

	@RequestMapping(value = "/selectSubVByPrimaryKey", method = RequestMethod.GET)
	public Euserv selectSubVByPrimaryKey(Integer projectid, Integer id){
		return euserService.selectSubVByPrimaryKey(projectid, id);
	}

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Euserv insert(String username, String password, Integer projectid, String type, String realname, String phone, String wechat, String time, String status){
		Euserv user = new Euserv();
		user.setUsername(username);
		user.setPassword(password);
		user.setProjectid(projectid);
		user.setType(type);
		user.setRealname(realname);
		user.setPhone(phone);
		user.setWechat(wechat);
		user.setTime(time);
		user.setStatus(status);
		euserService.insert(user);
		user.setProject(eprojectService.selectByPrimaryKey(projectid));
        return user;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Euserv update(Integer id, String username, String password, Integer projectid, String type, String realname, String phone, String wechat, String time, String status){
		Euserv user = euserService.selectVByPrimaryKey(id);
		if(user != null){
			user.setUsername(username);
			user.setPassword(password);
			user.setProjectid(projectid);
			user.setType(type);
			user.setRealname(realname);
			user.setPhone(phone);
			user.setWechat(wechat);
			user.setTime(time);
			user.setStatus(status);
			euserService.updateByPrimaryKey(user);
			user.setProject(eprojectService.selectByPrimaryKey(projectid));
		}
        return user;
    }
}