package com.cqrs.producer.service;

import com.cqrs.producer.event.CreateCoffeeOrderEvent;
import com.cqrs.producer.model.CoffeeOrder;
import com.cqrs.producer.model.CoffeeType;
import com.cqrs.producer.repository.CoffeeOrderRepository;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderCommandServiceImpl implements OrderCommandService{

    @Autowired
    private EventsProducer orderPublisher;

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    @Override
    public Try<CompletableFuture<UUID>> placeOrder(CoffeeType coffeeType) {
       Try.success(coffeeType)
               .map(CoffeeOrder::new)
               .map(coffeeOrderRepository::save)
               .map(CreateCoffeeOrderEvent::new)
               .

    }
}
