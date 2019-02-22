package com.iot.mapper;

import com.iot.bean.Euser;
import com.iot.bean.Euserv;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EuserMapper {
    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Euser> selectAll();

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Euser> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    Euser selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Euserv> selectVAll();

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Euserv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Euserv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Euser> selectSubAll(Integer projectid);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Euser> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where projectid = #{projectid,jdbcType=INTEGER} and id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    Euser selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Euserv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Euserv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, username, password, projectid, type, realname, phone, wechat, time, status",
            "from euser",
            "where projectid = #{projectid,jdbcType=INTEGER} and id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="wechat", property="wechat", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Euserv selectSubVByPrimaryKey(Integer projectid, Integer id);

    @Delete({
        "delete from euser",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into euser (id, username, ",
        "password, projectid, ",
        "type, realname, ",
        "phone, wechat, time, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{projectid,jdbcType=INTEGER}, ",
        "#{type,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{wechat,jdbcType=VARCHAR}, #{time,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(Euser record);

    @Update({
        "update euser",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "projectid = #{projectid,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "realname = #{realname,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "wechat = #{wechat,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Euser record);
}