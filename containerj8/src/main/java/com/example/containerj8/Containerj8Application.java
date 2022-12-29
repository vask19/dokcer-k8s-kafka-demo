package com.example.containerj8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Containerj8Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Containerj8Application.class, args);
        Thread.sleep(20000);
    }

}
