package com.example.scheduler_maven.shcedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledDuePaymentRepository extends JpaRepository<ScheduledDuePayment,Long> {
}
