package com.example.micro2.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@EnableBinding(Micro2Binding.class)
@Component
public class MessageConsumer {


    @StreamListener(target = Micro2Binding.INPUT_CHANNEL)
    private void initTestData(Long userId){
        System.out.println("user id:" + userId);
    }
}
