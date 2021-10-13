package com.atguigu.spring5.testDemo;

import com.atguigu.spring5.autowire.Emp;
import com.atguigu.spring5.wire.config.SpringConfig;
import com.atguigu.spring5.wire.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class wireTest {

    @Test
    public void testService(){

        //1加载spring配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("beanwire1.xml");

        //获取配置文件的对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }


    @Test
    public void testService1(){

        //1加载spring配置文件
        ApplicationContext context=
                new AnnotationConfigApplicationContext(SpringConfig.class);

        //获取配置文件的对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
