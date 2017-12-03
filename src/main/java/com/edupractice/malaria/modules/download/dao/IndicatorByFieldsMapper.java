package com.edupractice.malaria.modules.download.dao;

import com.edupractice.malaria.modules.common.pojo.Indicator;
import com.edupractice.malaria.modules.download.pojo.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IndicatorByFieldsMapper {
    List<Indicator> selectIndicatorByFields(List<String> displayFields) throws Exception;
    List<String> selectBelongTables() throws Exception;
    List<Map<String,Object>> selectData(SQLQuery sqlQuery)throws Exception;
    List<Indicator> selectIndicatorOfDisease()throws Exception;
}