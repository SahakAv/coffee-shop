package com.sahakav.coffee_shop.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "coffee_order")
public class CoffeeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CoffeeType coffeeType;

    public CoffeeOrder(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }
}
