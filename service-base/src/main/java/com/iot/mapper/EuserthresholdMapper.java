package com.iot.mapper;

import com.iot.bean.Euserthreshold;
import com.iot.bean.Euserthresholdv;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EuserthresholdMapper {
    @Select({
        "select",
        "id, userid, thresholdid, note",
        "from euserthreshold"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Euserthreshold> selectAll();

    @Select({
        "select",
        "id, userid, thresholdid, note",
        "from euserthreshold",
        "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Euserthreshold> selectBySql(@Param("sql") String sql);

    @Select({
        "select",
        "id, userid, thresholdid, note",
        "from euserthreshold",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Euserthreshold selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, userid, thresholdid, note",
        "from euserthreshold"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "thresholdid",property = "threshold",
                one = @One(select = "com.iot.mapper.EthresholdMapper.selectVByPrimaryKey"))
    })
    List<Euserthresholdv> selectVAll();

    @Select({
        "select",
        "id, userid, thresholdid, note",
        "from euserthreshold",
        "where ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "thresholdid",property = "threshold",
                one = @One(select = "com.iot.mapper.EthresholdMapper.selectVByPrimaryKey"))
    })
    List<Euserthresholdv> selectVBySql(@Param("sql") String sql);

    @Select({
        "select",
        "id, userid, thresholdid, note",
        "from euserthreshold",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "thresholdid",property = "threshold",
                one = @One(select = "com.iot.mapper.EthresholdMapper.selectVByPrimaryKey"))
    })
    Euserthresholdv selectVByPrimaryKey(Integer id);

    @Select({
        "select",
        "euserthreshold.id id, euserthreshold.userid userid, euserthreshold.thresholdid thresholdid, euserthreshold.note note",
        "from euserthreshold, euser",
        "where euserthreshold.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Euserthreshold> selectSubAll(Integer projectid);

    @Select({
        "select",
        "euserthreshold.id id, euserthreshold.userid userid, euserthreshold.thresholdid thresholdid, euserthreshold.note note",
        "from euserthreshold, euser",
        "where euserthreshold.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Euserthreshold> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
        "select",
        "euserthreshold.id id, euserthreshold.userid userid, euserthreshold.thresholdid thresholdid, euserthreshold.note note",
        "from euserthreshold, euser",
        "where euserthreshold.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER} and euserthreshold.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Euserthreshold selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
        "select",
        "euserthreshold.id id, euserthreshold.userid userid, euserthreshold.thresholdid thresholdid, euserthreshold.note note",
        "from euserthreshold, euser",
        "where euserthreshold.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "thresholdid",property = "threshold",
                one = @One(select = "com.iot.mapper.EthresholdMapper.selectVByPrimaryKey"))
    })
    List<Euserthresholdv> selectSubVAll(Integer projectid);

    @Select({
        "select",
        "euserthreshold.id id, euserthreshold.userid userid, euserthreshold.thresholdid thresholdid, euserthreshold.note note",
        "from euserthreshold, euser",
        "where euserthreshold.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER} and ${sql}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "thresholdid",property = "threshold",
                one = @One(select = "com.iot.mapper.EthresholdMapper.selectVByPrimaryKey"))
    })
    List<Euserthresholdv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
        "select",
        "euserthreshold.id id, euserthreshold.userid userid, euserthreshold.thresholdid thresholdid, euserthreshold.note note",
        "from euserthreshold, euser",
        "where euserthreshold.userid = euser.id and euser.projectid = #{projectid,jdbcType=INTEGER} and euserthreshold.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="thresholdid", property="thresholdid", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column = "userid",property = "user",
                one = @One(select = "com.iot.mapper.EuserMapper.selectVByPrimaryKey")),
        @Result(column = "thresholdid",property = "threshold",
                one = @One(select = "com.iot.mapper.EthresholdMapper.selectVByPrimaryKey"))
    })
    Euserthresholdv selectSubVByPrimaryKey(Integer projectid, Integer id);

    @Delete({
        "delete from euserthreshold",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into euserthreshold (id, userid, ",
        "thresholdid, note)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{thresholdid,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Euserthreshold record);

    @Update({
        "update euserthreshold",
        "set userid = #{userid,jdbcType=INTEGER},",
        "thresholdid = #{thresholdid,jdbcType=INTEGER},",
        "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Euserthreshold record);
}