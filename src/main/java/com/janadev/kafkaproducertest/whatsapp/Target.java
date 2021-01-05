package com.janadev.kafkaproducertest.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Target {

    private String targetId;
    private String phoneNumber;
}
