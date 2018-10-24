package com.zxelec.springboot_exception.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomerExceptionHandler {

    private static final Logger Log=LoggerFactory.getLogger(CustomerExceptionHandler.class);

    /**
     * 定义全局异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    Object exceptionHandler(Exception e , HttpServletRequest request){

        Map<String,Object> mapResult = new HashMap<>();

        mapResult.put("code",100);
        mapResult.put("msg",e.getMessage());
        mapResult.put("url",request.getRequestURL());

        return mapResult;
    }


    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    Object myExceptionHandler(Exception e){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());

        return modelAndView;
    }


}
