package com.yun.beat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shrio")
public class ShrioController {

    @RequestMapping("/user")
    public String getUserinfor(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return "aaaaaaaaaaaaaaaaaaa";
    }
}
