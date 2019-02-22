package com.iot.mapper;

import com.iot.bean.Esensor;
import com.iot.bean.Esensorv;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EsensorMapper {
    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Esensor> selectAll();

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Esensor> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Esensor selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "projectid",property = "project",
                one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Esensorv> selectVAll();

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "projectid",property = "project",
                one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Esensorv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "projectid",property = "project",
                one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Esensorv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Esensor> selectSubAll(Integer projectid);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Esensor> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where projectid = #{projectid,jdbcType=INTEGER} and id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Esensor selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "projectid",property = "project",
                one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Esensorv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "projectid",property = "project",
                one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Esensorv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, protocol, timer, note",
            "from esensor",
            "where projectid = #{projectid,jdbcType=INTEGER} and id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "projectid",property = "project",
                one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Esensorv selectSubVByPrimaryKey(Integer projectid, Integer id);
    
    @Delete({
        "delete from esensor",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into esensor (id, item, ",
        "projectid, protocol, ",
        "timer, note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{projectid,jdbcType=INTEGER}, #{protocol,jdbcType=VARCHAR}, ",
        "#{timer,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Esensor record);

    @Update({
        "update esensor",
        "set item = #{item,jdbcType=VARCHAR},",
          "projectid = #{projectid,jdbcType=INTEGER},",
          "protocol = #{protocol,jdbcType=VARCHAR},",
          "timer = #{timer,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Esensor record);
}