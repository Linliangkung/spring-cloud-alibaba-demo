package com.jsako.spring.cloud.alibaba.provider.controller;

import com.jsako.spring.cloud.alibaba.common.enums.HelloEnum;
import com.jsako.spring.cloud.alibaba.common.pojo.ApiResponse;
import com.jsako.spring.cloud.alibaba.common.pojo.HelloPojo;
import com.jsako.spring.cloud.alibaba.common.pojo.Response;
import com.jsako.spring.cloud.alibaba.common.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/5/25 17:56
 * @Description:
 */
@RequestMapping("/hello")
@RestController
@RefreshScope
public class HelloController extends BaseController {

    @Value("${spring.test}")
    private String value;


    @RequestMapping
    public String hello(@RequestParam HelloEnum hello) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("123");
        return "hello alibaba cloud,value:" + value + ",fatherValue:" + fatherValue + ",enum:" + hello.ordinal();
    }

    @RequestMapping("/helloPojoAndParam")
    public String helloPojoAndParam(@RequestParam HelloEnum hello, @RequestBody HelloPojo helloPojo, HttpServletRequest request) {
        String header = request.getHeader("X-Request-Red");
        System.out.println(header);
        return "hello enum:" + hello.ordinal() + ",helloPojo.name=" + helloPojo.getName();
    }

    @RequestMapping("/helloList")
    public String helloList(@RequestBody List<String> helloLists) {
        return "hello lists:" + helloLists;
    }


    @RequestMapping("/helloInteger")
    public String helloInteger(@RequestBody Integer hello) {
        return "hello:" + hello;
    }


    @RequestMapping("/helloCollection")
    public Collection<String> helloCollection(@RequestBody Collection<Integer> param) {
        return param.stream().map(String::valueOf).collect(Collectors.toList());
    }

    @RequestMapping("/helloDate")
    public String helloDate(@RequestParam Date startDate, @RequestParam Date endDate) {
        return startDate.toString();
    }

    @RequestMapping("/helloArray")
    public String helloArray(@RequestBody HelloEnum... helloEnums) {
        return helloEnums[0].name();
    }

    @RequestMapping("/helloMap")
    public Map<String, HelloPojo> helloMap() {
        HelloPojo pojo = new HelloPojo();
        pojo.setName("llj");
        return Collections.singletonMap("123", pojo);
    }

    @RequestMapping("/helloResponse")
    public Response<HelloPojo> helloResponse() {
        Response<HelloPojo> helloPojoResponse = new Response<>();
        HelloPojo data = new HelloPojo();
        data.setName("林良劲爱蔡佳欣");
        data.setDate(new Date());
        helloPojoResponse.setData(data);
        return helloPojoResponse;
    }

    @RequestMapping("/helloUser")
    public User helloUser(@RequestBody User user) {
        return user;
    }


    @RequestMapping("/helloApiResponse")
    public ApiResponse helloApiResponse() {
        ApiResponse apiResponse = new ApiResponse();
        HelloPojo data = new HelloPojo();
        data.setName("llj");
        apiResponse.setData(data);
        apiResponse.setCode(200);
        return apiResponse;
    }

    @RequestMapping("/helloStringEmpty")
    public List<String> helloStringEmpty(@RequestBody String param, HttpServletRequest request) {
        System.out.println(request.getHeader("feature-tag"));
        System.out.println(request.getHeader("eagleeye-traceid"));
        return Collections.singletonList("123");
    }

    @RequestMapping("/helloException")
    public void helloException() {
        System.out.println("123");
        throw new RuntimeException();
    }


    @RequestMapping("/helloException2")
    public void helloException2() {
        System.out.println("koko");
        throw new RuntimeException();
    }

    @RequestMapping("/hello10")
    public String hello10() throws InterruptedException {
        Thread.sleep(10000);
        return "hello10";
    }

    @RequestMapping("/hello20")
    String hello20() throws InterruptedException {
        Thread.sleep(20000);
        return "hello20";
    }

}

