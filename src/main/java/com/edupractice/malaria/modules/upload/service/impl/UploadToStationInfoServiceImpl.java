package com.edupractice.malaria.modules.upload.service.impl;

import com.edupractice.malaria.modules.common.dao.MeteorologicalStationMapper;
import com.edupractice.malaria.modules.common.pojo.MeteorologicalStation;
import com.edupractice.malaria.modules.common.pojo.MeteorologicalStationExample;
import com.edupractice.malaria.modules.upload.pojo.ErrorStationInfo;
import com.edupractice.malaria.modules.upload.pojo.RowDataSorted;
import com.edupractice.malaria.modules.upload.pojo.Upload2DBInfo;
import com.edupractice.malaria.modules.upload.service.UploadToStationInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Service
public class UploadToStationInfoServiceImpl implements UploadToStationInfoService {
    @Resource
    private MeteorologicalStationMapper meteorologicalStationMapper;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UploadToStationInfoServiceImpl.class);
    /**
     * 对Station表中行数据，每个单元数据进行读取处理，返回正确或错误信息
     *
     * @param cellValues
     * @return
     * @throws Exception
     */
    public RowDataSorted<MeteorologicalStation, ErrorStationInfo> MeteorologicalStationCellData(Map<String, String> cellValues) throws Exception {
        RowDataSorted<MeteorologicalStation, ErrorStationInfo> rowDataSorted = new RowDataSorted<>();
        try {
            MeteorologicalStation meteorologicalStation = new MeteorologicalStation();
            if (!cellValues.get("区站号").trim().equals(".")) {
                meteorologicalStation.setStationId(Integer.parseInt(cellValues.get("区站号")));
            }
            if (!cellValues.get("台站名称").trim().equals(".")) {
                meteorologicalStation.setStationName(cellValues.get("台站名称").trim());
            }
            if (!cellValues.get("省份").trim().equals(".")) {
                meteorologicalStation.setProvinces(cellValues.get("省份").trim());
            }
            if (!cellValues.get("纬度(度分)").trim().equals(".")) {
                meteorologicalStation.setLat(Integer.parseInt(cellValues.get("纬度(度分)").trim()));
            }
            if (!cellValues.get("经度(度分)").trim().equals(".")) {
                meteorologicalStation.setLng(Integer.parseInt(cellValues.get("经度(度分)").trim()));
            }
            if (!cellValues.get("海拔高度(0.1米)").trim().equals(".")) {
                meteorologicalStation.setAltitude(Integer.parseInt(cellValues.get("海拔高度(0.1米)")));
            }
            if (!cellValues.get("开始年份").trim().equals(".")) {
                meteorologicalStation.setStartYear(Integer.parseInt(cellValues.get("开始年份").trim()));
            }
            if (!cellValues.get("开始月份").trim().equals(".")) {
                meteorologicalStation.setStartMonth(Integer.parseInt(cellValues.get("开始月份").trim()));
            }
            if (!cellValues.get("截止年份").trim().equals(".")) {
                meteorologicalStation.setEndYear(Integer.parseInt(cellValues.get("截止年份").trim()));
            }
            if (!cellValues.get("截止月份").trim().equals(".")) {
                meteorologicalStation.setEndMonth(Integer.parseInt(cellValues.get("截止月份").trim()));
            }
            if (!cellValues.get("缺测情况").trim().equals(".")) {
                meteorologicalStation.setLackMeasurement(cellValues.get("缺测情况").trim());
            }
            rowDataSorted.setHasError(Boolean.FALSE);
            rowDataSorted.setCorrectData(meteorologicalStation);

        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
            ErrorStationInfo errorStationInfo = dealStationError(cellValues);
            rowDataSorted.setHasError(Boolean.TRUE);
            rowDataSorted.setErrorData(errorStationInfo);
        }
        return rowDataSorted;
    }

    public Upload2DBInfo saveDataToStationDB(MeteorologicalStation rowData) throws Exception {
        Upload2DBInfo upload2DBInfo = new Upload2DBInfo();
        if (null != meteorologicalStationMapper.selectByPrimaryKey(rowData.getStationId())) {
            upload2DBInfo.setNeedUpdate(true);
            upload2DBInfo.setNeedInsert(false);
        } else {
            upload2DBInfo.setNeedUpdate(false);
            upload2DBInfo.setNeedInsert(true);
        }
        try {
            MeteorologicalStation meteorologicalStation = new MeteorologicalStation();
            meteorologicalStation.setStationId(rowData.getStationId());
            meteorologicalStation.setStationName(rowData.getStationName());
            meteorologicalStation.setProvinces(rowData.getProvinces());
            meteorologicalStation.setLat(rowData.getLat());
            meteorologicalStation.setLng(rowData.getLng());
            meteorologicalStation.setAltitude(rowData.getAltitude());
            meteorologicalStation.setStartYear(rowData.getStartYear());
            meteorologicalStation.setStartMonth(rowData.getStartMonth());
            meteorologicalStation.setEndYear(rowData.getEndYear());
            meteorologicalStation.setEndMonth(rowData.getEndMonth());
            meteorologicalStation.setLackMeasurement(rowData.getLackMeasurement());
            if (upload2DBInfo.isNeedUpdate()) {
                MeteorologicalStationExample meteorologicalStationExample = new MeteorologicalStationExample();
                meteorologicalStationExample.createCriteria().andStationIdEqualTo(rowData.getStationId());
                if (1 == meteorologicalStationMapper.updateByExampleSelective(meteorologicalStation, meteorologicalStationExample)) {
                    logger.trace("meteorologicalStation更新stationID为的" + meteorologicalStation.getStationId() + "记录  成功 ");
                } else {
                    logger.error("meteorologicalStation更新stationID为的" + meteorologicalStation.getStationId() + "记录  失败 ");
                }
            }
            if (upload2DBInfo.isNeedInsert()) {
                if (1 == meteorologicalStationMapper.insert(meteorologicalStation)) {
                    logger.trace("meteorologicalStation插入stationID为的" + meteorologicalStation.getStationId() + "记录  成功 ");
                } else {
                    logger.error("meteorologicalStation插入stationID为的" + meteorologicalStation.getStationId() + "记录  失败 ");
                }
            }
        } catch (Exception e) {
            upload2DBInfo.setSuccessOp(false);
            logger.error("saveDataToStationDB(MeteorologicalStation rowData)失败 Exception信息：" + e.getMessage());
            return upload2DBInfo;
        }
        upload2DBInfo.setSuccessOp(true);
        return upload2DBInfo;
    }

    private ErrorStationInfo dealStationError(Map<String, String> cellValues) throws Exception {
        ErrorStationInfo errorStationInfo = new ErrorStationInfo();
        errorStationInfo.setStationId(cellValues.get("区站号"));
        errorStationInfo.setStationName(cellValues.get("台站名称"));
        errorStationInfo.setProvinces(cellValues.get("省份"));
        errorStationInfo.setLat(cellValues.get("纬度(度分)"));
        errorStationInfo.setLng(cellValues.get("经度(度分)"));
        errorStationInfo.setAltitude(cellValues.get("海拔高度(0.1米)"));
        errorStationInfo.setStartYear(cellValues.get("开始年份"));
        errorStationInfo.setStartMonth(cellValues.get("开始月份"));
        errorStationInfo.setEndYear(cellValues.get("截止年份"));
        errorStationInfo.setEndMonth(cellValues.get("截止月份"));
        errorStationInfo.setLackMeasurement(cellValues.get("缺测情况"));
        return errorStationInfo;
    }


}
