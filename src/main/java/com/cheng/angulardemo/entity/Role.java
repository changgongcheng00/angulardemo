package com.cheng.angulardemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable{

    private static final long serialVersionUID = -574414361158397343L;
    /**
     * id
     */
    private int id;

    /**
     * 角色名称
     */
    private String rolename;
}
