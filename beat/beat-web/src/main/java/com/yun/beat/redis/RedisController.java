package com.yun.beat.redis;

import com.yun.beat.biz.service.DemoService;
import com.yun.beat.config.RedisLock;
import com.yun.beat.util.RedisUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lmy
 * @date 2021/7/1 10:12
 */

@Slf4j
@Controller
@RequestMapping("/rest")
public class RedisController {

    @Autowired
    private RedisUtil rd;

    @Autowired
    private DemoService demoService;

    @Autowired
    RedisLock redisLock;

    //超时时间10s
    private static final int TIMEOUT = 10 * 1000;

    /**
     * 通过字符串获取值
     */
    @ApiOperation(value="redis获取String值", notes="redis获取String值",tags = "redis",httpMethod = "GET")
    @RequestMapping(value="/getStringKey/{stringkey}",method = RequestMethod.GET)
    public void getStringKey(String stringkey){
        log.info("获取的值为{}",stringkey);
        String o =  (String)rd.get(stringkey);
        log.info("获取的值为{}",o);
    }


    /**
     * 通过字符串获取值
     */
    @ApiOperation(value="redis保存String值并设置过期时间", notes="redis保存String值并设置过期时间",tags = "redis",httpMethod = "GET")
    @RequestMapping(value="/saveStringKey/{stringkey}",method = RequestMethod.GET)
    public void saveStringKey(String stringkey){
        log.info("获取的值为{}",stringkey);
        boolean f= rd.set(stringkey,"你好啊！！！！！！",10000);
        log.info("保存String是否成功{}",f);
    }


    /**
     * 保存list
     */
    @ApiOperation(value="redis保存list值", notes="redis保存list值",tags = "redis",httpMethod = "GET")
    @RequestMapping("/saveListKey")
    public void saveList(){
       boolean f=  rd.lSet("ud", demoService.test(2));
       log.info("存储list集合是否成功{}",f);
    }

    /**
     * 通过list主键获取值
     * @param listKey
     */
    @ApiOperation(value="redi获取list值", notes="redis获取list值",tags = "redis",httpMethod = "GET")
    @RequestMapping("/getListKey/{listKey}")
    public void getListValue(String listKey){
        List<Object> ud = rd.lGet(listKey, 0, -1);
        log.info("存储list集合"+ud.toString());
    }


    /**
     * Redis分布式锁
     * @param productId
     */
    @ApiOperation(value="redi分布式锁", notes="redi分布式锁",tags = "redis",httpMethod = "GET")
    @RequestMapping("/getfbsKey/{productId}")
    public void secKill(String productId){
        long time = System.currentTimeMillis() + TIMEOUT;
        //加锁
        if (!redisLock.lock(productId, String.valueOf(time))){
            log.info( "人太多了，等会儿再试吧~");
        }

        //具体的秒杀逻辑 等待一定时间后将key删除
        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }


}
