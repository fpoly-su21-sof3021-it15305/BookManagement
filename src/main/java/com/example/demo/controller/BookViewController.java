package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;
import com.example.demo.model.BookType;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookViewController {

	@Autowired
	private BookService _bookService;
	
	@GetMapping
	public String getListPage(Model model) {
		List<Book> books = _bookService.getAll();
		model.addAttribute("books", books);
		return "book/list";
	}
	
	@GetMapping("/{id}")
	public String getDetailPage(@PathVariable Integer id,
			Model model) {
		Book book = _bookService.getById(id);
		model.addAttribute("book", book);
		model.addAttribute("bookTypes", BookType.values());
		return "book/detail";
	}
	
	@GetMapping("/new")
	public String getNewPage(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("bookTypes", BookType.values());
		return "book/new";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute("book") Book book, 
			Model model) {
		Integer id = _bookService.save(book);
		model.addAttribute("book", book);
		System.out.println("Insert");
		return "redirect:/book/" + id;
	}
	
	@PutMapping("/update")
	public String update(@ModelAttribute("book") Book book, 
			Model model) {
		_bookService.save(book);
		model.addAttribute("book", book);
		System.out.println("Update");
		return "redirect:/book";
	} 
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		_bookService.deleteById(id);
		return "redirect:/book";
	}
}
