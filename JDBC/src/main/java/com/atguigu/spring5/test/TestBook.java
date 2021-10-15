package com.atguigu.spring5.test;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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



}
