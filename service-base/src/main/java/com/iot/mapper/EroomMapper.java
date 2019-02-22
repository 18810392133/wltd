package com.iot.mapper;

import com.iot.bean.Eroom;
import com.iot.bean.Eroomv;
import com.iot.bean.Eroom;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EroomMapper {
    @Select({
            "select",
            "id, item, bimid, status, modelfile, note",
            "from eroom"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eroom> selectAll();

    @Select({
            "select",
            "id, item, bimid, status, modelfile, note",
            "from eroom",
            "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eroom> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, bimid, status, modelfile, note",
            "from eroom",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Eroom selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, bimid, status, modelfile, note",
            "from eroom"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "bimid", property = "bim",
                one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    List<Eroomv> selectVAll();

    @Select({
            "select",
            "id, item, bimid, status, modelfile, note",
            "from eroom",
            "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "bimid", property = "bim",
                one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    List<Eroomv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, bimid, status, modelfile, note",
            "from eroom",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "bimid", property = "bim",
                one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    Eroomv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "eroom.id id, eroom.item item, eroom.bimid bimid, eroom.status status, eroom.modelfile modelfile, eroom.note note",
            "from eroom, ebim, eplat",
            "where eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eroom> selectSubAll(Integer projectid);

    @Select({
            "select",
            "eroom.id id, eroom.item item, eroom.bimid bimid, eroom.status status, eroom.modelfile modelfile, eroom.note note",
            "from eroom, ebim, eplat",
            "where eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Eroom> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "eroom.id id, eroom.item item, eroom.bimid bimid, eroom.status status, eroom.modelfile modelfile, eroom.note note",
            "from eroom, ebim, eplat",
            "where eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and eroom.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Eroom selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "eroom.id id, eroom.item item, eroom.bimid bimid, eroom.status status, eroom.modelfile modelfile, eroom.note note",
            "from eroom, ebim, eplat",
            "where eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "bimid", property = "bim",
                one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    List<Eroomv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "eroom.id id, eroom.item item, eroom.bimid bimid, eroom.status status, eroom.modelfile modelfile, eroom.note note",
            "from eroom, ebim, eplat",
            "where eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "bimid", property = "bim",
                one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    List<Eroomv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "eroom.id id, eroom.item item, eroom.bimid bimid, eroom.status status, eroom.modelfile modelfile, eroom.note note",
            "from eroom, ebim, eplat",
            "where eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and eroom.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
        @Result(column="bimid", property="bimid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="modelfile", property="modelfile", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "bimid", property = "bim",
                one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    Eroomv selectSubVByPrimaryKey(Integer projectid, Integer id);
    
    @Delete({
        "delete from eroom",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eroom (id, item, ",
        "bimid, status, modelfile, ",
        "note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{bimid,jdbcType=INTEGER}, #{status,jdbcType=VARCHAR}, #{modelfile,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(Eroom record);
    
    @Update({
        "update eroom",
        "set item = #{item,jdbcType=VARCHAR},",
          "bimid = #{bimid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=VARCHAR},",
          "modelfile = #{modelfile,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Eroom record);
}