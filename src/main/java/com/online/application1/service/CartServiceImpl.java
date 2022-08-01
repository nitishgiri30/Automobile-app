package com.online.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.application.dao.CartRepository;
import com.online.application.dto.Cart;
import com.online.application.dto.Product;
import com.online.application.exception.CartException;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepo;

	@Override
	public Cart addCart(Cart cart) throws CartException {
		return this.cartRepo.save(cart);
	}

	@Override
	public Cart getCartById(Integer cartId) throws CartException {
		java.util.Optional<Cart> cart = this.cartRepo.findById(cartId);
		if (cart.isEmpty())
			throw new CartException("message");
		return cart.get();
	}

	@Override
	public Cart updateCart(Cart cart) throws CartException {
		java.util.Optional<Cart> productdb = this.cartRepo.findById(cart.getCartId());

		if (productdb.isEmpty()) {
			throw new CartException("id " + cart.getCartId() + "  doesn't exist ");
		}

		return this.cartRepo.save(cart);
	}

	@Override
	public void deleteCartById(Integer cartId) throws CartException {
		this.cartRepo.deleteById(cartId);
	}

}
