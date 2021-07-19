package com.jsako.spring.cloud.alibaba.common.pojo;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/7/23 11:01
 * @Description:
 */
public class ApiResponse<T> {
    private T data;

    private int code;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "data=" + data +
                ", code=" + code +
                '}';
    }
}
