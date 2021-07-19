package com.jsako.spring.cloud.alibaba.webflux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/5/18 12:26
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping
    public Flux<Integer> test() throws InterruptedException {
        Thread.sleep(10000L);
        return Flux.fromStream(Stream.of(123, 321));
    }


}
