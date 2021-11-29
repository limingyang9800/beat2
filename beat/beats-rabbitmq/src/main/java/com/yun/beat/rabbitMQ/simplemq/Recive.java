package com.yun.beat.rabbitMQ.simplemq;


import com.rabbitmq.client.*;

public class Recive {
    private final static String QUEUE_NAME="simple_queue";

    public static void main(String[] args) throws Exception{
        Connection connection= ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        DefaultConsumer consumer=new DefaultConsumer(channel){

            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
                                       byte[] body){
                String msg=new String(body);
                System.out.println("[X] recive:"+ msg);
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);

    }

}
