package com.vask.micro.eurekaclient2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/new")
public class NewController {


    @GetMapping("/name")
    public String getName(){
        return "new";
    }
}
