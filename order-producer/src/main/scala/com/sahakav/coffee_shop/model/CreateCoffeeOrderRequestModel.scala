package com.sahakav.coffee_shop.model

import com.fasterxml.jackson.annotation.JsonProperty

case class CreateCoffeeOrderRequestModel(@JsonProperty(value ="coffeeType") coffeeType: CoffeeType){



}
