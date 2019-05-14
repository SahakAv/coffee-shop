package com.cqrs.producer.repository;

import com.cqrs.producer.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,UUID> {
}
