import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class test {
    public static void main(String[] args) {
        Properties kaProperties =
                new Properties();
        kaProperties.put("bootstrap.servers",
                "localhost:9092,localhost:9093,localhost:9094");
        kaProperties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        kaProperties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        try (Producer<String, String> producer =
                     new KafkaProducer<>(kaProperties)) {
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<>("kinaction_helloworld",
                            null, "hello world again!");
            producer.send(producerRecord);
            System.out.println(111);

        }
    }}









