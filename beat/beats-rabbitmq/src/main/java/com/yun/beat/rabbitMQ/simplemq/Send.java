package com.yun.beat.rabbitMQ.simplemq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
    private final static String QUEUE_NAME="simple_queue";

    public static void main(String[] args) throws Exception{
        //获取到连接
       // Connection connection  = ConnectionUtil.getConnection();
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("127.0.0.1");
        //设置端口
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection  connection=factory.newConnection();

        //从连接中创建通道，使用通道才能完成相关操作
        Channel channel=connection.createChannel();
        //声明创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //发送消息
        String message="Hello World!!1231321";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("[X] send "+message);
        channel.close();
        connection.close();

    }
}
