package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.FourLevelLinkage;
import com.edupractice.malaria.modules.common.pojo.FourLevelLinkageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FourLevelLinkageMapper {
    int countByExample(FourLevelLinkageExample example);

    int deleteByExample(FourLevelLinkageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FourLevelLinkage record);

    int insertSelective(FourLevelLinkage record);

    List<FourLevelLinkage> selectByExample(FourLevelLinkageExample example);

    FourLevelLinkage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FourLevelLinkage record, @Param("example") FourLevelLinkageExample example);

    int updateByExample(@Param("record") FourLevelLinkage record, @Param("example") FourLevelLinkageExample example);

    int updateByPrimaryKeySelective(FourLevelLinkage record);

    int updateByPrimaryKey(FourLevelLinkage record);
}