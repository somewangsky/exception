package com.zxelec.springboot_exception.controller;

import com.zxelec.springboot_exception.domain.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {


    @RequestMapping("test1")
    public String test1() {

        int i = 1 / 0;

        return "what are you doing!!!";
    }


    @RequestMapping("test2")
    public String test2() {

        throw new MyException(500, "myException 发生了错误");
    }
}
