package com.edupractice.malaria.modules.common.service.impl;

import com.edupractice.malaria.modules.common.dao.AddressResolveMapper;
import com.edupractice.malaria.modules.common.pojo.AddressGeocode;
import com.edupractice.malaria.modules.common.service.AddressResolveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressResolveServiceImpl implements AddressResolveService {
    @Resource
    private AddressResolveMapper addressResolveMapper;
    @Resource
    private AddressResolveService addressResolveService;

    @Override
    public Map<String, String> getGeocoderLatitude(String address) throws Exception {
        BufferedReader in = null;
        try {
            //将地址转换成utf-8的16进制
            address = URLEncoder.encode(address, "UTF-8");
            URL tirc = new URL("http://api.map.baidu.com/geocoder?address=" + address + "&output=json&key=" + "r7HZ9G3PvvzKqG7uhjLXRbRG99gfRGvO");

            in = new BufferedReader(new InputStreamReader(tirc.openStream(), "UTF-8"));
            String res;
            StringBuilder sb = new StringBuilder("");
            while ((res = in.readLine()) != null) {
                sb.append(res.trim());
            }
            String str = sb.toString();
            Map<String, String> map = null;
            if (StringUtils.isNotEmpty(str)) {
                int lngStart = str.indexOf("lng\":");
                int lngEnd = str.indexOf(",\"lat");
                int latEnd = str.indexOf("},\"precise");
                if (lngStart > 0 && lngEnd > 0 && latEnd > 0) {
                    String lng = str.substring(lngStart + 5, lngEnd);
                    String lat = str.substring(lngEnd + 7, latEnd);
                    map = new HashMap<String, String>();
                    map.put("lng", lng);
                    map.put("lat", lat);
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void updateAddress() throws Exception {
//        List<AddressGeocode> addressGeocodeList = addressResolveMapper.selectAddress();
//        for(AddressGeocode addressGeocode:addressGeocodeList){
        for (int i=859;i<10000;i++) {
            AddressGeocode addressGeocode = addressResolveMapper.selectAddress(i);
            String address = addressGeocode.getAddress();
            Map<String, String> json = addressResolveService.getGeocoderLatitude(address);
            addressGeocode.setLng(json.get("lng"));
            addressGeocode.setLat(json.get("lat"));
            addressResolveMapper.updateAddress(addressGeocode);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
