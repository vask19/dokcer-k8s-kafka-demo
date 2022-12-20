package com.example.micro1.mq;
import com.example.micro1.Alert;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Properties;
import java.util.logging.Logger;

import static com.example.micro1.AlertStatus.Critical;

@Service
@Configuration
@Slf4j
public class KafkaOrderMessagingService {
    private KafkaTemplate<String, TacoOrder> kafkaTemplate;


    public void sendOrder(TacoOrder order) {
            Properties kaProperties = new Properties();
            kaProperties.put("bootstrap.servers",
                    "localhost:9092,localhost:9093,localhost:9094");
            kaProperties.put("key.serializer",
                    "org.apache.kafka.common.serialization.LongSerializer");
            kaProperties.put("value.serializer",
                    "io.confluent.kafka.serializers.KafkaAvroSerializer");
            kaProperties.put("schema.registry.url",
                    "http://localhost:8081");
            try (Producer<Long, Alert> producer =
                         new KafkaProducer<>(kaProperties)) {
                Alert alert =
                        new Alert(12345L,
                                Instant.now().toEpochMilli(),
                                Critical);
                log.info("kinaction_info Alert -> {}", alert);
                ProducerRecord<Long, Alert> producerRecord =
                        new ProducerRecord<>("kinaction_schematest",
                                alert.getSensorId(),
                                alert);
                producer.send(producerRecord);
            }
        }
    }
