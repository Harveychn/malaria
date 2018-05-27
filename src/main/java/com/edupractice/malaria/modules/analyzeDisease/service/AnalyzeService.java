package com.edupractice.malaria.modules.analyzeDisease.service;

import com.edupractice.malaria.modules.analyzeDisease.pojo.AgeGroupChart;
import com.edupractice.malaria.modules.analyzeDisease.pojo.CareerChart;
import com.edupractice.malaria.modules.analyzeDisease.pojo.SexChart;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AnalyzeService {
    List<SexChart> analyzeBySex(String dataSource) throws Exception;

    List<CareerChart> analyzeByCareer(String dataSource) throws Exception;

    List<AgeGroupChart> analyzeByAgeGroup(String dataSource) throws Exception;
}
