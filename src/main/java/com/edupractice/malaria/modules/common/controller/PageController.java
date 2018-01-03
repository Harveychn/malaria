package com.edupractice.malaria.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class PageController {

    @RequestMapping("firstPage")
    public ModelAndView firstPage(){
        return new ModelAndView("first-page");
    }

    @RequestMapping("/locatedUserMap")
    public ModelAndView LocatedUserMap(){
        return new ModelAndView("locatedUserMap");
    }

    @RequestMapping("/hotMap")
    public  ModelAndView hotMap(){
        return new ModelAndView("hotMap");
    }
    @RequestMapping("/analyzeSexChart")
    public ModelAndView analyzeSexChart(){
        return new ModelAndView("analyzeSexChart");
    }

}
