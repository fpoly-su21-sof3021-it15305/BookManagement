package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Book;

public interface IBookRepository 
	extends CrudRepository<Book, String> {

	@Override
    List<Book> findAll();
	
	@Query("SELECT b FROM Book b WHERE b.name LIKE %:name%")
	List<Book> findByName(@Param("name") String name);
	
	List<Book> findByNameLike(String name);
}
