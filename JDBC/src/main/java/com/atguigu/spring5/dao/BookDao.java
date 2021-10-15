package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;

public interface BookDao {
    void add(Book book);


    void update(Book book);

    void delete(Book book);


    //查询记录数
    int selectCount();

    //查询记录
    Book findBook(Book book);
}
