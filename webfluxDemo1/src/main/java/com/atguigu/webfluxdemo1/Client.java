package com.atguigu.webfluxdemo1;

import com.atguigu.webfluxdemo1.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author gaich
 * @date 2022/5/19
 * @apiNote
 */
public class Client {

    public static void main(String[] args) {

        //调用服务区的管理
        WebClient webClient=WebClient.create("http://127.0.0.1:6749");

        //根据id查询
        String id="1";
        User block = webClient.get().uri("/users/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class)
                .block();
        System.out.println(block.getName());

        //查询所有
        Flux<User> userFlux = webClient.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
        userFlux.map(stu->stu.getName()).buffer().doOnNext(System.out::println).blockFirst();



    }
}
