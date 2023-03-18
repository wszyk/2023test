package com.aliyun.gp.enums;

import lombok.Getter;

@Getter
public enum  API_ENUM {
    每日增量("dayAll");

    private String   path;

    API_ENUM(String path) {
        this.path = path;
    }
}
