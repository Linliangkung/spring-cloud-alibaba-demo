package com.jsako.spring.cloud.alibaba.webflux.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/5/18 16:44
 * @Description:
 */
public class TestReactor {

//    public static void main(String[] args) {
//        Mono.defer(() -> Mono.just(1)).subscribe(integer -> System.out.println(1));
//    }

//    public static void main(String[] args) {
//        Flux.just(31231,32132).then(Mono.just("nima")).doOnDiscard(Integer.class,s -> System.out.println("discard"+s)).subscribe(System.out::println);
//    }

//    public static void main(String[] args) {
//        Flux<String> bridge = Flux.create(sink -> {
//            sink.onRequest(n -> {
//                System.out.println(n);
//                sink.next("3213213");
//            });
//        });
//        bridge.subscribe(System.out::println);
//    }

    public static void main(String[] args) {

    }
}
