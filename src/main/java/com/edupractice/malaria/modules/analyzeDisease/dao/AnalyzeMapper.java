package com.edupractice.malaria.modules.analyzeDisease.dao;

import com.edupractice.malaria.modules.analyzeDisease.pojo.AnalyzeRe;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AnalyzeMapper {
    Set<String> selectDisease() throws Exception;

    List<AnalyzeRe> analyzeBySex(String dataSource) throws Exception;

    List<AnalyzeRe> analyzeByCareer(String dataSource) throws Exception;

    List<AnalyzeRe> analyzeByAgeGroup(String dataSource) throws Exception;
}
