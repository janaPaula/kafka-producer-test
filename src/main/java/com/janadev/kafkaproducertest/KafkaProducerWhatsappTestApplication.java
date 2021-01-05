package com.janadev.kafkaproducertest;

import com.janadev.kafkaproducertest.kafka.OutputStream;
import com.janadev.kafkaproducertest.kafka.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@Slf4j
@EnableBinding(value = {OutputStream.class})
@SpringBootApplication
public class KafkaProducerWhatsappTestApplication implements CommandLineRunner {

	@Autowired
	private ProducerService producerService;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerWhatsappTestApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("ESCREVENDO NO TÓPICO");
		producerService.sendWhatsappMensageToKafkaTopic();
	}
}
