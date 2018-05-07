package com.edupractice.malaria.modules.common.service;

import java.util.Map;

public interface AddressResolveService {
    Map<String,String> getGeocoderLatitude(String address)throws Exception;
    void updateAddress()throws Exception;
}
