package com.aliyun.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author: DevStudio
 */
@RestController
public class WelcomeController {

    private static final String[] GREETINGS = {
            "Welcome to DevStudio",
            "碧油鸡全部退散, 颈腰椎早日康复! 贼真诚",
            "有对象了么? 别慌, 送你一个! 领取请加钉钉群: 35991139",
            "404?!! 不要慌，不要急，App Observer 帮助您~ 了解一下",
            "Cosy 提效补全用过没, 还能搜搜搜",
            "代码平台哪家强, Codeup! Codeup!! Codeup!!!"
    };

    /**
     * 皮一下
     * @return 皮皮
     */
    @GetMapping("/welcome")
    public String welcome() {
        Random random = new Random();
        int position = random.nextInt(GREETINGS.length);
        return GREETINGS[position];
    }
}
