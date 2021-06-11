package com.example.demo.utils;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.Cart;

public class CartUtils {

	// Products in the cart, stored in Session.
	public static Cart getCartInSession(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("myCart");
		if (cart == null) {
			cart = new Cart();
			cart.setCartDetails(new HashMap<Integer, Integer>());
			request.getSession().setAttribute("myCart", cart);
		}
		return cart;
	}
	
	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}
}
