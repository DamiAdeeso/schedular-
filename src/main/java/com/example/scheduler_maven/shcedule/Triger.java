package com.example.scheduler_maven.shcedule;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

@Component
public class Triger {

  //  private ScheduledTaskRegistrar scheduledTaskRegistrar;

    @Scheduled()
    public void myScheduledTask() {
        System.out.println("Task executed at: " + System.currentTimeMillis());
    }

}
