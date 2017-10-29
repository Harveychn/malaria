package com.edupractice.malaria.modules.upload.service.impl;

import com.edupractice.malaria.modules.upload.service.DispatcherUploadFileService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class DispatcherUploadFileServiceImpl implements DispatcherUploadFileService{

    public int getDestination(String filePath) throws Exception {
        int caseNum = 0;
        InputStream is = new FileInputStream(filePath);
        if (filePath.endsWith(".xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            HSSFSheet hssfSheet = workbook.getSheetAt(0);
            //第一行
            HSSFRow hssfRow = hssfSheet.getRow(0);
            List<String> fieldNames = new ArrayList<>();
            //循环第一行单元格,每一个单元格的值保存到list中
            for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
                String cellValue = hssfRow.getCell(i).getStringCellValue().trim();
                fieldNames.add(i, cellValue);
            }
            caseNum = getCaseNum(fieldNames);
        } else if (filePath.endsWith(".xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet xssfSheet = workbook.getSheetAt(0);
            XSSFRow xssfRow = xssfSheet.getRow(0);
            List<String> fieldNames = new ArrayList<>();
            for (int i = 0; i < xssfRow.getLastCellNum(); i++) {
                String cellValue = xssfRow.getCell(i).getStringCellValue().trim();
                fieldNames.add(i, cellValue);
            }
            caseNum = getCaseNum(fieldNames);
        }
        return caseNum;
    }

    /**
     * 根据上传excel文件的第一行字段名判断数据是上传到那张表
     *
     * @param fieldNames
     * @return -1:无效格式表格
     * 1：疾病信息
     * 2：气候信息
     * 3：气候站信息
     * @throws Exception
     */
    private int getCaseNum(List<String> fieldNames) throws Exception {
        if (43 == fieldNames.size()) {
            if (fieldNames.get(0).trim().equals("数据年份")
                    && fieldNames.get(1).trim().equals("卡片ID")
                    && fieldNames.get(2).trim().equals("卡片编号")
                    && fieldNames.get(3).trim().equals("卡片状态")
                    && fieldNames.get(4).trim().equals("患者姓名")
                    && fieldNames.get(5).trim().equals("性别")
                    && fieldNames.get(6).trim().equals("出生日期")
                    && fieldNames.get(7).trim().equals("年龄")
                    && fieldNames.get(8).trim().equals("患者工作单位")
                    && fieldNames.get(9).trim().equals("联系电话")
                    && fieldNames.get(10).trim().equals("病人属于")
                    && fieldNames.get(11).trim().equals("现住地址国标")
                    && fieldNames.get(12).trim().equals("现住详细地址")
                    && fieldNames.get(13).trim().equals("职业")
                    && fieldNames.get(14).trim().equals("病例分类")
                    && fieldNames.get(15).trim().equals("病例分类2")
                    && fieldNames.get(16).trim().equals("发病日期")
                    && fieldNames.get(17).trim().equals("诊断时间")
                    && fieldNames.get(18).trim().equals("死亡日期")
                    && fieldNames.get(19).trim().equals("疾病名称")
                    && fieldNames.get(20).trim().equals("订正前病种")
                    && fieldNames.get(21).trim().equals("填卡医生")
                    && fieldNames.get(22).trim().equals("医生填卡日期")
                    && fieldNames.get(23).trim().equals("报告单位地区编码")
                    && fieldNames.get(24).trim().equals("报告单位")
                    && fieldNames.get(25).trim().equals("单位类型")
                    && fieldNames.get(26).trim().equals("报告卡录入时间")
                    && fieldNames.get(27).trim().equals("录卡用户")
                    && fieldNames.get(28).trim().equals("录卡用户所属单位")
                    && fieldNames.get(29).trim().equals("县区审核时间")
                    && fieldNames.get(30).trim().equals("地市审核时间")
                    && fieldNames.get(31).trim().equals("省市审核时间")
                    && fieldNames.get(32).trim().equals("审核状态")
                    && fieldNames.get(33).trim().equals("订正报告时间")
                    && fieldNames.get(34).trim().equals("订正终审时间")
                    && fieldNames.get(35).trim().equals("终审死亡时间")
                    && fieldNames.get(36).trim().equals("订正用户")
                    && fieldNames.get(37).trim().equals("订正用户所属单位")
                    && fieldNames.get(38).trim().equals("删除时间")
                    && fieldNames.get(39).trim().equals("删除用户")
                    && fieldNames.get(40).trim().equals("删除用户所属单位")
                    && fieldNames.get(41).trim().equals("删除原因")
                    && fieldNames.get(42).trim().equals("备注")
                    ) {
                return 1;
            }
        }
        if (10 == fieldNames.size()) {
            if (fieldNames.get(0).trim().equals("区站号")
                    && fieldNames.get(1).trim().equals("年")
                    && fieldNames.get(2).trim().equals("月")
                    && fieldNames.get(3).trim().equals("日")
                    && fieldNames.get(4).trim().equals("平均气温")
                    && fieldNames.get(5).trim().equals("日最低气温")
                    && fieldNames.get(6).trim().equals("日最高气温")
                    && fieldNames.get(7).trim().equals("20-20时降水量")
                    && fieldNames.get(8).trim().equals("最小相对湿度")
                    && fieldNames.get(9).trim().equals("平均相对湿度")) {
                return 2;
            }
        }
        //-1 表示出现错误，不存在该字段值的文件模板
        return -1;
    }

}
