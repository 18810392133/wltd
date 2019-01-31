package com.iot.mapper;

import com.iot.bean.Ebim;
import com.iot.bean.Ebimv;
import com.iot.bean.Esensor;
import com.iot.bean.Esensorv;
import com.iot.util.RedisCache;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface EsensorMapper {
    @Select({
            "select",
            "id, item, bimid, protocol, timer, status, note",
            "from esensor"
    })
    List<Esensor> selectAll();

    @Select({
            "select",
            "id, item, bimid, protocol, timer, status, note",
            "from esensor",
            "where ${sql}"
    })
    List<Esensor> selectBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, bimid, protocol, timer, status, note",
            "from esensor",
            "where id = #{id}"
    })
    Esensor selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, item, bimid, protocol, timer, status, note",
            "from esensor"
    })
    @Results({
            @Result(column="bimid", property="bimid"),
            @Result(column = "bimid", property = "bim",
                    one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    List<Esensorv> selectVAll();

    @Select({
            "select",
            "id, item, bimid, protocol, timer, status, note",
            "from esensor",
            "where ${sql}"
    })
    @Results({
            @Result(column="bimid", property="bimid"),
            @Result(column = "bimid", property = "bim",
                    one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    List<Esensorv> selectVBySql(@Param("sql") String sql);

    @Select({
            "select",
            "id, item, bimid, protocol, timer, status, note",
            "from esensor",
            "where id = #{id}"
    })
    @Results({
            @Result(column="bimid", property="bimid"),
            @Result(column = "bimid", property = "bim",
                    one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    Esensorv selectVByPrimaryKey(Integer id);

    @Select({
            "select",
            "esensor.id id, esensor.item item, esensor.bimid bimid, esensor.protocol protocol, esensor.timer timer, esensor.status status, esensor.note note",
            "from esensor, ebim, eplat",
            "where esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid}"
    })
    List<Esensor> selectSubAll(Integer projectid);

    @Select({
            "select",
            "esensor.id id, esensor.item item, esensor.bimid bimid, esensor.protocol protocol, esensor.timer timer, esensor.status status, esensor.note note",
            "from esensor, ebim, eplat",
            "where esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid} and ${sql}"
    })
    List<Esensor> selectSubBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "esensor.id id, esensor.item item, esensor.bimid bimid, esensor.protocol protocol, esensor.timer timer, esensor.status status, esensor.note note",
            "from esensor, ebim, eplat",
            "where esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid} and ebim.id = #{id}"
    })
    Esensor selectSubByPrimaryKey(Integer projectid, Integer id);

    @Select({
            "select",
            "esensor.id id, esensor.item item, esensor.bimid bimid, esensor.protocol protocol, esensor.timer timer, esensor.status status, esensor.note note",
            "from esensor, ebim, eplat",
            "where esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid}"
    })
    @Results({
            @Result(column="bimid", property="bimid"),
            @Result(column = "bimid", property = "bim",
                    one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    List<Esensorv> selectSubVAll(Integer projectid);

    @Select({
            "select",
            "esensor.id id, esensor.item item, esensor.bimid bimid, esensor.protocol protocol, esensor.timer timer, esensor.status status, esensor.note note",
            "from esensor, ebim, eplat",
            "where esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid} and ${sql}"
    })
    @Results({
            @Result(column="bimid", property="bimid"),
            @Result(column = "bimid", property = "bim",
                    one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    List<Esensorv> selectSubVBySql(Integer projectid, @Param("sql") String sql);

    @Select({
            "select",
            "esensor.id id, esensor.item item, esensor.bimid bimid, esensor.protocol protocol, esensor.timer timer, esensor.status status, esensor.note note",
            "from esensor, ebim, eplat",
            "where esensor.bimid = ebim.id and ebim.platid = eplat.id and eplat.projectid = #{projectid} and id = #{id}"
    })
    @Results({
            @Result(column="bimid", property="bimid"),
            @Result(column = "bimid", property = "bim",
                    one = @One(select = "com.iot.mapper.EbimMapper.selectVByPrimaryKey"))
    })
    Esensorv selectSubVByPrimaryKey(Integer projectid, Integer id);
    
    @Delete({
        "delete from esensor",
        "where id = #{id}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into esensor",
        "(id, item, bimid, protocol, timer, status, note)",
        "values (#{id}, #{item}, #{bimid}, #{protocol}, #{timer}, #{status}, #{note})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Esensor record);

    @Update({
        "update esensor",
        "set item = #{item},",
          "bimid = #{bimid},",
          "protocol = #{protocol},",
          "timer = #{timer},",
          "status = #{status},",
          "note = #{note}",
        "where id = #{id}"
    })
    int updateByPrimaryKey(Esensor record);
}