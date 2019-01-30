package com.nicholas.java.exception;

import com.nicholas.java.vo.ErrorResult;

/**
 * @author NicholasLiu
 * @date 2019/1/30
 **/
public class MyException extends RuntimeException{

    private ErrorResult result;

    public MyException(ErrorResult result) {
        this.result = result;
    }

    public ErrorResult getResult() {
        return result;
    }
}
