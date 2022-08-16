package com.cys.boot.manager.impl;

import java.util.ArrayList;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.OrderformDAO;
import com.cys.boot.entity.Orderform;
import com.cys.boot.manager.OrderformManager;
@Service
public class OrderformManagerImp implements OrderformManager {
	private OrderformDAO dao;
	

	public OrderformManagerImp(OrderformDAO dao) {
		super();
		this.dao = dao;
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public Orderform getOrderform(long id) {
		//
		return dao.getOrderform(id);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void insertOrderform(Orderform o) {
		//
		dao.insertOrderform(o);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void updateOrderform(Orderform o) {
		//
		dao.updateOrderform(o);
	}



	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Orderform> getOrderformByUserid(long userId) {
		//
		return dao.getOrderformByUserid(userId);
	}
	

}
