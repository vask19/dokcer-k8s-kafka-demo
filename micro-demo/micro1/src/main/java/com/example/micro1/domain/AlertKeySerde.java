package com.example.micro1.domain;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class AlertKeySerde implements Serializer<Alert>,
        Deserializer<Alert> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    public byte[] serialize(String topic, Alert key) {
        if (key == null) {
            return null;
        }
        return key.getStageId().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Alert data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }

    public Alert deserialize
            (String topic, byte[] value) {
        // в будущем может возвращать Alert, если потребуется
        return null;
    }

    @Override
    public Alert deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }
}
