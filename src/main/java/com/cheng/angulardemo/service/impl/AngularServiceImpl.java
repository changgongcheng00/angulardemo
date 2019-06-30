package com.cheng.angulardemo.service.impl;

import com.cheng.angulardemo.dao.AngularDao;
import com.cheng.angulardemo.entity.User;
import com.cheng.angulardemo.service.AngularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AngularServiceImpl
 * @Description TODO
 * @Author cheng
 * @Date 2019/6/26 23:22
 **/
@Service
public class AngularServiceImpl implements AngularService{

    @Autowired
    AngularDao angularDao;


    @Override
    public List<User> getUser() {
        return angularDao.getUser();
    }

    @Override
    public User getUserDetail(int id) {
        return angularDao.getUserDetail(id);
    }

    @Override
    public void addUser(User user) {
        angularDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        angularDao.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        angularDao.removeUser(id);
    }
}
