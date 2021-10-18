package com.atguigu.spring5.service;


import com.atguigu.spring5.dao.BookDao;
import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //注入dao
    @Autowired
    public BookDao bookDao;

    //添加的方法
    public void addBook(Book book){

        bookDao.add(book);

    }

    //更新的方法
    public void updateBook(Book book){

        bookDao.update(book);

    }

    //删除的方法
    public void deleteBook(Book book){

        bookDao.delete(book);

    }

    //查询记录数
    public int findCount(){

        int count = bookDao.selectCount();
        return count;

    }

    //查询返回对象
    public Book findBook(Book book) {
        Book result = bookDao.findBook(book);
        return result;
    }


    //查询返回对象集合
    public List<Book> findAll() {
        List<Book> result = bookDao.findAllBook();
        return result;
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }

    //批量修改
    public void batchUpdate(List<Object[]> batchArgs) {
        bookDao.batchUpdateBook(batchArgs);
    }

    //批量删除
    public void batchDelete(List<Object[]> batchArgs) {
        bookDao.batchDeleteBook(batchArgs);
    }
}
