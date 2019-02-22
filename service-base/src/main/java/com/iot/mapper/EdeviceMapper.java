package com.iot.mapper;

import com.iot.bean.Edevice;
import com.iot.bean.Edevicev;
import com.iot.bean.Edevice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EdeviceMapper {
    @Select({
            "select",
            "id, item, sensorid, roomid, protocol, status, level, note",
            "from edevice"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Edevice> selectAll();

    @Select({
            "select",
            "id, item, sensorid, roomid, protocol, status, level, note",
            "from edevice",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Edevice> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, sensorid, roomid, protocol, status, level, note",
            "from edevice",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Edevice selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, sensorid, roomid, protocol, status, level, note",
            "from edevice"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey")),
            @Result(column = "roomid", property = "room",
                    one = @One(select = "com.iot.mapper.EroomMapper.selectVByPrimaryKey"))
    })
    List<Edevicev> selectVAll();

    @Select({
            "select",
            "id, item, sensorid, roomid, protocol, status, level, note",
            "from edevice",
            "where ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey")),
            @Result(column = "roomid", property = "room",
                    one = @One(select = "com.iot.mapper.EroomMapper.selectVByPrimaryKey"))
    })
    List<Edevicev> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, sensorid, roomid, protocol, status, level, note",
            "from edevice",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey")),
            @Result(column = "roomid", property = "room",
                    one = @One(select = "com.iot.mapper.EroomMapper.selectVByPrimaryKey"))
    })
    Edevicev selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "edevice.id id, edevice.item item, edevice.sensorid sensorid, edevice.roomid roomid, edevice.protocol protocol, edevice.status status, edevice.level level, edevice.note note",
            "from edevice, eroom, ebim, eplat",
            "where edevice.roomid = eroom.id and eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Edevice> selectSubAll(Integer projectid);

    @Select({
            "select",
            "edevice.id id, edevice.item item, edevice.sensorid sensorid, edevice.roomid roomid, edevice.protocol protocol, edevice.status status, edevice.level level, edevice.note note",
            "from edevice, eroom, ebim, eplat",
            "where edevice.roomid = eroom.id and eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Edevice> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "edevice.id id, edevice.item item, edevice.sensorid sensorid, edevice.roomid roomid, edevice.protocol protocol, edevice.status status, edevice.level level, edevice.note note",
            "from edevice, eroom, ebim, eplat",
            "where edevice.roomid = eroom.id and eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and edevice.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Edevice selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "edevice.id id, edevice.item item, edevice.sensorid sensorid, edevice.roomid roomid, edevice.protocol protocol, edevice.status status, edevice.level level, edevice.note note",
            "from edevice, eroom, ebim, eplat",
            "where edevice.roomid = eroom.id and eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey")),
            @Result(column = "roomid", property = "room",
                    one = @One(select = "com.iot.mapper.EroomMapper.selectVByPrimaryKey"))
    })
    List<Edevicev> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "edevice.id id, edevice.item item, edevice.sensorid sensorid, edevice.roomid roomid, edevice.protocol protocol, edevice.status status, edevice.level level, edevice.note note",
            "from edevice, eroom, ebim, eplat",
            "where edevice.roomid = eroom.id and eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey")),
            @Result(column = "roomid", property = "room",
                    one = @One(select = "com.iot.mapper.EroomMapper.selectVByPrimaryKey"))
    })
    List<Edevicev> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "edevice.id id, edevice.item item, edevice.sensorid sensorid, edevice.roomid roomid, edevice.protocol protocol, edevice.status status, edevice.level level, edevice.note note",
            "from edevice, eroom, ebim, eplat",
            "where edevice.roomid = eroom.id and eroom.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid,jdbcType=INTEGER} and edevice.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="item", property="item", jdbcType=JdbcType.VARCHAR),
            @Result(column="sensorid", property="sensorid", jdbcType=JdbcType.INTEGER),
            @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
            @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey")),
            @Result(column = "roomid", property = "room",
                    one = @One(select = "com.iot.mapper.EroomMapper.selectVByPrimaryKey"))
    })
    Edevicev selectSubVByPrimaryKey(Integer projectid, Integer id);
    
    @Delete({
        "delete from edevice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into edevice (id, item, ",
        "sensorid, roomid, protocol, ",
        "status, level, note)",
        "values (#{id,jdbcType=INTEGER}, #{item,jdbcType=VARCHAR}, ",
        "#{sensorid,jdbcType=INTEGER}, #{roomid,jdbcType=INTEGER}, #{protocol,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{level,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Edevice record);
    
    @Update({
        "update edevice",
        "set item = #{item,jdbcType=VARCHAR},",
          "sensorid = #{sensorid,jdbcType=INTEGER},",
          "roomid = #{roomid,jdbcType=INTEGER},",
          "protocol = #{protocol,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Edevice record);
}