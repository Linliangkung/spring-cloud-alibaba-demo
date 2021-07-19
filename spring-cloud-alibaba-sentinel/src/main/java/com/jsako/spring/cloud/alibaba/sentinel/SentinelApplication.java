package com.jsako.spring.cloud.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/5/19 11:49
 * @Description:
 */
@SpringBootApplication(scanBasePackages = {"com.jsako"})
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }
}
