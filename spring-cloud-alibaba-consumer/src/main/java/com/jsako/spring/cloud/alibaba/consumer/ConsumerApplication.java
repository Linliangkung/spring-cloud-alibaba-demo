package com.jsako.spring.cloud.alibaba.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/5/25 17:11
 * @Description:
 */
@SpringBootApplication(scanBasePackages = {"com.jsako"})
@EnableFeignClients("com.jsako.spring.cloud.alibaba.consumer.client")
@EnableAspectJAutoProxy(proxyTargetClass = false)
//@EnableCommonWeb
public class ConsumerApplication {
    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(ConsumerApplication.class, args);
        run.getBean("scopedTarget.testConfig");
    }
}
