package com.jsako.spring.cloud.alibaba.consumer.client;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/3/31 11:17
 * @Description:
 */
@Configuration
public class FeignConfig2 {
    @Bean
    public Request.Options options2() {
        return new Request.Options(10000, 30000);
    }
}
