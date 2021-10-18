package com.atguigu.spring5.dao;


import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{


    //注入JdbcTemplate
    @Autowired
    public JdbcTemplate jdbcTemplate;


    //添加的方法
    @Override
    public void add(Book book) {
        //创建sql语句
        String SQL="INSERT INTO `t_book`(`user_id`, `username`, `ustatus`) VALUES (?,?,?);\n";
        //调用方法实现
        Object[] args={ book.getUserId(), book.getUserName(), book.getUstatus()};
        int update = jdbcTemplate.update(SQL,args);
        System.out.println(update);
    }

    //修改的方法
    @Override
    public void update(Book book) {
        //创建sql语句
        String SQL="UPDATE `t_book` SET `username` = ?, `ustatus` = ? WHERE `user_id` = ?;\n";
        //调用方法实现
        Object[] args={book.getUserName(),book.getUstatus(), book.getUserId() };
        int update = jdbcTemplate.update(SQL,args);
        System.out.println(update);

    }

    //删除的方法
    @Override
    public void delete(Book book) {

        //创建sql语句
        String SQL="DELETE FROM `t_book` WHERE `user_id` = ?;\n";
        //调用方法实现
        Object[] args={ book.getUserId() };
        int update = jdbcTemplate.update(SQL,args);
        System.out.println(update);

    }


    //查询记录数
    @Override
    public int selectCount() {

        //创建sql语句
        String SQL="SELECT count(*) FROM `t_book`";

        Integer find = jdbcTemplate.queryForObject(SQL,Integer.class);
        System.out.println(find);
        return find;


    }

    //查询返回对象
    @Override
    public Book findBook(Book book) {
        //创建sql语句
        String SQL="SELECT * FROM `t_book` where user_id=2";



        Book book1 = jdbcTemplate.queryForObject(SQL,new BeanPropertyRowMapper<Book>(Book.class));
        System.out.println(book1);
        return book1;
    }

    @Override
    public List<Book> findAllBook() {
                //创建sql语句
        String SQL="SELECT * FROM `t_book`";



        List<Book> book1 = jdbcTemplate.query(SQL,new BeanPropertyRowMapper<Book>(Book.class));
        System.out.println(book1);
        return book1;
    }

    //批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {

        String sql="insert into t_book values (?,?,?)";

        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString( ints));

    }

    //批量添加
    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {

        //创建sql语句
        String SQL="UPDATE `t_book` SET `username` = ?, `ustatus` = ? WHERE `user_id` = ?;\n";

        int[] ints = jdbcTemplate.batchUpdate(SQL, batchArgs);
        System.out.println(Arrays.toString( ints));

    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        //创建sql语句
        String SQL="DELETE FROM `t_book` WHERE `user_id` = ?;\n";


        int[] ints = jdbcTemplate.batchUpdate(SQL, batchArgs);
        System.out.println(Arrays.toString( ints));
    }
}
