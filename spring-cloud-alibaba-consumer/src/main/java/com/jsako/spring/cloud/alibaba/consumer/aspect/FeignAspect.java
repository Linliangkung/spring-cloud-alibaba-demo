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
@Order(10)
public class FeignAspect {

    @Pointcut("@within(org.springframework.cloud.openfeign.FeignClient)&&execution(java.util.concurrent.Future *(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before");
//        throw new Exception("123");
        return joinPoint.proceed();
    }
}
