package com.edupractice.malaria.modules.download.service.impl;

import com.edupractice.malaria.modules.common.pojo.FourLevelLinkage;
import com.edupractice.malaria.modules.download.dao.DistrictInfoMapper;
import com.edupractice.malaria.modules.download.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Resource
    private DistrictInfoMapper districtInfoMapper;

    public List<FourLevelLinkage> getProvinces() throws Exception {
        return districtInfoMapper.selectProvinces();
    }

    public List<FourLevelLinkage> getCities(int upId) throws Exception {
        return districtInfoMapper.selectCities(upId);
    }

    public List<FourLevelLinkage> getCounties(int upId) throws Exception {
        return districtInfoMapper.selectCounties(upId);
    }

    public List<FourLevelLinkage> getVillages(int upId) throws Exception {
        return districtInfoMapper.selectVillages(upId);
    }
}
