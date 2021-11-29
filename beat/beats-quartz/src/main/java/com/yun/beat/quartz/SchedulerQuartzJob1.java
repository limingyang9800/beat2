package com.yun.beat.quartz;

import com.yun.beat.biz.service.DemoService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SchedulerQuartzJob1 implements Job {

    //@Autowired
    @Resource
    private DemoService demoService;

    private void before(){
        System.out.println("任务开始执行");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        try {

            before();
            SimpleDateFormat fordate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date =new Date();
            System.out.println("开始时间年月日时分秒："+fordate.format(date));
            System.out.println("开始："+System.currentTimeMillis());
            // TODO 业务
            String s = demoService.test(2).toString();
            System.out.println(s);

            System.out.println("结束："+System.currentTimeMillis());
            System.out.println("结束时间年月日时分秒："+fordate.format(new Date()));
            after();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private void after(){
        System.out.println("任务结束执行");
    }
}
