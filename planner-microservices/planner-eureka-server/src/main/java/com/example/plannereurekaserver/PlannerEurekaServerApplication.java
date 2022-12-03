package com.example.plannereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PlannerEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlannerEurekaServerApplication.class, args);
    }

}
