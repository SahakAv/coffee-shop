package com.sahakav.coffee_shop.event;

import com.sahakav.coffee_shop.model.CoffeeOrder;
import com.sahakav.coffee_shop.model.CoffeeType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CreateCoffeeOrderEvent extends AbstractCoffeeOrderEvent {
    @JsonProperty(value = "coffeeType")
    private CoffeeType coffeeType;

    public CreateCoffeeOrderEvent() {
        //Default constructor
    }

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
