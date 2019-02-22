package com.iot.mapper;

import com.iot.bean.Euserdevice;
import com.iot.bean.Euserdevicev;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EuserdeviceMapper {
    @Select({
        "select",
        "id, userid, deviceid, note",
        "from euserdevice"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Euserdevice> selectAll();

    @Select({
        "select",
        "id, userid, deviceid, note",
        "from euserdevice",
        "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Euserdevice> selectBySql(@Param("sql") String sql);

    @Select({
        "select",
        "id, userid, deviceid, note",
        "from euserdevice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Euserdevice selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, userid, deviceid, note",
        "from euserdevice"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "deviceid",property = "device",
                one = @One(select = "com.iot.mapper.EdeviceMapper.selectVByPrimaryKey"))
    })
    List<Euserdevicev> selectVAll();

    @Select({
        "select",
        "id, userid, deviceid, note",
        "from euserdevice",
        "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "deviceid",property = "device",
                one = @One(select = "com.iot.mapper.EdeviceMapper.selectVByPrimaryKey"))
    })
    List<Euserdevicev> selectVBySql(@Param("sql") String sql);

    @Select({
        "select",
        "id, userid, deviceid, note",
        "from euserdevice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "deviceid",property = "device",
                one = @One(select = "com.iot.mapper.EdeviceMapper.selectVByPrimaryKey"))
    })
    Euserdevicev selectVByPrimaryKey(Integer id);

    @Select({
        "select",
        "euserdevice.id id, euserdevice.userid userid, euserdevice.deviceid deviceid, euserdevice.note note",
        "from euserdevice, euser",
        "where euserdevice.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Euserdevice> selectSubAll(Integer projectid);

    @Select({
        "select",
        "euserdevice.id id, euserdevice.userid userid, euserdevice.deviceid deviceid, euserdevice.note note",
        "from euserdevice, euser",
        "where euserdevice.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Euserdevice> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
        "select",
        "euserdevice.id id, euserdevice.userid userid, euserdevice.deviceid deviceid, euserdevice.note note",
        "from euserdevice, euser",
        "where euserdevice.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER} and euserdevice.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Euserdevice selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
        "select",
        "euserdevice.id id, euserdevice.userid userid, euserdevice.deviceid deviceid, euserdevice.note note",
        "from euserdevice, euser",
        "where euserdevice.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "deviceid",property = "device",
                one = @One(select = "com.iot.mapper.EdeviceMapper.selectVByPrimaryKey"))
    })
    List<Euserdevicev> selectSubVAll(Integer projectid);

    @Select({
        "select",
        "euserdevice.id id, euserdevice.userid userid, euserdevice.deviceid deviceid, euserdevice.note note",
        "from euserdevice, euser",
        "where euserdevice.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "deviceid",property = "device",
                one = @One(select = "com.iot.mapper.EdeviceMapper.selectVByPrimaryKey"))
    })
    List<Euserdevicev> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
        "select",
        "euserdevice.id id, euserdevice.userid userid, euserdevice.deviceid deviceid, euserdevice.note note",
        "from euserdevice, euser",
        "where euserdevice.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER} and euserdevice.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="deviceid", property="deviceid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "deviceid",property = "device",
                one = @One(select = "com.iot.mapper.EdeviceMapper.selectVByPrimaryKey"))
    })
    Euserdevicev selectSubVByPrimaryKey(Integer projectid, Integer id);
    
    @Delete({
        "delete from euserdevice",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into euserdevice (id, userid, ",
        "deviceid, note)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{deviceid,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Euserdevice record);

    @Update({
        "update euserdevice",
        "set userid = #{userid,jdbcType=INTEGER},",
          "deviceid = #{deviceid,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Euserdevice record);
}