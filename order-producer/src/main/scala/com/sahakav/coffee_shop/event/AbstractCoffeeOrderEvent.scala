package com.sahakav.coffee_shop.event

import java.util.UUID


abstract class AbstractCoffeeOrderEvent() {


   def getOrderId: UUID

}
