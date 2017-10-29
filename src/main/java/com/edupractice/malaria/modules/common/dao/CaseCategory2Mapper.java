package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.CaseCategory2;
import com.edupractice.malaria.modules.common.pojo.CaseCategory2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseCategory2Mapper {
    int countByExample(CaseCategory2Example example);

    int deleteByExample(CaseCategory2Example example);

    int deleteByPrimaryKey(Integer categoryId2);

    int insert(CaseCategory2 record);

    int insertSelective(CaseCategory2 record);

    List<CaseCategory2> selectByExample(CaseCategory2Example example);

    CaseCategory2 selectByPrimaryKey(Integer categoryId2);

    int updateByExampleSelective(@Param("record") CaseCategory2 record, @Param("example") CaseCategory2Example example);

    int updateByExample(@Param("record") CaseCategory2 record, @Param("example") CaseCategory2Example example);

    int updateByPrimaryKeySelective(CaseCategory2 record);

    int updateByPrimaryKey(CaseCategory2 record);
}