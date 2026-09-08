package com.bridgelabz.fundoonotes.rabbitmq;

import com.bridgelabz.fundoonotes.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// UC10: a second, independent consumer bound to the same exchange/routing key as
// CollaboratorNotifyConsumer - added with zero changes to NoteShareEventProducer,
// which is the whole point of routing through an Exchange instead of a direct queue
@Component
public class ActivityLogConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ActivityLogConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.ACTIVITY_LOG_QUEUE)
    public void logActivity(String message) {
        logger.info("[activity-log] {}", message);
    }
}
