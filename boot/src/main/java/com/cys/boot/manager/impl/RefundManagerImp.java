package com.cys.boot.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.RefundDAO;
import com.cys.boot.entity.Refund;
import com.cys.boot.manager.RefundManager;
@Service
public class RefundManagerImp implements RefundManager {
	private RefundDAO dao;
	
	public RefundManagerImp(RefundDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public Refund getRefund(long id) {
		//
		return dao.getRefund(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertRefund(Refund r) {
		//
		dao.insertRefund(r);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateRefund(Refund r) {
		//
		dao.updateRefund(r);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteRefund(Refund r) {
		//
		dao.deleteRefund(r);
	}

}
