package com.edupractice.malaria.modules.login.dao;

import com.edupractice.malaria.modules.login.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * creator : jianeneng zhang
 * time : 17-10-15 17:02
 * function
 */
@Repository
public interface UserExpandMapper {
    List<User> selectCheckUser();
    void updateCheckUserAgree(String userEmail);
    void updateCheckUserReject(String userEmail);
    void deleteCheckUser(String uerEmail);

}
