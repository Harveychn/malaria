package com.edupractice.malaria.modules.login.service;

import com.edupractice.malaria.modules.login.pojo.User;

import java.util.List;

/**
 * creator : jianeneng zhang
 * time : 17-10-15 16:56
 * function
 */
public interface UserService {
    User checkLogin(String userEmail,String password) throws Exception;
    boolean checkRegister(String userEmail) throws Exception;
    void saveRegister(User User) throws Exception;
    List<User> selectCheckUser() throws Exception;
    void updateUser(String userEmail) throws Exception;
}