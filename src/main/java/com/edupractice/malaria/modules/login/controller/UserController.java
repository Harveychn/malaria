package com.edupractice.malaria.modules.login.controller;

import com.edupractice.malaria.modules.login.pojo.ShowUser;
import com.edupractice.malaria.modules.login.service.UserService;
import com.edupractice.malaria.modules.login.pojo.User;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * creator : jianeneng zhang
 * time : 17-10-15 16:53
 * function
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/exitToUserUI")
    public ModelAndView exitToUserUI() throws Exception {
        return new ModelAndView("view/common/exitedTip");
    }

    @RequestMapping(value = "/loginView", method = RequestMethod.GET)
    public ModelAndView loginView(String errorMessage,String userCount) throws Exception {
        System.out.println(errorMessage);
        System.out.println(userCount);
        return new ModelAndView("view/common/login") ;
    }

    @RequestMapping(value = "/registerView", method = RequestMethod.GET)
    public ModelAndView registerView() throws Exception {
        return new ModelAndView("view/common/register");
    }

    @RequestMapping(value = "/{authorizationStatus}")
    public ModelAndView getAdminView(@PathVariable("authorizationStatus") int authorizationStatus) throws Exception {
        return new ModelAndView("view/common/AdminUI");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(User user) throws Exception {
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPassword());
        User userChecked = userService.checkLogin(user.getUserEmail(), user.getUserPassword());
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(userChecked);
        if (null != userChecked) {
            modelAndView.addObject("user", user);
            //系统管理员页面
            if (userChecked.getUserRole().equals("3")) {
                modelAndView.setViewName("view/common/systemAdminUI");
            }
            //管理员界面
            if (userChecked.getUserRole().equals("2")) {
                modelAndView.setViewName("view/common/AdminUI");
            }
            return modelAndView;
        } else {
            modelAndView.addObject("errorMessage", "用户名或密码错误");
            if (null != user.getUserEmail() && !"".equals(user.getUserEmail())) {
                modelAndView.addObject("userCount", user.getUserEmail());
            }
            modelAndView.setViewName("redirect:/user/loginView");
            return modelAndView;
        }
    }

    @RequestMapping("/register")
    public ModelAndView userRegister(User user) throws Exception {
        boolean registerType = userService.checkRegister(user.getUserEmail());
        ModelAndView modelAndView = new ModelAndView();
        if (registerType) {
            userService.saveRegister(user);
            modelAndView.setViewName("view/common/login");
        }
        return modelAndView;
    }

    @RequestMapping("/showCheckUser")
    public ModelAndView showCheckUser() throws Exception {
        List<User> users = userService.selectCheckUser();
        List<ShowUser> users1 = new ArrayList<>();
        ShowUser showUser =new ShowUser();
        for (int i = 0; i < users.size(); i++) {
            showUser.setUser(users.get(i));
            showUser.setJoinDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(users.get(i).getJoinDate()));
            users1.add(showUser);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("checkUser", users1);
        modelAndView.setViewName("view/common/checkUser");
        return modelAndView;
    }

    @RequestMapping("/checkUserAgree/{userEmail}")
    public int checkUserAgree(@PathVariable String userEmail) throws Exception {
        userService.updateUserAgree(userEmail);
        return 1;
    }

    @RequestMapping("/checkUserReject/{userEmail}")
    public int checkUserReject(@PathVariable String userEmail)throws Exception{
        userService.updateUserReject(userEmail);
        return 1;
    }

    @RequestMapping("/Reject")
    public ModelAndView reject(User user)throws Exception{
        return  new ModelAndView();
    }
}
