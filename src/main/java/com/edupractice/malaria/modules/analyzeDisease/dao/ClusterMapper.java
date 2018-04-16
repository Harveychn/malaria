package com.edupractice.malaria.modules.analyzeDisease.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClusterMapper {
    List<String> getAllYear(String disease) throws Exception;

    List<String> getAllCareer() throws Exception;
}
