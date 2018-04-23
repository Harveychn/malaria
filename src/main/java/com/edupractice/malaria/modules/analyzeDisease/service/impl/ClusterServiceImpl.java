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

    private Random random;

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
            clusterList = vacantData(clusterList);
            System.out.println(clusterList);
        }
        return clusterList;
    }

    //空缺数据处理
    private List<Cluster> vacantData(List<Cluster> clusterList) throws Exception {
        //所有省份信息
        List<FourLevelLinkage> provinces = districtInfoMapper.selectProvinces();

        //恶性疟所有年份
        List<String> yearList1 = clusterMapper.getAllYear("恶性疟");
        //间日疟所有年份
        List<String> yearList2 = clusterMapper.getAllYear("间日疟");

        List<List<String>> yearList = new ArrayList<>();
        yearList.add(yearList1);
        yearList.add(yearList2);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < provinces.size(); j++) {
                for (int k = 1; k < yearList.get(i).size() - 1; k++) {
                    for (String key : clusterList.get(i).getClusterProvinceLists().get(k).get(j).getPatientNum().keySet()
                            ) {
                        if (clusterList.get(i).getClusterProvinceLists().get(k).get(j).getPatientNum().get(key) == 0) {
                            int lastYearNum = clusterList.get(i).getClusterProvinceLists().get(k - 1).get(j).getPatientNum().get(key);
                            int nextYearNum = clusterList.get(i).getClusterProvinceLists().get(k + 1).get(j).getPatientNum().get(key);
                            clusterList.get(i).getClusterProvinceLists().get(k).get(j).getPatientNum().put(key, (lastYearNum + nextYearNum) / 2);
                        }
                    }
                }
            }
        }
        return clusterList;
    }

    private Map<String, Integer> initMapValue(List<String> careerList) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < careerList.size(); i++) {
            stringIntegerMap.put(careerList.get(i), 0);
        }
        return stringIntegerMap;
    }


    /**
     * K-Means算法
     * 实现步骤
     * 1.随机获取总体中的K个元素作为总体的K个中心
     * 2.对中总体中的元素进行分类，每个元素判断自己到K个中心的距离，并归类到最近距离中心簇
     * 3.计算每个聚类的平均数，并作为新的中心点
     * 4.重复2.3步骤，直到这K个中心点不再变化（收敛），或者执行了足够多的迭代
     */
/*    private void kMeans(List<ClusterProv> dataSet, int k) {
        int dataLength = dataSet.size();
        //初始化
        if (dataSet.size() <= 0)
            System.out.println("数据为空");
        else {
            if (k > dataLength) {
                k = dataLength;
            }
            //初始化中心链表
            initCenters();
            //初始化簇
            initClusters();
            while (true) {
                clusterSet();
                countRule();
                //迭代完成
                if () {
                    break;
                }
                setNewCenter();
                m++;
                cluster.clear();
                cluster = initClusters();
            }
        }
    }*/
    private List<ClusterProvince> initCenters(List<ClusterProvince> dataSet, int k) {
        //初始化中心数据链表
        List<ClusterProvince> centers = new ArrayList<>();
        int[] randoms = new int[k];
        boolean flag = true;
        int temp = random.nextInt(dataSet.size());
        randoms[0] = temp;
        for (int i = 1; i < k; i++) {
            flag = true;
            while (flag) {
                temp = random.nextInt(dataSet.size());
                int j = 0;
                while (j < i) {
                    if (temp == randoms[j]) {
                        break;
                    }
                    j++;
                }
                if (j == i) {
                    flag = false;
                }
            }
            randoms[i] = temp;
        }
        for (int i = 0; i < k; i++) {
            centers.add(dataSet.get(i));
        }
        return centers;
    }

    //初始化簇集合
    private List<List<ClusterProvince>> initClusters(int k) {

        List<List<ClusterProvince>> clusters = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            clusters.add(new ArrayList<>());
        }
        return clusters;
    }

    //将当前元素放到最小距离中心相关的簇中
    private List<List<ClusterProvince>> clusterSet(List<ClusterProvince> dataSet, List<ClusterProvince> centers, int k, List<List<ClusterProvince>> clusters) {
        float[] distance = new float[k];
        for (int i = 0; i < dataSet.size(); i++) {
            for (int j = 0; j < k; j++) {
                distance[j] = distance(dataSet.get(i), centers.get(j));
            }
            int minLocation = minDistance(distance);
            clusters.get(minLocation).add(dataSet.get(i));
        }
        return clusters;
    }

    //设置新的簇中心
    private void setNewCenter(int k, List<List<ClusterProvince>> clusters, List<ClusterProvince> centers) {
        for (int i = 0; i < k; i++) {
            //每一簇
            ClusterProvince newCenter = new ClusterProvince();
            Map<String, Integer> newCenterMap = new HashMap<>();
            int n = clusters.get(i).size();
            int[] temp = new int[centers.get(i).getPatientNum().size()];
            Map<String, Integer> tempMap = new HashMap<>();
            if (n != 0) {
                for (String key : centers.get(i).getPatientNum().keySet()) {
                    int patientSum = 0;
                    for (int j = 0; j < n; j++) {
                        //每个省份
                        patientSum += clusters.get(i).get(j).getPatientNum().get(key);
                    }
                    newCenterMap.put(key, patientSum / n);
                }
            }

            newCenter.setProvince("default");
            newCenter.setPatientNum(newCenterMap);
            centers.set(i, newCenter);
        }

    }

    private void countRule() {
    }

    //计算两点之间的欧氏距离
    private float distance(ClusterProvince element, ClusterProvince center) {
        float distance = 0.0f;
        float temp = 0.0f;
        for (String key : element.getPatientNum().keySet()) {
            temp += (element.getPatientNum().get(key) - center.getPatientNum().get(key))
                    * (element.getPatientNum().get(key) - center.getPatientNum().get(key));
        }
        distance = (float) Math.sqrt(temp);
        return distance;
    }

    //获取距离集合中最小距离的位置
    private int minDistance(float[] distance) {
        float minDistance = distance[0];
        int minLocation = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] < minDistance) {
                minDistance = distance[i];
                minLocation = i;
            } else if (distance[i] == minDistance) // 如果相等，随机返回一个位置
            {
                if (random.nextInt(10) < 5) {
                    minLocation = i;
                }
            }
        }
        return minLocation;
    }
}