package com.edupractice.malaria.modules.analyzeDisease.controller;

import com.edupractice.malaria.modules.analyzeDisease.pojo.AgeGroupChart;
import com.edupractice.malaria.modules.analyzeDisease.pojo.CareerChart;
import com.edupractice.malaria.modules.analyzeDisease.pojo.SexChart;
import com.edupractice.malaria.modules.analyzeDisease.service.AnalyzeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 根据疾病进行分类
 * 展示疾病人群的性别、职业、年龄段的关系
 * Created by 郑晓辉 on 2016/10/3.
 */
@Controller
@RequestMapping("/AnalyzeByCharts")
public class AnalyzeByChartsController {
    @Resource
    private AnalyzeService analyzeService;

    @RequestMapping("analyzeView")
    public ModelAndView analyzeView() throws Exception {
        return new ModelAndView("analyzeSexChart");
    }

    /*性别比例分析*/
    @RequestMapping(value = "/sexChart", method = RequestMethod.POST)
    public
    @ResponseBody
    List<SexChart> sexChart(String dataSource) throws Exception {
        System.out.println(dataSource);
        return analyzeService.analyzeBySex(dataSource);
    }

    /*职业比例分析*/
    @RequestMapping(value = "/careerChart", method = RequestMethod.POST)
    public
    @ResponseBody
    List<CareerChart> careerChart(String dataSource) throws Exception {
        System.out.println(dataSource);
        return analyzeService.analyzeByCareer(dataSource);
    }

    @RequestMapping(value = "/ageGroupChart", method = RequestMethod.POST)
    public
    @ResponseBody
    List<AgeGroupChart> ageGroupChart(String dataSource) throws Exception {
        System.out.println(dataSource);
        return analyzeService.analyzeByAgeGroup(dataSource);
    }
}
