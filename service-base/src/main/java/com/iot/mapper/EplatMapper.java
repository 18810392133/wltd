package com.iot.mapper;

import com.iot.bean.Eplat;
import com.iot.bean.Eplatv;
import com.iot.util.RedisCache;
import org.apache.ibatis.annotations.*;
import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface EplatMapper {
    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat"
    })
    List<Eplat> selectAll();

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where ${sql}"
    })
    List<Eplat> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where id = #{id}"
    })
    Eplat selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
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
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Eplatv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where id = #{id}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Eplatv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid}"
    })
    List<Eplat> selectSubAll(Integer projectid);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid} and ${sql}"
    })
    List<Eplat> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid} and id = #{id}"
    })
    Eplat selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Eplatv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid} and ${sql}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    List<Eplatv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "id, item, projectid, province, city, longitude, latitude, note",
            "from eplat",
            "where projectid = #{projectid} and id = #{id}"
    })
    @Results({
            @Result(column="projectid", property="projectid"),
            @Result(column = "projectid",property = "project",
                    one = @One(select = "com.iot.mapper.EprojectMapper.selectByPrimaryKey"))
    })
    Eplatv selectSubVByPrimaryKey(Integer projectid, Integer id);

    @Delete({
        "delete from eplat",
        "where id = #{id}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eplat",
        "(id, item, projectid, province, city, longitude, latitude, note)",
        "values (#{id}, #{item}, #{projectid}, #{province}, #{city}, #{longitude}, #{latitude}, #{note})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Eplat record);

    @Update({
        "update eplat",
        "set item = #{item},",
          "projectid = #{projectid},",
          "province = #{province},",
          "city = #{city},",
          "longitude = #{longitude},",
          "latitude = #{latitude},",
          "note = #{note}",
        "where id = #{id}"
    })
    int updateByPrimaryKey(Eplat record);
}