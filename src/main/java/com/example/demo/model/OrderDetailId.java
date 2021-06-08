package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderDetailId implements Serializable {
	private static final long serialVersionUID = -433049638735652351L;
	
	private Order order;
	private Book book;
}
