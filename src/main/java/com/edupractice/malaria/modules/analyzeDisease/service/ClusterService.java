package com.edupractice.malaria.modules.analyzeDisease.service;

import com.edupractice.malaria.modules.analyzeDisease.pojo.AgeCluster;
import com.edupractice.malaria.modules.analyzeDisease.pojo.CareerCluster;

import java.util.List;

public interface ClusterService {
    List<CareerCluster> clusterByCareer() throws Exception;

    List<AgeCluster> clusterByAge() throws Exception;
}
