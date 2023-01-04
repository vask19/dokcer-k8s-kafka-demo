package com.example.micro1.domain;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class AlertKeySerde implements Serializer<Alert>,
        Deserializer<Alert> {


    public byte[] serialize(String topic, Alert key) {
        if (key == null) {
            return null;
        }
        return key.getStageId().getBytes(StandardCharsets.UTF_8);
    }


    public Alert deserialize
            (String topic, byte[] value) {
        // в будущем может возвращать Alert, если потребуется
        return null;
    }

    @Override
    public void serialize(Alert object, OutputStream outputStream) throws IOException {

    }
}

