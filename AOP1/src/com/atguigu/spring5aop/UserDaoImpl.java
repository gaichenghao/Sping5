package com.atguigu.spring5aop;

public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a, int b) {
        System.out.println("add执行了");
        return a+b;
    }

    @Override
    public String update(String a) {
        System.out.println("update执行了");
        return a;

    }
}
