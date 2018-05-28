package com.edupractice.malaria.modules.forecast.controller;

import com.edupractice.malaria.modules.analyzeDisease.pojo.SexChart;
import com.edupractice.malaria.modules.analyzeDisease.service.AnalyzeService;
import com.edupractice.malaria.modules.forecast.pojo.ForecastChart;
import com.edupractice.malaria.modules.forecast.service.RegressionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/forecast")
public class ForecastController {
    @Resource
    private RegressionService regressionService;

    @RequestMapping("/forecastView")
    public ModelAndView analyzeView() throws Exception {
        return new ModelAndView("forecast");
    }

    @RequestMapping("/forecastChart")
    public
    @ResponseBody
    ForecastChart forecastChart(String dataSource) throws Exception {
        System.out.println(dataSource);
        ForecastChart forecastChart = new ForecastChart();
        double[][][] dataSet = regressionService.regressionEChartsDataSet(dataSource);
        double[][] theta = regressionService.OLS(dataSet);
        double[][][] forecastDataSet = regressionService.forecastDataSet(theta);
        forecastChart.setDataSet(dataSet);
        forecastChart.setTheta(theta);
        forecastChart.setForecastDataSet(forecastDataSet);
        return forecastChart;
    }
}
