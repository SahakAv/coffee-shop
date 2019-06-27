package com.sahakav.coffee_shop.resource

import java.util.UUID

import com.sahakav.coffee_shop.model.{CoffeeOrderState, CreateCoffeeOrderRequestModel}
import com.sahakav.coffee_shop.service.OrderCommandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestBody, RequestMapping, RequestMethod, RestController}

import scala.util.{Failure, Success}

@RestController
@RequestMapping()
class OrderCommandResource (@Autowired val orderCommandService: OrderCommandService){


  @RequestMapping(path = Array("/order"), consumes = Array("application/json"), produces = Array("application/json"), method = Array(RequestMethod.POST))
  def placeOrder(@RequestBody createCoffeeOrderDto: CreateCoffeeOrderRequestModel): ResponseEntity[UUID] = {
     orderCommandService.placeOrder(createCoffeeOrderDto.coffeeType) match {
       case Success(value) => ResponseEntity.accepted().body(value)
       case Failure(exception) => throw new RuntimeException(exception)
     }
  }

  @RequestMapping(path = Array("/order/{id}"),  produces = Array("application/json"), method = Array(RequestMethod.GET))
  def getOrderState(@PathVariable(name = "id") id:UUID): CoffeeOrderState ={
    orderCommandService.getOrderState(id)
  }
}
