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

    @RequestMapping("/LocatedUserMap")
    public ModelAndView LocatedUserMap(){
        return new ModelAndView("LocatedUserMap");
    }

}