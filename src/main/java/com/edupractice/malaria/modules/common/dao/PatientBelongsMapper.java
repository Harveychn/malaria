package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.PatientBelongs;
import com.edupractice.malaria.modules.common.pojo.PatientBelongsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientBelongsMapper {
    int countByExample(PatientBelongsExample example);

    int deleteByExample(PatientBelongsExample example);

    int deleteByPrimaryKey(Integer belongsId);

    int insert(PatientBelongs record);

    int insertSelective(PatientBelongs record);

    List<PatientBelongs> selectByExample(PatientBelongsExample example);

    PatientBelongs selectByPrimaryKey(Integer belongsId);

    int updateByExampleSelective(@Param("record") PatientBelongs record, @Param("example") PatientBelongsExample example);

    int updateByExample(@Param("record") PatientBelongs record, @Param("example") PatientBelongsExample example);

    int updateByPrimaryKeySelective(PatientBelongs record);

    int updateByPrimaryKey(PatientBelongs record);
}