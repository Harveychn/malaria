package com.edupractice.malaria.modules.download.service.impl;

import com.edupractice.malaria.modules.common.domain.FourLevelLinkage;
import com.edupractice.malaria.modules.download.mapper.DistrictInformationMapper;
import com.edupractice.malaria.modules.download.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * creator : jianeneng zhang
 * time : 17-10-16 15:15
 * function
 */
@Service
public class DistrictServiceImpl implements DistrictService{
   /* @Resource
    private DistrictInformationMapper districtInformationMapper;

    public List<FourLevelLinkage> getProvinces() throws Exception {
        return districtInformationMapper.selectProvinces();
    }

    public List<FourLevelLinkage> getCities(int upId) throws Exception {
        return districtInformationMapper.selectCities(upId);
    }

    public List<FourLevelLinkage> getCounties(int upId) throws Exception {
        return districtInformationMapper.selectCounties(upId);
    }

    public List<FourLevelLinkage> getVillages(int upId) throws Exception {
        return districtInformationMapper.selectVillages(upId);
    }*/
}
