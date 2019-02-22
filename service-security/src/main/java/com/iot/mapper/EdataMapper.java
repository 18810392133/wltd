package com.iot.mapper;

import com.iot.bean.Edata;
import com.iot.bean.Edatav;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;

public interface EdataMapper {
    @Select({
            "select",
            "id, item, deviceid, attrid, time, note",
            "from edata"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
            @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Edata> selectAll();

    @Select({
            "select",
            "id, item, deviceid, attrid, time, note",
            "from edata",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
            @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Edata> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, deviceid, attrid, time, note",
            "from edata",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
            @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Edata selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, deviceid, attrid, time, note",
            "from edata"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
            @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Edatav> selectVAll();

    @Select({
            "select",
            "id, item, deviceid, attrid, time, note",
            "from edata",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
            @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Edatav> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, deviceid, attrid, time, note",
            "from edata",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
            @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Edatav selectVByPrimaryKey(Integer id);

    @Delete({
        "delete from edata",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into edata (id, item, ",
        "deviceid, attrid, ",
        "time, note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{deviceid,jdbcType=INTEGER}, #{attrid,jdbcType=INTEGER}, ",
        "#{time,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Edata record);

    @Update({
        "update edata",
        "set item = #{item,jdbcType=VARCHAR},",
          "deviceid = #{deviceid,jdbcType=INTEGER},",
          "attrid = #{attrid,jdbcType=INTEGER},",
          "time = #{time,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Edata record);
}