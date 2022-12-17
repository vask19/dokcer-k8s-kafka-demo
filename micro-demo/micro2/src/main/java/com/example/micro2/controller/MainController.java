package com.example.micro2.controller;


import com.example.micro2.servise.KafkaConsumerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private KafkaConsumerService kafkaConsumerService;

    public MainController(KafkaConsumerService kafkaConsumerService) {
        this.kafkaConsumerService = kafkaConsumerService;
    }



    @GetMapping()
    public void showDate(){
        var result = kafkaConsumerService.getDate();
        System.out.println("\n\n\n" +111);
//        System.out.println(result);
        System.out.println("\n\n\n");

    }
}
