package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.MeteorologicalStation;
import com.edupractice.malaria.modules.common.pojo.MeteorologicalStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MeteorologicalStationMapper {
    int countByExample(MeteorologicalStationExample example);

    int deleteByExample(MeteorologicalStationExample example);

    int deleteByPrimaryKey(Integer stationId);

    int insert(MeteorologicalStation record);

    int insertSelective(MeteorologicalStation record);

    List<MeteorologicalStation> selectByExample(MeteorologicalStationExample example);

    MeteorologicalStation selectByPrimaryKey(Integer stationId);

    int updateByExampleSelective(@Param("record") MeteorologicalStation record, @Param("example") MeteorologicalStationExample example);

    int updateByExample(@Param("record") MeteorologicalStation record, @Param("example") MeteorologicalStationExample example);

    int updateByPrimaryKeySelective(MeteorologicalStation record);

    int updateByPrimaryKey(MeteorologicalStation record);
}