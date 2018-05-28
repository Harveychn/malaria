package com.edupractice.malaria.modules.outbreakAnalysis.service;

import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapDTO;
import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotMapService {
    List<HotMapVO> selectAddress(HotMapDTO hotMapDTO)throws Exception;
}
