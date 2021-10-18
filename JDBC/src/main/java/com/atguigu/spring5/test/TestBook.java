package com.atguigu.spring5.test;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {


    @Test
    public void testJdbcTemplate(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book=new Book();
        book.setUserId("213");
        book.setUserName("gai");
        book.setUstatus("1");
        bookService.addBook(book);
    }

    @Test
    public void testJdbcTemplate1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book=new Book();
        book.setUserId("213");
        book.setUserName("cheng");
        book.setUstatus("1");
        bookService.updateBook(book);
    }

    @Test
    public void testJdbcTemplate2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book=new Book();
        book.setUserId("213");
        bookService.deleteBook(book);
    }

    @Test
    public void testJdbcTemplate3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        bookService.findCount();
    }


    @Test
    public void testJdbcTemplate4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Book book=new Book();
        book.setUserId("213");
        bookService.findBook(book);
    }

    @Test
    public void testJdbcTemplate5(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.findAll();
    }


    @Test
    public void testJdbcTemplate6(){
        List<Object[]> batchArgs =new ArrayList<>();
        Object[] O1={"3","java","a"};
        Object[] O2={"4","python","b"};
        Object[] O3={"5","c#","c"};
        batchArgs.add(O1);
        batchArgs.add(O2);
        batchArgs.add(O3);

        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        //调用批量添加方法
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void testJdbcTemplate7(){
        List<Object[]> batchArgs =new ArrayList<>();
        Object[] O1={"java1","a","3"};
        Object[] O2={"python1","b","4"};
        Object[] O3={"c#1","c","5"};
        batchArgs.add(O1);
        batchArgs.add(O2);
        batchArgs.add(O3);

        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        //调用批量添加方法
        bookService.batchUpdate(batchArgs);
    }

    //批量删除
    @Test
    public void testJdbcTemplate8(){
        List<Object[]> batchArgs =new ArrayList<>();
        Object[] O1={"3"};
        Object[] O2={"4"};
        Object[] O3={"5"};
        batchArgs.add(O1);
        batchArgs.add(O2);
        batchArgs.add(O3);

        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        //调用批量添加方法
        bookService.batchDelete(batchArgs);
    }




}
