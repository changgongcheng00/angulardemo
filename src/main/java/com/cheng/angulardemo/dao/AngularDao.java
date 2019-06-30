package com.cheng.angulardemo.dao;

import com.cheng.angulardemo.entity.User;

import java.util.List;

public interface AngularDao {

    List<User> getUser();

    User getUserDetail(int id);

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

}
