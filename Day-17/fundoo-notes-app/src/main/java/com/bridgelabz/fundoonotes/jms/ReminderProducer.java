package com.bridgelabz.fundoonotes.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

// UC8: fires a JMS message per reminder set; the Consumer processes it on a separate thread
// so setting a reminder returns to the client almost instantly
@Component
public class ReminderProducer {

    private static final String REMINDER_QUEUE = "reminder-queue";

    private final JmsTemplate jmsTemplate;

    public ReminderProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendReminderMessage(int noteId, String reminderTime) {
        String message = "Reminder set for noteId=" + noteId + " at " + reminderTime;
        jmsTemplate.convertAndSend(REMINDER_QUEUE, message);
    }
}
