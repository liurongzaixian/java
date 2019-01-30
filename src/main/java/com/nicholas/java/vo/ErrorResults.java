package com.nicholas.java.vo;

/**
 * @author NicholasLiu
 * @date 2019/1/30
 **/
public class ErrorResults {

    public static final ErrorResult ERROR = new ErrorResult("1", "error");
    public static final ErrorResult INVALID_TIMESTAMP = new ErrorResult("108", "Invalid Timestamp");
    public static final ErrorResult MISSING_PARAMS = new ErrorResult("400", "missing params");
    public static final ErrorResult FORBIDDEN = new ErrorResult("403", "forbidden");
    public static final ErrorResult RESOURCENOTFOUND = new ErrorResult("404", "not found");
    public static final ErrorResult METHODERROR = new ErrorResult("405", "request method error");

}
