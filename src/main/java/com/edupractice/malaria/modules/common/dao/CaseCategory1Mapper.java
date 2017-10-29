package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.CaseCategory1;
import com.edupractice.malaria.modules.common.pojo.CaseCategory1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseCategory1Mapper {
    int countByExample(CaseCategory1Example example);

    int deleteByExample(CaseCategory1Example example);

    int deleteByPrimaryKey(Integer categoryId1);

    int insert(CaseCategory1 record);

    int insertSelective(CaseCategory1 record);

    List<CaseCategory1> selectByExample(CaseCategory1Example example);

    CaseCategory1 selectByPrimaryKey(Integer categoryId1);

    int updateByExampleSelective(@Param("record") CaseCategory1 record, @Param("example") CaseCategory1Example example);

    int updateByExample(@Param("record") CaseCategory1 record, @Param("example") CaseCategory1Example example);

    int updateByPrimaryKeySelective(CaseCategory1 record);

    int updateByPrimaryKey(CaseCategory1 record);
}