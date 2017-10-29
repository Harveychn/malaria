package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.Doctor;
import com.edupractice.malaria.modules.common.pojo.DoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorMapper {
    int countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Integer doctorId);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(Integer doctorId);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
}