package com.cys.boot.manager;

import com.cys.boot.entity.ShoppingCart;

public interface ShoppingCartManager {
	
	ShoppingCart getShoppingCart(long userId);
	void insertShoppingCart(ShoppingCart sc);
	void deleteShoppingCart(long userId);
}
