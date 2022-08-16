package com.cys.boot.manager.impl;

import java.util.ArrayList;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.CashierDAO;
import com.cys.boot.entity.Cashier;
import com.cys.boot.manager.CashierManager;

/**
 *@description
 *@author Chenyongsheng
 *@date 2022/6/23
 */
@Service
public class CashierManagerImp implements CashierManager {
	private CashierDAO dao;
	
	public CashierManagerImp(CashierDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public Cashier getCashier(long id) {
		//
		return dao.getCashier(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public Cashier getCashierByBothId(long userId, long storeId) {
		//
		return dao.getCashierByBothId(userId, storeId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Cashier> getCashierByStoreid(long storeId) {
		//
		return dao.getCashierByStoreid(storeId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Cashier> getCashierByUserid(long userId) {
		//
		return dao.getCashierByUserid(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertCashier(Cashier cashier) {
		//
		dao.insertCashier(cashier);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateCashier(Cashier cashier) {
		//
		dao.updateCashier(cashier);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteCashier(Cashier cashier) {
		//
		dao.deleteCashier(cashier);
	}

}
