package com.edupractice.malaria.modules.upload.controller;

import com.edupractice.malaria.modules.common.pojo.CONSTANT;
import com.edupractice.malaria.modules.upload.service.DispatcherUploadFileService;
import com.edupractice.malaria.modules.upload.service.UploadToCardInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UploadController {

    @Resource
    private DispatcherUploadFileService dispatcherUploadFileService;

    @Resource
    private UploadToCardInfoService uploadToCardInfoService;

    @RequestMapping("/UploadFileTest")
    public String testUp()throws Exception{
        uploadToCardInfoService.saveDataToDB(CONSTANT.getUPLOADFILEPATH());

        System.out.println(dispatcherUploadFileService.getDestination(CONSTANT.getUPLOADFILEPATH()));
        return "OK";
    }

}
