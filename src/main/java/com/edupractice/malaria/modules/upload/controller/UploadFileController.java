package com.edupractice.malaria.modules.upload.controller;

import com.edupractice.malaria.modules.common.pojo.constant.CONSTANT;
import com.edupractice.malaria.modules.upload.pojo.Data2DBInfo;
import com.edupractice.malaria.modules.upload.pojo.FileListInfo;
import com.edupractice.malaria.modules.upload.pojo.UploadInfo;
import com.edupractice.malaria.modules.upload.service.DispatcherUploadFileService;
import com.edupractice.malaria.modules.upload.service.ExcelOperateService;
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

    @Resource
    private ExcelOperateService excelOperateService;

    private List<UploadInfo> result;


    @RequestMapping("/uploadView")
    public ModelAndView uploadView() throws Exception {
        return new ModelAndView("view/common/dataUpload") ;
    }

    @RequestMapping("/displayUploadInfo")
    public ModelAndView displayUploadInfo() throws Exception {
        System.out.println("well");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view/common/uploadInform");
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
    public @ResponseBody List<UploadInfo> UploadToDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //上传的多个文件
        List<FileListInfo> filesInform = getUploadFilePath(request, response);
        List<UploadInfo> uploadInfos = new ArrayList<>();
        UploadInfo uploadInform = null;
        for (int i = 0; i < filesInform.size(); i++) {
            uploadInform = new UploadInfo();
            FileListInfo current = filesInform.get(i);
            uploadInform.setFileName(current.getFileName());
            System.out.println(uploadInform.getFileName());
            //当前文件是否有错
            if (current.isError()) {
                //文件类型错误
                if (current.isFileTypeError()) {
                    uploadInform.setFileTypeError(true);
                    uploadInfos.add(i, uploadInform);
                    continue;
                }
//                uploadInform.html.setErrorOccur(true);
//                uploadInform.html.setErrorMessage(current.getErrorMessage());
                uploadInfos.add(i, uploadInform);
                continue;
            }
            //通过上传到服务器的文件路径，读取文件信息，操作数据
            String filePath = current.getFilePath();
            //根据第一行字段来判断文件数据应该上传到那一个表
            if (-1 != dispatcherUploadFileService.getDestination(filePath)) {
                uploadInform.setHasThisModule(true);
            }
            else {
                uploadInform.setHasThisModule(false);
                uploadInfos.add(i, uploadInform);
                continue;
            }
            Data2DBInfo data2DBInfo =excelOperateService.ExcelOperateSave(filePath);
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
                fileFolder.mkdirs();
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