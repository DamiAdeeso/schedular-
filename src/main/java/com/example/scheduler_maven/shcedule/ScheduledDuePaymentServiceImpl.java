package com.example.scheduler_maven.shcedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduledDuePaymentServiceImpl implements ScheduledDuePaymentService, SchedulingConfigurer {
    @Autowired
    private ScheduledDuePaymentRepository scheduledDuePaymentRepository;

    @Override
    public ScheduledDuePayment save(ScheduledDuePayment scheduledDuePayment) {
        return scheduledDuePaymentRepository.save(scheduledDuePayment);
    }

    private Trigger getTrigger() {
        List<ScheduledDuePayment> dueDa = scheduledDuePaymentRepository.findAll();
        int dueDay = dueDa.isEmpty() ? 1 : dueDa.get(0).getDueDayNominal();
        //return new CronTrigger("0 0 0 " + dueDay + " * ?");
      //  return new CronTrigger("0/ " + dueDay + " 0 * * ?");
        return new CronTrigger("0 0 0 * * ?");
    }

    public void calculateScheduledNominals() {
        List<ScheduledDuePayment> dueDa = scheduledDuePaymentRepository.findAll();
        LocalDate currentDate = LocalDate.now();

        dueDa.forEach(e -> {
            int  dueDayNominal = e.getDueDayNominal();
            if (dueDayNominal==(currentDate.getDayOfMonth())) {
                e.setStatus("Paid");
            }
        });
        scheduledDuePaymentRepository.saveAll(dueDa);
    }

    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                this::calculateScheduledNominals,
                getTrigger()
        );
    }
}
