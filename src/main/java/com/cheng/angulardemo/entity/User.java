package com.cheng.angulardemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{

    private static final long serialVersionUID = 58350307873341216L;

    private int id;

    private String username;

    private String password;

    private String tel;

    private int age;
}
