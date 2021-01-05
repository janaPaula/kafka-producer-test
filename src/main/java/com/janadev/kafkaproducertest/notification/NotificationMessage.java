package com.janadev.kafkaproducertest.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class NotificationMessage {

    private final Channel channel;
    private final Action action;
    private final String template;
    private final String sender;
    private final String receiver;
    private final ReceiverType receiverType;
    private final String receiverName;
    private final String receiverEmail;
    private final String resource;
    private final String campaign;
    private final Map<String, String> params;
    private final UUID externalId;
    private final Boolean push;
    private final LocalDateTime createdAt;

}
