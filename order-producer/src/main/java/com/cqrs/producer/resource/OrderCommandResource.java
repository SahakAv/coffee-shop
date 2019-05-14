package com.cqrs.producer.resource;

import com.cqrs.producer.service.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderCommandResource {
    @Autowired
    private OrderCommandService orderCommandService;


}
