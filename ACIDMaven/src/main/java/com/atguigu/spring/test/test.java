package com.atguigu.spring.test;

import com.atguigu.spring.config.TxConfig;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class test {


    @Autowired
    private UserService userService;

    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferAccount();

    }

    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferAccount();

    }

    @Test
    public void test3(){
        ApplicationContext context=new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferAccount();

    }
    //函数式风格创建对象，交给spring进行管理
    @Test
    public void test4(){
        //1创建GenericApplicationContext对象
        GenericApplicationContext context=new AnnotationConfigApplicationContext();
        //2、调用context的方法对象注册
        context.refresh();
//        context.registerBean(User.class,()->new User());
        context.registerBean("user1",User.class,()->new User());
        //3获取spring注册的对象
//        User user = (User)context.getBean("user");
        User user = (User)context.getBean("user1");
        System.out.println(user);


    }


}
