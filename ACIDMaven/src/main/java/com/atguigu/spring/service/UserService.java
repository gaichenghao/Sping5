package com.atguigu.spring.service;


import com.atguigu.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)//可重复读
public class UserService {

    //注入dao
    @Autowired
    private UserDao userDao;

    //转账



    public void transferAccount(){


        //try {
            //开启事务



            //减少100
            userDao.reduceMoney();

            //模拟异常
            int i=10/0;
            //增加100
            userDao.addMoney();
            //没有发生异常 提交事务

       // }catch (Exception ex)
       // {
            //出现异常 回滚

        //}



    }


}
