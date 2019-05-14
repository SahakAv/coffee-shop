package com.cqrs.producer.event;

import com.cqrs.producer.model.CoffeeOrder;
import com.cqrs.producer.model.CoffeeType;

import java.util.UUID;

public class CreateCoffeeOrderEvent extends AbstractCoffeeOrderEvent {

    private CoffeeType coffeeType;

    public CreateCoffeeOrderEvent(UUID orderId, CoffeeType coffeeType) {
        super(orderId);
        this.coffeeType = coffeeType;
    }

    public CreateCoffeeOrderEvent(CoffeeOrder coffeeOrder){
        super(coffeeOrder.getId());
        this.coffeeType  = coffeeOrder.getCoffeeType();
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }
}
