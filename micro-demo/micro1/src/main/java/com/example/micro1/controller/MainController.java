package com.example.micro1.controller;

import com.example.micro1.mq.KafkaOrderMessagingService;
import com.example.micro1.mq.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final KafkaOrderMessagingService kafkaOrderMessagingService;

    public MainController(KafkaOrderMessagingService kafkaOrderMessagingService) {
        this.kafkaOrderMessagingService = kafkaOrderMessagingService;
    }


    @GetMapping("{id}")
    public String setId(@PathVariable("id") Long id){
        TacoOrder tacoOrder = new TacoOrder();
        tacoOrder.setName("bob with id: " + id);
        kafkaOrderMessagingService.sendOrder(tacoOrder);
        return "or";
    }



}
