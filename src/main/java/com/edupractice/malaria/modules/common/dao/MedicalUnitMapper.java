package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.MedicalUnit;
import com.edupractice.malaria.modules.common.pojo.MedicalUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalUnitMapper {
    int countByExample(MedicalUnitExample example);

    int deleteByExample(MedicalUnitExample example);

    int deleteByPrimaryKey(Integer medicalUnitId);

    int insert(MedicalUnit record);

    int insertSelective(MedicalUnit record);

    List<MedicalUnit> selectByExample(MedicalUnitExample example);

    MedicalUnit selectByPrimaryKey(Integer medicalUnitId);

    int updateByExampleSelective(@Param("record") MedicalUnit record, @Param("example") MedicalUnitExample example);

    int updateByExample(@Param("record") MedicalUnit record, @Param("example") MedicalUnitExample example);

    int updateByPrimaryKeySelective(MedicalUnit record);

    int updateByPrimaryKey(MedicalUnit record);
}