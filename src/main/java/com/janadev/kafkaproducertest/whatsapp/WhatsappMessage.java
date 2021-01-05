package com.janadev.kafkaproducertest.whatsapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class WhatsappMessage {

    @JsonProperty(value = "vendor_properties")
    private Map<String, String> vendorProperties;

    @JsonProperty(value = "link_params_strategy")
    private String linkParamsStrategy;

    @JsonProperty(value = "link_params")
    private List<String> linkParams;
}
