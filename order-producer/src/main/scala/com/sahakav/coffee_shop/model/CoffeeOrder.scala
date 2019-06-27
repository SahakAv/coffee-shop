package com.sahakav.coffee_shop.model

import javax.persistence._
import java.util.UUID


@Entity
@Table(name = "coffee_order")
class CoffeeOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: UUID = _

  @Enumerated(EnumType.STRING)
  @Column(name = "orderState")
  var orderState: CoffeeOrderState = CoffeeOrderState.IN_PROCESS

  @Column(name = "coffeeType")
  var coffeeType: CoffeeType = _


}

object CoffeeOrder {

  def apply(coffeeType: CoffeeType): CoffeeOrder = {
    val coffeeOrder: CoffeeOrder = new CoffeeOrder
    coffeeOrder.coffeeType = coffeeType
    coffeeOrder
  }

}

