package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "OrderDetail")
@IdClass(OrderDetailId.class)
public class OrderDetail {
	@Id
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;
	
	private BigDecimal price;
	
	private Integer quantity;
}
