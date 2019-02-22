package com.iot.mapper;

import com.iot.bean.Ethreshold;
import com.iot.bean.Ethresholdv;
import com.iot.bean.Ethreshold;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EthresholdMapper {
    @Select({
            "select",
            "id, item, attrid, level, overtime, note",
            "from ethreshold"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Ethreshold> selectAll();

    @Select({
            "select",
            "id, item, attrid, level, overtime, note",
            "from ethreshold",
            "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Ethreshold> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, attrid, level, overtime, note",
            "from ethreshold",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Ethreshold selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, attrid, level, overtime, note",
            "from ethreshold"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "attrid", property = "attr",
                one = @One(select = "com.iot.mapper.EattrMapper.selectVByPrimaryKey"))
    })
    List<Ethresholdv> selectVAll();

    @Select({
            "select",
            "id, item, attrid, level, overtime, note",
            "from ethreshold",
            "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "attrid", property = "attr",
                one = @One(select = "com.iot.mapper.EattrMapper.selectVByPrimaryKey"))
    })
    List<Ethresholdv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, attrid, level, overtime, note",
            "from ethreshold",
            "where id = #{id, jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "attrid", property = "attr",
                one = @One(select = "com.iot.mapper.EattrMapper.selectVByPrimaryKey"))
    })
    Ethresholdv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "ethreshold.id id, ethreshold.item item, ethreshold.attrid attrid, ethreshold.level level, ethreshold.overtime overtime, ethreshold.note note",
            "from ethreshold, eattr, esensor",
            "where ethreshold.attrid = eattr.id and eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Ethreshold> selectSubAll(Integer projectid);

    @Select({
            "select",
            "ethreshold.id id, ethreshold.item item, ethreshold.attrid attrid, ethreshold.level level, ethreshold.overtime overtime, ethreshold.note note",
            "from ethreshold, eattr, esensor",
            "where ethreshold.attrid = eattr.id and eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Ethreshold> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "ethreshold.id id, ethreshold.item item, ethreshold.attrid attrid, ethreshold.level level, ethreshold.overtime overtime, ethreshold.note note",
            "from ethreshold, eattr, esensor",
            "where ethreshold.attrid = eattr.id and eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER} and ethreshold.id = #{id, jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Ethreshold selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "ethreshold.id id, ethreshold.item item, ethreshold.attrid attrid, ethreshold.level level, ethreshold.overtime overtime, ethreshold.note note",
            "from ethreshold, eattr, esensor",
            "where ethreshold.attrid = eattr.id and eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "attrid", property = "attr",
                one = @One(select = "com.iot.mapper.EattrMapper.selectVByPrimaryKey"))
    })
    List<Ethresholdv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "ethreshold.id id, ethreshold.item item, ethreshold.attrid attrid, ethreshold.level level, ethreshold.overtime overtime, ethreshold.note note",
            "from ethreshold, eattr, esensor",
            "where ethreshold.attrid = eattr.id and eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "attrid", property = "attr",
                one = @One(select = "com.iot.mapper.EattrMapper.selectVByPrimaryKey"))
    })
    List<Ethresholdv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "ethreshold.id id, ethreshold.item item, ethreshold.attrid attrid, ethreshold.level level, ethreshold.overtime overtime, ethreshold.note note",
            "from ethreshold, eattr, esensor",
            "where ethreshold.attrid = eattr.id and eattr.sensorid = esensor.id and esensor.projectid = #{projectid, jdbcType=INTEGER} and ethreshold.id = #{id, jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="attrid", property="attrid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="overtime", property="overtime", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "attrid", property = "attr",
                one = @One(select = "com.iot.mapper.EattrMapper.selectVByPrimaryKey"))
    })
    Ethresholdv selectSubVByPrimaryKey(Integer projectid, Integer id);
    
    @Delete({
        "delete from ethreshold",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ethreshold (id, item, ",
        "attrid, level, overtime, ",
        "note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{attrid,jdbcType=INTEGER}, #{level,jdbcType=INTEGER}, #{overtime,jdbcType=INTEGER}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(Ethreshold record);

    @Update({
        "update ethreshold",
        "set item = #{item,jdbcType=VARCHAR},",
          "attrid = #{attrid,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "overtime = #{overtime,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Ethreshold record);
}