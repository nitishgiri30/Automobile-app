package com.online.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.application.dto.Cart;
import com.online.application.dto.Product;
import com.online.application.exception.CartException;
import com.online.application.services.CartServiceImpl;

@RestController
public class CartController { 
	
	@Autowired
	CartServiceImpl cartService;
	
	@PostMapping("cart")
	public Cart createCart(@RequestBody Cart cart) throws CartException {
		
		return this.cartService.addCart(cart); 

	}
    
	@GetMapping("cart/{id}")
	public Cart getCartById(@PathVariable("id") Integer id) throws CartException {

		return this.cartService.getCartById(id);

	}

	@PutMapping("updatecart")
	public Cart updateCart(@RequestBody Cart cart) throws CartException {

		return this.cartService.updateCart(cart);

	}

	@DeleteMapping("cart/{id}")
	public void deleteCartById(@PathVariable("id") Integer id) throws CartException {

		this.cartService.deleteCartById(id);
		System.out.println("Delete Cart id:" + id);

	}

}
