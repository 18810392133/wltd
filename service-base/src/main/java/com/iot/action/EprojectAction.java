package com.iot.action;
  
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.iot.bean.Eproject;
import com.iot.bean.Select;
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
@RequestMapping("/project")
public class EprojectAction {  
    @Resource  
    private EprojectService eprojectService;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public Map<Object, Object> select(){
		List<Eproject> list = eprojectService.selectAll();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

    @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
    public Map<Object, Object> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules){
    	List<Eproject> list = eprojectService.selectByPage(page, rows, sort, order, filterRules);
    	PageInfo<Eproject> pageInfo = new PageInfo<Eproject>(list);
    	Map<Object, Object> map = new HashMap<Object, Object>();
    	map.put("total", pageInfo.getTotal());
    	map.put("rows", list);
        return map;
    }

	@RequestMapping(value = "/selectBySql", method = RequestMethod.GET)
	public Map<Object, Object> selectBySql(String sql){
		List<Eproject> list = eprojectService.selectBySql(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Map<Object, Object> selectByPrimaryKey(Integer id){
		Eproject object = eprojectService.selectByPrimaryKey(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("object", object);
		return map;
	}

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Map<Object, Object> insert(String item, String fileurl, String servicename, String dburl, String detail){
    	Map<Object, Object> map = new HashMap<Object, Object>();
    	if(isValidate(item, 0)){
    		Eproject project = new Eproject();
    		project.setItem(item);
    		project.setFileurl(fileurl);
    		project.setServicename(servicename);
    		project.setDburl(dburl);
    		project.setDetail(detail);
            eprojectService.insert(project);
            map = new BeanMap(project);
    	}else{
    		map.put("isError", true);
    		map.put("msg", "该项目已存在");
    	}
        return map;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Map<Object, Object> update(Integer id, String item, String fileurl, String servicename, String dburl, String detail){
    	Map<Object, Object> map = new HashMap<Object, Object>();
    	if(isValidate(item, id)){
    		Eproject project = eprojectService.selectByPrimaryKey(id);
    		if(project != null){
    			project.setItem(item);
        		project.setFileurl(fileurl);
				project.setServicename(servicename);
				project.setDburl(dburl);
        		project.setDetail(detail);
	            eprojectService.updateByPrimaryKey(project);
	            map = new BeanMap(project);
    		}
    	}else{
    		map.put("isError", true);
    		map.put("msg", "该项目已存在");
    	}
        return map;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Map<Object, Object> delete(Integer id){
    	Map<Object, Object> map = new HashMap<Object, Object>();
    	eprojectService.deleteByPrimaryKey(id);
    	map.put("success", true);
        return map;
    }

	@RequestMapping(value = "/combobox", method = RequestMethod.GET)
	public JSONArray combobox(){
		JSONArray jsonArray = new JSONArray();
		List<Eproject> list = eprojectService.selectAll();
		for(int i = 0; i < list.size(); i++){
			Select select = new Select();
			select.setText(list.get(i).getItem());
			select.setValue(String.valueOf(list.get(i).getId()));
			jsonArray.add(select);
		}
		return jsonArray;
	}

    public boolean isValidate(String item, Integer id){
    	List<Eproject> list = eprojectService.selectBySql("item='" + item + "' and id!=" + id);
    	if(list.size() > 0)
    		return false;
    	else
    		return true;
	}
}