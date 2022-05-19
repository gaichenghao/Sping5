package com.atguigu.demoreactor.rector;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author gaich
 * @date 2022/5/18
 * @apiNote
 */
public class TestReactor {

    public static void main(String[] args) {
        //just方法直接声明

        Flux.just(1,2,3,5).subscribe(System.out::println);
        Mono.just(1).subscribe(System.out::println);
        ////其他的方法
        //Integer[] array={1,2,3,5};
        //Flux.fromArray(array);
        //
        //List<Integer> integers = Arrays.asList(array);
        //Flux.fromIterable(integers);
        //
        //Stream<Integer> stream=integers.stream();
        //Flux.fromStream(stream);

    }
}
