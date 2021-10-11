package com.atguigu.spring5.testDemo;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {


    @Test
    public void testAdd(){

        //1加载spring配置文件
        //BeanFactory的子接口，更强大
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");

        //BeanFactory context=
                new ClassPathXmlApplicationContext("bean1.xml");
        //获取配置文件的对象
        User user = context.getBean("user", User.class);
        user.setName("aaa");
        user.setAge(123);
        user.add();
        System.out.println(user);
        Class<User> userClass = User.class;
        String name = userClass.getName();

        System.out.println(name);

    }

    @Test
    public void testBook1(){

        //1加载spring配置文件
        //BeanFactory的子接口，更强大
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");

        //BeanFactory context=
        new ClassPathXmlApplicationContext("bean1.xml");
        //获取配置文件的对象
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.tsetBool1();

    }

    @Test
    public void testOrder1(){

        //1加载spring配置文件
        //BeanFactory的子接口，更强大
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");

        //BeanFactory context=
        new ClassPathXmlApplicationContext("bean1.xml");
        //获取配置文件的对象
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        orders.tsetOrder1();

    }
}
