package com.yun.beat.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lmy
 * @date 2021/7/7 16:48
 */
@Component("test2task")
@Slf4j
public class TestInterfaceTask {

    public void consoleLog(){
        log.info("通过测试接口 来控制定时任务");
    }
}
