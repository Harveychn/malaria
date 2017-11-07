package com.edupractice.malaria.modules.download.service;

import com.edupractice.malaria.modules.common.pojo.FourLevelLinkage;

import java.util.List;

public interface DistrictService {
    List<FourLevelLinkage> getProvinces() throws Exception;
    List<FourLevelLinkage> getCities(int upId) throws Exception;
    List<FourLevelLinkage> getCounties(int upId) throws  Exception;
    List<FourLevelLinkage> getVillages(int upId) throws Exception;
}
