package com.jsako.spring.cloud.alibaba.consumer.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Duration;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/12/16 13:09
 * @Description:
 */
@ConfigurationProperties("test")
@Component
@RefreshScope
public class TestConfig {

    @PostConstruct
    public void init() throws InterruptedException {
//        Thread.sleep(10000);
        System.out.println("123");
    }

    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }

    private String name;

    private Duration test;

    public Duration getTest() {
        return test;
    }

    public void setTest(Duration test) {
        this.test = test;
    }

    public String getName()  {
//        try {
//            Thread.sleep(60000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return name;
    }

    public String get() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
