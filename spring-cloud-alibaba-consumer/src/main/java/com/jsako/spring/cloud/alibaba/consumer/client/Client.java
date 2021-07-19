package com.jsako.spring.cloud.alibaba.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Future;

import static com.jsako.spring.cloud.alibaba.consumer.client.HelloClient.URL_PREFIX;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/5/29 16:37
 * @Description:
 */
//@FeignClient(value = "spring-cloud-alibaba-provider",contextId = "123")
@RequestMapping(URL_PREFIX)
public interface Client {
    @RequestMapping("/helloInteger")
    String helloInteger1(int i);


}
