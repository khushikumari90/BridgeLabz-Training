package com.bridgelabz.fundoonotes.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// UC8: picks up reminder messages off the queue and "processes" them on its own thread,
// so the Controller/Producer side never waits on this work
@Component
public class ReminderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ReminderConsumer.class);

    @JmsListener(destination = "reminder-queue")
    public void handleReminder(String message) {
        try {
            // simulating the "real" processing work (e.g. eventually sending an email/push notification)
            Thread.sleep(500);
            logger.info("Processed reminder message: {}", message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Reminder processing interrupted", e);
        }
    }
}
