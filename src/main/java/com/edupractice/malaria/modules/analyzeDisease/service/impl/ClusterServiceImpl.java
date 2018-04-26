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
    public List<String> getAllYear() throws Exception {
        return clusterMapper.getAllYear();
    }

    //聚类所需原数据处理
    public List<Cluster> clusterDataSet(String type) throws Exception {
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
        List<String> yearList1 = clusterMapper.getAllYearByDisease("恶性疟");
        //间日疟所有年份
        List<String> yearList2 = clusterMapper.getAllYearByDisease("间日疟");

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
                for (FourLevelLinkage currentProvince : provinces
                        ) {
                    ClusterProvince clusterProvince = new ClusterProvince();
                    clusterProvince.setProvince(currentProvince.getName());
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

        //数据填充
        for (int i = 0; i < provinces.size(); i++) {
            System.out.println(provinces.get(i).getName());
            List<AnalyzeRe> analyzeReList = new ArrayList<>();
            if (type.equals("Career")) {
                analyzeReList = analyzeMapper.analyzeByCareer(provinces.get(i).getName());
            } else if (type.equals("AgeGroup")) {
                analyzeReList = analyzeMapper.analyzeByAgeGroup(provinces.get(i).getName());
            }
            if (analyzeReList.size() == 0) {
                break;
            }
            for (AnalyzeRe current : analyzeReList
                    ) {
                if ("恶性疟".equals(current.getDisease())) {
                    for (int k = 0; k < yearList.get(0).size(); k++) {
                        if (yearList.get(0).get(k).equals(Integer.toString(current.getYear()))) {
                            clusterList.get(0).getClusterProvinceLists().get(k).get(i).getPatientNum().put(current.getAttitude(), (float) current.getPatientNum());
                            break;
                        }
                    }
                } else if ("间日疟".equals(current.getDisease())) {
                    for (int k = 0; k < yearList.get(1).size(); k++) {
                        if (yearList.get(1).get(k).equals(Integer.toString(current.getYear()))) {
                            clusterList.get(1).getClusterProvinceLists().get(k).get(i).getPatientNum().put(current.getAttitude(), (float) current.getPatientNum());
                            break;
                        }
                    }
                }
            }
            System.out.println(clusterList);
        }
        clusterList = vacantData(clusterList);
        return clusterList;
    }

    //空缺数据处理
    private List<Cluster> vacantData(List<Cluster> clusterList) throws Exception {
        //所有省份信息
        List<FourLevelLinkage> provinces = districtInfoMapper.selectProvinces();

        //恶性疟所有年份
        List<String> yearList1 = clusterMapper.getAllYearByDisease("恶性疟");
        //间日疟所有年份
        List<String> yearList2 = clusterMapper.getAllYearByDisease("间日疟");

        List<List<String>> yearList = new ArrayList<>();
        yearList.add(yearList1);
        yearList.add(yearList2);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < provinces.size(); j++) {
                for (int k = 1; k < yearList.get(i).size() - 1; k++) {
                    for (String key : clusterList.get(i).getClusterProvinceLists().get(k).get(j).getPatientNum().keySet()
                            ) {
                        if (clusterList.get(i).getClusterProvinceLists().get(k).get(j).getPatientNum().get(key) == 0) {
                            float lastYearNum = clusterList.get(i).getClusterProvinceLists().get(k - 1).get(j).getPatientNum().get(key);
                            float nextYearNum = clusterList.get(i).getClusterProvinceLists().get(k + 1).get(j).getPatientNum().get(key);
                            clusterList.get(i).getClusterProvinceLists().get(k).get(j).getPatientNum().put(key, (float) ((int) (lastYearNum + nextYearNum) / 2));
                        }
                    }
                }
            }
        }
        return clusterList;
    }

    private Map<String, Float> initMapValue(List<String> attributeList) {
        Map<String, Float> stringIntegerMap = new HashMap<>();
        for (String attribute : attributeList
                ) {
            stringIntegerMap.put(attribute, 0.0f);
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
    public List<List<ClusterProvince>> kMeans(List<ClusterProvince> dataSet, int k) {
        List<ClusterProvince> centers;
        List<List<ClusterProvince>> clusters = new ArrayList<>();
        List<Float> jc = new ArrayList<>();
        int dataLength = dataSet.size();
        int iterativeNum = 0;
        //初始化
        if (dataSet.size() <= 0)
            System.out.println("数据为空");
        else {
            if (k > dataLength) {
                k = dataLength;
            }
            //初始化中心链表
            centers = initCentersPro(dataSet, k);
            //初始化簇
            clusters = initClusters(k);
            while (true) {
                clusters = clusterSet(dataSet, centers, k, clusters);
                jc.add(countRule(clusters, centers));
                //迭代完成
                if (iterativeNum != 0) {
                    if (jc.get(iterativeNum) - jc.get(iterativeNum - 1) == 0) {
                        break;
                    }
                }
                centers = setNewCenter(k, clusters, centers);
                iterativeNum++;
                clusters.clear();
                clusters = initClusters(k);
            }
        }
        return clusters;
    }

    private List<ClusterProvince> initCenters(List<ClusterProvince> dataSet, int k) {
        //初始化中心数据链表
        Random random = new Random();
        List<ClusterProvince> centers = new ArrayList<>();
        int[] randoms = new int[k];
        boolean flag;
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
            centers.add(dataSet.get(randoms[i]));
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
        for (ClusterProvince dataSetProvince : dataSet) {
            for (int j = 0; j < k; j++) {
                distance[j] = distance(dataSetProvince, centers.get(j));
            }
            int minLocation = minDistanceLoc(distance);
            clusters.get(minLocation).add(dataSetProvince);
        }
        return clusters;
    }

    //设置新的簇中心
    private List<ClusterProvince> setNewCenter(int k, List<List<ClusterProvince>> clusters, List<ClusterProvince> centers) {
        for (int i = 0; i < k; i++) {
            ClusterProvince newCenter = new ClusterProvince();
            Map<String, Float> newCenterMap = new HashMap<>();
            int n = clusters.get(i).size();
            if (n != 0) {
                for (String key : centers.get(i).getPatientNum().keySet()) {
                    float patientSum = 0;
                    for (int j = 0; j < n; j++) {
                        patientSum += clusters.get(i).get(j).getPatientNum().get(key);
                    }
                    newCenterMap.put(key, patientSum / n);
                }
            }
            newCenter.setProvince("default");
            newCenter.setPatientNum(newCenterMap);
            centers.set(i, newCenter);
        }
        return centers;
    }

    //计算误差平方和准则函数方法
    private float countRule(List<List<ClusterProvince>> clusters, List<ClusterProvince> centers) {
        float jcF = 0.0f;
        for (int i = 0; i < clusters.size(); i++) {
            for (int j = 0; j < clusters.get(i).size(); j++) {
                jcF += errorSquare(clusters.get(i).get(j), centers.get(i));
            }
        }
        return jcF;
    }

    //求两点误差平方的方法
    private float errorSquare(ClusterProvince element, ClusterProvince center) {
        float temp = 0.0f;
        for (String key : element.getPatientNum().keySet()) {
            temp += (element.getPatientNum().get(key) - center.getPatientNum().get(key))
                    * (element.getPatientNum().get(key) - center.getPatientNum().get(key));
        }
        return temp;
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
    private int minDistanceLoc(float[] distance) {
        Random random = new Random();
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

    //获取距离集合中最小距离
    private float minDistance(float[] distance) {
        float minDistance = distance[0];
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] < minDistance) {
                minDistance = distance[i];
            }
        }
        return minDistance;
    }

    private List<ClusterProvince> initCentersPro(List<ClusterProvince> dataSet, int k) {
        //K-means++算法初始化中心数据链表
        Random random = new Random();
        List<ClusterProvince> centers = new ArrayList<>();

        float[] minDistanceArray = new float[dataSet.size()];
        int count = 1;
        //第一个簇中心点
        int firstCenter = random.nextInt(dataSet.size());
        centers.add(dataSet.get(firstCenter));
        for (int i = 1; i < k; i++) {

            //找出每个样本与已知聚类中心之间的最短距离
            for (int j = 0; j < dataSet.size(); j++) {

                float[] distance = new float[count];
                for (int l = 0; l < count; l++) {
                    distance[l] = distance(dataSet.get(j), centers.get(l));
                }
                minDistanceArray[j] = minDistance(distance);
            }

            float[] probability = centerProbability(minDistanceArray);
            int temp = random.nextInt(1);
            for (int j = 1; j < probability.length; j++) {
                if (((Math.abs(probability[j - 1] - temp) < 0.00000001) | (probability[j - 1] < temp)) && (temp < probability[j])) {
                    centers.add(dataSet.get(j));
                    count++;
                    break;
                }
            }
        }
        return centers;
    }

    private float[] centerProbability(float[] distance) {
        //可能成为聚类中心的概率
        float[] probability = new float[distance.length + 1];
        float sum = 0.0f;
        for (float index : distance
                ) {
            sum += (index * index);
        }
        for (int i = 1; i < distance.length; i++) {
            probability[i] = distance[i] * distance[i] / sum;
        }
        probability[0] = 0;
        //轮转法
        for (int i = 1; i < distance.length; i++) {
            probability[i] += probability[i - 1];
        }
        return probability;
    }
}