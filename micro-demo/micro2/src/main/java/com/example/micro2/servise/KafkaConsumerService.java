package com.example.micro2.servise;

import com.example.micro2.Alert;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

@Service
@Slf4j
public class KafkaConsumerService {
    private volatile boolean keepConsuming = true;



    public Map<String, String> getDate(){
        Properties kaProperties = new Properties();
        kaProperties.put("bootstrap.servers",
                "localhost:9092,localhost:9093,localhost:9094");
        kaProperties.put("group.id", "kinaction_helloconsumer");
        kaProperties.put("enable.auto.commit", "true");
        kaProperties.put("auto.commit.interval.ms", "1000");
        kaProperties.put("key.deserializer",
                "org.apache.kafka.common.serialization.LongDeserializer");
        kaProperties.put("value.deserializer",
                "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        kaProperties.put("schema.registry.url", "http://localhost:8081");

        KafkaConsumerService helloWorldConsumer = new KafkaConsumerService();
        helloWorldConsumer.consume(kaProperties);
        Runtime.getRuntime()
                .addShutdownHook(
                        new Thread(helloWorldConsumer::shutdown)
                );
        return null;

    }


    private void consume(Properties kaProperties) {
        try (KafkaConsumer<Long, Alert> consumer =
                     new KafkaConsumer<>(kaProperties)) {
            consumer.subscribe(
                    List.of("kinaction_schematest")
            );
            while (keepConsuming) {
                ConsumerRecords<Long, Alert> records =
                        consumer.poll(Duration.ofMillis(250));
                for (ConsumerRecord<Long, Alert> record :
                        records) {
                    log.info("kinaction_info offset = {}, kinaction_value = {}",
                            record.offset(),
                            record.value());
                }
            }
        }
    }


    private void shutdown() {
        keepConsuming = false;
    }
}


