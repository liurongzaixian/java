package com.nicholas.java.web.support;

import com.nicholas.java.exception.MyException;
import com.nicholas.java.vo.ErrorResult;
import com.nicholas.java.vo.ErrorResults;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author NicholasLiu
 * @date 2019/1/30
 **/
@ControllerAdvice
public class ExceptionController {

    /**
     * 自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MyException.class)
    public String handlerForMyException(HttpServletRequest request,MyException ex) {
        request.setAttribute("javax.servlet.error.status_code", 500);
        request.setAttribute("error",ex.getResult());
        return "forward:/error";
    }

    /**
     * 405 请求方法错误
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String handlerForHttpRequestMethodNotSupportedException(HttpServletRequest request, Throwable ex) {
        request.setAttribute("error",new ErrorResult("405",ex.getMessage()));
        return "forward:/error";
    }
    /**
     * 全局系统异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    public String handlerForException(HttpServletRequest request, Throwable ex) {
        request.setAttribute("error",ErrorResults.ERROR);
        return "forward:/error";
    }
    /**
     * 400 参数错误
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String handlerForMissingServletRequestParameterException(HttpServletRequest request, Throwable ex) {
        request.setAttribute("error", ErrorResults.MISSING_PARAMS);
        return "forward:/error";
    }



}
