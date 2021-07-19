package com.jsako.spring.cloud.alibaba.consumer.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/7/2 18:58
 * @Description:
 */
@Component
@Aspect
public class AspectTest implements Ordered {

    @Pointcut("this(com.jsako.spring.cloud.alibaba.consumer.aspect.TestAop)")
    public void ponintcut() {

    }

    @Before("ponintcut()")
    public void before() {
        System.out.println("before");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
