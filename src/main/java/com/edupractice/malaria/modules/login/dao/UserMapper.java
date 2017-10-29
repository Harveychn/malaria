package com.edupractice.malaria.modules.login.dao;

import com.edupractice.malaria.modules.login.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByEmail(String userEmail);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}