package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@Column(name = "BookCode")
	private String bookCode;
	
	@Column(name = "Id", nullable = false)
	@GeneratedValue()
	private Integer id;
	
	@Column(name = "Name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "Quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "Price", nullable = false)
	private BigDecimal price; // để BigDecimal cho tính toán chính xác
	
	@Column(name = "Author", length = 100, nullable = false)
	private String author;
	
	@Column(name = "PublishedDate", nullable = false)
	private Date publishedDate;
	
	@Column(name = "BookType", nullable = false)
	private BookType type;
}
