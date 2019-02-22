package com.iot.mapper;

import com.iot.bean.Eattr;
import com.iot.bean.Eattrv;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EattrMapper {
    @Select({
            "select",
            "id, item, sensorid, protocol, compare, unit, timer, note",
            "from eattr"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eattr> selectAll();

    @Select({
            "select",
            "id, item, sensorid, protocol, compare, unit, timer, note",
            "from eattr",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eattr> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, sensorid, protocol, compare, unit, timer, note",
            "from eattr",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Eattr selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, sensorid, protocol, compare, unit, timer, note",
            "from eattr"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    List<Eattrv> selectVAll();

    @Select({
            "select",
            "id, item, sensorid, protocol, compare, unit, timer, note",
            "from eattr",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    List<Eattrv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, sensorid, protocol, compare, unit, timer, note",
            "from eattr",
            "where id = #{id, jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    Eattrv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.compare compare, eattr.unit unit, eattr.timer timer, eattr.note note",
            "from eattr, esensor",
            "where eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eattr> selectSubAll(Integer projectid);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.compare compare, eattr.unit unit, eattr.timer timer, eattr.note note",
            "from eattr, esensor",
            "where eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eattr> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.compare compare, eattr.unit unit, eattr.timer timer, eattr.note note",
            "from eattr, esensor",
            "where eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER} and eattr.id = #{id, jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Eattr selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.compare compare, eattr.unit unit, eattr.timer timer, eattr.note note",
            "from eattr, esensor",
            "where eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    List<Eattrv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.compare compare, eattr.unit unit, eattr.timer timer, eattr.note note",
            "from eattr, esensor",
            "where eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    List<Eattrv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.compare compare, eattr.unit unit, eattr.timer timer, eattr.note note",
            "from eattr, esensor",
            "where eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER} and eattr.id = #{id, jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="compare", property="compare", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="timer", property="timer", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    Eattrv selectSubVByPrimaryKey(Integer projectid, Integer id);
    
    @Delete({
        "delete from eattr",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eattr (id, item, ",
        "sensorid, protocol, ",
        "compare, unit, timer, note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{sensorid,jdbcType=INTEGER}, #{protocol,jdbcType=VARCHAR}, ",
        "#{compare,jdbcType=VARCHAR}, #{unit,jdbcType=VARCHAR}, #{timer,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR})"
    })
    int insert(Eattr record);

    @Update({
        "update eattr",
        "set item = #{item,jdbcType=VARCHAR},",
          "sensorid = #{sensorid,jdbcType=INTEGER},",
          "protocol = #{protocol,jdbcType=VARCHAR},",
          "compare = #{compare,jdbcType=VARCHAR},",
          "unit = #{unit,jdbcType=VARCHAR},",
          "timer = #{timer,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Eattr record);
}