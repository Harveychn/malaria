package com.edupractice.malaria.modules.outbreakAnalysis.controller;

import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapDTO;
import com.edupractice.malaria.modules.outbreakAnalysis.pojo.HotMapVO;
import com.edupractice.malaria.modules.outbreakAnalysis.service.HotMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/hotMap")
public class HotMapController {
    @Resource
    private HotMapService hotMapService;

    @RequestMapping(value = "/selectAddress",method =RequestMethod.POST)
    public
    @ResponseBody
    List<HotMapVO> selectAddress(String diseaseName,String year,String career) throws Exception {
        HotMapDTO hotMapDTO=new HotMapDTO();
        hotMapDTO.setYear(year);
        hotMapDTO.setDiseaseName(diseaseName);
        hotMapDTO.setCareer(career);
        List<HotMapVO> hotMapVOList=hotMapService.selectAddress(hotMapDTO);
        return hotMapVOList;
    }
}
