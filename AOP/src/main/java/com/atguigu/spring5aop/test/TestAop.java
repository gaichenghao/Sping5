package com.atguigu.spring5aop.test;


import com.atguigu.spring5aop.aopanno.User;
import com.atguigu.spring5aop.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAopAnno(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testAopAnno1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }


}
