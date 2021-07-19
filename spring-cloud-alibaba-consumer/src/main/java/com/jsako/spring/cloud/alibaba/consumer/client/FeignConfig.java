package com.jsako.spring.cloud.alibaba.consumer.client;

import feign.Request;
import org.springframework.context.annotation.Bean;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/3/31 11:03
 * @Description:
 */
public class FeignConfig {

    @Bean
    public Request.Options options() {
        return new Request.Options(12312321, 12312321);
    }
}
