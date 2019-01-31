package com.iot.mapper;

import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import com.iot.bean.Eplat;
import com.iot.bean.Eplatv;
import com.iot.util.RedisCache;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface EbimMapper {
    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, note",
            "from ebim"
    })
    List<Ebim> selectAll();

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, note",
            "from ebim",
            "where ${sql}"
    })
    List<Ebim> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, note",
            "from ebim",
            "where id = #{id}"
    })
    Ebim selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, note",
            "from ebim"
    })
    @Results({
            @Result(column="platid", property="platid"),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    List<Ebimv> selectVAll();

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, note",
            "from ebim",
            "where ${sql}"
    })
    @Results({
            @Result(column="platid", property="platid"),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    List<Ebimv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, note",
            "from ebim",
            "where id = #{id}"
    })
    @Results({
            @Result(column="platid", property="platid"),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    Ebimv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid}"
    })
    List<Ebim> selectSubAll(Integer projectid);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid} and ${sql}"
    })
    List<Ebim> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid} and ebim.id = #{id}"
    })
    Ebim selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid}"
    })
    @Results({
            @Result(column="platid", property="platid"),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    List<Ebimv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid} and ${sql}"
    })
    @Results({
            @Result(column="platid", property="platid"),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    List<Ebimv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid} and id = #{id}"
    })
    @Results({
            @Result(column="platid", property="platid"),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    Ebimv selectSubVByPrimaryKey(Integer projectid, Integer id);

    @Delete({
        "delete from ebim",
        "where id = #{id}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ebim",
        "(id, item, platid, longitude, latitude, status, note)",
        "values (#{id}, #{item}, #{platid}, #{longitude}, #{latitude}, #{status}, #{note})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Ebim record);

    @Update({
        "update ebim",
        "set item = #{item},",
          "platid = #{platid},",
          "longitude = #{longitude},",
          "latitude = #{latitude},",
          "status = #{status},",
          "note = #{note}",
        "where id = #{id}"
    })
    int updateByPrimaryKey(Ebim record);
}