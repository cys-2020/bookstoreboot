package com.cys.boot.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.CouponDAO;
import com.cys.boot.entity.Coupon;
import com.cys.boot.manager.CouponManager;
@Service
public class CouponManagerImp implements CouponManager {
	private CouponDAO dao;
	

	public CouponManagerImp(CouponDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public Coupon getCoupon(long id) {
		//
		return dao.getCoupon(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public Coupon getCouponByBothId(long userId, long storeId) {
		//
		return dao.getCouponByBothId(userId, storeId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertCoupon(Coupon coupon) {
		//
		dao.insertCoupon(coupon);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateCoupon(Coupon coupon) {
		//
		dao.updateCoupon(coupon);
	}

}
