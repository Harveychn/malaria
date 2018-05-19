package com.edupractice.malaria.modules.forecast.service.impl;

import com.edupractice.malaria.modules.analyzeDisease.dao.ClusterMapper;
import com.edupractice.malaria.modules.forecast.dao.ForecastMapper;
import com.edupractice.malaria.modules.forecast.pojo.ForecastChart;
import com.edupractice.malaria.modules.forecast.pojo.ForecastRe;
import com.edupractice.malaria.modules.forecast.service.RegressionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegressionServiceImpl implements RegressionService {
    @Resource
    private ForecastMapper forecastMapper;
    @Resource
    private ClusterMapper clusterMapper;


    //DataSet封装
    public double[][][] regressionEChartsDataSet(String dataSource) throws Exception {
        //dataSet[0] 恶性疟, dataSet[1] 间日疟
        List<String> allYear = clusterMapper.getAllYear();
        double[][][] dataSet = new double[2][allYear.size()][2];
        List<ForecastRe> forecastReList = forecastMapper.forecastPatientNum(dataSource);
        if (0 == forecastReList.size()) {
            return null;
        }
        int index0 = 0;
        int index1 = 0;
        for (ForecastRe current : forecastReList) {
            if ("恶性疟".equals(current.getDisease())) {
                dataSet[0][index0][0] = Integer.parseInt(current.getYear());
                dataSet[0][index0][1] = current.getPatientNum();
                index0++;
            } else if ("间日疟".equals(current.getDisease())) {
                dataSet[1][index1][0] = Integer.parseInt(current.getYear());
                dataSet[1][index1][1] = current.getPatientNum();
                index1++;
            }
        }
        return dataSet;
    }

    //最小二乘法
    public double[][] OLS(double[][][] dataSet) {
        double[][] result = new double[2][2];
        for (int i = 0; i < dataSet.length; i++) {
            double sumX = 0;
            double sumY = 0;
            double sumXY = 0;
            double sumXX = 0;
            double len = dataSet[i].length;
            for (int j = 0; j < len; j++) {
                sumX += dataSet[i][j][0];
                sumY += dataSet[i][j][1];
                sumXY += dataSet[i][j][0] * dataSet[i][j][1];
                sumXX += dataSet[i][j][0] * dataSet[i][j][0];
            }
            result[i][0] = ((len * sumXY) - (sumX * sumY)) / ((len * sumXX) - (sumX * sumX));
            result[i][1] = (sumY / len) - ((result[i][0] * sumX) / len);
        }
        return result;
    }

    //预测数据
    public double[][][] forecastDataSet(double[][] hypothesis) throws Exception {
        List<String> allYear = clusterMapper.getAllYear();
        //dataSet[0] 恶性疟, dataSet[1] 间日疟
        int len = allYear.size() + 5;
        double[][][] dataSet = new double[2][len][2];
        for (int i = 0; i < len; i++) {
            dataSet[0][i][0] = 2005 + i;
            dataSet[1][i][0] = 2005 + i;
            dataSet[0][i][1] = hypothesis(hypothesis[0][0], hypothesis[0][1], dataSet[0][i][0]);
            dataSet[1][i][1] = hypothesis(hypothesis[1][0], hypothesis[1][1], dataSet[1][i][0]);
        }
        return dataSet;
    }

    //获取函数值
    public double hypothesis(double theta0, double theta1, double xParameter) {
        return theta1 + theta0 * xParameter;
    }
    //DataSet封装
//    public List<List<Integer>> regressionDataSet(String dataSource) throws Exception {
//        List<ForecastRe> forecastReList = forecastMapper.forecastPatientNum(dataSource);
//        if (0 == forecastReList.size()) {
//            return null;
//        }
//        List<Integer> xAxisList0 = new ArrayList<>();
//        List<Integer> yAxisList0 = new ArrayList<>();
//        List<Integer> xAxisList1 = new ArrayList<>();
//        List<Integer> yAxisList1 = new ArrayList<>();
//
//        for (ForecastRe current : forecastReList) {
//            if ("恶性疟".equals(current.getDisease())) {
//                xAxisList0.add(Integer.parseInt(current.getYear()));
//                yAxisList0.add(current.getPatientNum());
//            } else if ("间日疟".equals(current.getDisease())) {
//                xAxisList1.add(Integer.parseInt(current.getYear()));
//                yAxisList1.add(current.getPatientNum());
//            }
//
//        }
//        List<List<Integer>> dataSet = new ArrayList<>();
//        dataSet.add(xAxisList0);
//        dataSet.add(yAxisList0);
//        dataSet.add(xAxisList1);
//        dataSet.add(yAxisList1);
//
//        return dataSet;
//    }

    //   Linear Regression Algorithm
    //   h = theta0 + theta1 * xParameter
//    public List<Double> linearRegression(List<Integer> xAxis, List<Integer> yAxis) {
//        //最大的迭代次数
//        int maxIteration = 7000;
//
//        double theta0 = 0.0;
//        double theta1 = 0.0;
//        int iteration = 1;
//        List<Double> equation = new ArrayList<>();
//
//        //learning rate
//        double alpha = 0.001;
//        double deviation = 1.0;
//        double EPS = 0.0001;
//
//        while ((deviation > EPS) && (iteration < maxIteration)) {
//            deviation = 0.0f;
//            //随机梯度下降
//            for (int i = 0; i < xAxis.size(); i++) {
//                theta0 = theta0 + alpha * (yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i)));
//                theta1 = theta1 + alpha * (yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i))) * xAxis.get(i);
//            }
//
////            //批量梯度下降
////            float sum0 = 0.0f;
////            float sum1 = 0.0f;
////            for (int i = 0; i < xAxis.size(); i++) {
////                sum0 += (yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i)));
////                sum1 += (yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i))) * xAxis.get(i);
////            }
////            theta0 = theta0 + alpha * sum0 / xAxis.size();
////            theta1 = theta1 + alpha * sum1 / xAxis.size();
//
//            //误差计算
//            for (int i = 0; i < xAxis.size(); i++) {
//                deviation += Math.pow(yAxis.get(i) - hypothesis(theta0, theta1, xAxis.get(i)), 2);
//            }
//            iteration++;
//        }
//
//        equation.add(0, theta0);
//        equation.add(1, theta1);
//        return equation;
//    }


    //通过python获取线性回归的参数
//    public List<List<Double>> javaPython(List<List<Integer>> dataSet) {
//        List<List<Double>> equations = new ArrayList<>();
//        for (int i = 0; i < 3; ) {
//            List<Double> equation = new ArrayList<>();
//            String paramA = StringUtils.join(dataSet.get(i), ",");
//            String paramB = StringUtils.join(dataSet.get(i + 1), ",");
//            String[] arguments = new String[]{"D:\\Program\\Python36\\python.exe", "D:\\Workplace\\malaria\\src\\main\\java\\com\\edupractice\\malaria\\modules\\forecast\\linear.py", paramA, paramB};
//            try {
//                Process process = Runtime.getRuntime().exec(arguments);
//                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//                LineNumberReader input = new LineNumberReader(in);
//                //获取Python返回的参数
//                String line = input.readLine();
//                String[] temp = line.split(" ");
//                equation.add(Double.parseDouble(temp[0]));
//                equation.add(Double.parseDouble(temp[1]));
//                input.close();
//                in.close();
//                process.waitFor();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            equations.add(equation);
//            i += 2;
//        }
//        return equations;
//    }


//    public List<List<Double>> getAxisByEquation(List<List<Double>> equation) throws Exception {
//        List<List<Integer>> yearList = new ArrayList<>();
//        List<String> yearList1Temp = clusterMapper.getAllYearByDisease("间日疟");
//        List<String> yearList2Temp = clusterMapper.getAllYearByDisease("恶性疟");
//        List<Integer> yearList1 = yearList1Temp.stream().map(Integer::parseInt).collect(Collectors.toList());
//        List<Integer> yearList2 = yearList2Temp.stream().map(Integer::parseInt).collect(Collectors.toList());
//        yearList.add(yearList1);
//        yearList.add(yearList2);
//
//        List<Double> yAxis1 = new ArrayList<>();
//        List<Double> yAxis2 = new ArrayList<>();
//        List<List<Double>> yAxis = new ArrayList<>();
//        yAxis.add(yAxis1);
//        yAxis.add(yAxis2);
//        for (int i = 0; i < yearList.size(); i++) {
//            for (int j = 0; j < yearList.get(i).size(); j++) {
//                yAxis.get(i).add(hypothesis(equation.get(i).get(1), equation.get(i).get(0), yearList1.get(j)));
//            }
//        }
//        return yAxis;
//    }


}