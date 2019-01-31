package com.iot.mapper;

import com.iot.bean.Eattr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EattrMapper {
    @Delete({
        "delete from eattr",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eattr (id, item, ",
        "sensorid, protocol, ",
        "type, unit, thresholdl, ",
        "thresholdm, thresholdh, ",
        "note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{sensorid,jdbcType=INTEGER}, #{protocol,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{unit,jdbcType=VARCHAR}, #{thresholdl,jdbcType=VARCHAR}, ",
        "#{thresholdm,jdbcType=VARCHAR}, #{thresholdh,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(Eattr record);

    @Select({
        "select",
        "id, item, sensorid, protocol, type, unit, thresholdl, thresholdm, thresholdh, ",
        "note",
        "from eattr",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
        @Result(column="thresholdl", property="thresholdl", jdbcType=JdbcType.VARCHAR),
        @Result(column="thresholdm", property="thresholdm", jdbcType=JdbcType.VARCHAR),
        @Result(column="thresholdh", property="thresholdh", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Eattr selectByPrimaryKey(Integer id);

    @Update({
        "update eattr",
        "set item = #{item,jdbcType=VARCHAR},",
          "sensorid = #{sensorid,jdbcType=INTEGER},",
          "protocol = #{protocol,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "unit = #{unit,jdbcType=VARCHAR},",
          "thresholdl = #{thresholdl,jdbcType=VARCHAR},",
          "thresholdm = #{thresholdm,jdbcType=VARCHAR},",
          "thresholdh = #{thresholdh,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Eattr record);
}