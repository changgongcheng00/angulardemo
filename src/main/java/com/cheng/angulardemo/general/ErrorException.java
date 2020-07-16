package com.cheng.angulardemo.general;

import lombok.Data;

/**
 * @ClassName ErrorException
 * @Description TODO
 * @Author cheng
 * @Date 2019/7/2 19:53
 **/
@Data
public class ErrorException {

    public static final int ERROR = 500;
    public static final int REPEAT_ERROR = 300;
    public static final int NO_REPEAT_ERROR = 400;
}
