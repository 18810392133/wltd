package com.iot.mapper;

import com.iot.bean.Eproject;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;

public interface EprojectMapper {
    @Select({
            "select",
            "id, item, fileurl, servicename, dburl, detail",
            "from eproject"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="fileurl", property="fileurl", jdbcType=JdbcType.VARCHAR),
            @Result(column="servicename", property="servicename", jdbcType=JdbcType.VARCHAR),
            @Result(column="dburl", property="dburl", jdbcType=JdbcType.VARCHAR),
            @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Eproject> selectAll();

    @Select({
            "select",
            "id, item, fileurl, servicename, dburl, detail",
            "from eproject",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="fileurl", property="fileurl", jdbcType=JdbcType.VARCHAR),
            @Result(column="servicename", property="servicename", jdbcType=JdbcType.VARCHAR),
            @Result(column="dburl", property="dburl", jdbcType=JdbcType.VARCHAR),
            @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Eproject> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, fileurl, servicename, dburl, detail",
            "from eproject",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="fileurl", property="fileurl", jdbcType=JdbcType.VARCHAR),
            @Result(column="servicename", property="servicename", jdbcType=JdbcType.VARCHAR),
            @Result(column="dburl", property="dburl", jdbcType=JdbcType.VARCHAR),
            @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    Eproject selectByPrimaryKey(Integer id);

    @Delete({
        "delete from eproject",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eproject (id, item, ",
        "fileurl, servicename, ",
        "dburl, detail)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{fileurl,jdbcType=VARCHAR}, #{servicename,jdbcType=VARCHAR}, ",
        "#{dburl,jdbcType=VARCHAR}, #{detail,jdbcType=LONGVARCHAR})"
    })
    int insert(Eproject record);

    @Update({
        "update eproject",
        "set item = #{item,jdbcType=VARCHAR},",
          "fileurl = #{fileurl,jdbcType=VARCHAR},",
          "servicename = #{servicename,jdbcType=VARCHAR},",
          "dburl = #{dburl,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Eproject record);
}