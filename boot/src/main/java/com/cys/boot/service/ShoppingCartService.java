package com.cys.boot.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.entity.ShoppingCart;
import com.cys.boot.entity.ShoppingCartItem;
/**
 *@description items list are saved in session.
 *(sc),(sciMap)
 *@author Chenyongsheng
 *@date 2022/7/7
 */
public interface ShoppingCartService {
	ShoppingCart getShoppingCart(long userId);
	void insertShoppingCart(long userId);
	void deleteShoppingCart(long userId);
	
	
	

	
	
	/**
	 * add item into sc
	 * @param json {item}
	 * @author Chenyongsheng
	 */
	void addItemIntoShoppingCart(HttpServletRequest hsr, String json);
	
	
	
	/**
	 * (flush) get items map in shoppingCart.
	 * @param hsr need get shoppingCart
	 * @return lastest items map
	 * @author Chenyongsheng
	 */
	HashMap<Integer, ShoppingCartItem> getUserShoppingCartItemMap(HttpServletRequest hsr);
	
	
	/**
	 * select all items in shoppingCart list
	 * @param hsr need user id->shoppingCart(session)
	 * @author Chenyongsheng
	 */
	void selectAllItem(HttpServletRequest hsr);
	
	
	/**
	 * get avail coupons by items info
	 * @param hsr need get shoppingCart
	 * @author Chenyongsheng
	 */
	void buySelectedItem(HttpServletRequest hsr);
	
	
	
	
	/**
	 * get final shoppingCart after session destroying and persist each item
	 * @param hsr need get shoppingCart
	 * @author Chenyongsheng
	 */
	void persistItems(HttpServletRequest hsr);
}
