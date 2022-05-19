package com.atguigu.webfluxdemo1.service.impl;

import com.atguigu.webfluxdemo1.entity.User;
import com.atguigu.webfluxdemo1.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaich
 * @date 2022/5/18
 * @apiNote
 */
@Service
public class UserServiceImpl implements UserService {

    //创建map集合 存储数据
    private final Map<Integer,User> userMap=new HashMap<>();


    public UserServiceImpl(){
        this.userMap.put(1,new User("lucy","nan",20));
        this.userMap.put(2,new User("mary","nv",30));
        this.userMap.put(3,new User("jack","nv",50));
    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.userMap.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.userMap.values());
    }

    //添加用户
    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person->{
            //向map集合里面放值
            int i = userMap.size() + 1;
            userMap.put(1,person);
        }).thenEmpty(Mono.empty());
    }
}
