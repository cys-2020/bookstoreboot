package com.cys.boot.manager;
import java.util.ArrayList;

import com.cys.boot.entity.ShoppingCartItem;
public interface ShoppingCartItemManager {
	ShoppingCartItem getShoppingCartItem(long id);
	ArrayList<ShoppingCartItem> getShoppingCartItemByShoppingCartId(long scid);
	void insertShoppingCartItem(ShoppingCartItem chat);
	void updateShoppingCartItem(ShoppingCartItem chat);
	void deleteShoppingCartItem(long id);
}