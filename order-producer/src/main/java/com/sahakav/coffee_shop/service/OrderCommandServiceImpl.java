package com.sahakav.coffee_shop.service;

import com.sahakav.coffee_shop.event.AbstractCoffeeOrderEvent;
import com.sahakav.coffee_shop.event.CreateCoffeeOrderEvent;
import com.sahakav.coffee_shop.event.handler.CoffeeEventHandler;
import com.sahakav.coffee_shop.model.CoffeeOrder;
import com.sahakav.coffee_shop.model.CoffeeType;
import com.sahakav.coffee_shop.repository.CoffeeOrderRepository;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderCommandService.class);

    private final CoffeeEventHandler coffeeEventHandler;

    private final CoffeeOrderRepository coffeeOrderRepository;

    public OrderCommandServiceImpl(CoffeeEventHandler coffeeEventHandler, CoffeeOrderRepository coffeeOrderRepository) {
        this.coffeeEventHandler = coffeeEventHandler;
        this.coffeeOrderRepository = coffeeOrderRepository;
    }

    @Override
    public Try<UUID> placeOrder(CoffeeType coffeeType) {
        return Try.success(coffeeType)
                .map(CoffeeOrder::new)
                .map(coffeeOrderRepository::save)
                .peek(coffeeOrder -> LOGGER.info("Creating order " + coffeeOrder))
                .map(CreateCoffeeOrderEvent::new)
                .andThen(coffeeEventHandler::handle)
                .map(AbstractCoffeeOrderEvent::getOrderId);

    }
}
