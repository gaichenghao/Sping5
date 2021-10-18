package com.atguigu.spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //少钱
    @Override
    public void reduceMoney() {

        String sql="update t_account set money=money-? where username=?";

        int mary = jdbcTemplate.update(sql, 100, "Mary");
        System.out.println(mary);

    }



    @Override
    public void addMoney() {

        String sql="update t_account set money=money+? where username=?";

        int mary = jdbcTemplate.update(sql, 100, "lucy");
        System.out.println(mary);

    }


}
