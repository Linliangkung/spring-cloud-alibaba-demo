package com.jsako.spring.cloud.alibaba.consumer.controller;

import com.jsako.spring.cloud.alibaba.common.enums.HelloEnum;
import com.jsako.spring.cloud.alibaba.common.pojo.HelloPojo;
import com.jsako.spring.cloud.alibaba.consumer.client.HelloClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/5/25 18:07
 * @Description:
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private final static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private HelloClient helloClient;


    @RequestMapping("/callHello")
    public String callHello() {
        return helloClient.hello(HelloEnum.HELLO);
    }

    @RequestMapping("/callHelloPojoAndParam")
    public String callHelloPojoAndParam() {
        HelloPojo helloPojo = new HelloPojo();
        helloPojo.setName("林良劲");
        return helloClient.helloPojoAndParam(HelloEnum.WORLD, helloPojo);
    }

    @RequestMapping("/callHelloList")
    public String callHelloList() {
        return helloClient.helloList(Stream.of("林良劲", "蔡佳欣").collect(Collectors.toList()));
    }

    @RequestMapping("/callHelloInteger")
    public String callHelloInteger() {
        return helloClient.helloInteger(520);
    }


    @RequestMapping("/callHelloCollection")
    public Collection<String> callHelloCollection() {
        return helloClient.helloCollection(Arrays.asList(1, 2, 3, 520));
    }

    @RequestMapping("/callHelloDate")
    public String callHelloDate() {
        return helloClient.helloDate(new Date(), new Date());
    }

    @RequestMapping("/callHelloArray")
    public String callHelloArray() {
        return helloClient.helloArray(HelloEnum.HELLO, HelloEnum.WORLD);
    }

    @RequestMapping("/callHelloMap")
    public String callHelloMap() {
        return helloClient.helloMap().toString();
    }


    @RequestMapping("/callHelloResponse")
    public String callHelloResponse() {
        return helloClient.helloResponse().getData().getName();
    }

    @RequestMapping("/callHelloApiResponse")
    public String callHelloApiResponse() {
        return helloClient.helloApiResponse().toString();
    }

    @RequestMapping("/callStringEmpty")
    public List<String> callStringEmpty()  {
        try {
//            TraceContext.setTraceId("traceId");
//            TraceContext.setTag("tag");
            return helloClient.helloStringEmpty(" ").get();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/callHelloException")
    public void callHelloException(){
         helloClient.helloException();
    }

    @RequestMapping("/callHelloException2")
    public void callHelloException2(){
        helloClient.helloException2();
    }

    @RequestMapping("/notFoundError")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundError() {
        logger.info("notFoundError");
        return "not found";
    }

    @RequestMapping("/serverError")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverError() {
        logger.info("serverError");
        return "serverError";
    }


    @RequestMapping("/spi")
    public String spi() {
        logger.info("spi");
        return "spi";
    }

    @RequestMapping("/logInfo")
    public void logInfo() {
        logger.info("info");
    }


    @RequestMapping("/testAsync")
    public void testAsync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> s = helloClient.hello10();
        Future<String> s1 = helloClient.hello20();
        System.out.println(s.get());
        System.out.println(s1.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    @ExceptionHandler(FeignException.class)
    public void handlerFeignException(FeignException ex) {
        logger.info("content:{}",new String(ex.content(), StandardCharsets.UTF_8));
    }
}

