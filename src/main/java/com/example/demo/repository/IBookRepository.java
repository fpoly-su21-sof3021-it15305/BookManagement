package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Book;

public interface IBookRepository 
	extends CrudRepository<Book, Integer> {

	/*
	 * Viết lại hàm tìm tất cả
	 */
	@Override
    List<Book> findAll();
	
	/*
	 * Tìm kiếm theo tên cách 1
	 * Tự định nghĩa câu truy vấn
	 */
	@Query("SELECT b FROM Book b WHERE b.name LIKE %:name%")
	List<Book> findByName(@Param("name") String name);
	
	/*
	 * Tìm kiếm theo tên cách 2
	 * Sử dụng cơ chế tự động của Spring Boot
	 */
	List<Book> findByNameLike(String name);
}
