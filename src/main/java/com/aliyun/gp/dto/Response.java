package com.aliyun.gp.dto;

import lombok.Data;

/**
 * 数据来源：https://stockapi.com.cn
 * @param <T>
 */
@Data
public class Response<T>{

    private String code;

    private String msg;

    private T data;
}

