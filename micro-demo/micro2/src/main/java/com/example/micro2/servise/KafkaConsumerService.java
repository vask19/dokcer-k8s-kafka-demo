package com.example.micro2.servise;

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
                "org.apache.kafka.common.serialization.StringDeserializer");
        kaProperties.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumerService helloWorldConsumer = new KafkaConsumerService();
        helloWorldConsumer.consume(kaProperties);
        Runtime.getRuntime().
                addShutdownHook(new Thread(helloWorldConsumer::shutdown));
        return null;

    }


    private void consume(Properties kaProperties) {
        Map<String ,String > result = new HashMap<>();
        try (KafkaConsumer<String, String> consumer =
                     new KafkaConsumer<>(kaProperties)) {
            consumer.subscribe(
                    List.of(
                            "kinaction_helloworld"
                    )
            );
            while (keepConsuming) {
                ConsumerRecords<String, String> records =
                        consumer.poll(Duration.ofMillis(250));
                for (ConsumerRecord<String, String> record :
                        records) {
                    System.out.println(record.offset() + " :" + record.value() + "-------------------");
                    result.put(record.offset()+ "",record.value());

            }}
        }
    }



    private void shutdown() {
        keepConsuming = false;
    }
}


