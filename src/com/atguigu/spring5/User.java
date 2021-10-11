package com.atguigu.spring5;


import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class User {

    private String name;

    private int age;

    public void add(){
        System.out.println("add--------------");
    }

    public User(){
        System.out.println("无参构造");
    }

    public User(String name){
        this.name=name;
    }
}
