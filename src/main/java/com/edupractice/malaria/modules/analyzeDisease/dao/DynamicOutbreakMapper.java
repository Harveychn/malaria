package com.edupractice.malaria.modules.analyzeDisease.dao;

import com.edupractice.malaria.modules.analyzeDisease.pojo.DynamicOutbreakRe;
import com.edupractice.malaria.modules.analyzeDisease.pojo.DynamicOutbreakVo;

import java.util.List;

public interface DynamicOutbreakMapper {
    /**
     * 动态爆发
     *
     * @param dynamicOutbreakVo 查询参数pojo
     * @return address，以及相同address的count
     * @throws Exception
     */
    List<DynamicOutbreakRe> selectAddressByYearMonth(DynamicOutbreakVo dynamicOutbreakVo) throws Exception;

}
