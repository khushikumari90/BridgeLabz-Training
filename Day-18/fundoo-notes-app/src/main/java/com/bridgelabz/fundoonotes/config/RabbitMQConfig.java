package com.bridgelabz.fundoonotes.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// UC10: note-sharing events go through an Exchange, unlike JMS's direct queue (UC8's reminders).
// A Topic Exchange is used so more than one consumer can react to the same "note.shared" event
// without the Producer knowing or caring how many consumers exist.
@Configuration
public class RabbitMQConfig {

    public static final String NOTES_EXCHANGE = "notes-exchange";
    public static final String NOTE_SHARED_ROUTING_KEY = "note.shared";

    public static final String COLLABORATOR_NOTIFY_QUEUE = "collaborator-notify-queue";
    public static final String ACTIVITY_LOG_QUEUE = "activity-log-queue";

    @Bean
    public TopicExchange notesExchange() {
        return new TopicExchange(NOTES_EXCHANGE);
    }

    @Bean
    public Queue collaboratorNotifyQueue() {
        return new Queue(COLLABORATOR_NOTIFY_QUEUE);
    }

    @Bean
    public Queue activityLogQueue() {
        return new Queue(ACTIVITY_LOG_QUEUE);
    }

    @Bean
    public Binding collaboratorNotifyBinding(Queue collaboratorNotifyQueue, TopicExchange notesExchange) {
        return BindingBuilder.bind(collaboratorNotifyQueue).to(notesExchange).with(NOTE_SHARED_ROUTING_KEY);
    }

    // second consumer bound to the SAME exchange/routing key, zero changes needed on the Producer side -
    // this is the concrete proof of the routing decoupling benefit
    @Bean
    public Binding activityLogBinding(Queue activityLogQueue, TopicExchange notesExchange) {
        return BindingBuilder.bind(activityLogQueue).to(notesExchange).with(NOTE_SHARED_ROUTING_KEY);
    }
}
