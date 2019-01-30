package com.nicholas.java.vo;

/**
 * @author NicholasLiu
 * @date 2019/1/30
 **/
public class Result {

    protected String status;

    protected String code;

    public Result(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public Result() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
