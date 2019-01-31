package com.iot.mapper;

import com.iot.bean.Eproject;
import com.iot.util.RedisCache;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface EprojectMapper {
    @Select({
            "select",
            "id, item, fileurl, servicename, dburl, detail",
            "from eproject"
    })
    List<Eproject> selectAll();

    @Select({
            "select",
            "id, item, fileurl, servicename, dburl, detail",
            "from eproject",
            "where ${sql}"
    })
    List<Eproject> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, fileurl, servicename, dburl, detail",
            "from eproject",
            "where id = #{id}"
    })
    Eproject selectByPrimaryKey(Integer id);

    @Delete({
        "delete from eproject",
        "where id = #{id}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eproject",
        "(id, item, fileurl, servicename, dburl, detail)",
        "values (#{id}, #{item}, #{fileurl}, #{servicename}, #{dburl}, #{detail})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Eproject record);

    @Update({
        "update eproject",
        "set item = #{item},",
          "fileurl = #{fileurl},",
          "servicename = #{servicename},",
          "dburl = #{dburl},",
          "detail = #{detail}",
        "where id = #{id}"
    })
    int updateByPrimaryKey(Eproject record);
}