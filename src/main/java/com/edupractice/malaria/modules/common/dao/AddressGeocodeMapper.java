package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.AddressGeocode;
import com.edupractice.malaria.modules.common.pojo.AddressGeocodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressGeocodeMapper {
    int countByExample(AddressGeocodeExample example);

    int deleteByExample(AddressGeocodeExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(AddressGeocode record);

    int insertSelective(AddressGeocode record);

    List<AddressGeocode> selectByExample(AddressGeocodeExample example);

    AddressGeocode selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") AddressGeocode record, @Param("example") AddressGeocodeExample example);

    int updateByExample(@Param("record") AddressGeocode record, @Param("example") AddressGeocodeExample example);

    int updateByPrimaryKeySelective(AddressGeocode record);

    int updateByPrimaryKey(AddressGeocode record);
}