package com.yun.beat.rabbitMQ.simplemq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {
    public  static Connection getConnection() throws Exception{
        //定义连接工厂
        ConnectionFactory factory =new ConnectionFactory();
        //设置服务地址
        factory.setHost("127.0.0.1");
        //设置端口
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
         Connection  connection=factory.newConnection();
        return connection;
    }
}
