package com.edupractice.malaria.modules.common.service;

import com.edupractice.malaria.modules.common.dao.AddressResolveMapper;
import com.edupractice.malaria.modules.common.pojo.AddressGeocode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressResolveServiceTest {
    @Resource
    private  AddressResolveService addressResolveService;
    @Resource
    private AddressResolveMapper addressResolveMapper;
    @Test
    public void test()throws Exception{
//        AddressGeocode addressGeocode=addressResolveMapper.selectAddress();
//        System.out.println(addressGeocode.getAddressId());
//        System.out.println(addressGeocode.getAddress());
//        String address=addressGeocode.getAddress();
////        String address="浦东区张杨路1725号";
//        Map<String,String> json=addressResolveService.getGeocoderLatitude(address);
//        addressGeocode.setLng(json.get("lng"));
//        addressGeocode.setLat(json.get("lat"));
//        System.out.println(addressGeocode.getLng());
//        System.out.println(addressGeocode.getLat());
//        addressResolveMapper.updateAddress(addressGeocode);
        addressResolveService.updateAddress();
    }
}