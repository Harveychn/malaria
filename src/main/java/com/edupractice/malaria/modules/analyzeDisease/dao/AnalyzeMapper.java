package com.edupractice.malaria.modules.analyzeDisease.dao;

import com.edupractice.malaria.modules.analyzeDisease.pojo.AgeGroupAnalyzeRe;
import com.edupractice.malaria.modules.analyzeDisease.pojo.CareerAnalyzeRe;
import com.edupractice.malaria.modules.analyzeDisease.pojo.SexAnalyzeRe;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public interface AnalyzeMapper {
    Set<String> selectDisease() throws Exception;

    List<SexAnalyzeRe> analyzeBySex(String dataSource) throws Exception;

    List<CareerAnalyzeRe> analyzeByCareer(String dataSource) throws Exception;

    List<AgeGroupAnalyzeRe> analyzeByAgeGroup(String dataSource) throws Exception;
}
