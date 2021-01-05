package com.janadev.kafkaproducertest.whatsapp;

import com.janadev.kafkaproducertest.whatsapp.Source;
import com.janadev.kafkaproducertest.whatsapp.WhatsappMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Body {

    private String event;

    private Source source;

    private WhatsappMessage payload;
}
