package com.yun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lmy
 * @date 2021/7/7 16:06
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yun.beat.dao")
public class DynamicScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicScheduleApplication.class, args);
    }
}
