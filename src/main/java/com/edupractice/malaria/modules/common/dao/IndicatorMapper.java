package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.Indicator;
import com.edupractice.malaria.modules.common.pojo.IndicatorExample;
import com.edupractice.malaria.modules.common.pojo.IndicatorKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorMapper {
    int countByExample(IndicatorExample example);

    int deleteByExample(IndicatorExample example);

    int deleteByPrimaryKey(IndicatorKey key);

    int insert(Indicator record);

    int insertSelective(Indicator record);

    List<Indicator> selectByExample(IndicatorExample example);

    Indicator selectByPrimaryKey(IndicatorKey key);

    int updateByExampleSelective(@Param("record") Indicator record, @Param("example") IndicatorExample example);

    int updateByExample(@Param("record") Indicator record, @Param("example") IndicatorExample example);

    int updateByPrimaryKeySelective(Indicator record);

    int updateByPrimaryKey(Indicator record);
}