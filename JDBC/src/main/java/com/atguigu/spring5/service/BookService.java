package com.atguigu.spring5.service;


import com.atguigu.spring5.dao.BookDao;
import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //查询记录
    public Book findBook(Book book) {
        Book result = bookDao.findBook(book);
        return result;
    }
}
