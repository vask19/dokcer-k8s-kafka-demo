package com.example.micro1.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Micro2Binding {
    String OUTPUT_CHANNEL = "todoOutputChannel";


    @Output(OUTPUT_CHANNEL)
    MessageChannel todoOutputChannel();
}
