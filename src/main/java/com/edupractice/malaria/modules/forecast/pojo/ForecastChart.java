package com.edupractice.malaria.modules.forecast.pojo;

public class ForecastChart {
    double[][][] dataSet;
    double[][] theta;
    double[][][] forecastDataSet;

    public double[][][] getForecastDataSet() {
        return forecastDataSet;
    }

    public void setForecastDataSet(double[][][] forecastDataSet) {
        this.forecastDataSet = forecastDataSet;
    }

    public double[][][] getDataSet() {
        return dataSet;
    }

    public void setDataSet(double[][][] dataSet) {
        this.dataSet = dataSet;
    }

    public double[][] getTheta() {
        return theta;
    }

    public void setTheta(double[][] theta) {
        this.theta = theta;
    }
}
