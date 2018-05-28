package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.AddressGeocode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressResolveMapper {
    AddressGeocode selectAddress(int addressId)throws Exception;
    void updateAddress(AddressGeocode addressGeocode)throws Exception;
}
