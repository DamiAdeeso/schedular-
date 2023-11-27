package com.example.scheduler_maven.shcedule;

import org.springframework.stereotype.Service;

@Service
public interface ScheduledDuePaymentService {
    public ScheduledDuePayment  save(ScheduledDuePayment scheduledDuePayment) ;

}
