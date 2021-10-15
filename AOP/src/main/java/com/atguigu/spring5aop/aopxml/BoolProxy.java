package com.atguigu.spring5aop.aopxml;

import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

public class BoolProxy {



    //前置通知
    //@Before 注解表示作为前置通知
//    @Before(value = "pointdemo()")
//    @Order(value = 2)
    public void before(){
        System.out.println("before -------------------");
    }


}
