package com.sahakav.coffee_shop;

import com.sahakav.coffee_shop.event.CreateCoffeeOrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Receiver  {

    @KafkaListener(topics = "order")
    public void listen(@Payload CreateCoffeeOrderEvent message){
        System.out.println("m" +message);
    }
}
