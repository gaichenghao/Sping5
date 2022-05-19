package com.atguigu.webfluxdemo1.handler;

import com.atguigu.webfluxdemo1.entity.User;
import com.atguigu.webfluxdemo1.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author gaich
 * @date 2022/5/19
 * @apiNote
 */
public class UserHandler {

    private UserService userService;
    public UserHandler(UserService userService){
        this.userService=userService;
    }

    //根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest serverRequest){
        //获取id值
        int id = Integer.valueOf(serverRequest.pathVariable("id"));
        //空值处理
        Mono<ServerResponse> build = ServerResponse.notFound().build();



        //调用service方法得到数据
        Mono<User> userMono = this.userService.getUserById(id);

        //把userMono进行转换返回
        //使用Reactor 操作符flatmap
        return userMono

                .flatMap(person->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(person)))
                .switchIfEmpty(build);

    }
    //查询所有
    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest){
        //调用service得到结果
        Flux<User> allUser = this.userService.getAllUser();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allUser,User.class);
    }

    //添加
    public Mono<ServerResponse> saveUser(ServerRequest serverRequest){

        //得到user对象
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));

    }
}
