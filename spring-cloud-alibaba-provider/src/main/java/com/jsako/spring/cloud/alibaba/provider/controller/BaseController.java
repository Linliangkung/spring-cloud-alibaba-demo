package com.jsako.spring.cloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/5/29 11:08
 * @Description:
 */

public abstract class BaseController {
    @Value("${spring.father.test}")
    protected String fatherValue;
}
