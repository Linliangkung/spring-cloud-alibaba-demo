package com.jsako.spring.cloud.alibaba.consumer.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/8/8 18:55
 * @Description:
 */
public class TestFeignInterceptor2 implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TestFeignInterceptor2.class);
    @Override
    public void apply(RequestTemplate template) {
        logger.info("TestFeignInterceptor2");
    }
}
