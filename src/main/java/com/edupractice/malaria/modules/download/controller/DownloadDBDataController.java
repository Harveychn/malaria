package com.edupractice.malaria.modules.download.controller;

import com.edupractice.malaria.modules.download.pojo.CategoryFieldsRe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/DownloadDBData")
public class DownloadDBDataController {

    @RequestMapping(value = "downloadView")
    public String downloadView()throws Exception{
        return "view/common/dataDownload";
    }

    /**
     * 根据用户选择的数据类别，获取展示的字段名
     * 同时转到相应的选择页面
     *
     * @param category
     * @return
     * @throws Exception
     */
    @RequestMapping("/fieldNameDownloadable")
    public ModelAndView fieldNameDownloadable(@RequestParam(value = "category") String category) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
/*
        List<CategoryFieldsRe> categoryFieldsRes = downloadDBDataService.getFieldsNameDownload(category);
        if (categoryFieldsRes != null) {
            modelAndView.addObject("categoryFieldsRes", categoryFieldsRes);
        } else {
            modelAndView.addObject("categoryFieldsRes", null);
        }
*/
        if ("Disease".equals(category.trim())) {
            modelAndView.setViewName("view/common/downloadDisease");
        } else if ("Weather".equals(category.trim())) {
            modelAndView.setViewName("view/common/downloadWeather");
        } else if ("Station".equals(category.trim())) {
            modelAndView.setViewName("view/common/downloadStation");
        } else {
            modelAndView.setViewName("view/error/404");
        }
        return modelAndView;
    }
}
