package com.nicholas.java.vo;

/**
 * @author NicholasLiu
 * @date 2019/1/30
 **/
public class OkResult<T> extends Result{

    private T data;

    public OkResult(T data) {
        super("success", "0");
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
