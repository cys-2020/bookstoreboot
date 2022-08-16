package com.cys.boot.dao;

import com.cys.boot.entity.ShoppingCart;

public interface ShoppingCartDAO {
	
	void insertShoppingCart(ShoppingCart sc);
	ShoppingCart getShoppingCart(long userId);
	
	
	
	void deleteShoppingCart(long userId);
}
