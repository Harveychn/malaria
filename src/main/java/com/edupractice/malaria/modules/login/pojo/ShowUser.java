package com.edupractice.malaria.modules.login.pojo;

import java.util.Date;

public class ShowUser {

    private User user;
    private String joinDate;

    public ShowUser(User user, String joinDate) {
        this.user = user;
        this.joinDate = joinDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
