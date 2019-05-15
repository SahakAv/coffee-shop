package com.sahakav.coffee_shop.event;


import java.util.UUID;

public abstract class AbstractCoffeeOrderEvent {
    private  UUID orderId;

    public AbstractCoffeeOrderEvent() {
        //Default constructor
    }

    public AbstractCoffeeOrderEvent(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

}
