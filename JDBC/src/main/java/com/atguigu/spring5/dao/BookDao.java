package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);


    void update(Book book);

    void delete(Book book);


    //查询记录数
    int selectCount();

    //查询记录
    Book findBook(Book book);

    //查询集合
    List<Book> findAllBook();

    //批量添加
    void batchAddBook(List<Object[]> batchArgs);

    //批量修改
    void batchUpdateBook(List<Object[]> batchArgs);

    //批量删除
    void batchDeleteBook(List<Object[]> batchArgs);
}
