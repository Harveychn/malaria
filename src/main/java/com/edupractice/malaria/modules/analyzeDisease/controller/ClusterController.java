package com.edupractice.malaria.modules.analyzeDisease.controller;

import com.edupractice.malaria.modules.analyzeDisease.pojo.Cluster;
import com.edupractice.malaria.modules.analyzeDisease.pojo.ClusterProvince;
import com.edupractice.malaria.modules.analyzeDisease.service.ClusterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/cluster")
public class ClusterController {
    @Resource
    private ClusterService clusterservice;

    @RequestMapping("/kMeans")
    public
    @ResponseBody
    List<List<ClusterProvince>> Cluster(String diseaseName, String year, String attribute) throws Exception {
        List<Cluster> clusters = new ArrayList<>();
        clusterservice.clusterDataSet(attribute);
        int k = 4;
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

    @RequestMapping("/getAllYear")
    public
    @ResponseBody
    List<String> getYear() throws Exception {
        return clusterservice.getAllYear();
    }

    @RequestMapping("clusterView")
    public
    @ResponseBody
    ModelAndView clusterView() {
        return new ModelAndView("cluster");
    }
}