package com.edupractice.malaria.modules.analyzeDisease.service;

import com.edupractice.malaria.modules.analyzeDisease.pojo.Cluster;

import java.util.List;

public interface ClusterService {
    List<Cluster> cluster(String type) throws Exception;
}
