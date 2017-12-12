package com.edupractice.malaria.modules.login.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @GetMapping(value = "/mapView")
    public ModelAndView mapView()throws Exception{
        return new ModelAndView("locatedUserMap");
    }
    @GetMapping(value = "/")
    public ModelAndView login()throws Exception{
        return new ModelAndView("UserUI");
    }

    @GetMapping(value = "/hello")
    public String testFunc()throws Exception{
        return "ok";
    }

    @GetMapping(value = "/getView")
    public ModelAndView getView()throws Exception{
        return new ModelAndView("test");
    }
    @GetMapping(value = "/homepage")
    public ModelAndView homepage()throws Exception{
        return new ModelAndView("first-page");
    }
}
