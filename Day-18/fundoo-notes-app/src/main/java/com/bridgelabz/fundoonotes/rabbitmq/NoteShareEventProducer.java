package com.bridgelabz.fundoonotes.rabbitmq;

import com.bridgelabz.fundoonotes.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

// UC10: publishes a "note shared" event onto the Exchange - any number of consumers can
// listen for it without this Producer ever needing to know they exist
@Component
public class NoteShareEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public NoteShareEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishNoteShared(int noteId, String sharedWithEmail) {
        String message = "Note " + noteId + " was shared with " + sharedWithEmail;
        rabbitTemplate.convertAndSend(RabbitMQConfig.NOTES_EXCHANGE, RabbitMQConfig.NOTE_SHARED_ROUTING_KEY, message);
    }
}
