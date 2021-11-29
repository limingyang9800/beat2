package com.yun.beat.activiti;

import com.yun.beat.dao.entity.UserDao;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * 工作流
 * @author lmy
 * @date 2021/7/1 16:52
 */

@RestController
@RequestMapping("/rest")
public class ActivitiController {

    /*@Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;


*//**
 * 1：部署一个Activiti流程
 * 运行成功后，查看之前的数据库表，就会发现多了很多内容
 *//*
    @ApiOperation(value="获取当前流程", notes="获取当前流程",tags = "activiti",httpMethod = "GET")
    @RequestMapping("/stratQj")
    public void creatActivitiTask(){
        //根据bpmn文件部署流程
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment =processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("activitis/acitivitiEmploee.bpmn")
                //.addClasspathResource("activiti/acitivitiEmploee.png")
                .deploy();
        //获取流程定义
        ProcessDefinition processDefinition = processEngine.getRepositoryService().createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        //启动流程定义，返回流程实例
        ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceById(processDefinition.getId());
        String processId = pi.getId();
        System.out.println("流程创建成功，当前流程实例ID："+processId);

        Task task=processEngine.getTaskService().createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第一次执行前，任务名称发起请假："+task.getName());
        processEngine.getTaskService().complete(task.getId());

        task = processEngine.getTaskService().createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第二次执行前，任务名称组长审批："+task.getName()+"-----"+task.getProcessInstanceId());
        processEngine.getTaskService().addComment(task.getId(),task.getProcessInstanceId(),"审批通过！！！");
        processEngine.getTaskService().complete(task.getId());

        task = processEngine.getTaskService().createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第三次执行前，任务名称经理审批："+task.getName());
        processEngine.getTaskService().complete(task.getId());

        task = processEngine.getTaskService().createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("task为null，任务执行完毕："+task);
    }
*/

    @ApiOperation(value="获取当前流程", notes="获取当前流程",tags = "activiti",httpMethod = "GET")
    @RequestMapping("/qd")
    public void testActiviti() {
        System.out.println("hhhhhhhhhhhhhhh");
    }
}
