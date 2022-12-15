package com.example.micro2.mq;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
public class OrderListener {

    @KafkaListener(topics="tacocloud.orders.topic")
    public void handle(TacoOrder order) {
    }
}
