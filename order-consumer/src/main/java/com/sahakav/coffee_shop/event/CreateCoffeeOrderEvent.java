package com.sahakav.coffee_shop.event;

import com.sahakav.coffee_shop.model.CoffeeType;

import java.util.UUID;

public class CreateCoffeeOrderEvent extends AbstractCoffeeOrderEvent {
    private CoffeeType coffeeType;

    public CreateCoffeeOrderEvent() {
        //Default constructor
    }

    public CreateCoffeeOrderEvent(UUID orderId, CoffeeType coffeeType) {
        super(orderId);
        this.coffeeType = coffeeType;
    }


    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }
}
