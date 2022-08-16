package com.cys.boot.manager.impl;

import java.util.ArrayList;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.ShoppingCartItemDAO;
import com.cys.boot.entity.ShoppingCartItem;
import com.cys.boot.manager.ShoppingCartItemManager;
@Service
public class ShoppingCartItemManagerImp implements ShoppingCartItemManager {
	private ShoppingCartItemDAO dao;
	
	public ShoppingCartItemManagerImp(ShoppingCartItemDAO dao) {
		super();
		this.dao = dao;
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public ShoppingCartItem getShoppingCartItem(long id) {
		//
		return dao.getShoppingCartItem(id);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public ArrayList<ShoppingCartItem> getShoppingCartItemByShoppingCartId(long scid) {
		//
		return dao.getShoppingCartItemByShoppingCartId(scid);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void insertShoppingCartItem(ShoppingCartItem chat) {
		//
		dao.insertShoppingCartItem(chat);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void updateShoppingCartItem(ShoppingCartItem chat) {
		//
		dao.updateShoppingCartItem(chat);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void deleteShoppingCartItem(long id) {
		//
		dao.deleteShoppingCartItem(id);
	}

}
