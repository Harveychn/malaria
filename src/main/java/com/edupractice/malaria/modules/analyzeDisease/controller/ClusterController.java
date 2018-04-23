package com.edupractice.malaria.modules.analyzeDisease.controller;

import com.edupractice.malaria.modules.analyzeDisease.pojo.Cluster;
import com.edupractice.malaria.modules.analyzeDisease.pojo.ClusterProvince;
import com.edupractice.malaria.modules.analyzeDisease.service.ClusterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/Cluster")
public class ClusterController {
    @Resource
    private ClusterService clusterservice;

    @RequestMapping("/career")
    public
    @ResponseBody
    List<List<ClusterProvince>> ClusterCareer(String year, String diseaseName, String attribute) throws Exception {
        List<Cluster> clusters = new ArrayList<>();
        clusterservice.clusterDataSet(attribute);
        int k = 0;
        int index = 0;
        if (diseaseName.equals("恶性疟")) {
            index = 0;
        } else if (diseaseName.equals("间日疟")) {
            index = 1;
        }
        List<ClusterProvince> dataSet = clusters.get(index).getClusterProvinceLists().get(clusters.get(index).getYearList().indexOf(year));
        List<List<ClusterProvince>> ClusterPro = clusterservice.kMeans(dataSet, k);
        return ClusterPro;
    }
}