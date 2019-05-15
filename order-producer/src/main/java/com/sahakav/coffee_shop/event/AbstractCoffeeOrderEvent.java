package com.sahakav.coffee_shop.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public abstract class AbstractCoffeeOrderEvent {
    @JsonProperty(value = "orderId")
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
