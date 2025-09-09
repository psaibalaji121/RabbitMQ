package com.example.rabbitmq;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class Controller {

    private final OrderProducer producer;

    public Controller(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/{id}")
    public String createOrder(@PathVariable String id) {
        producer.send(id);
        return "Order ID " + id + " sent to RabbitMQ";
    }

}
