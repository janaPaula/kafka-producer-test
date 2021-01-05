package com.janadev.kafkaproducertest.whatsapp;

import lombok.Data;

@Data
public class WhatsappPayload {

    private String event;

    private Source source;

//    private Header headers;

    public WhatsappPayload(String event, Source source) {
        this.event = event;
        this.source = source;
//        this.headers = headers;
    }
}
