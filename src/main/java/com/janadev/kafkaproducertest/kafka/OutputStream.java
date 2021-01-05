package com.janadev.kafkaproducertest.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface OutputStream {

    String WHATSAPP_EVENTS = "notification-whatsapp-events-output";
    String NOTIFICATION_EVENTS = "notification-events-output";

    @Output(OutputStream.WHATSAPP_EVENTS)
    MessageChannel produceWhatsAppEvent();

    @Output(OutputStream.NOTIFICATION_EVENTS)
    MessageChannel producerNotificationEvents();
}
