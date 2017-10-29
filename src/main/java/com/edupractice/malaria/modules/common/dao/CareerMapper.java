package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.Career;
import com.edupractice.malaria.modules.common.pojo.CareerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerMapper {
    int countByExample(CareerExample example);

    int deleteByExample(CareerExample example);

    int deleteByPrimaryKey(Integer careerId);

    int insert(Career record);

    int insertSelective(Career record);

    List<Career> selectByExample(CareerExample example);

    Career selectByPrimaryKey(Integer careerId);

    int updateByExampleSelective(@Param("record") Career record, @Param("example") CareerExample example);

    int updateByExample(@Param("record") Career record, @Param("example") CareerExample example);

    int updateByPrimaryKeySelective(Career record);

    int updateByPrimaryKey(Career record);
}