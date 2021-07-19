package com.jsako.spring.cloud.alibaba.common.pojo;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/6/23 17:46
 * @Description:
 */
public class SerializeConverter extends StdConverter<String, List<String>> {

    @Override
    public List<String> convert(String value) {
        return Stream.of(value).collect(Collectors.toList());
    }

}
