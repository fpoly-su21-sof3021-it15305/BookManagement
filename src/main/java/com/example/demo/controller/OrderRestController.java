package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private OrderService _orderService;
	
	@PostMapping
	public int newOrder(@RequestBody Order order) {
		return _orderService.newOrder(order).getOrderId();
	}
}
