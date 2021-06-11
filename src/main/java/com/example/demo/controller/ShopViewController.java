package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Book;
import com.example.demo.model.Cart;
import com.example.demo.service.BookService;
import com.example.demo.utils.CartUtils;
import com.example.demo.utils.CommonConst;

@Controller
@RequestMapping("/shop")
public class ShopViewController {

	@Autowired
	private BookService _bookService;
	
	@GetMapping
	public String getBooks(Model model,
			@RequestParam(defaultValue = "0") int currentPage) {
		
		// trường hợp nhỏ hơn 0
		// lấy trang đầu tiên
		if (currentPage < 0) 
			currentPage = 0;
		Page<Book> page = _bookService
				.getPages(currentPage, CommonConst.PAGE_SIZE);
		
		// trường hợp lớn hơn tổng trang
		// lấy trang cuối cùng
		if (page.getTotalPages() < currentPage)
			page = _bookService
				.getPages(page.getTotalPages(), CommonConst.PAGE_SIZE);
		
		model.addAttribute("page", page);
		return "shop/shopping";
	}
	
	@GetMapping("/addToCart/{bookId}")
	public String addToCart(@PathVariable Integer bookId,
			Model model,
			HttpServletRequest request) {
		Cart cart = CartUtils.getCartInSession(request);
		cart.getCartDetails().put(bookId, 
				cart.getCartDetails().get(bookId) == null ?
						1 : cart.getCartDetails().get(bookId) + 1);
		model.addAttribute("cartDetails", cart.getCartDetails());
		return "shop/cart";
	}
	
}
