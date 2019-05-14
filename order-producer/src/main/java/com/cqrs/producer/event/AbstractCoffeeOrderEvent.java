package com.cqrs.producer.event;

import java.util.UUID;

public abstract class AbstractCoffeeOrderEvent {
    private final UUID orderId;


    public AbstractCoffeeOrderEvent(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

}
