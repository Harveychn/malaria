package com.edupractice.malaria.modules.outbreakAnalysis.service.impl;

import com.edupractice.malaria.modules.outbreakAnalysis.dao.HotMapMapper;
import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapDTO;
import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapVO;
import com.edupractice.malaria.modules.outbreakAnalysis.service.HotMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotMapServiceImpl implements HotMapService {
    @Autowired
    private HotMapMapper hotMapMapper;
    @Override
    public List<HotMapVO> selectAddress(HotMapDTO hotMapDTO) throws Exception {
        List<HotMapVO> hotMapVOList=hotMapMapper.selectAddress(hotMapDTO);
        return hotMapVOList;
    }
}
