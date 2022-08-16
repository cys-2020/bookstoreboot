package com.cys.boot.manager;

import org.apache.ibatis.annotations.Param;


import com.cys.boot.entity.Coupon;

public interface CouponManager {
	Coupon getCoupon(long id);
	Coupon getCouponByBothId(@Param("userId")long userId,
			@Param("sotreId")long storeId);
	void insertCoupon(Coupon coupon);
	void updateCoupon(Coupon coupon);
}
