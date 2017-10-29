package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.WeatherData;
import com.edupractice.malaria.modules.common.pojo.WeatherDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataMapper {
    int countByExample(WeatherDataExample example);

    int deleteByExample(WeatherDataExample example);

    int deleteByPrimaryKey(Integer weatherId);

    int insert(WeatherData record);

    int insertSelective(WeatherData record);

    List<WeatherData> selectByExample(WeatherDataExample example);

    WeatherData selectByPrimaryKey(Integer weatherId);

    int updateByExampleSelective(@Param("record") WeatherData record, @Param("example") WeatherDataExample example);

    int updateByExample(@Param("record") WeatherData record, @Param("example") WeatherDataExample example);

    int updateByPrimaryKeySelective(WeatherData record);

    int updateByPrimaryKey(WeatherData record);
}