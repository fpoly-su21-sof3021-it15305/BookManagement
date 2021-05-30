package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController()
@RequestMapping("/api/book")
public class BookRestController {

	@Autowired // Khởi tạo object, Spring tự làm
	private BookService _bookService;

	// http://localhost:8080/api/book
	@GetMapping()
	public List<Book> getAll() {
		return _bookService.getAll();
	}

	// http://localhost:8080/api/book
	@GetMapping("/name/{name}")
	public List<Book> getByName(@PathVariable String name) {
		return _bookService.getByName(name);
	}

	// http://localhost:8080/api/book/get?id=1
	@GetMapping("/get")
	public Book getById2(@RequestParam Integer id) {
		return _bookService.getById(id);
	}

	// http://localhost:8080/api/book/{id}
	// Ví dụ: http://localhost:8080/api/book/1
	@GetMapping("/{id}")
	public Book getById(@PathVariable Integer id) {
		return _bookService.getById(id);
	}

	// http://localhost:8080/api/book
	@PostMapping()
	public int add(@RequestBody Book book) {
		return _bookService.save(book);
	}

	// http://localhost:8080/api/book
	@PutMapping()
	public int update(@RequestBody Book book) {
		return _bookService.save(book);
	}

	// http://localhost:8080/api/book/{id}
	// Ví dụ: http://localhost:8080/api/book/1
	@DeleteMapping("/{id}")
	public int delete(@PathVariable Integer id) {
		return _bookService.deleteById(id);
	}
}
