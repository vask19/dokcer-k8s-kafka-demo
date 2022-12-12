package com.example.micro1.mq;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Micro2Binding.class)
public class MessageProducer {

    private Micro2Binding micro2Binding;

    public MessageProducer(Micro2Binding micro2Binding) {
        this.micro2Binding = micro2Binding;
    }

    public void newUserAction(Long userId){
        Message<Long> message =  MessageBuilder.withPayload(userId).build();
        micro2Binding.todoOutputChannel().send(message);



    }

}
