package com.sahakav.coffee_shop.service

import com.sahakav.coffee_shop.event.AbstractCoffeeOrderEvent
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture


@Component
class EventsProducer(@Autowired val kafkaTemplate: KafkaTemplate[String, _ >: AbstractCoffeeOrderEvent]) {

  @Value("${kafka.orders.topic}")
  var topic: String = _


  def produce(abstractCoffeeOrderEvent: AbstractCoffeeOrderEvent): Unit = {
    try
       kafkaTemplate.send(topic, abstractCoffeeOrderEvent)
    catch {
      case e: Exception =>
        System.out.println(e)
    }
  }
}
