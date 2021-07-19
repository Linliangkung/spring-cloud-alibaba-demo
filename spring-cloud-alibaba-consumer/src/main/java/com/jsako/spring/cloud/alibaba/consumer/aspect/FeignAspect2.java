package com.jsako.spring.cloud.alibaba.consumer.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/7/6 14:17
 * @Description:
 */
@Aspect
//@Component
@Order(20)
public class FeignAspect2 {

    @Pointcut("@within(org.springframework.cloud.openfeign.FeignClient)&&execution(java.util.concurrent.Future *(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before2");
        return joinPoint.proceed(joinPoint.getArgs());

    }
}
