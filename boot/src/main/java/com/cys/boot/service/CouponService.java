package com.cys.boot.service;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.typeNeedHandle.CouponEnum;
/**
 * 
 *@description [id,userid,storeid,m1,m2...,m10,([if(m3==0)]am1*am2*)]
 *@author Chenyongsheng
 *@date 2022/7/7
 */
public interface CouponService {
	/**
	 * get a coupon in a store, according to all good total
	 * price user will buy.
	 * @param hsr get userid
	 * @param storeId 
	 * @param totalPrice total price of all good user buy
	 * @return a coupon enum
	 */
	CouponEnum getCouponByTotalPriceInOneStore(
			HttpServletRequest hsr,long storeId,float totalPrice);
	
	
	
	
	
	
	/**
	 * init coupon when user buy a good in a store or add into sc.
	 * if user hasnot buy or add into sc in the store,
	 *  insert(init) his coupon about this store, else  do nothing
	 * @param hsr
	 * @param storeId
	 * @author Chenyongsheng
	 */
	void initCoupon(HttpServletRequest hsr,long storeId);
	
	
	//void increCoupon();
	
	/**
	 * after user using a coupon(pay for orderform), one coupon number-1
	 * @param userId
	 * @param storeId
	 * @param flag coupon's flag(as coupon number[] index)
	 * @author Chenyongsheng
	 */
	void decreCouponAmount(long userId,long storeId,int flag);
}
