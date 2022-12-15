package com.example.micro1.mq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class KafkaOrderMessagingService {
    private KafkaTemplate<String, TacoOrder> kafkaTemplate;

    public void sendOrder(TacoOrder order) {
        kafkaTemplate.sendDefault( order);
    }

    @Bean
    public KafkaTemplate<String, TacoOrder> kafkaTemplate(){
    }
}
