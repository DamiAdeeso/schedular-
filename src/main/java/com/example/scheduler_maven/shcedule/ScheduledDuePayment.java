package com.example.scheduler_maven.shcedule;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
public class ScheduledDuePayment {
    private int dueDayNominal;
    private LocalDate endDate;
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}