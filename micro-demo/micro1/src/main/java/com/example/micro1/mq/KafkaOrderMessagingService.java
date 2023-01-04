package com.example.micro1.mq;
import com.example.micro1.AlertLevelPartitioner;
import com.example.micro1.domain.Alert;
import com.example.micro1.domain.AlertKeySerde;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.Properties;
@Service
@Configuration
@Slf4j
public class KafkaOrderMessagingService {
    private KafkaTemplate<String, TacoOrder> kafkaTemplate;


    public void sendOrder(TacoOrder order) {
            Properties kaProperties = new Properties();
            kaProperties.put("bootstrap.servers",
                    "localhost:9092,localhost:9093");
            kaProperties.put("key.serializer",
                    AlertKeySerde.class.getName());
            kaProperties.put("value.serializer",
                    "org.apache.kafka.common.serialization.StringSerializer");
                    kaProperties.put("partitioner.class",
                            AlertLevelPartitioner.class.getName());

        try (Producer<Alert, String> producer =
                     new KafkaProducer<>(kaProperties)) {
            Alert alert = new Alert(1, "Stage 1", "CRITICAL", "Stage 1 stopped");
            ProducerRecord<Alert, String>  producerRecord =
                  new ProducerRecord<>
                    ("kinaction_alert", alert, alert.getAlertMessage());
            producer.send(producerRecord,
                    new AlertCallback());



        }





    }
    }
