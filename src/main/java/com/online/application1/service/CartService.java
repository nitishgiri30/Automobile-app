package com.online.application.services;

import java.util.List;

import com.online.application.dto.Cart;
import com.online.application.exception.CartException;

public interface CartService {  
	
	Cart addCart(Cart cart) throws CartException;
	
	Cart getCartById(Integer cartId) throws CartException;  
	
	Cart updateCart(Cart cart) throws CartException;
	
	void deleteCartById(Integer cartId) throws CartException;

}
