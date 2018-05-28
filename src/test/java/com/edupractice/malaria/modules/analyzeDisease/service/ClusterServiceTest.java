package com.edupractice.malaria.modules.analyzeDisease.service;

import com.edupractice.malaria.modules.analyzeDisease.pojo.Cluster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClusterServiceTest {
    @Autowired
    private ClusterService clusterService;

    @Test
    public void ClusterTest() throws Exception {
        List<Cluster> clusters=  clusterService.clusterDataSet("Career");
        clusters.get(0);
        System.out.println(clusters);
        return;
    }


}