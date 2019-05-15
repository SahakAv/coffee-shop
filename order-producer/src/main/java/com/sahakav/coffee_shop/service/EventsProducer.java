package com.sahakav.coffee_shop.service;

import com.sahakav.coffee_shop.event.AbstractCoffeeOrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class EventsProducer {

    @Value("${kafka.orders.topic}")
    private String topic;

    private final KafkaTemplate<String, ? super AbstractCoffeeOrderEvent> kafkaTemplate;

    public EventsProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void produce(AbstractCoffeeOrderEvent abstractCoffeeOrderEvent){
        try {
            ListenableFuture<? extends SendResult<String, ? super AbstractCoffeeOrderEvent>> send = kafkaTemplate.send(topic, abstractCoffeeOrderEvent);

        }catch (Exception e){
        System.out.println(e);
    }}
}
