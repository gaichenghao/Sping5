package com.atguigu.spring5aop.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect//生成代理对象
public class UserProxy {



    //相同的切入点抽取
    @Pointcut(value = "execution(* com.atguigu.spring5aop.aopanno.User.add(..))")
    public void pointdemo(){

    }



    //前置通知
    //@Before 注解表示作为前置通知
    @Before(value = "pointdemo()")
    @Order(value = 2)
    public void before(){
        System.out.println("before -------------------");
    }

    //最终通知
    @After(value = "execution(* com.atguigu.spring5aop.aopanno.User.add(..))")
    public void after(){
        System.out.println("after -------------------");
    }

    //后置通知 （返回通知）
    @AfterReturning(value = "execution(* com.atguigu.spring5aop.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning -------------------");
    }


    //异常通知
    @AfterThrowing(value = "execution(* com.atguigu.spring5aop.aopanno.User.add(..))")
    public void afterThrowing(){
        System.out.println("AfterThrowing -------------------");
    }

    //环绕通知
    @Around(value = "execution(* com.atguigu.spring5aop.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        System.out.println("环绕之前 -------------------");

        //被增强方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后 -------------------");
    }



}
