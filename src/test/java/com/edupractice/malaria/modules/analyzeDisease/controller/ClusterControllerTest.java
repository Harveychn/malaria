package com.edupractice.malaria.modules.analyzeDisease.controller;

import com.edupractice.malaria.modules.analyzeDisease.pojo.Cluster;
import com.edupractice.malaria.modules.analyzeDisease.pojo.ClusterProvince;
import com.edupractice.malaria.modules.analyzeDisease.service.ClusterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClusterControllerTest {
    @Resource
    private ClusterService clusterService;

    @Test
    public void clusterToGroup() throws Exception {
        String diseaseName = "间日疟";
        String year = "2005";
        String attribute = "AgeGroup";
        List<Cluster> clusters = clusterService.clusterDataSet(attribute);
        int k = 4;
        int index = 0;
        if (diseaseName.equals("恶性疟")) {
            index = 0;
        } else if (diseaseName.equals("间日疟")) {
            index = 1;
        }
        List<ClusterProvince> dataSet = clusters.get(index).getClusterProvinceLists().get(clusters.get(index).getYearList().indexOf(year));
        List<List<ClusterProvince>> clusterPro = clusterService.kMeans(dataSet, k);
        System.out.println(clusterPro);
    }

}