package com.janadev.kafkaproducertest.whatsapp;

import com.janadev.kafkaproducertest.whatsapp.Target;
import com.janadev.kafkaproducertest.whatsapp.WhatsappMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Source {

    private String id;

    private Target target;

    private WhatsappMessage payload;
}
