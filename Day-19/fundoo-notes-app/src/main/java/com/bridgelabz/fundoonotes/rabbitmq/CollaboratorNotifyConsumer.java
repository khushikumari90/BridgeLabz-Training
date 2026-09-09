package com.bridgelabz.fundoonotes.rabbitmq;

import com.bridgelabz.fundoonotes.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// UC10: reacts to a note being shared - in a full build this would send a notification
// to the collaborator; kept as a log line here since Collaborators (UC13) isn't built yet
@Component
public class CollaboratorNotifyConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CollaboratorNotifyConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.COLLABORATOR_NOTIFY_QUEUE)
    public void notifyCollaborator(String message) {
        logger.info("[collaborator-notify] {}", message);
    }
}
