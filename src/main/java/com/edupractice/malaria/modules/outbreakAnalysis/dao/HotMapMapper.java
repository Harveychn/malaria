package com.edupractice.malaria.modules.outbreakAnalysis.dao;

import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapDTO;
import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotMapMapper {
    List<HotMapVO> selectAddress(HotMapDTO hotMapDTO)throws Exception;
}
