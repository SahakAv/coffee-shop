package com.sahakav.coffee_shop.service;

import com.sahakav.coffee_shop.model.CoffeeType;
import io.vavr.control.Try;

import java.util.UUID;

public interface OrderCommandService {

    Try<UUID> placeOrder(CoffeeType coffeeType);

}
