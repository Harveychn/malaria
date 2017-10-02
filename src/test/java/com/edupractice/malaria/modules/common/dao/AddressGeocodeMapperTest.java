package com.edupractice.malaria.modules.common.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressGeocodeMapperTest {

    @Autowired
    private AddressGeocodeMapper addressGeocodeMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        for (int i=0;i<10;i++){
            System.out.println(addressGeocodeMapper.selectByPrimaryKey(12));
            Thread.sleep(500);
        }
    }

}