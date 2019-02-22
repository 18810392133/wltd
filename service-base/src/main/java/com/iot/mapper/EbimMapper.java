package com.iot.mapper;

import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EbimMapper {
    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, modelfile, note",
            "from ebim"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Ebim> selectAll();

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, modelfile, note",
            "from ebim",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Ebim> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, modelfile, note",
            "from ebim",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Ebim selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, modelfile, note",
            "from ebim"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    List<Ebimv> selectVAll();

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, modelfile, note",
            "from ebim",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    List<Ebimv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, platid, longitude, latitude, status, modelfile, note",
            "from ebim",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    Ebimv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.modelfile modelfile, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Ebim> selectSubAll(Integer projectid);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.modelfile modelfile, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Ebim> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.modelfile modelfile, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and ebim.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Ebim selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.modelfile modelfile, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    List<Ebimv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.modelfile modelfile, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    List<Ebimv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "ebim.id id, ebim.item item, ebim.platid platid, ebim.longitude longitude, ebim.latitude latitude, ebim.status status, ebim.modelfile modelfile, ebim.note note",
            "from ebim, eplat",
            "where ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and ebim.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="platid", property="platid", jdbcType=JdbcType.INTEGER),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "platid", property = "plat",
                    one = @One(select = "com.iot.mapper.EplatMapper.selectVByPrimaryKey"))
    })
    Ebimv selectSubVByPrimaryKey(Integer projectid, Integer id);
    
    @Delete({
        "delete from ebim",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ebim (id, item, ",
        "platid, longitude, ",
        "latitude, status, ",
        "modelfile, note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{platid,jdbcType=INTEGER}, #{longitude,jdbcType=VARCHAR}, ",
        "#{latitude,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{modelfile,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR})"
    })
    int insert(Ebim record);

    @Update({
        "update ebim",
        "set item = #{item,jdbcType=VARCHAR},",
          "platid = #{platid,jdbcType=INTEGER},",
          "longitude = #{longitude,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "modelfile = #{modelfile,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Ebim record);
}