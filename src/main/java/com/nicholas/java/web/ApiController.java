package com.nicholas.java.web;

import com.nicholas.java.exception.MyException;
import com.nicholas.java.vo.ErrorResults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NicholasLiu
 * @date 2019/1/30
 **/
@RestController
public class ApiController {

    @RequestMapping(value = "/name",method = RequestMethod.POST)
    public String getUserName(@RequestParam("name") String name) {
        if("张三".equals(name)) {
            throw new MyException(ErrorResults.INVALID_TIMESTAMP);
        }
        return name;
    }

    @RequestMapping(value = "/403")
    public String getForbidden(HttpServletResponse response) throws IOException {
        response.sendError(403, "Forbidden");
        return null;
    }



}
