package com.iot.mapper;

import com.iot.bean.Euser;
import com.iot.bean.Euserv;
import com.iot.util.RedisCache;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface EuserMapper {
    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser"
    })
    List<Euser> selectAll();

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where ${sql}"
    })
    List<Euser> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where id = #{id}"
    })
    Euser selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Euserv> selectVAll();

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where ${sql}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Euserv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where id = #{id}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Euserv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where projectid = #{projectid}"
    })
    List<Euser> selectSubAll(Integer projectid);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where projectid = #{projectid} and ${sql}"
    })
    List<Euser> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where projectid = #{projectid} and id = #{id}"
    })
    Euser selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where projectid = #{projectid}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Euserv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where projectid = #{projectid} and ${sql}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Euserv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, item, password, projectid, type, realname, age, time, status",
            "from euser",
            "where projectid = #{projectid} and id = #{id}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Euserv selectSubVByPrimaryKey(Integer projectid, Integer id);

    @Delete({
        "delete from euser",
        "where id = #{id}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into euser",
        "(id, item, password, projectid, type, realname, age, time, status)",
        "values (#{id}, #{item}, #{password}, #{projectid}, #{type}, #{realname}, #{age}, #{time}, #{status})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Euser record);

    @Update({
        "update euser",
        "set item = #{item},",
          "password = #{password},",
          "projectid = #{projectid},",
          "type = #{type},",
          "realname = #{realname},",
          "age = #{age},",
          "time = #{time},",
          "status = #{status}",
        "where id = #{id}"
    })
    int updateByPrimaryKey(Euser record);
}