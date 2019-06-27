package com.sahakav.coffee_shop.event

import java.util.UUID

import com.fasterxml.jackson.annotation.JsonProperty
import com.sahakav.coffee_shop.model.{CoffeeOrder, CoffeeType}

case class CreateCoffeeOrderEvent(@JsonProperty(value = "coffeeType") coffeeType: CoffeeType, @JsonProperty(value = "orderId") orderId: UUID) extends AbstractCoffeeOrderEvent {


  override def getOrderId: UUID = orderId
}

object CreateCoffeeOrderEvent {


  def apply(coffeeOrder: CoffeeOrder): CreateCoffeeOrderEvent = new CreateCoffeeOrderEvent(coffeeOrder.coffeeType, UUID.randomUUID())
}

