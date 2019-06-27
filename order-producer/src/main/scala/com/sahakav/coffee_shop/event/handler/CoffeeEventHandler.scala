package com.sahakav.coffee_shop.event.handler

import java.util.UUID

import com.sahakav.coffee_shop.event.CreateCoffeeOrderEvent
import com.sahakav.coffee_shop.service.EventsProducer
import org.springframework.stereotype.Service

@Service
class CoffeeEventHandler(val eventsProducer: EventsProducer) {

  def handle(createCoffeeOrderEvent: CreateCoffeeOrderEvent): UUID = {
    eventsProducer.produce(createCoffeeOrderEvent)
    createCoffeeOrderEvent.orderId
  }
}
