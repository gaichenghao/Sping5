package com.atguigu.spring5.wire.service;


import com.atguigu.spring5.wire.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


//在注解里面value属性值可以省略不写，
//默认值是类名称，首字母小写

//@Component(value = "userService")
@Service
public class UserService {

    //定义dao类型属性
    //不需要加set方法
    //添加注入属性注解
//    @Autowired //根据类型进行注入
//    @Qualifier(value="userDaoImpl1")//根据名称进行注入
//    private UserDao userDao;

    //@Resource//根据类型进行注入
    @Resource(name = "userDaoImpl1")//根据名称进行注入
    private UserDao userDao;

    public void add(){
        System.out.println("service add------------"+name);
        userDao.add();
    }

    @Value(value = "abc") //注入普通类型
    private String name;
}
