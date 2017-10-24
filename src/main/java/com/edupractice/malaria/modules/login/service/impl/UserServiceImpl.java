package com.edupractice.malaria.modules.login.service.impl;

import com.edupractice.malaria.modules.login.service.UserService;
import com.edupractice.malaria.modules.login.dao.UserExpandMapper;
import com.edupractice.malaria.modules.login.pojo.User;
import com.edupractice.malaria.modules.login.dao.UserMapper;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * creator : jianeneng zhang
 * time : 17-10-15 16:49
 * function
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private UserExpandMapper userExpandMapper;

    //登陆方法的实现，从html页面获取userEmail与userPassword与user中的userPassword比较
    public User checkLogin(String userEmail,String password) throws Exception {
        System.out.println(userEmail);
        System.out.println(password);
        User user = userMapper.selectByEmail(userEmail);
        //邮箱未注册
        if (null == user) {
            return null;
        }
        //已审核
        if (user.getIsChecked().equals("1")) {
            //密码正确
            if(user.getUserPassword().equals(password))
            {
                System.out.println(user);
                return user;
            }
        }
        //未审核或密码错误
        return null;
    }

    //判断是否已被注册方法的实现，从html页面获取userEmail与user中的userEmail比较
    public boolean checkRegister(String userEmail) throws Exception {
        User User = userMapper.selectByEmail(userEmail);
        if (User == null)
            return true;
        else
            return false;
    }

    //注册方法的实现
    public void saveRegister(User user) throws Exception {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        Date d = df.parse(time);
        user.setIsChecked("0");
        user.setUserRole("0");
        user.setJoinDate(d);
        userMapper.insert(user);
    }

    //审核页面获取user表中的待审核用户信息
    public List<User> selectCheckUser() throws Exception {
        return userExpandMapper.selectCheckUser();
    }

    //更新check_user中的isChecked和userRole
    public void updateUser(String userEmail) throws Exception {
        userExpandMapper.updateCheckUser(userEmail);
    }

}
