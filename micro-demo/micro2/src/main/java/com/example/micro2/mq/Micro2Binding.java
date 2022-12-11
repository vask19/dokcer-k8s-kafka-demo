package com.example.micro2.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Micro2Binding {

    String INPUT_CHANNEL = "todoInputChannel";

    @Input(INPUT_CHANNEL)
    MessageChannel todoInputChannel();
}
