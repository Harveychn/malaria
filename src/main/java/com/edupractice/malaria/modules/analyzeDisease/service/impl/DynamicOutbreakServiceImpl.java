package com.edupractice.malaria.modules.analyzeDisease.service.impl;

import com.edupractice.malaria.modules.analyzeDisease.dao.DynamicOutbreakMapper;
import com.edupractice.malaria.modules.analyzeDisease.pojo.DynamicOutbreakRe;
import com.edupractice.malaria.modules.analyzeDisease.pojo.DynamicOutbreakVo;
import com.edupractice.malaria.modules.analyzeDisease.service.DynamicOutbreakService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DynamicOutbreakServiceImpl implements DynamicOutbreakService{
    @Resource
    private DynamicOutbreakMapper dynamicOutbreakMapper;
    @Override
    public List<DynamicOutbreakRe> findAddressList(DynamicOutbreakVo dynamicOutbreakVo) throws Exception {
        return dynamicOutbreakMapper.selectAddressByYearMonth(dynamicOutbreakVo);
    }
}