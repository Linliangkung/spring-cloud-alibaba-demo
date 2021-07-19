package com.jsako.spring.cloud.alibaba.common.pojo;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.List;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/6/23 17:29
 * @Description:
 */
public class DeserializeConverter extends StdConverter<List<String>, String> {
    @Override
    public String convert(List<String> value) {
        System.out.println("value:" + value);
        return "123";
    }

}
