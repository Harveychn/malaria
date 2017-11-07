package com.edupractice.malaria.modules.download.dao;

import com.edupractice.malaria.modules.download.pojo.CategoryFieldsRe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryFieldsMapper {
    List<CategoryFieldsRe> selectCategoryFields(String Disease) throws  Exception;

}
