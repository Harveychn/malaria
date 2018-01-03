package com.edupractice.malaria.modules.analyzeDisease.service;

import com.edupractice.malaria.modules.analyzeDisease.pojo.DynamicOutbreakRe;
import com.edupractice.malaria.modules.analyzeDisease.pojo.DynamicOutbreakVo;

import java.util.List;

public interface DynamicOutbreakService {
    List<DynamicOutbreakRe> findAddressList(DynamicOutbreakVo dynamicOutbreakVo) throws Exception;
}
