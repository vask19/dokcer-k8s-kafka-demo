package com.example.micro1.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

@Slf4j
public class AlertCallback implements Callback {
    public void onCompletion
            (RecordMetadata metadata,
             Exception exception) {
        if (exception != null) {
            log.error("kinaction_error", exception);
        } else {
            log.info("kinaction_info offset = {}, topic = {}, timestamp = {}",
                    metadata.offset(), metadata.topic(), metadata.timestamp());
        }
    }
}
    }
