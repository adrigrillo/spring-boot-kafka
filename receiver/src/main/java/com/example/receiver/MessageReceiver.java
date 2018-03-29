package com.example.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Sink.class)
public class MessageReceiver {

    @StreamListener(Sink.INPUT)
    private void receiveMessage(String message) {
        log.info("Message received from Kafka: {}", message);
    }
}
