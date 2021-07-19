package com.jsako.spring.cloud.alibaba.consumer.controller;

import com.jsako.spring.cloud.alibaba.consumer.client.HelloClient2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/8/12 15:26
 * @Description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    private String test;

    @Value("${test}")
    public void setTest(String test) {
        this.test = test;
    }

    @PostConstruct
    public void init(){
//        try {
//            //Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    @Autowired
    private Environment environment;

    @Autowired
    private HelloClient2 helloClient2;

    @RequestMapping("/test")
    public void test() {
        System.out.println(environment);
        System.out.println(environment.getProperty("test"));
    }

    @RequestMapping("/test1")
    public void test1( String test) {
        System.out.println(test);
    }


    @Autowired
    private TestConfig testConfig;

    @RequestMapping("/testt")
    public void testest(){
        System.out.println("testConfig:"+testConfig.getName());
    }


    @RequestMapping("/getConfig")
    public String getConfig(){
        return testConfig.getName();
    }

    @RequestMapping("/getConfig2")
    public String getConfig2(){
        return testConfig.get();
    }

    @Autowired
    private Environment env;

    @RequestMapping("/testEnv")
    public String testEnv(@RequestParam String param) {
        log.debug("123");
        return env.getProperty(param);
    }
}
