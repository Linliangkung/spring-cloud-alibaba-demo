package com.jsako.spring.cloud.alibaba.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/12/16 13:10
 * @Description:
 */
@RestController
@RequestMapping("/123123")
public class TtController {

    @Autowired
    private TestConfig testConfig;

    @RequestMapping
    public void test(){
        String name = testConfig.getName();
        System.out.println(name);
    }
}
