package com.sahakav.coffee_shop.service

import java.util.UUID

import com.sahakav.coffee_shop.model.{CoffeeOrderState, CoffeeType}

import scala.util.Try

trait OrderCommandService {


  def placeOrder(coffeeType: CoffeeType): Try[UUID]

  def getOrderState(orderId:UUID):CoffeeOrderState

}
