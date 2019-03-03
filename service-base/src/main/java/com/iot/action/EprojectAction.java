package com.iot.action;

import com.github.pagehelper.PageInfo;
import com.iot.bean.Eproject;
import com.iot.service.EprojectService;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Eproject> selectAll(){
		return eprojectService.selectAll();
	}

	@CrossOrigin
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
	public List<Eproject> selectBySql(String sql){
		return eprojectService.selectBySql(sql);
	}

	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Eproject selectByPrimaryKey(Integer id){
		return eprojectService.selectByPrimaryKey(id);
	}

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Eproject insert(String item, String fileurl, String servicename, String dburl, String detail){
		Eproject project = new Eproject();
		project.setItem(item);
		project.setFileurl(fileurl);
		project.setServicename(servicename);
		project.setDburl(dburl);
		project.setDetail(detail);
		eprojectService.insert(project);
        return project;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Eproject update(Integer id, String item, String fileurl, String servicename, String dburl, String detail){
		Eproject project = eprojectService.selectByPrimaryKey(id);
		if(project != null){
			project.setItem(item);
			project.setFileurl(fileurl);
			project.setServicename(servicename);
			project.setDburl(dburl);
			project.setDetail(detail);
			eprojectService.updateByPrimaryKey(project);
		}
        return project;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int delete(Integer id){
        return eprojectService.deleteByPrimaryKey(id);
    }
}