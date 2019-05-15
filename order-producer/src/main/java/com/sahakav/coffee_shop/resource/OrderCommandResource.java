package com.sahakav.coffee_shop.resource;

import com.sahakav.coffee_shop.model.CoffeeType;
import com.sahakav.coffee_shop.service.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderCommandResource {
    private final OrderCommandService orderCommandService;


    public OrderCommandResource(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    @PostMapping(name = "/order", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> placeOrder(){
        UUID uuid = orderCommandService.placeOrder(CoffeeType.valueOf("LATTE")).get();
        return ResponseEntity.accepted().body(uuid);
    }
}
