package com.cys.boot.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.entity.ShoppingCartItem;
/**
 * 
 *@description  items map are saved in session.(sciMap)
 *@author Chenyongsheng
 *@date 2022/7/7
 */
public interface ShoppingCartItemService {
	
	ArrayList<ShoppingCartItem> 
				getShoppingCartItemByShoppingCartId(long scId);
	void insertShoppingCartItem(ShoppingCartItem sci);
	void updateShoppingCartItem(ShoppingCartItem sci);
	void deleteShoppingCartItem(long id);
	
	
	/**
	 * select this item(set selected), and return good activities info if exist.
	 * @param hsr get sc
	 * @param index items list index
	 * @return good coupon info json
	 * @author Chenyongsheng
	 */
	String selectItem(HttpServletRequest hsr, int index);
	
	
	/**
	 * get shoppingCart item good's typs list
	 * @param hsr
	 * @param index
	 * @return good typ list
	 * @author Chenyongsheng
	 */
	ArrayList<String> getTyp(HttpServletRequest hsr, int index);
	
	
	/**
	 * update item good's type in shoppingCart
	 * @param hsr
	 * @param index
	 * @param typIndex typs[] index
	 * @author Chenyongsheng
	 */
	void updateType(HttpServletRequest hsr, int index,int typIndex);
	
	
	/**
	 * update item good's amount in shoppingCart
	 * @param hsr
	 * @param index
	 * @param amount good amount in item
	 * @author Chenyongsheng
	 */
	void updateAmount(HttpServletRequest hsr, int index,int amount);
	
	
	/**
	 * delete this item from shoppingCart
	 * @param index item arraylist index
	 * @author Chenyongsheng
	 */
	void deleteItem(HttpServletRequest hsr, int index);
	
	
}
