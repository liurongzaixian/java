package com.nicholas.java.exception;

import com.nicholas.java.vo.ErrorResult;
import com.nicholas.java.vo.ErrorResults;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author NicholasLiu
 * @date 2019/1/30
 **/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{


    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        HttpStatus statusCode = getStatus(webRequest);
        String code = String.valueOf(statusCode.value());
        if ("403".equals(code)) {
            fillingMap(errorAttributes, ErrorResults.FORBIDDEN);
            return errorAttributes;
        } else if ("404".equals(code)) {
            fillingMap(errorAttributes, ErrorResults.RESOURCENOTFOUND);
            return errorAttributes;
        }

        ErrorResult error = (ErrorResult) webRequest.getAttribute("error", RequestAttributes.SCOPE_REQUEST);
        errorAttributes.put("status", error.getStatus());
        errorAttributes.put("code", error.getCode());
        errorAttributes.put("msg", error.getMsg());

        return errorAttributes;
    }

    private HttpStatus getStatus(WebRequest webRequest) {
        Integer statusCode = (Integer) webRequest.getAttribute("javax.servlet.error.status_code", RequestAttributes.SCOPE_REQUEST);
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }


    private void fillingMap (Map<String, Object> errorAttributes, ErrorResult result) {
        errorAttributes.put("status", result.getStatus());
        errorAttributes.put("code", result.getCode());
        errorAttributes.put("msg", result.getMsg());
    }
}
