package com.edupractice.malaria.modules.analyzeDisease.service;

import com.edupractice.malaria.modules.analyzeDisease.pojo.Cluster;
import com.edupractice.malaria.modules.analyzeDisease.pojo.ClusterProvince;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClusterService {
    List<String> getAllYear() throws Exception;

    List<Cluster> clusterDataSet(String type) throws Exception;

    List<List<ClusterProvince>> kMeans(List<ClusterProvince> dataSet, int k) throws Exception;
}
