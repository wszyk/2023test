package com.aliyun.demo.controller;

import com.aliyun.demo.constant.SexEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author: DevStudio
 */
@RestController
public class NameController {

    /**
     * baby 起名
     * @param sex 性别, girl|boy
     * @param surname 姓氏
     * @return 名字
     */
    @PostMapping("/name")
    public String getName(@RequestParam(required = false, defaultValue = "girl") String sex,
                          @RequestParam String surname) {
        return surname + getName(sex);
    }

    /**
     * girl's names
     */
    private static final String[] GIRL_NAMES = {
            "风", "霜", "雨", "雪", "冰", "寒", "月", "颜", "函", "宜", "琪", "菱", "伊", "珊"
    };
    /**
     * boy's names
     */
    private static final String[] BOY_NAMES = {
            "轩", "珸", "羽", "璇", "允", "芸", "沺", "苒", "阳", "煦", "辰", "灿", "耀", "烨"
    };

    /**
     * 随机获取名
     *
     * @param sex 性别, girl|boy
     * @return 名
     */
    public static String getName(String sex) {
        Random random = new Random();
        int nameSize = random.nextInt(2) + 1;
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < nameSize; i++) {
            String[] nameArgs = SexEnum.GIRL.name().toLowerCase().equals(sex) ? GIRL_NAMES : BOY_NAMES;
            name.append(nameArgs[random.nextInt(nameArgs.length)]);
        }
        return name.toString();
    }

}
