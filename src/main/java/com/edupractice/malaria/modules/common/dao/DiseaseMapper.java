package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.Disease;
import com.edupractice.malaria.modules.common.pojo.DiseaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseMapper {
    int countByExample(DiseaseExample example);

    int deleteByExample(DiseaseExample example);

    int deleteByPrimaryKey(Integer diseaseId);

    int insert(Disease record);

    int insertSelective(Disease record);

    List<Disease> selectByExample(DiseaseExample example);

    Disease selectByPrimaryKey(Integer diseaseId);

    int updateByExampleSelective(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByExample(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByPrimaryKeySelective(Disease record);

    int updateByPrimaryKey(Disease record);
}