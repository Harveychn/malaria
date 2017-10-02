package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.domain.AddressGeocode;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "test")
public interface AddressGeocodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer addressid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int insert(AddressGeocode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int insertSelective(AddressGeocode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    @Cacheable
    AddressGeocode selectByPrimaryKey(Integer addressid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AddressGeocode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AddressGeocode record);
}