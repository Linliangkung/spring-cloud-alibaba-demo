package com.jsako.spring.cloud.alibaba.consumer.aspect;

import org.springframework.stereotype.Component;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/7/2 18:58
 * @Description:
 */
@Component
public class TestAop implements Jie1, Jie2 {
    @Override
    public void jie1() {
        System.out.println("jie1 impl");
    }

    @Override
    public void jie2() {
        System.out.println("jie2 impl");
    }
}
