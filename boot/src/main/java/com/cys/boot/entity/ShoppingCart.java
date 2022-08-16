package com.cys.boot.entity;

import java.util.HashMap;

/**
 *@description in session , because it need multi times service for
 *a while.
 * it is used as middleware between user and item, and items repo too.
 *@author Chenyongsheng
 *@date 2022/7/6
 */
public class ShoppingCart {
	private long id;
	private long userId;
	private HashMap<Integer,ShoppingCartItem> repo;
	public ShoppingCart() {
		//
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public HashMap<Integer, ShoppingCartItem> getRepo() {
		return repo;
	}
	public void setRepo(HashMap<Integer, ShoppingCartItem> repo) {
		this.repo = repo;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", userId=" + userId + ", repo=" + repo + "]";
	}

	
}
