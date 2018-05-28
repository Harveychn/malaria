package com.edupractice.malaria.modules.analyzeDisease.service.impl;

import com.edupractice.malaria.modules.analyzeDisease.dao.AnalyzeMapper;
import com.edupractice.malaria.modules.analyzeDisease.pojo.*;
import com.edupractice.malaria.modules.analyzeDisease.service.AnalyzeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyzeServiceImpl implements AnalyzeService {
    @Resource
    private AnalyzeMapper analyzeMapper;

    @Override
    public List<SexChart> analyzeBySex(String dataSource) throws Exception {
        List<AnalyzeRe> analyzeReList = analyzeMapper.analyzeBySex(dataSource);
        if (0 == analyzeReList.size()) {
            return null;
        }
        List<AnalyzeRe> diseaseC1 = new ArrayList<>();
        List<String> yearListC1 = new ArrayList<>();
        List<AnalyzeRe> diseaseC2 = new ArrayList<>();
        List<String> yearListC2 = new ArrayList<>();
        for (int count = 0; count < analyzeReList.size(); count++) {
            AnalyzeRe current = analyzeReList.get(count);
            if (current.getDisease().equals("恶性疟")) {
                diseaseC1.add(current);
                if (!yearListC1.contains(Integer.toString(current.getYear()))) {
                    yearListC1.add(Integer.toString(current.getYear()));
                }
            } else if (current.getDisease().equals("间日疟")) {
                diseaseC2.add(current);
                if (!yearListC2.contains(Integer.toString(current.getYear()))) {
                    yearListC2.add(Integer.toString(current.getYear()));
                }
            }
        }
        List<String> sexList = new ArrayList<>();
        sexList.add("男");
        sexList.add("女");

        List<Integer> valueListC1 = new ArrayList<>();
        for (int i = 0; i < yearListC1.size(); i++) {
            valueListC1.add(i * sexList.size(), 0);
            valueListC1.add(i * sexList.size() + 1, 0);//valueList数值清零
            for (int j = 0; j < diseaseC1.size(); j++) {
                AnalyzeRe current = diseaseC1.get(j);
                if (yearListC1.get(i).equals(Integer.toString(current.getYear()))) {
                    if (current.getAttitude().equals(sexList.get(0))) {
                        valueListC1.set(i * sexList.size(), current.getPatientNum());
                    }
                    if (current.getAttitude().equals(sexList.get(1))) {
                        valueListC1.set(i * sexList.size() + 1, current.getPatientNum());
                    }
                }//赋值对应年份患病男女数量
            }
        }
        SexChart sexChartC1 = new SexChart();
        sexChartC1.setDisease("恶性疟");
        sexChartC1.setSexList(sexList);
        sexChartC1.setYearList(yearListC1);
        sexChartC1.setValuesList(valueListC1);

        List<Integer> valueListC2 = new ArrayList<>();
        for (int i = 0; i < yearListC2.size(); i++) {
            valueListC2.add(i * sexList.size(), 0);
            valueListC2.add(i * sexList.size() + 1, 0);//valueList数值清零
            for (int j = 0; j < diseaseC2.size(); j++) {
                AnalyzeRe current = diseaseC2.get(j);
                if (yearListC2.get(i).equals(Integer.toString(current.getYear()))) {
                    if (current.getAttitude().equals(sexList.get(0))) {
                        valueListC2.set(i * sexList.size(), current.getPatientNum());
                        continue;
                    }
                    if (current.getAttitude().equals(sexList.get(1))) {
                        valueListC2.set(i * sexList.size() + 1, current.getPatientNum());
                    }
                }//赋值对应年份患病男女数量
            }
        }
        SexChart sexChartC2 = new SexChart();
        sexChartC2.setDisease("间日疟");
        sexChartC2.setSexList(sexList);
        sexChartC2.setYearList(yearListC2);
        sexChartC2.setValuesList(valueListC2);

        List<SexChart> sexChartList = new ArrayList<>();
        sexChartList.add(0, sexChartC1);
        sexChartList.add(1, sexChartC2);
        return sexChartList;
    }

    @Override
    public List<CareerChart> analyzeByCareer(String dataSource) throws Exception {
        List<AnalyzeRe> careerAnalyzeReList = analyzeMapper.analyzeByCareer(dataSource);
        if (0 >= careerAnalyzeReList.size()) {
            return null;
        }
        List<CareerChart> careerChartList = new ArrayList<>();
        List<AnalyzeRe> diseaseC1 = new ArrayList<>();
        List<AnalyzeRe> diseaseC2 = new ArrayList<>();
        List<String> yearListC1 = new ArrayList<>();
        List<String> yearListC2 = new ArrayList<>();
        for (int i = 0; i < careerAnalyzeReList.size(); i++) {
            AnalyzeRe current = careerAnalyzeReList.get(i);
            if ("恶性疟".equals(current.getDisease().trim())) {
                diseaseC1.add(current);
                if (!yearListC1.contains(Integer.toString(current.getYear()))) {
                    yearListC1.add(Integer.toString(current.getYear()));
                }
            }
            if ("间日疟".equals(current.getDisease().trim())) {
                diseaseC2.add(current);
                if (!yearListC2.contains(Integer.toString(current.getYear()))) {
                    yearListC2.add(Integer.toString(current.getYear()));
                }
            }
        }
        List<List> valueList_1 = new ArrayList<>();
        List<List> careerList_1 = new ArrayList<>();
        for (int i = 0; i < yearListC1.size(); i++) {
            List<String> careerCurrent = new ArrayList<>();
            List<Integer> valueCurrent = new ArrayList<>();
            for (int j = 0; j < diseaseC1.size(); j++) {
                if (yearListC1.get(i).equals(Integer.toString(diseaseC1.get(j).getYear()))) {
                    valueCurrent.add(diseaseC1.get(j).getPatientNum());
                    careerCurrent.add(diseaseC1.get(j).getAttitude());
                }
            }
            careerList_1.add(careerCurrent);
            valueList_1.add(valueCurrent);
        }
        CareerChart careerChartC1 = new CareerChart();
        careerChartC1.setDisease("恶性疟");
        careerChartC1.setYearList(yearListC1);
        careerChartC1.setValuesList(valueList_1);
        careerChartC1.setCareerList(careerList_1);
        careerChartList.add(careerChartC1);

        List<List> valueList_2 = new ArrayList<>();
        List<List> careerList_2 = new ArrayList<>();
        for (int i = 0; i < yearListC2.size(); i++) {
            List<String> careerCurrent = new ArrayList<>();
            List<Integer> valueCurrent = new ArrayList<>();
            for (int j = 0; j < diseaseC2.size(); j++) {
                if (yearListC2.get(i).equals(Integer.toString(diseaseC2.get(j).getYear()))) {
                    careerCurrent.add(diseaseC2.get(j).getAttitude());
                    valueCurrent.add(diseaseC2.get(j).getPatientNum());
                    continue;
                }
            }
            valueList_2.add(valueCurrent);
            careerList_2.add(careerCurrent);
        }
        CareerChart careerChartC2 = new CareerChart();
        careerChartC2.setDisease("间日疟");
        careerChartC2.setYearList(yearListC2);
        careerChartC2.setValuesList(valueList_2);
        careerChartC2.setCareerList(careerList_2);
        careerChartList.add(careerChartC2);
        return careerChartList;
    }

    @Override
    public List<AgeGroupChart> analyzeByAgeGroup(String dataSource) throws Exception {
        List<AnalyzeRe> ageGroupAnalyzeReList = analyzeMapper.analyzeByAgeGroup(dataSource);
        if (0 >= ageGroupAnalyzeReList.size()) {
            return null;
        }
        List<AgeGroupChart> ageGroupChartList = new ArrayList<>();
        List<AnalyzeRe> diseaseC1 = new ArrayList<>();
        List<AnalyzeRe> diseaseC2 = new ArrayList<>();
        List<String> yearListC1 = new ArrayList<>();
        List<String> yearListC2 = new ArrayList<>();
        for (int i = 0; i < ageGroupAnalyzeReList.size(); i++) {
            AnalyzeRe current = ageGroupAnalyzeReList.get(i);
            if ("恶性疟".equals(current.getDisease().trim())) {
                diseaseC1.add(current);
                if (!yearListC1.contains(Integer.toString(current.getYear()))) {
                    yearListC1.add(Integer.toString(current.getYear()));
                }
            }
            if ("间日疟".equals(current.getDisease().trim())) {
                diseaseC2.add(current);
                if (!yearListC2.contains(Integer.toString(current.getYear()))) {
                    yearListC2.add(Integer.toString(current.getYear()));
                }
            }
        }
        List<List> valueList_1 = new ArrayList<>();
        List<List> ageGroupList_1 = new ArrayList<>();
        for (int i = 0; i < yearListC1.size(); i++) {
            List<String> ageGroupCurrent = new ArrayList<>();
            List<Integer> valueCurrent = new ArrayList<>();
            for (int j = 0; j < diseaseC1.size(); j++) {
                if (yearListC1.get(i).equals(Integer.toString(diseaseC1.get(j).getYear()))) {
                    valueCurrent.add(diseaseC1.get(j).getPatientNum());
                    ageGroupCurrent.add(diseaseC1.get(j).getAttitude());
                }
            }
            ageGroupList_1.add(ageGroupCurrent);
            valueList_1.add(valueCurrent);
        }
        AgeGroupChart ageGroupChartC1 = new AgeGroupChart();
        ageGroupChartC1.setDisease("恶性疟");
        ageGroupChartC1.setYearList(yearListC1);
        ageGroupChartC1.setValuesList(valueList_1);
        ageGroupChartC1.setAgeGroupList(ageGroupList_1);
        ageGroupChartList.add(ageGroupChartC1);

        List<List> valueList_2 = new ArrayList<>();
        List<List> ageGroupList_2 = new ArrayList<>();
        for (int i = 0; i < yearListC2.size(); i++) {
            List<String> ageGroupCurrent = new ArrayList<>();
            List<Integer> valueCurrent = new ArrayList<>();
            for (int j = 0; j < diseaseC2.size(); j++) {
                if (yearListC2.get(i).equals(Integer.toString(diseaseC2.get(j).getYear()))) {
                    ageGroupCurrent.add(diseaseC2.get(j).getAttitude());
                    valueCurrent.add(diseaseC2.get(j).getPatientNum());
                    continue;
                }
            }
            valueList_2.add(valueCurrent);
            ageGroupList_2.add(ageGroupCurrent);
        }
        AgeGroupChart ageGroupChartC2 = new AgeGroupChart();
        ageGroupChartC2.setDisease("间日疟");
        ageGroupChartC2.setYearList(yearListC2);
        ageGroupChartC2.setValuesList(valueList_2);
        ageGroupChartC2.setAgeGroupList(ageGroupList_2);
        ageGroupChartList.add(ageGroupChartC2);
        return ageGroupChartList;
    }

}