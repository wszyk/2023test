package com.aliyun.gp.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task1 {


    @Scheduled(cron ="*/6 * * * * ?")
    public void sayWord() {
        System.out.println("world");
    }

}
