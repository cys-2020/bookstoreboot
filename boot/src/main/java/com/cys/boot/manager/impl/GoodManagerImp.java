package com.cys.boot.manager.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.GoodDAO;

import com.cys.boot.entity.Good;
import com.cys.boot.manager.GoodManager;
@Service
public class GoodManagerImp implements GoodManager {
	private GoodDAO dao;
	public GoodManagerImp(GoodDAO dao) {
		super();
		this.dao = dao;
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public Good getGood(long id) {
		//
		return dao.getGood(id);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void insertGood(Good good) {
		//
		dao.insertGood(good);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void updateGood(Good good) {
		//
		dao.updateGood(good);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void deleteGood(Good good) {
		//
		dao.deleteGood(good);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public long getStoreid(long id) {
		//
		return dao.getStoreid(id);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public ArrayList<Good> getGoodByNameInStore(String key, long storeId) {
		//
		return dao.getGoodByNameInStore(key, storeId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Good> getGoodByName(String nameKey) {
		//
		return dao.getGoodByName(nameKey);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Good> getAllGood(long userId) {
		return dao.getAllGood(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Good> getGoodByStoreId(long storeId) {
		return dao.getGoodByStoreId(storeId);
	}

}
