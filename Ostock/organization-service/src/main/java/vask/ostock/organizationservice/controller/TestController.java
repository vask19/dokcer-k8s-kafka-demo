package vask.ostock.organizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/123/")
public class TestController {

    @GetMapping
    public String getTest(){
        return "ok";
    }

}
