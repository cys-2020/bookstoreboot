package com.cys.boot.dao;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.Coupon;

public interface CouponDAO {
	Coupon getCoupon(long id);
	Coupon getCouponByBothId(@Param("userId")long userId,
			@Param("storeId")long storeId);
	void insertCoupon(Coupon coupon);
	void updateCoupon(Coupon coupon);
}
