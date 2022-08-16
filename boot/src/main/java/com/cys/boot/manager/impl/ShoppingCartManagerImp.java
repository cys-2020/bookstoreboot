package com.cys.boot.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.ShoppingCartDAO;
import com.cys.boot.entity.ShoppingCart;
import com.cys.boot.manager.ShoppingCartManager;
@Service
public class ShoppingCartManagerImp implements ShoppingCartManager {
	private ShoppingCartDAO dao;
	public ShoppingCartManagerImp(ShoppingCartDAO dao) {
		super();
;		this.dao = dao;
	}



	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void insertShoppingCart(ShoppingCart sc) {
		//
		dao.insertShoppingCart(sc);
	}



	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void deleteShoppingCart(long userId) {
		//
		dao.deleteShoppingCart(userId);
	}


	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public ShoppingCart getShoppingCart(long userId) {
		//
		return dao.getShoppingCart(userId);
	}







}
