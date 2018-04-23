package com.edupractice.malaria.modules.analyzeDisease.controller;

import com.edupractice.malaria.modules.analyzeDisease.pojo.ClusterProvince;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/Cluster")
public class ClusterController {


    @RequestMapping("/career")
    public
    @ResponseBody
    List<List<String>> ClusterCareer(String year, String diseaseName) throws Exception {
        List<List<String>> ClusterPro = new ArrayList<>();
        // List<ClusterCareer> clusterCareer = clusterService.cluster();

        return ClusterPro;
    }

}