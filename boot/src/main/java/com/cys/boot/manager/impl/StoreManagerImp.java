package com.cys.boot.manager.impl;

import java.util.ArrayList;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.StoreDAO;
import com.cys.boot.entity.Store;
import com.cys.boot.manager.StoreManager;
@Service
public class StoreManagerImp implements StoreManager {
	private StoreDAO dao;
	
	public StoreManagerImp(StoreDAO dao) {
		super();
		this.dao = dao;
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public Store getStore(long id) {
		//
		return dao.getStore(id);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void insertStore(Store store) {
		//
		dao.insertStore(store);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void updateStore(Store store) {
		//
		dao.updateStore(store);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void deleteStore(long storeId) {
		//
		dao.deleteStore(storeId);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public ArrayList<Store> getStoreByName(String nameKey) {
		//
		return dao.getStoreByName(nameKey);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Store> getStoreBySellerId(long sellerId) {
		//
		return dao.getStoreBySellerId(sellerId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Long> getStoreIdBySellerId(long sellerId) {
		//
		return dao.getStoreIdBySellerId(sellerId);
	}

	@Override
	public String getStoreName(long id) {
		//
		return dao.getStoreName(id);
	}

	@Override
	public Store getStoreAndAllGood(long id) {
		//
		return dao.getStoreAndAllGood(id);
	}

}
