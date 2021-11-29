package com.yun.beat.quartz;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class QuartzApiController {
    @Autowired
    private QuartzScheduler quartzScheduler;


    @ApiOperation(value="启动当前定时器", notes="启动当前定时器",tags = "quart",httpMethod = "GET")
    @RequestMapping(value="/start" ,method = RequestMethod.GET,produces = "application/json")
    public void startQuartzJob() {
        try {
            quartzScheduler.startJob();
            System.out.println("启动定时任务");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value="获取当前定时器", notes="获取当前定时器",tags = "quart",httpMethod = "GET")
    @RequestMapping("/info")
    public String getQuartzJob(String name, String group) {
        String info = null;
        try {
            info = quartzScheduler.getJobInfo("job1", "group1");
            System.out.println("获取定时器的名称"+quartzScheduler.getJobInfo("job1", "group1"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }
    @ApiOperation(value="启动当前定时器", notes="modify",tags = "quart",httpMethod = "GET")
    @RequestMapping("/modify")
    public boolean modifyQuartzJob(String name, String group, String time) {
        boolean flag = true;
        try {
            flag = quartzScheduler.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @ApiOperation(value="启动当前定时器", notes="pause",tags = "quart",httpMethod = "GET")
    @RequestMapping(value = "/pause")
    public void pauseQuartzJob(String name, String group) {
        try {
            quartzScheduler.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value="启动当前定时器", notes="pauseAll",tags = "quart",httpMethod = "GET")
    @RequestMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            quartzScheduler.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    @ApiOperation(value="启动当前定时器", notes="delete",tags = "quart",httpMethod = "GET")
    @RequestMapping(value = "/delete")
    public void deleteJob(String name, String group) {
        try {
            quartzScheduler.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }





}
