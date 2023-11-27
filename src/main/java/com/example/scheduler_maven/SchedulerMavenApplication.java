package com.example.scheduler_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.scheduler_maven")
@EnableScheduling
public class SchedulerMavenApplication {





    public static void main(String[] args) {
        SpringApplication.run(SchedulerMavenApplication.class, args);
    }


}


