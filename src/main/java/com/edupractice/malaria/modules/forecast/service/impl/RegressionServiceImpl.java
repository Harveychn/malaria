package com.edupractice.malaria.modules.forecast.service.impl;

import com.edupractice.malaria.modules.forecast.dao.ForecastMapper;
import com.edupractice.malaria.modules.forecast.pojo.ForecastRe;
import com.edupractice.malaria.modules.forecast.service.RegressionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegressionServiceImpl implements RegressionService {
    @Resource
    private ForecastMapper forecastMapper;

    @Override
    public List<List<Integer>> regressionDataSet(String dataSource) throws Exception {
        List<ForecastRe> forecastReList = forecastMapper.forecastPatientNum(dataSource);
        if (0 == forecastReList.size()) {
            return null;
        }
        List<Integer> xAxisList0 = new ArrayList<>();
        List<Integer> yAxisList0 = new ArrayList<>();
        List<Integer> xAxisList1 = new ArrayList<>();
        List<Integer> yAxisList1 = new ArrayList<>();

        for (ForecastRe current : forecastReList) {
            if ("恶性疟".equals(current.getDisease())) {
                xAxisList0.add(Integer.parseInt(current.getYear()));
                yAxisList0.add(current.getPatientNum());
            } else if ("间日疟".equals(current.getDisease())) {
                xAxisList1.add(Integer.parseInt(current.getYear()));
                yAxisList1.add(current.getPatientNum());
            }

        }
        List<List<Integer>> dataSet = new ArrayList<>();
        dataSet.add(xAxisList0);
        dataSet.add(yAxisList0);
        dataSet.add(xAxisList1);
        dataSet.add(yAxisList1);

        return dataSet;
    }

    // Linear Regression Algorithm
    // h = theta0 + theta1 * xParameter
    public List<Double> linearRegression(List<Integer> xAxis, List<Integer> yAxis) {
        //最大的迭代次数
        int maxIteration = 7000;

        double theta0 = 0.0;
        double theta1 = 0.0;
        int iteration = 1;
        List<Double> equation = new ArrayList<>();

        //learning rate
        double alpha = 0.001;
        double deviation = 1.0;
        double EPS = 0.0001;

        while ((deviation > EPS) && (iteration < maxIteration)) {
            deviation = 0.0f;
            //随机梯度下降
            for (int i = 0; i < xAxis.size(); i++) {
                theta0 = theta0 + alpha * (yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i)));
                theta1 = theta1 + alpha * (yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i))) * xAxis.get(i);
            }

//            //批量梯度下降
//            float sum0 = 0.0f;
//            float sum1 = 0.0f;
//            for (int i = 0; i < xAxis.size(); i++) {
//                sum0 += (yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i)));
//                sum1 += (yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i))) * xAxis.get(i);
//            }
//            theta0 = theta0 + alpha * sum0 / xAxis.size();
//            theta1 = theta1 + alpha * sum1 / xAxis.size();

            //误差计算
            for (int i = 0; i < xAxis.size(); i++) {
                deviation += Math.pow(yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i)), 2);
            }
            iteration++;
        }

        equation.add(0, theta0);
        equation.add(1, theta1);
        return equation;
    }

    //y的取值
    public double hypothesis(double theta0, double theta1, int xParameter) {
        return theta0 + theta1 * xParameter;
    }
}
