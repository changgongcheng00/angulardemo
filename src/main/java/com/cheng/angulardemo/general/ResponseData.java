package com.cheng.angulardemo.general;

import lombok.Data;

import javax.xml.ws.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ResponseData
 * @Description TODO
 * @Author cheng
 * @Date 2019/6/30 16:22
 **/
@Data
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = -9005122285200299698L;

    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "";

    private int code;

    private String msg;

    private List<T> data;

    public static <T> ResponseData<T> success(){
        ResponseData<T> response = new ResponseData();
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS_MSG);
        return response;
    }

    public static <T> ResponseData<T> error(int code,String errMsg){
        ResponseData<T> response = new ResponseData();
        response.setCode(code);
        response.setMsg(errMsg);
        return response;
    }

    public static <T> ResponseData<T> success(List<T> items){
        ResponseData<T> response = new ResponseData();
        response.setData(items);
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS_MSG);
        return response;
    }

    public static <T> ResponseData<T> error(List<T> items,int code,String errMsg){
        ResponseData<T> response = new ResponseData();
        response.setData(items);
        response.setCode(code);
        response.setMsg(errMsg);
        return response;
    }

}
