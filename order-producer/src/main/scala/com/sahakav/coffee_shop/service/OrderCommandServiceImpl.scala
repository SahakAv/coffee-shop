package com.sahakav.coffee_shop.service

import java.util.{Optional, UUID}

import com.sahakav.coffee_shop.event.CreateCoffeeOrderEvent
import com.sahakav.coffee_shop.event.handler.CoffeeEventHandler
import com.sahakav.coffee_shop.model.{CoffeeOrder, CoffeeOrderState, CoffeeType}
import com.sahakav.coffee_shop.repository.CoffeeOrderRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.jdk.OptionConverters.RichOptional
import scala.util.{Success, Try}
import scala.jdk.javaapi.OptionConverters.toScala


@Service
class OrderCommandServiceImpl(@Autowired val coffeeEventHandler: CoffeeEventHandler, @Autowired val coffeeOrderRepository: CoffeeOrderRepository) extends OrderCommandService {

  private val LOGGER = LoggerFactory.getLogger(classOf[OrderCommandService])


  override def placeOrder(coffeeType: CoffeeType): Try[UUID] = {
    LOGGER.info("Creating order for type '{}'",coffeeType)
    Success(coffeeType)
      .map(c =>  CoffeeOrder(c))
      .map(order => coffeeOrderRepository.save(order))
      .map(order => CreateCoffeeOrderEvent(order))
      .map(event => coffeeEventHandler.handle(event))

}

  override def getOrderState(orderId: UUID): CoffeeOrderState =

     coffeeOrderRepository.findById(orderId).toScala.map(o => o.orderState).get




}
