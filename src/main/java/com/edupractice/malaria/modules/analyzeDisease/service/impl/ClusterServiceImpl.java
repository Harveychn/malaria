package com.edupractice.malaria.modules.analyzeDisease.service.impl;

import com.edupractice.malaria.modules.analyzeDisease.dao.AnalyzeMapper;
import com.edupractice.malaria.modules.analyzeDisease.dao.ClusterMapper;
import com.edupractice.malaria.modules.analyzeDisease.pojo.*;
import com.edupractice.malaria.modules.analyzeDisease.service.ClusterService;
import com.edupractice.malaria.modules.common.pojo.FourLevelLinkage;
import com.edupractice.malaria.modules.download.dao.DistrictInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ClusterServiceImpl implements ClusterService {
    @Resource
    private AnalyzeMapper analyzeMapper;
    @Resource
    private DistrictInfoMapper districtInfoMapper;
    @Resource
    private ClusterMapper clusterMapper;

    @Override
    public List<Cluster> cluster(String type) throws Exception {

        //所有职业信息
        List<String> careers = clusterMapper.getAllCareer();
        //所有年龄区间
        List<String> ageGroup = Arrays.asList("0-9", "10-19", "20-29",
                "30-39", "40-49", "50-59", "60-69", "70-79", "80-89",
                "90-99", ">99");

        List<String> attitude = new ArrayList<>();
        if (type.equals("Career")) {
            attitude = careers;
        } else if (type.equals("AgeGroup")) {
            attitude = ageGroup;
        }

        //所有省份信息
        List<FourLevelLinkage> provinces = districtInfoMapper.selectProvinces();

        //恶性疟所有年份
        List<String> yearList1 = clusterMapper.getAllYear("恶性疟");
        //间日疟所有年份
        List<String> yearList2 = clusterMapper.getAllYear("间日疟");

        List<List<String>> yearList = new ArrayList<>();
        yearList.add(yearList1);
        yearList.add(yearList2);

        List<Cluster> clusterList = new ArrayList<>();

        //初始化
        //clusterList.get(0) 恶性疟
        //clusterList.get(1) 间日疟
        for (int i = 0; i < 2; i++) {
            Cluster cluster = new Cluster();
            List<List<ClusterProvince>> clusterProvinceLists = new ArrayList<>();
            for (int j = 0; j < yearList.get(i).size(); j++) {
                List<ClusterProvince> clusterProvinceList = new ArrayList<>();
                for (int k = 0; k < provinces.size(); k++) {
                    ClusterProvince clusterProvince = new ClusterProvince();
                    clusterProvince.setProvince(provinces.get(k).getName());
                    clusterProvince.setPatientNum(initMapValue(attitude));
                    clusterProvinceList.add(clusterProvince);
                }
                clusterProvinceLists.add(clusterProvinceList);
            }
            cluster.setYearList(yearList1);
            cluster.setClusterProvinceLists(clusterProvinceLists);
            if (i == 0) {
                cluster.setDiseaseName("恶性疟");
            } else if (i == 1) {
                cluster.setDiseaseName("间日疟");
            }
            clusterList.add(cluster);
        }

        for (int i = 0; i < provinces.size(); i++) {
            List<AnalyzeRe> analyzeReList = new ArrayList<>();
            if (type.equals("Career")) {
                analyzeReList = analyzeMapper.analyzeByCareer(provinces.get(i).getName());
            } else if (type.equals("AgeGroup")) {
                analyzeReList = analyzeMapper.analyzeByAgeGroup(provinces.get(i).getName());
            }
            if (analyzeReList.size() == 0) {
                return null;
            }
            for (int j = 0; j < analyzeReList.size(); j++) {
                AnalyzeRe current = analyzeReList.get(j);
                if ("恶性疟".equals(current.getDisease())) {
                    for (int k = 0; k < yearList.get(0).size(); k++) {
                        if (yearList.get(0).get(k).equals(Integer.toString(current.getYear()))) {
                            clusterList.get(0).getClusterProvinceLists().get(k).get(i).getPatientNum().put(current.getAttitude(), current.getPatientNum());
                            break;
                        }
                    }
                } else if ("间日疟".equals(current.getDisease())) {
                    for (int k = 0; k < yearList.get(1).size(); k++) {
                        if (yearList.get(1).get(k).equals(Integer.toString(current.getYear()))) {
                            clusterList.get(1).getClusterProvinceLists().get(k).get(i).getPatientNum().put(current.getAttitude(), current.getPatientNum());
                            break;
                        }
                    }
                }
            }
            System.out.println(clusterList);
        }
        return clusterList;
    }

    /*   @Override
       public List<Cluster> clusterByAge() throws Exception {
           List<String> ageGroup = Arrays.asList("0-9", "10-19", "20-29",
                   "30-39", "40-49", "50-59", "60-69", "70-79", "80-89",
                   "90-99", ">99");


           //所有省份
           List<FourLevelLinkage> provinces = districtInfoMapper.selectProvinces();

           //恶性疟所有年份
           List<String> yearList1 = clusterMapper.getAllYear("恶性疟");

           //间日疟所有年份
           List<String> yearList2 = clusterMapper.getAllYear("间日疟");

           List<List<String>> yearList = new ArrayList<>();
           yearList.add(yearList1);
           yearList.add(yearList2);

           List<Cluster> ageClusterList = new ArrayList<>();

           //初始化
           for (int i = 0; i < 2; i++) {
               Cluster ageCluster = new Cluster();
               List<List<ClusterProvince>> ageClusterProvLists = new ArrayList<>();
               for (int j = 0; j < yearList.get(i).size(); j++) {
                   List<ClusterProvince> ageClusterProvs = new ArrayList<>();
                   for (int k = 0; k < provinces.size(); k++) {
                       ClusterProvince ageClusterProv = new ClusterProvince();
                       ageClusterProv.setProvince(provinces.get(k).getName());
                       ageClusterProv.setPatientNum(initMapValue(ageGroup));

                       ageClusterProvs.add(ageClusterProv);
                   }
                   ageClusterProvLists.add(ageClusterProvs);
               }
               ageCluster.setClusterProvinceLists(ageClusterProvLists);
               ageCluster.setYearList(yearList.get(i));
               if (i == 0) {
                   ageCluster.setDiseaseName("恶性疟");
               } else if (i == 1) {
                   ageCluster.setDiseaseName("间日疟");
               }
               ageClusterList.add(ageCluster);
           }

           //数据处理
           for (int i = 0; i < provinces.size(); i++) {
               List<AnalyzeRe> ageGroupAnalyzeRes = analyzeMapper.analyzeByAgeGroup(provinces.get(i).getName());

               if (ageGroupAnalyzeRes.size() == 0) {
                   return null;
               }
               for (int j = 0; j < ageGroupAnalyzeRes.size(); j++) {
                   AnalyzeRe current = ageGroupAnalyzeRes.get(j);
                   if ("恶性疟".equals(current.getDisease())) {
                       for (int k = 0; k < yearList.get(0).size(); k++) {
                           if (yearList.get(0).get(k).equals(Integer.toString(current.getYear()))) {
                               ageClusterList.get(0).getClusterProvinceLists().get(k).get(i).getPatientNum().put(current.getAttitude(), current.getPatientNum());
                               break;
                           }
                       }
                   } else if ("间日疟".equals(current.getDisease())) {
                       for (int k = 0; k < yearList.get(1).size(); k++) {
                           if (yearList.get(0).get(k).equals(Integer.toString(current.getYear()))) {
                               ageClusterList.get(1).getClusterProvinceLists().get(k).get(i).getPatientNum().put(current.getAttitude(), current.getPatientNum());
                               break;
                           }
                       }
                   }
               }
               System.out.println(ageClusterList);
           }
           return ageClusterList;
       }
   */
    private Map<String, Integer> initMapValue(List<String> careerList) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < careerList.size(); i++) {
            stringIntegerMap.put(careerList.get(i), 0);
        }
        return stringIntegerMap;
    }
}