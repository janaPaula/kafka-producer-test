package com.janadev.kafkaproducertest.kafka;

import com.janadev.kafkaproducertest.kafka.OutputStream;
import com.janadev.kafkaproducertest.notification.Action;
import com.janadev.kafkaproducertest.notification.Channel;
import com.janadev.kafkaproducertest.notification.NotificationMessage;
import com.janadev.kafkaproducertest.notification.ReceiverType;
import com.janadev.kafkaproducertest.whatsapp.Source;
import com.janadev.kafkaproducertest.whatsapp.Target;
import com.janadev.kafkaproducertest.whatsapp.WhatsappMessage;
import com.janadev.kafkaproducertest.whatsapp.WhatsappPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final OutputStream outputStream;

    public void sendNotificationMessageToKafkaTopic(){
        HashMap<String, String> map = new HashMap<>();
        map.put("to", "5511970213420");
        NotificationMessage notificationMessage = new NotificationMessage(Channel.WHATSAPP, Action.CREATE, "signup_customer_mobile_verification_code", "", "24106350",
                ReceiverType.CONSUMER, "", "", "", "", map,
                UUID.randomUUID(), false, LocalDateTime.now());

        outputStream.producerNotificationEvents().send(MessageBuilder.withPayload(notificationMessage)
                .setHeader("correlationId", UUID.randomUUID().toString())
                .build());
    }

    public void sendWhatsappMensageToKafkaTopic(){
        WhatsappPayload payload = buildWhatsAppPayload();
        outputStream.produceWhatsAppEvent()
                .send(MessageBuilder.withPayload(payload)
                .setHeader("correlationId", UUID.randomUUID().toString())
//                .setHeader("spamId", UUID.randomUUID().toString())
                        .build());
        log.info("MESSAGEM ENVIADA COM SUCESSO");
    }

    private WhatsappPayload buildWhatsAppPayload() {
        HashMap<String, String> map = new HashMap<>();
        map.put("template_name", "welcome_multiple_languages");
        map.put("template_namespace", "whatsapp:hsm:it:infobip");
        map.put("language", "en");
        map.put("scenario_key", "4453A625D58CB8A78A0BC3F9DDB8C027");
        ArrayList<String> list = new ArrayList<>();
        list.add("code");
        WhatsappMessage whatsapp_payload = new WhatsappMessage(map, "whatsapp_params", list);
        return new WhatsappPayload(
                "NOTIFICATION_WHATSAPP_WAS_CREATED",
                new Source("a3f275aa-adee-470a-ade3-a00f5a669dde", new Target("17", "5511970213420"), whatsapp_payload)
        );
    }
}
