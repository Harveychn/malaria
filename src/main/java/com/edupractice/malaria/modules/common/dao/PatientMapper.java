package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.Patient;
import com.edupractice.malaria.modules.common.pojo.PatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper {
    int countByExample(PatientExample example);

    int deleteByExample(PatientExample example);

    int deleteByPrimaryKey(Integer patientId);

    int insert(Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    Patient selectByPrimaryKey(Integer patientId);

    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}