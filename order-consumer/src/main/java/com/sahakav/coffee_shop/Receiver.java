package com.sahakav.coffee_shop;

import com.cqrs.producer.event.CreateCoffeeOrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver  {

    @KafkaListener(topics = "orders")
    public void listen(@Payload CreateCoffeeOrderEvent message){
        System.out.println(message);
    }
}
