package com.atguigu.spring5aop.aopanno;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect//生成代理对象
public class UserProxy {


    //前置通知
    //@Before 注解表示作为前置通知
    @Before(value = "execution(* com.atguigu.spring5aop.aopanno.User.add(..))")
    public void before(){
        System.out.println("before -------------------");
    }
}
