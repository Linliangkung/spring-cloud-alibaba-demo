package com.jsako.spring.cloud.alibaba.common.pojo;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/5/27 13:51
 * @Description:
 */
public class Response<T> {
    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
