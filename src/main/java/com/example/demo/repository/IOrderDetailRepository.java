package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.OrderDetail;
import com.example.demo.model.OrderDetailId;

public interface IOrderDetailRepository 
	extends CrudRepository<OrderDetail, OrderDetailId>{

}
