package com.atguigu.spring5.testDemo;

import com.atguigu.spring5.autowire.Emp;
import com.atguigu.spring5.bean.Orders;
import com.atguigu.spring5.collectiontype.Book;
import com.atguigu.spring5.collectiontype.Course;
import com.atguigu.spring5.collectiontype.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBean2 {
    @Test
    public void test1(){
        //1加载spring配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean5.xml");

        //获取配置文件的对象
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @Test
    public void test2(){
        //1加载spring配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean6.xml");

        //获取配置文件的对象
        Book book = context.getBean("book", Book.class);
        book.test();
    }

    @Test
    public void test3(){
        //1加载spring配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean7.xml");

        //获取配置文件的对象
        Course course1 = context.getBean("myBean", Course.class);
        Course course2 = context.getBean("myBean", Course.class);
        System.out.println(course1);
        System.out.println(course2);
    }

    @Test
    public void test4(){
        //1加载spring配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean8.xml");

        //获取配置文件的对象
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建Bean实例对象");
        System.out.println(orders);

        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test5(){
        //1加载spring配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean9.xml");

        //获取配置文件的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
