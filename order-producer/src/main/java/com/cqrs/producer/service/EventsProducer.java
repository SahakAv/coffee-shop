package com.cqrs.producer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventsProducer {

    @Value("${orders.topic}")
    private String topic;
}
