package com.edupractice.malaria.modules.analyzeDisease.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClusterServiceTest {
    @Autowired
    private ClusterService clusterService;

    @Test
    public void ClusterTest() throws Exception {
        clusterService.cluster("Career");
        return;
    }


}