package com.edupractice.malaria.modules.analyzeDisease.service.impl;

import com.edupractice.malaria.modules.analyzeDisease.dao.AnalyzeMapper;
import com.edupractice.malaria.modules.analyzeDisease.dao.ClusterMapper;
import com.edupractice.malaria.modules.analyzeDisease.pojo.AgeCluster;
import com.edupractice.malaria.modules.analyzeDisease.pojo.CareerAnalyzeRe;
import com.edupractice.malaria.modules.analyzeDisease.pojo.CareerCluster;
import com.edupractice.malaria.modules.analyzeDisease.pojo.CareerClusterProv;
import com.edupractice.malaria.modules.analyzeDisease.service.ClusterService;
import com.edupractice.malaria.modules.common.pojo.FourLevelLinkage;
import com.edupractice.malaria.modules.download.dao.DistrictInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClusterServiceImpl implements ClusterService {
    @Resource
    private AnalyzeMapper analyzeMapper;
    @Resource
    private DistrictInfoMapper districtInfoMapper;
    @Resource
    private ClusterMapper clusterMapper;

    @Override
    public List<CareerCluster> clusterByCareer() throws Exception {
        //所有省份信息
        List<FourLevelLinkage> provinces = districtInfoMapper.selectProvinces();
        //所有职业信息
        List<String> careers = clusterMapper.getAllCareer();
        //恶性疟所有年份
        List<String> yearList1 = clusterMapper.getAllYear("恶性疟");
        //间日疟所有年份
        List<String> yearList2 = clusterMapper.getAllYear("间日疟");

        List<List<String>> yearList = new ArrayList<>();
        yearList.add(yearList1);
        yearList.add(yearList2);

        CareerCluster careerCluster1 = new CareerCluster();
        CareerCluster careerCluster2 = new CareerCluster();

        careerCluster1.setDiseaseName("恶性疟");
        careerCluster1.setYearList(yearList1);

        careerCluster2.setDiseaseName("间日疟");
        careerCluster2.setYearList(yearList2);

        List<CareerCluster> careerClusterList = new ArrayList<>();

        //初始化
        for (int i = 0; i < 2; i++) {
            CareerCluster careerCluster = new CareerCluster();
            List<List<CareerClusterProv>> careerClusterProvs = new ArrayList<>();
            for (int j = 0; j < yearList.get(i).size(); j++) {
                List<CareerClusterProv> provs = new ArrayList<>();
                for (int k = 0; k < provinces.size(); k++) {
                    CareerClusterProv temp = new CareerClusterProv();
                    temp.setCareerValue(initCareerValue(careers));
                    temp.setProvince(provinces.get(k).getName());
                    provs.add(temp);
                }
                careerClusterProvs.add(provs);
            }
            careerCluster.setCareerClusterProvList(careerClusterProvs);
            careerCluster.setYearList(yearList1);

            if (i == 0) {
                careerCluster.setDiseaseName("恶性疟");
            } else if (i == 1) {
                careerCluster.setDiseaseName("间日疟");
            }
            careerClusterList.add(careerCluster);
        }


        for (int i = 0; i < provinces.size(); i++) {
            List<CareerAnalyzeRe> careerAnalyzeReList = analyzeMapper.analyzeByCareer(provinces.get(i).getName());

            if (careerAnalyzeReList.size() == 0) {
                return null;
            }
            for (int j = 0; j < careerAnalyzeReList.size(); j++) {
                CareerAnalyzeRe current = careerAnalyzeReList.get(j);
                if ("恶性疟".equals(current.getDisease())) {
                    for (int k = 0; k < yearList.get(0).size(); k++) {
                        if (yearList.get(0).get(k).equals(Integer.toString(current.getYear()))) {
                            careerClusterList.get(0).getCareerClusterProvList().get(k).get(i).getCareerValue().put(current.getCareer(), current.getPatientNum());
                            break;
                        }
                    }
                } else if ("间日疟".equals(current.getDisease())) {
                    for (int k = 0; k < yearList.get(1).size(); k++) {
                        if (yearList.get(1).get(k).equals(Integer.toString(current.getYear()))) {
                            careerClusterList.get(1).getCareerClusterProvList().get(k).get(i).getCareerValue().put(current.getCareer(), current.getPatientNum());
                            break;
                        }
                    }
                }
            }
            System.out.println(careerClusterList);
        }
        return careerClusterList;
    }
/*
    public List<CareerCluster> clusterByCareer() throws Exception {
        //获取所有省份
        List<FourLevelLinkage> provinces = districtInfoMapper.selectProvinces();

        List<String> yearList1 = clusterMapper.getAllYear("间日疟");
        List<String> yearList2 = clusterMapper.getAllYear("恶性疟");

        List<List<CareerClusterProv>> careerClusterProvsList1 = new ArrayList<>();
        List<List<CareerClusterProv>> careerClusterProvsList2 = new ArrayList<>();

        List<CareerClusterProv> careerClusterProvs1 = new ArrayList<>();
        List<CareerClusterProv> careerClusterProvs2 = new ArrayList<>();

        for (int i = 0; i < provinces.size(); i++) {
            List<CareerAnalyzeRe> careerAnalyzeReList = analyzeMapper.analyzeByCareer(provinces.get(i).getName());
            if (careerAnalyzeReList.size() == 0) {
                return null;
            }
            CareerClusterProv careerClusterProv1 = new CareerClusterProv();
            CareerClusterProv careerClusterProv2 = new CareerClusterProv();

            careerClusterProv1.setProvince(provinces.get(i).getName());
            careerClusterProv1.setCareerValue(initCareerValue(clusterMapper.getAllCareer()));
            careerClusterProv2.setProvince(provinces.get(i).getName());
            careerClusterProv2.setCareerValue(initCareerValue(clusterMapper.getAllCareer()));

            for (int count = 0; count < careerAnalyzeReList.size(); count++) {
                CareerAnalyzeRe current = careerAnalyzeReList.get(count);

                if (current.getDisease().equals("间日疟")) {
                    for (int j = 0; j < yearList1.size(); j++) {
                        if (yearList1.get(j).equals(current.getYear())) {
                            careerClusterProvsList1.get(j).get(i).getCareerValue().put(current.getCareer(), current.getPatientNum());
                        }
                    }
                } else if (current.getDisease().equals("恶性疟")) {
                    for (int j = 0; j < yearList2.size(); j++) {
                        if (yearList2.get(j).equals(current.getYear())) {
                            careerClusterProvs2.get(i).getCareerValue().put(current.getCareer(), current.getPatientNum());
                        }
                    }
                }
            }
            careerClusterProvs1.add(careerClusterProv1);
            careerClusterProvs2.add(careerClusterProv2);
        }
        careerClusterProvsList1.add(careerClusterProvs1);
        careerClusterProvsList2.add(careerClusterProvs2);

        CareerCluster careerCluster1 = new CareerCluster();
        careerCluster1.setDiseaseName("间日疟");
        careerCluster1.setYearList(yearList1);
        careerCluster1.setCareerClusterProvList(careerClusterProvsList1);

        CareerCluster careerCluster2 = new CareerCluster();
        careerCluster2.setDiseaseName("恶性疟");
        careerCluster2.setYearList(yearList2);


        careerCluster2.setCareerClusterProvList(careerClusterProvsList2);

        List<CareerCluster> careerClusterList = new ArrayList<>();
        careerClusterList.add(0, careerCluster1);
        careerClusterList.add(1, careerCluster2);

        return careerClusterList;
    }
*/

    @Override
    public List<AgeCluster> clusterByAge() throws Exception {
        return null;
    }

    private Map<String, Integer> initCareerValue(List<String> careerList) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < careerList.size(); i++) {
            stringIntegerMap.put(careerList.get(i), 0);
        }
        return stringIntegerMap;
    }
}