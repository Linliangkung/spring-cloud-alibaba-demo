package com.jsako.spring.cloud.alibaba.sentinel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/5/19 17:24
 * @Description:
 */
@RestController
public class TestController {
    @RequestMapping("/api/ok")
    public void test(){

    }
}
