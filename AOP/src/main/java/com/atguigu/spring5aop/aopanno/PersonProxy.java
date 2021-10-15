package com.atguigu.spring5aop.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonProxy {


    //前置通知
    //@Before 注解表示作为前置通知
    @Before(value = "execution(* com.atguigu.spring5aop.aopanno.User.add(..))")
    @Order(value = 1)//相同通知优先级
    public void before(){
        System.out.println("PERSON before -------------------");
    }
}
