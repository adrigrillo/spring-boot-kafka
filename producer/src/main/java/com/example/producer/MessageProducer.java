package com.example.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Component
@RestController
@EnableBinding(Source.class)
public class MessageProducer {

    private Source source;

    @Autowired
    public MessageProducer(Source source) {
        this.source = source;
    }

    @RequestMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private void createMessage(@RequestParam("message") String message) {
        log.info("Received petition, sending message. Message to send [0]", message);
        source.output().send(MessageBuilder.withPayload(message).build());
    }
}
