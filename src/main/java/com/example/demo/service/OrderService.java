package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Order;
import com.example.demo.repository.IOrderRepository;

@Component
public class OrderService {

	@Autowired
	private IOrderRepository _orderRepo;
	
	public Order newOrder(Order order) {
		return _orderRepo.save(order);
	}
}
