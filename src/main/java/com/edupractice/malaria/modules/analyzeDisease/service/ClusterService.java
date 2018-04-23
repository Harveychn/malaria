package com.edupractice.malaria.modules.analyzeDisease.service;

import com.edupractice.malaria.modules.analyzeDisease.pojo.Cluster;
import com.edupractice.malaria.modules.analyzeDisease.pojo.ClusterProvince;

import java.util.List;

public interface ClusterService {
    List<Cluster> clusterDataSet(String type) throws Exception;

    List<List<ClusterProvince>> kMeans(List<ClusterProvince> dataSet, int k) throws Exception;
}
