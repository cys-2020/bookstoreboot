package com.cys.boot.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.SellerDAO;
import com.cys.boot.entity.Seller;
import com.cys.boot.manager.SellerManager;

/**
 *	@description 
 *	@author Chenyongsheng
 * 	@date 2022/5/4
 */
@Service
public class SellerManagerImp implements SellerManager {
	private SellerDAO dao;
	
	public SellerManagerImp(SellerDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public Seller getSeller(long id) {
		//
		return dao.getSeller(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertSeller(Seller seller) {
		//
		dao.insertSeller(seller);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateSeller(Seller seller) {
		//
		dao.updateSeller(seller);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteSeller(Seller seller) {
		//
		dao.deleteSeller(seller);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public Seller getSellerByUserId(long userId) {
		//
		return dao.getSellerByUserId(userId);
	}

	@Override
	public long getSellerIdByUserId(long userId) {
		//
		return dao.getSellerIdByUserId(userId);
	}

}
