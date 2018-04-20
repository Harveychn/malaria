package com.edupractice.malaria.modules.analyzeDisease.controller;

import com.edupractice.malaria.modules.analyzeDisease.pojo.ClusterProvince;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/Cluster")
public class ClusterController {
    private Random random;

    @RequestMapping("/career")
    public
    @ResponseBody
    List<List<String>> ClusterCareer(String year, String diseaseName) throws Exception {
        List<List<String>> ClusterPro = new ArrayList<>();
        // List<ClusterCareer> clusterCareer = clusterService.cluster();

        return ClusterPro;
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

    private List<List<ClusterProvince>> initClusters(int k) {
        //初始化簇集合
        List<List<ClusterProvince>> clusters = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            clusters.add(new ArrayList<>());
        }
        return clusters;
    }

    private List<List<ClusterProvince>> clusterSet(List<ClusterProvince> dataSet, List<ClusterProvince> centers, int k, List<List<ClusterProvince>> clusters) {
        //将当前元素放到最小距离中心相关的簇中
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

    private void setNewCenter(int k, List<List<ClusterProvince>> clusters, List<ClusterProvince> centers) {
        //设置新的簇中心
        for (int i = 0; i < k; i++) {
            int n = clusters.get(i).size();
            int[] temp = new int[centers.get(i).getPatientNum().size()];
            Map<String, Integer> tempMap = new HashMap<>();
            if (n != 0) {
                for (int j = 0; j < n; j++) {
                    for (String key : centers.get(i).getPatientNum().keySet()
                            ) {
                        temp[i] += clusters.get(i).get(j).getPatientNum().get(key);
                    }
                }
            }
            //设置平均值
//            centers.get(i).setCareerValue();
        }

    }

    private void countRule() {
    }

    private float distance(ClusterProvince element, ClusterProvince center) {
        //计算两点之间的欧氏距离
        float distance = 0.0f;
        float temp = 0.0f;
        for (String key : element.getPatientNum().keySet()) {
            temp += (element.getPatientNum().get(key) - center.getPatientNum().get(key))
                    * (element.getPatientNum().get(key) - center.getPatientNum().get(key));
        }
        distance = (float) Math.sqrt(temp);
        return distance;
    }

    private int minDistance(float[] distance) {
        //获取距离集合中最小距离的位置
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