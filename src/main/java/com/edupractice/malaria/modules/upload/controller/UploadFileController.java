package com.edupractice.malaria.modules.upload.controller;

import com.edupractice.malaria.modules.common.pojo.CONSTANT;
import com.edupractice.malaria.modules.upload.pojo.Data2DBInfo;
import com.edupractice.malaria.modules.upload.pojo.FileListInfo;
import com.edupractice.malaria.modules.upload.pojo.UploadInfo;
import com.edupractice.malaria.modules.upload.service.DispatcherUploadFileService;
import com.edupractice.malaria.modules.upload.service.UploadToCardInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/UploadFile")
public class UploadFileController {

    private static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @Resource
    private DispatcherUploadFileService dispatcherUploadFileService;

    @Resource
    private UploadToCardInfoService uploadToCardInfoService;

    private List<UploadInfo> result;

    @RequestMapping("/uploadView")
    public String uploadView() throws Exception {
        return "common/dataUpload";
    }

    @RequestMapping("/displayUploadInfo")
    public ModelAndView displayUploadInform() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/uploadInform");
        modelAndView.addObject("result", this.result);
        return modelAndView;
    }

    /**
     * 上传文件，文件数据保存到数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/UploadToDB", method = RequestMethod.POST)
    public
    @ResponseBody
    List<UploadInfo> UploadToDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //上传的多个文件
        List<FileListInfo> filesInform = getUploadFilePath(request, response);
        List<UploadInfo> uploadInfos = new ArrayList<>();
        UploadInfo uploadInform = null;
        for (int i = 0; i < filesInform.size(); i++) {
            uploadInform = new UploadInfo();
            FileListInfo current = filesInform.get(i);
            uploadInform.setFileName(current.getFileName());
            //当前文件是否有错
            if (current.isError()) {
                //文件类型错误
                if (current.isFileTypeError()) {
                    uploadInform.setFileTypeError(true);
                    uploadInfos.add(i, uploadInform);
                    continue;
                }
//                uploadInform.setErrorOccur(true);
//                uploadInform.setErrorMessage(current.getErrorMessage());
                uploadInfos.add(i, uploadInform);
                continue;
            }
            //通过上传到服务器的文件路径，读取文件信息，操作数据
            String filePath = current.getFilePath();
            //根据第一行字段来判断文件数据应该上传到那一个表
            if (-1 != dispatcherUploadFileService.getDestination(filePath)) {
                uploadInform.setHasThisModule(true);
            } else {
                uploadInform.setHasThisModule(false);
                uploadInfos.add(i, uploadInform);
                continue;
            }
            Data2DBInfo data2DBInfo = uploadToCardInfoService.saveDataToDB(filePath);
            uploadInform.setSavedRowsTotal(data2DBInfo.getSavedRowsTotal());
            uploadInform.setErrorRowCodes(data2DBInfo.getErrorRowsCode());
            uploadInfos.add(i, uploadInform);
        }
        this.result = uploadInfos;
        return uploadInfos;
    }

    /**
     * 返回上传多个文件的初步处理结果
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private List<FileListInfo> getUploadFilePath(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
        List<MultipartFile> fileList = mr.getFiles("files[]");
        List<FileListInfo> fileListInfos = new ArrayList<>();
        FileListInfo fileInform = null;
        for (int i = 0; i < fileList.size(); i++) {
            fileInform = new FileListInfo();
            MultipartFile currentFile = fileList.get(i);
            String fileOriginName = currentFile.getOriginalFilename();
            fileInform.setFileName(fileOriginName);
            //文件类型校验
            if (!checkFile(fileOriginName)) {
                fileInform.setFileTypeError(true);
                fileListInfos.set(i, fileInform);
                continue;
            }
            SimpleDateFormat folderSdf = new SimpleDateFormat("yyyy-MM-dd");
            String folderPath = CONSTANT.getUPLOADFILEPATH() + "/" + folderSdf.format(new Date());
            File fileFolder = new File(folderPath);

            SimpleDateFormat fileSdf = new SimpleDateFormat("yyyyMMddhhmmss");
            String currentDate = fileSdf.format(new Date());
            String filePath = folderPath + "/" + currentDate + "-" + fileOriginName;
            File file = new File(filePath);
            //文件目录不存在则创建目录
            if (!fileFolder.exists()) {
                fileFolder.mkdir();
            }
            try {
                // 转存文件
                currentFile.transferTo(file);
            } catch (IOException e) {
                System.out.println("【！文件输入输出流出现问题】 message:" + e.getMessage());
                fileInform.setError(true);
                fileInform.setErrorMessage(e.getMessage());
                fileListInfos.add(i, fileInform);
                continue;
            } catch (IllegalStateException e) {
                System.out.println("【！IllegalStateException】 message:" + e.getMessage());
                fileInform.setError(true);
                fileInform.setErrorMessage(e.getMessage());
                fileListInfos.add(i, fileInform);
                continue;
            }
            fileInform.setNoError(true);
            fileInform.setFilePath(filePath);
            fileListInfos.add(i, fileInform);
        }
        return fileListInfos;
    }

    /**
     * 上传文件类型校验
     * true表示文件格式允许
     *
     * @param fileName 文件OriginName
     * @return
     */
    private boolean checkFile(String fileName) {
        boolean flag = false;
        String suffixList = "xls,xlsx";
        //获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

        if (suffixList.contains(suffix.trim().toLowerCase())) {
            flag = true;
        }
        return flag;
    }

}

// switch (dispatcherUploadFileService.getDestination(filePath)) {
//         case 0:
//         UploadDBMessage<ErrorCardInfor<String>, CardInform> uploadDBMessage0
//        = uploadToCardInforService.saveDataToCardInfor(filePath);
//        uploadInform.setCardInform(uploadDBMessage0);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 1:
//        UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> uploadDBMessage1
//        = uploadToPIService.saveDataToPatientInformation(filePath);
//        uploadInform.setPatientInform(uploadDBMessage1);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 2:
//        UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> uploadDBMessage2
//        = uploadToPCIService.saveDataToPCI(filePath);
//        uploadInform.setPatientCaseInform(uploadDBMessage2);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 3:
//        UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> uploadDBMessage3
//        = uploadToCaseReportService.saveToCaseReportInfor(filePath);
//        uploadInform.setCaseReportInform(uploadDBMessage3);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 4:
//        UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> uploadDBMessage4
//        = uploadToCaseRevisedService.saveToCaseRevisedInfor(filePath);
//        uploadInform.setCaseRevisedInform(uploadDBMessage4);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 5:
//        UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> uploadDBMessage5
//        = uploadToCaseJudgService.saveToCaseJudgInfor(filePath);
//        uploadInform.setCaseJudgeInform(uploadDBMessage5);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 6:
//        UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> uploadDBMessage6
//        = uploadToWeatherService.saveDataToWeather(filePath);
//        uploadInform.setWeatherInform(uploadDBMessage6);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 7:
//        UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> uploadDBMessage7
//        = uploadToObserStaService.saveDataToObserSta(filePath);
//        uploadInform.setObserveStaInform(uploadDBMessage7);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//default:
//        uploadInform.setHasThisModule(false);
//        uploadInforms.add(i, uploadInform);
//        break;
//        }
//    @Resource
//    private UploadToCardInforService uploadToCardInforService;
//    @Resource
//    private UploadToPIService uploadToPIService;
//    @Resource
//    private UploadToPCIService uploadToPCIService;
//    @Resource
//    private UploadToCaseReportService uploadToCaseReportService;
//    @Resource
//    private UploadToCaseRevisedService uploadToCaseRevisedService;
//    @Resource
//    private UploadToCaseJudgService uploadToCaseJudgService;
//    @Resource
//    private UploadToWeatherService uploadToWeatherService;
//    @Resource
//    private UploadToObserStaService uploadToObserStaService;
//    List<FileListInform> filesInform = getUploadFilePath(request, response);
//    List<UploadInform> uploadInforms = new ArrayList<>();
//    UploadInform uploadInform = null;
//        for (int i = 0; i < filesInform.size(); i++) {
//        uploadInform = new UploadInform();
//        FileListInform current = filesInform.get(i);
//        uploadInform.setFileName(current.getFileName());
//        if (current.isError()) {
//        if (current.isFileTypeError()) {
//        uploadInform.setFileTypeError(true);
//        uploadInforms.add(i, uploadInform);
//        continue;
//        }
//        uploadInform.setErrorOccur(true);
//        uploadInform.setErrorMessage(current.getErrorMessage());
//        uploadInforms.add(i, uploadInform);
//        continue;
//        }
//        //通过上传到服务器的文件路径，读取文件信息，操作数据
//        String filePath = current.getFilePath();
//        //根据第一行字段来判断文件数据应该上传到那一个表
//        switch (dispatcherUploadFileService.getDestination(filePath)) {
//        case 0:
//        UploadDBMessage<ErrorCardInfor<String>, CardInform> uploadDBMessage0
//        = uploadToCardInforService.saveDataToCardInfor(filePath);
//        uploadInform.setCardInform(uploadDBMessage0);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 1:
//        UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> uploadDBMessage1
//        = uploadToPIService.saveDataToPatientInformation(filePath);
//        uploadInform.setPatientInform(uploadDBMessage1);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 2:
//        UploadDBMessage<ErrorPatientCaseInfor<String>, PatientCasesInformation> uploadDBMessage2
//        = uploadToPCIService.saveDataToPCI(filePath);
//        uploadInform.setPatientCaseInform(uploadDBMessage2);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 3:
//        UploadDBMessage<ErrorCaseReportInfor<String>, CaseReportInformation> uploadDBMessage3
//        = uploadToCaseReportService.saveToCaseReportInfor(filePath);
//        uploadInform.setCaseReportInform(uploadDBMessage3);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 4:
//        UploadDBMessage<ErrorCaseRevisedInfor<String>, CaseRevisedInformation> uploadDBMessage4
//        = uploadToCaseRevisedService.saveToCaseRevisedInfor(filePath);
//        uploadInform.setCaseRevisedInform(uploadDBMessage4);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 5:
//        UploadDBMessage<ErrorCaseJudgInfor<String>, CaseJudgmentInformation> uploadDBMessage5
//        = uploadToCaseJudgService.saveToCaseJudgInfor(filePath);
//        uploadInform.setCaseJudgeInform(uploadDBMessage5);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 6:
//        UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> uploadDBMessage6
//        = uploadToWeatherService.saveDataToWeather(filePath);
//        uploadInform.setWeatherInform(uploadDBMessage6);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//        case 7:
//        UploadDBMessage<ErrorObserStaInfor<String>, MeteorologicalStationInsformation> uploadDBMessage7
//        = uploadToObserStaService.saveDataToObserSta(filePath);
//        uploadInform.setObserveStaInform(uploadDBMessage7);
//        uploadInform.setHasThisModule(true);
//        uploadInforms.add(i, uploadInform);
//        break;
//default:
//        uploadInform.setHasThisModule(false);
//        uploadInforms.add(i, uploadInform);
//        break;
//        }
//        }
//        this.result = uploadInforms;
//        return uploadInforms;
//        }
//
///**
// * 返回上传多个文件的初步处理结果
// *
// * @param request
// * @param response
// * @return
// * @throws Exception
// */
//private List<FileListInform> getUploadFilePath(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
//        List<MultipartFile> fileList = mr.getFiles("files[]");
//        List<FileListInform> fileInformList = new ArrayList<>();
//        FileListInform fileInform = null;
//        for (int i = 0; i < fileList.size(); i++) {
//        fileInform = new FileListInform();
//        MultipartFile currentFile = fileList.get(i);
//        String fileOriginName = currentFile.getOriginalFilename();
//        fileInform.setFileName(fileOriginName);
//        //文件类型校验
//        if (!checkFile(fileOriginName)) {
//        fileInform.setFileTypeError(true);
//        fileInformList.set(i, fileInform);
//        continue;
//        }
//        SimpleDateFormat folderSdf = new SimpleDateFormat("yyyy-MM-dd");
//        String folderPath = "E:/创新实践/uploadFiles/excels" + "/" + folderSdf.format(new Date());
//        File fileFolder = new File(folderPath);
//
//        SimpleDateFormat fileSdf = new SimpleDateFormat("yyyyMMddhhmmss");
//        String currentDate = fileSdf.format(new Date());
//        String filePath = folderPath + "/" + currentDate + "-" + fileOriginName;
//        File file = new File(filePath);
//        //文件目录不存在则创建目录
//        if (!fileFolder.exists()) {
//        fileFolder.mkdir();
//        }
//        try {
//        currentFile.transferTo(file);
//        } catch (IOException e) {
//        System.out.println("【！文件输入输出流出现问题】 message:" + e.getMessage());
//        fileInform.setError(true);
//        fileInform.setErrorMessage(e.getMessage());
//        fileInformList.add(i, fileInform);
//        continue;
//        } catch (IllegalStateException e) {
//        System.out.println("【！IllegalStateException】 message:" + e.getMessage());
//        fileInform.setError(true);
//        fileInform.setErrorMessage(e.getMessage());
//        fileInformList.add(i, fileInform);
//        continue;
//        }
//        fileInform.setNoError(true);
//        fileInform.setFilePath(filePath);
//        fileInformList.add(i, fileInform);
//        }
//        return fileInformList;
