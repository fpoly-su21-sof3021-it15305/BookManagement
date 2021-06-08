package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Book")
@SQLDelete(sql = "UPDATE Book SET is_deleted = 1 WHERE Id=?")
@Where(clause = "is_deleted=0")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "BookId")
	private Integer bookId;
	
	@Column(name = "Name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "Quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "Price", nullable = false)
	private BigDecimal price; // để BigDecimal cho tính toán chính xác
	
	@Column(name = "Author", length = 100, nullable = false)
	private String author;
	
	@Column(name = "PublishedDate", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishedDate;
	
	@Column(name = "BookType", nullable = false)
	private BookType type;
	
	@Column(name = "IsDeleted", nullable = false)
	private boolean isDeleted;
	
	@OneToMany(mappedBy = "book")
	private List<OrderDetail> orderDetails;
}
