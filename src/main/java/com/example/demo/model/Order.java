package com.example.demo.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "[Order]")
public class Order {

	@Id
	@GeneratedValue
	private Integer orderId;
	
	@Column(name = "CreatedDate",
			columnDefinition = "DATETIME DEFAULT GETDATE()")
	private Date createdDate = Calendar.getInstance().getTime();
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
}
