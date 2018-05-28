package com.edupractice.malaria.modules.analyzeDisease.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClusterMapper {
    List<String> getAllYearByDisease(String disease) throws Exception;

    List<String> getAllYear() throws Exception;

    List<String> getAllCareer() throws Exception;
}
