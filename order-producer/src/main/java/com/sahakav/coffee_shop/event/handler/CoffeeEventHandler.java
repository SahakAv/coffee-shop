package com.sahakav.coffee_shop.event.handler;

import com.sahakav.coffee_shop.event.CreateCoffeeOrderEvent;
import com.sahakav.coffee_shop.service.EventsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeEventHandler {

    @Autowired
    private EventsProducer eventsProducer;

    public void handle(CreateCoffeeOrderEvent createCoffeeOrderEvent){
       eventsProducer.produce(createCoffeeOrderEvent);}
}
