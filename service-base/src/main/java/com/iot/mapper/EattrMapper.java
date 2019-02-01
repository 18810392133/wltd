package com.iot.mapper;

import com.iot.bean.Eattr;
import com.iot.bean.Eattrv;
import com.iot.util.RedisCache;
import org.apache.ibatis.annotations.*;
import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface EattrMapper {
    @Select({
            "select",
            "id, item, sensorid, protocol, type, unit, thresholdl, thresholdm, thresholdh, note",
            "from eattr"
    })
    List<Eattr> selectAll();

    @Select({
            "select",
            "id, item, sensorid, protocol, type, unit, thresholdl, thresholdm, thresholdh, note",
            "from eattr",
            "where ${sql}"
    })
    List<Eattr> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, sensorid, protocol, type, unit, thresholdl, thresholdm, thresholdh, note",
            "from eattr",
            "where id = #{id}"
    })
    Eattr selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, sensorid, protocol, type, unit, thresholdl, thresholdm, thresholdh, note",
            "from eattr"
    })
    @Results({
            @Result(column="sensorid", property="sensorid"),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    List<Eattrv> selectVAll();

    @Select({
            "select",
            "id, item, sensorid, protocol, type, unit, thresholdl, thresholdm, thresholdh, note",
            "from eattr",
            "where ${sql}"
    })
    @Results({
            @Result(column="sensorid", property="sensorid"),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    List<Eattrv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, sensorid, protocol, type, unit, thresholdl, thresholdm, thresholdh, note",
            "from eattr",
            "where id = #{id}"
    })
    @Results({
            @Result(column="sensorid", property="sensorid"),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    Eattrv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.type type, eattr.unit unit, eattr.thresholdl thresholdl, eattr.thresholdm thresholdm, eattr.thresholdh thresholdh, eattr.note note",
            "from eattr, esensor, ebim, eplat",
            "where eattr.sensorid = esensor.id and esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid}"
    })
    List<Eattr> selectSubAll(Integer projectid);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.type type, eattr.unit unit, eattr.thresholdl thresholdl, eattr.thresholdm thresholdm, eattr.thresholdh thresholdh, eattr.note note",
            "from eattr, esensor, ebim, eplat",
            "where eattr.sensorid = esensor.id and esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid} and ${sql}"
    })
    List<Eattr> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.type type, eattr.unit unit, eattr.thresholdl thresholdl, eattr.thresholdm thresholdm, eattr.thresholdh thresholdh, eattr.note note",
            "from eattr, esensor, ebim, eplat",
            "where eattr.sensorid = esensor.id and esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid} and eattr.id = #{id}"
    })
    Eattr selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.type type, eattr.unit unit, eattr.thresholdl thresholdl, eattr.thresholdm thresholdm, eattr.thresholdh thresholdh, eattr.note note",
            "from eattr, esensor, ebim, eplat",
            "where eattr.sensorid = esensor.id and esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid}"
    })
    @Results({
            @Result(column="sensorid", property="sensorid"),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    List<Eattrv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.type type, eattr.unit unit, eattr.thresholdl thresholdl, eattr.thresholdm thresholdm, eattr.thresholdh thresholdh, eattr.note note",
            "from eattr, esensor, ebim, eplat",
            "where eattr.sensorid = esensor.id and esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid} and ${sql}"
    })
    @Results({
            @Result(column="sensorid", property="sensorid"),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    List<Eattrv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "eattr.id id, eattr.item item, eattr.sensorid sensorid, eattr.protocol protocol, eattr.type type, eattr.unit unit, eattr.thresholdl thresholdl, eattr.thresholdm thresholdm, eattr.thresholdh thresholdh, eattr.note note",
            "from eattr, esensor, ebim, eplat",
            "where eattr.sensorid = esensor.id and esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid} and eattr.id = #{id}"
    })
    @Results({
            @Result(column="sensorid", property="sensorid"),
            @Result(column = "sensorid", property = "sensor",
                    one = @One(select = "com.iot.mapper.EsensorMapper.selectVByPrimaryKey"))
    })
    Eattrv selectSubVByPrimaryKey(Integer projectid, Integer id);

    @Delete({
        "delete from eattr",
        "where id = #{id}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eattr",
        "(id, item, sensorid, protocol, type, unit, thresholdl, thresholdm, thresholdh, note)",
        "values (#{id}, #{item}, #{sensorid}, #{protocol}, #{type}, #{unit}, #{thresholdl}, #{thresholdm}, #{thresholdh}, #{note})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Eattr record);

    @Update({
        "update eattr",
        "set item = #{item},",
          "sensorid = #{sensorid},",
          "protocol = #{protocol},",
          "type = #{type},",
          "unit = #{unit},",
          "thresholdl = #{thresholdl},",
          "thresholdm = #{thresholdm},",
          "thresholdh = #{thresholdh},",
          "note = #{noteR}",
        "where id = #{id}"
    })
    int updateByPrimaryKey(Eattr record);
}