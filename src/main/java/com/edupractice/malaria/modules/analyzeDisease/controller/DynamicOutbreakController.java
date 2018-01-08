package com.edupractice.malaria.modules.analyzeDisease.controller;

import com.edupractice.malaria.modules.analyzeDisease.pojo.DynamicOutbreakRe;
import com.edupractice.malaria.modules.analyzeDisease.pojo.DynamicOutbreakVo;
import com.edupractice.malaria.modules.analyzeDisease.service.DynamicOutbreakService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 动态爆发
 */
@Controller
@RequestMapping("/DynamicOutbreak")
public class DynamicOutbreakController {

    @Resource
    private DynamicOutbreakService dynamicOutbreakService;

    @RequestMapping("/subModule1")
    public
    @ResponseBody
    List<DynamicOutbreakRe> subModule1(DynamicOutbreakVo dynamicOutbreakVo) throws Exception {
        System.out.println(" dynamicOutbreakVo.year :" + dynamicOutbreakVo.getYear() +
                "\ndynamicOutbreakVo.month :" + dynamicOutbreakVo.getMonth() +
                "\ndynamicOutbreakVo.province : " + dynamicOutbreakVo.getProvince());
        List<DynamicOutbreakRe> address = dynamicOutbreakService.findAddressList(dynamicOutbreakVo);
        System.out.println(" address List : " + address);
        return address;
    }

}