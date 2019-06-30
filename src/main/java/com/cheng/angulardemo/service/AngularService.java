package com.cheng.angulardemo.service;

import com.cheng.angulardemo.entity.User;

import java.util.List;

/**
 * @ClassName AngularService
 * @Description TODO
 * @Author cheng
 * @Date 2019/6/26 23:22
 **/
public interface AngularService {

    List<User> getUser();

    User getUserDetail(int id);

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);
}
