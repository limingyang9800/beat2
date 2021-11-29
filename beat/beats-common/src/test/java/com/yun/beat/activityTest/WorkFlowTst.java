package com.yun.beat.activityTest;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class WorkFlowTst {

    /*@Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    *//**
 * @author lmy
 * @create 2021-05-18 11:06
 * @desc 从数据源和流程图中，生成一个数据库表（这个就是Activiti流程控制的关键的数据表）
**//*
    @Test
    public void creatTable() {
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml")
                .buildProcessEngine();
    }


    *//**
     * 1：部署一个Activiti流程
     * 运行成功后，查看之前的数据库表，就会发现多了很多内容
     *//*
    @Test
    public void creatActivitiTask(){
        //加载的那两个内容就是我们之前已经弄好的基础内容哦。
        //得到了流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment =processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("process/acitivitiEmploee.bpmn")
                //.addClasspathResource("activiti/acitivitiEmploee.png")
                .deploy();
    }

    *//**
     * 2：启动流程实例
     *//*
    @Test
    public void testStartProcessInstance(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        processEngine.getRuntimeService()
               .startProcessInstanceById("myProcess_1:1:4");  //这个是查看数据库中act_re_procdef表
    }

    *//**
     * 完成请假申请
     *//*
    @Test
    public void testQingjia(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getTaskService()
                .complete("2504"); //查看act_ru_task表
    }

    @Test
    public void testQueryTask(){
        //项目组长审批
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                //.taskAssignee("小毛")
                .list();
        for (Task task : tasks) {
            System.out.println(task.getName());
        }
    }

    *//**
     * 项目组长完成任务
     *//*
    @Test
    public void testFinishTask_manager(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        engine.getTaskService()
                .complete("5002"); //查看act_ru_task数据表
    }


    //项目经理完成审批
    @Test
    public void testFinishTask_Boss(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getTaskService()
                .complete("7504");  //查看act_ru_task数据表
    }




    //查询流程
    @Test
    public void queryTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //根据assignee(节点接受人)查询任务
        //String assignee = "张三";
        String assignee="";
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();

        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            Task task = tasks.get(i);

        }
        //首次运行的时候这个没有输出，因为第一次运行的时候扫描act_ru_task的表里面是空的，但第一次运行完成之后里面会添加一条记录，之后每次运行里面都会添加一条记录
        for (Task task : tasks) {
            System.out.println("taskId=" +"流程任务节点信息ID："+ task.getId() +
                    ",taskName:" +"流程任务节点名称ID：" +task.getName() +
                    ",assignee:" + "流程任务节点接受人："+task.getAssignee() +
                    ",createTime:" +"流程任务节点创建时间："+ task.getCreateTime());
        }





    }



    @Test
    public void firstDemo() {
        //根据bpmn文件部署流程
        //Deployment deployment = repositoryService.createDeployment().addClasspathResource("activiti/acitivitiEmploee.bpmn").deploy();

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment =processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("activiti/acitivitiEmploee.bpmn")
                .addClasspathResource("activiti/acitivitiEmploee.png")
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






    *//**
     * 查询所有的部署流程
     *//*
    @Test
    public void queryAllDeplyoment() {
        //得到流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        List<Deployment> lists = processEngine.getRepositoryService()
                .createDeploymentQuery()
                .orderByDeploymenTime()//按照部署时间排序
                .desc()//按照降序排序
                .list();
        for (Deployment deployment : lists) {
            System.out.println(deployment.getId() + "    部署名称" + deployment.getName());
        }

    }












*/






}
