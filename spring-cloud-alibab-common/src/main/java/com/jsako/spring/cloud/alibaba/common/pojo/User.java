package com.jsako.spring.cloud.alibaba.common.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2020/6/23 17:23
 * @Description:
 */
public class User {


    @JsonDeserialize(converter = DeserializeConverter.class)
    @JsonSerialize(converter = SerializeConverter.class)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
