package com.example.micro1.controller;

import com.example.micro1.mq.MessageProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
   private  MessageProducer ms;

    public MainController(MessageProducer ms) {
        this.ms = ms;
    }


    @GetMapping("{id}")
    public String setId(@PathVariable("id") Long id){
        ms.newUserAction(id);
        return "or";
    }



}
