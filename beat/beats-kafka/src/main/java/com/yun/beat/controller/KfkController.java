package com.yun.beat.controller;

import com.yun.beat.kafkaService.KfkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lmy
 * @date 2021/6/28 17:56
 */

@RestController
public class KfkController {

    @Autowired
    private KfkService kfkService;

    @GetMapping("/send")
    public String send(){
        kfkService.sendMsg("topic1","I am topic msg");
        return "success-topic1";
    }
}
