package com.nicholas.java.vo;

/**
 * @author NicholasLiu
 * @date 2019/1/30
 **/
public class ErrorResult extends Result{

    private String msg;

    public ErrorResult(String code,String msg) {
        super("error", code);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
