package com.cheng.angulardemo.controller;

import com.cheng.angulardemo.entity.User;
import com.cheng.angulardemo.general.ResponseData;
import com.cheng.angulardemo.service.AngularService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName AngularController
 * @Description TODO
 * @Author cheng
 * @Date 2019/6/26 23:21
 **/
@RestController
public class AngularController {

    private static final Logger logger = LoggerFactory.getLogger(AngularController.class);
    
    @Autowired
    AngularService angularService;

    @GetMapping(value = "/getUser")
    public List<User> getUser(){
        return angularService.getUser();
    }

    @GetMapping(value = "/getUserDetail")
    public User getUserDetail(@RequestParam String id){
          return angularService.getUserDetail(Integer.parseInt(id));
    }

    @PostMapping(value = "/addUser")
    public ResponseData addUser(@RequestBody User user){
        try {
            angularService.addUser(user);
        }catch (DuplicateKeyException e){
            logger.error(e.toString());
            return ResponseData.error(500,"用户名已存在");
        }catch (Exception e) {
            logger.error(e.toString());
            return ResponseData.error(500,"系统错误");
        }
        return ResponseData.success();
    }

    @PostMapping(value = "/updateUser")
    public ResponseData updateUser(@RequestBody User user){
        try {
            angularService.updateUser(user);
        }catch (DuplicateKeyException e){
            logger.error(e.toString());
            return ResponseData.error(500,"用户名已存在");
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseData.error(500,"系统错误");
        }
        return ResponseData.success();
    }
    @DeleteMapping(value = "/removeUser")
    public ResponseData removeUser(@RequestParam String id){
        try {
            angularService.removeUser(Integer.parseInt(id));
        } catch (Exception e) {
            return ResponseData.error(500,"系统错误");
        }
        return ResponseData.success();
    }
}
