package com.edupractice.malaria.modules.forecast.service;

import com.edupractice.malaria.modules.forecast.pojo.ForecastChart;

public interface RegressionService {
    //List<Double> linearRegression(List<Integer> xAxis, List<Integer> yAxis);

    public double[][][] regressionEChartsDataSet(String dataSource) throws Exception;

    public double[][] OLS(double[][][] dataSet);

    // List<List<Integer>> regressionDataSet(String dataSource) throws Exception;

    // List<List<Double>> javaPython(List<List<Integer>> dataSet);

    double hypothesis(double theta0, double theta1, double xParameter);

    double[][][] forecastDataSet(double[][] hypothesis) throws Exception;
    // List<List<Double>> getAxisByEquation(List<List<Double>> equation) throws Exception;

}
