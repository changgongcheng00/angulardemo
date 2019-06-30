package com.cheng.angulardemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permisssion implements Serializable{


    private static final long serialVersionUID = 5944096030835700198L;
    /**
     * id
     */
    private int id;

    /**
     * 审批类型
     */
    private String permissionName;
}
