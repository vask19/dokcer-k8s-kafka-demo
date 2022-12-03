package vask.spring.microservices.planner.plannerconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PlannerConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlannerConfigApplication.class, args);
    }

}
