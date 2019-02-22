package com.iot.mapper;

import com.iot.bean.Eplat;
import com.iot.bean.Eplatv;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import java.util.List;

public interface EplatMapper {
    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eplat> selectAll();

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eplat> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Eplat selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Eplatv> selectVAll();

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Eplatv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Eplatv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eplat> selectSubAll(Integer projectid);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eplat> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid,jdbcType=INTEGER} and id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Eplat selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Eplatv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Eplatv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid,jdbcType=INTEGER} and id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="projectid", property="projectid", jdbcType=JdbcType.INTEGER),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Eplatv selectSubVByPrimaryKey(Integer projectid, Integer id);

    @Delete({
        "delete from eplat",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eplat (id, item, ",
        "projectid, province, ",
        "city, longitude, ",
        "latitude, note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{projectid,jdbcType=INTEGER}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{longitude,jdbcType=VARCHAR}, ",
        "#{latitude,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR})"
    })
    int insert(Eplat record);

    @Update({
        "update eplat",
        "set item = #{item,jdbcType=VARCHAR},",
          "projectid = #{projectid,jdbcType=INTEGER},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "longitude = #{longitude,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Eplat record);
}