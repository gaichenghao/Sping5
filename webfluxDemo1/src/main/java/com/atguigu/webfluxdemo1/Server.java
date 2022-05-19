package com.atguigu.webfluxdemo1;

import com.atguigu.webfluxdemo1.handler.UserHandler;
import com.atguigu.webfluxdemo1.service.UserService;
import com.atguigu.webfluxdemo1.service.impl.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @author gaich
 * @date 2022/5/19
 * @apiNote
 */
public class Server {

    public static void main(String[] args) throws Exception {
        Server server=new Server();
        server.createReatorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //1、创建Router路由
    public RouterFunction<ServerResponse> routerFunction(){
        //创建handler对象
        UserService userService=new UserServiceImpl();
        UserHandler handler=new UserHandler(userService);

        //设置路由
        return RouterFunctions.route(
                GET("/users/{id}").and(accept(APPLICATION_JSON)),handler::getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)),handler::getAllUsers);
    }
    //3、创建服务器完成适配
    public void createReatorServer(){
        //路由和handler适配
        RouterFunction<ServerResponse> routerFunction = routerFunction();
        HttpHandler httpHandler = toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter reactorHttpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);

        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(reactorHttpHandlerAdapter).bindNow();
    }
}
