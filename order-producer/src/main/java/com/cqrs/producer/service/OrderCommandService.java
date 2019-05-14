package com.cqrs.producer.service;

import com.cqrs.producer.model.CoffeeType;
import io.vavr.control.Try;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface OrderCommandService {

    Try<CompletableFuture<UUID>> placeOrder(CoffeeType coffeeType);

}
