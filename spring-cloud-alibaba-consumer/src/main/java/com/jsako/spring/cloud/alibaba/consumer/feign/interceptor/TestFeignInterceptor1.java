package com.jsako.spring.cloud.alibaba.consumer.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/8/8 18:54
 * @Description:
 */
public class TestFeignInterceptor1 implements RequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TestFeignInterceptor1.class);
    @Override
    public void apply(RequestTemplate template) {
        logger.info("TestFeignInterceptor1");
    }
}
