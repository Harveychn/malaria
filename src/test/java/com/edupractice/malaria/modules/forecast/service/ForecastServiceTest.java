package com.edupractice.malaria.modules.forecast.service;

import com.edupractice.malaria.modules.analyzeDisease.service.ClusterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ForecastServiceTest {

    @Autowired
    private RegressionService regressionService;

    @Test
    public void forecastTest() throws Exception {
        List<List<Integer>> listList = regressionService.regressionDataSet("云南");
        regressionService.javaPython(listList);

        List<List<Double>> data = regressionService.getAxisByEquation(regressionService.javaPython(listList));
    }
}
