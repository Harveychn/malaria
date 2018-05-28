package com.edupractice.malaria.modules.forecast.dao;

import com.edupractice.malaria.modules.forecast.pojo.ForecastRe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForecastMapper {
    List<ForecastRe> forecastPatientNum(String dataSource) throws Exception;
}
