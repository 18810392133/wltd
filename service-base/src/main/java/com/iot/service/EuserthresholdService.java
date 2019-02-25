package com.iot.service;

import com.iot.bean.Euserthreshold;
import com.iot.bean.Euserthresholdv;
import java.util.List;

public interface EuserthresholdService {
    public List<Euserthreshold> selectAll();

    public List<Euserthreshold> selectByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserthreshold> selectBySql(String sql);

    public Euserthreshold selectByPrimaryKey(Integer id);

    public List<Euserthresholdv> selectVAll();

    public List<Euserthresholdv> selectVByPage(Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserthresholdv> selectVBySql(String sql);

    public Euserthresholdv selectVByPrimaryKey(Integer id);

    public List<Euserthresholdv> selectVByUserAttr(Integer userid, Integer attrid);

    public List<Euserthreshold> selectSubAll(Integer projectid);

    public List<Euserthreshold> selectSubByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserthreshold> selectSubBySql(Integer projectid, String sql);

    public Euserthreshold selectSubByPrimaryKey(Integer projectid, Integer id);

    public List<Euserthresholdv> selectSubVAll(Integer projectid);

    public List<Euserthresholdv> selectSubVByPage(Integer projectid, Integer page, Integer rows, String sort, String order, String filterRules);

    public List<Euserthresholdv> selectSubVBySql(Integer projectid, String sql);

    public Euserthresholdv selectSubVByPrimaryKey(Integer projectid, Integer id);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Euserthreshold record);

    public int updateByPrimaryKey(Euserthreshold record);
} 