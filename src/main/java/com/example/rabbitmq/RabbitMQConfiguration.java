package com.example.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String QUEUE_NAME = "example";
    public static final String EXCHANGE_NAME = "example_exchange";
    public static final String ROUTING_KEY = "example_routingkey";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME,false);
    }

    @Bean
    public TopicExchange exchange() {
        return  new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}
