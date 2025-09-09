package com.example.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String orderId) {
        String message = "Order created: " + orderId;
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME, RabbitMQConfiguration.ROUTING_KEY, message);
        System.out.println("Sent ->" + message);
    }
}
