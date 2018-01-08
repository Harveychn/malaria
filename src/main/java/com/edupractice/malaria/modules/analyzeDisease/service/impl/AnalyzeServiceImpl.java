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
        List<SexAnalyzeRe> sexAnalyzeReList = analyzeMapper.analyzeBySex(dataSource);
        if (0 == sexAnalyzeReList.size()) {
            return null;
        }
        List<SexAnalyzeRe> diseaseC1 = new ArrayList<>();
        List<String> yearListC1 = new ArrayList<>();
        List<SexAnalyzeRe> diseaseC2 = new ArrayList<>();
        List<String> yearListC2 = new ArrayList<>();
        for (int count = 0; count < sexAnalyzeReList.size(); count++) {
            SexAnalyzeRe current = sexAnalyzeReList.get(count);
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
                SexAnalyzeRe current = diseaseC1.get(j);
                if (yearListC1.get(i).equals(Integer.toString(current.getYear()))) {
                    if (current.getSex().equals(sexList.get(0))) {
                        valueListC1.set(i * sexList.size(), current.getPatientNum());
                    }
                    if (current.getSex().equals(sexList.get(1))) {
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
                SexAnalyzeRe current = diseaseC2.get(j);
                if (yearListC2.get(i).equals(Integer.toString(current.getYear()))) {
                    if (current.getSex().equals(sexList.get(0))) {
                        valueListC2.set(i * sexList.size(), current.getPatientNum());
                        continue;
                    }
                    if (current.getSex().equals(sexList.get(1))) {
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
        List<CareerAnalyzeRe> careerAnalyzeReList = analyzeMapper.analyzeByCareer(dataSource);
        if (0 >= careerAnalyzeReList.size()) {
            return null;
        }
        List<CareerChart> careerChartList = new ArrayList<>();
        List<CareerAnalyzeRe> diseaseC1 = new ArrayList<>();
        List<CareerAnalyzeRe> diseaseC2 = new ArrayList<>();
        List<String> yearListC1 = new ArrayList<>();
        List<String> yearListC2 = new ArrayList<>();
        for (int i = 0; i < careerAnalyzeReList.size(); i++) {
            CareerAnalyzeRe current = careerAnalyzeReList.get(i);
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
                    careerCurrent.add(diseaseC1.get(j).getCareer());
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
                    careerCurrent.add(diseaseC2.get(j).getCareer());
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
        List<AgeGroupAnalyzeRe> ageGroupAnalyzeReList = analyzeMapper.analyzeByAgeGroup(dataSource);
        if (0 >= ageGroupAnalyzeReList.size()) {
            return null;
        }
        List<AgeGroupChart> ageGroupChartList = new ArrayList<>();
        List<AgeGroupAnalyzeRe> diseaseC1 = new ArrayList<>();
        List<AgeGroupAnalyzeRe> diseaseC2 = new ArrayList<>();
        List<String> yearListC1 = new ArrayList<>();
        List<String> yearListC2 = new ArrayList<>();
        for (int i = 0; i < ageGroupAnalyzeReList.size(); i++) {
            AgeGroupAnalyzeRe current = ageGroupAnalyzeReList.get(i);
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
                    ageGroupCurrent.add(diseaseC1.get(j).getAgeGroup());
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
                    ageGroupCurrent.add(diseaseC2.get(j).getAgeGroup());
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
//        List<Map<SexViewKey,Integer>> sexChartData = new ArrayList<>();
//        SexViewKey sexViewKey = null;
//        SexAnalyzeRe current = null;
//        Map<SexViewKey,Integer> sexViewKeyMap = null;
//        for (int index = 0; index < sexAnalyzeReList.size(); index++) {
//            sexViewKey = new SexViewKey();
//            current = sexAnalyzeReList.get(index);
//            sexViewKeyMap= new HashMap<>();
//            sexViewKey.setDisease(current.getDisease());
//            sexViewKey.setDataYear(Integer.toBinaryString(current.getYear()));
//            sexViewKey.setSex(current.getSex());
//            sexViewKeyMap.put(sexViewKey,current.getPatientNum());
//            sexChartData.add(index,sexViewKeyMap);
//        }
//        return sexChartData;


//        Map<String, List<CareerAnalyzeRe>> careerResultMap = new HashMap<>();
//        //此处已经去掉“不详”的职业类别数据
//        Set<String> diseaseNames = analyzeMapper.selectDisease();
//        for (String s : diseaseNames) {
//            analyzeVo.setDiseaseName(s);
////            careerAnalyzeReList = analyzeMapper.analyzeByCareer(analyzeVo);
////            careerResultMap.put(s, careerAnalyzeReList);
//        }
//        return careerResultMap;


//        List<Integer> ageGroupPop = new ArrayList<Integer>();
//        for (int i = 0; i < 10; i++) {
//            analyzeVo.setVirtualAgeDownLimit(i * 10);
//            ageGroupPop.add(i, analyzeMapper.analyzeByAgeGroup(analyzeVo));
//        }
//        AgeGroupAnalyzeRe ageGroupAnalyzeRe = new AgeGroupAnalyzeRe();
//        ageGroupAnalyzeRe.setAgeGroup0_9Pop(ageGroupPop.get(0));
//        ageGroupAnalyzeRe.setAgeGroup10_19Pop(ageGroupPop.get(1));
//        ageGroupAnalyzeRe.setAgeGroup20_29Pop(ageGroupPop.get(2));
//        ageGroupAnalyzeRe.setAgeGroup30_39Pop(ageGroupPop.get(3));
//        ageGroupAnalyzeRe.setAgeGroup40_49Pop(ageGroupPop.get(4));
//        ageGroupAnalyzeRe.setAgeGroup50_59Pop(ageGroupPop.get(5));
//        ageGroupAnalyzeRe.setAgeGroup60_69Pop(ageGroupPop.get(6));
//        ageGroupAnalyzeRe.setAgeGroup70_79Pop(ageGroupPop.get(7));
//        ageGroupAnalyzeRe.setAgeGroup80_89Pop(ageGroupPop.get(8));
//        ageGroupAnalyzeRe.setAgeGroup90_99Pop(ageGroupPop.get(9));
//        return ageGroupAnalyzeRe;