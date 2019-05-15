package com.sahakav.coffee_shop.repository;

import com.sahakav.coffee_shop.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,UUID> {
}
