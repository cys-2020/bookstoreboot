package com.cys.boot.dao;
import java.util.ArrayList;

import com.cys.boot.entity.ShoppingCartItem;
public interface ShoppingCartItemDAO {
	ShoppingCartItem getShoppingCartItem(long id);
	ArrayList<ShoppingCartItem> getShoppingCartItemByShoppingCartId(long scid);
	void insertShoppingCartItem(ShoppingCartItem sci);
	void updateShoppingCartItem(ShoppingCartItem sci);
	void deleteShoppingCartItem(long id);
}
