package com.jsako.spring.cloud.alibaba.consumer.client;

import com.jsako.spring.cloud.alibaba.common.enums.HelloEnum;
import com.jsako.spring.cloud.alibaba.common.pojo.ApiResponse;
import com.jsako.spring.cloud.alibaba.common.pojo.HelloPojo;
import com.jsako.spring.cloud.alibaba.common.pojo.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/5/25 18:07
 * @Description:
 */
@FeignClient(value = "spring-cloud-alibaba-provider", contextId = "HelloClient2"/*,path = URL_PREFIX*/)
public interface HelloClient2 {
    String URL_PREFIX = "/hello";

    @RequestMapping()
    String hello(@RequestParam HelloEnum hello);

    @RequestMapping("/helloPojoAndParam")
    String helloPojoAndParam(@RequestParam HelloEnum hello, HelloPojo helloPojo);

    @RequestMapping("/helloList")
    String helloList(List<String> lists);

    @RequestMapping("/helloInteger")
    String helloInteger(int i);


    @PostMapping("/helloCollection")
    Collection<String> helloCollection(@RequestBody Collection<Integer> param);

    @PostMapping("/helloDate")
    String helloDate(@RequestParam Date startDate, @RequestParam Date endDate);

    @RequestMapping("/helloArray")
    String helloArray(@RequestBody HelloEnum... helloEnums);

    @RequestMapping("/helloMap")
    Map<String, HelloPojo> helloMap();

    @RequestMapping("/helloResponse")
    Response<HelloPojo> helloResponse();

    @RequestMapping("/helloApiResponse")
    ApiResponse helloApiResponse();

    @PostMapping("/helloStringEmpty")
    List<String> helloStringEmpty(String s);

    @RequestMapping(URL_PREFIX+"/helloException")
    void helloException();


    @RequestMapping(URL_PREFIX+"/helloException2")
     void helloException2();
}
