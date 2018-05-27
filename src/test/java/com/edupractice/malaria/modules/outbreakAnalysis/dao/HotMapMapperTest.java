package com.edupractice.malaria.modules.outbreakAnalysis.dao;

import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapDTO;
import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class HotMapMapperTest {
    @Autowired
    HotMapMapper hotMapMapper;

        @Test
        public void selectAddress() throws Exception {
            HotMapDTO hotMapDTO=new HotMapDTO();
            List<HotMapVO> hotMapVOList=new ArrayList<>();
            String diseaseName="间日疟";
            String year="2005";
            String career="民工";
            hotMapDTO.setCareer(career);
            hotMapDTO.setDiseaseName(diseaseName);
            hotMapDTO.setYear(year);
            hotMapVOList=hotMapMapper.selectAddress(hotMapDTO);
            System.out.println(hotMapVOList);
        }

}