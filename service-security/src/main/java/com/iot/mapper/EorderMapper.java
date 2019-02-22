package com.iot.mapper;

import com.iot.bean.Eorder;
import com.iot.bean.Eorderv;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;

public interface EorderMapper {
    @Select({
            "select",
            "id, item, dataid, userid, status, level, type, time, note",
            "from eorder"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataid", property="dataid", jdbcType=JdbcType.INTEGER),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eorder> selectAll();

    @Select({
            "select",
            "id, item, dataid, userid, status, level, type, time, note",
            "from eorder",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataid", property="dataid", jdbcType=JdbcType.INTEGER),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eorder> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, dataid, userid, status, level, type, time, note",
            "from eorder",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataid", property="dataid", jdbcType=JdbcType.INTEGER),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Eorder selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, dataid, userid, status, level, type, time, note",
            "from eorder"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataid", property="dataid", jdbcType=JdbcType.INTEGER),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "dataid", property = "data",
                    one = @One(select = "com.iot.mapper.EdataMapper.selectVByPrimaryKey"))
    })
    List<Eorderv> selectVAll();

    @Select({
            "select",
            "id, item, dataid, userid, status, level, type, time, note",
            "from eorder",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataid", property="dataid", jdbcType=JdbcType.INTEGER),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "dataid", property = "data",
                    one = @One(select = "com.iot.mapper.EdataMapper.selectVByPrimaryKey"))
    })
    List<Eorderv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, dataid, userid, status, level, type, time, note",
            "from eorder",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataid", property="dataid", jdbcType=JdbcType.INTEGER),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "dataid", property = "data",
                    one = @One(select = "com.iot.mapper.EdataMapper.selectVByPrimaryKey"))
    })
    Eorderv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "eorder.id id, eorder.item item, eorder.dataid dataid, eorder.userid userid, eorder.status status, eorder.level level, eorder.type type, eorder.time time, eorder.note note",
            "from eorder, edata",
            "where eorder.dataid = edata.id and edata.deviceid in ${devices}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataid", property="dataid", jdbcType=JdbcType.INTEGER),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "dataid", property = "data",
                    one = @One(select = "com.iot.mapper.EdataMapper.selectVByPrimaryKey"))
    })
    List<Eorderv> selectVByDevices(@Param("devices") String devices);

    @Select({
            "select",
            "eorder.id id, eorder.item item, eorder.dataid dataid, eorder.userid userid, eorder.status status, eorder.level level, eorder.type type, eorder.time time, eorder.note note",
            "from eorder, edata",
            "where eorder.dataid = edata.id and edata.deviceid = #{deviceid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="dataid", property="dataid", jdbcType=JdbcType.INTEGER),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "dataid", property = "data",
                    one = @One(select = "com.iot.mapper.EdataMapper.selectVByPrimaryKey"))
    })
    List<Eorderv> selectVByDevice(Integer deviceid);

    @Delete({
        "delete from eorder",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eorder (id, item, ",
        "dataid, userid, ",
        "status, level, type, time, ",
        "note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{dataid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{status,jdbcType=VARCHAR}, #{level,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, #{time,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Eorder record);

    @Update({
        "update eorder",
        "set item = #{item,jdbcType=VARCHAR},",
          "dataid = #{dataid,jdbcType=INTEGER},",
          "userid = #{userid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Eorder record);
}