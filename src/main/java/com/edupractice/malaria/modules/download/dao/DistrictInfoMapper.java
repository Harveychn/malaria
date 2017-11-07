package com.edupractice.malaria.modules.download.dao;

import com.edupractice.malaria.modules.common.pojo.FourLevelLinkage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictInfoMapper {
    List<FourLevelLinkage> selectProvinces() throws Exception;

    List<FourLevelLinkage> selectCities(@Param("upId") int upId) throws Exception;

    List<FourLevelLinkage> selectCounties(@Param("upId") int upId) throws Exception;

    List<FourLevelLinkage> selectVillages(@Param("upId") int upId) throws Exception;
}
