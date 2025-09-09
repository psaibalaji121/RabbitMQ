package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final RabbitTemplate rabbitTemplate;


    public OrderConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitMQConfiguration.QUEUE_NAME)
    public void receiveOrder(String orderId) {
        System.out.println("Received <-" + orderId);
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Processed ->" + orderId);
    }

}
