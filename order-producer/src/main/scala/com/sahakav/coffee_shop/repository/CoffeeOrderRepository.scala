package com.sahakav.coffee_shop.repository

import java.util.UUID

import com.sahakav.coffee_shop.model.CoffeeOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
trait CoffeeOrderRepository extends JpaRepository[CoffeeOrder, UUID]{

}
