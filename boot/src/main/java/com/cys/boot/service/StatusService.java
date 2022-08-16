package com.cys.boot.service;

import javax.servlet.http.HttpServletRequest;

/**
 *@description orderform status about both user and seller(0:new(in
 *sert)-->1:pay-->2:send-->3:end-->(-1:applyrefund)-->
 *(-2:refuse refund)-->(-3:cancel/okRefund)
 *@author Chenyongsheng
 *@date 2022/5/26
 */
public interface StatusService {
	/**
	 * if user commit a orderform, exe this method to generate(insert)
	 * a orderform(before user pay).  status=0
	 * @param json JSON1(de)==>#{goodId}, #{goodType}
	 * ,#{goodAmount}.
	 * JSON2(orderform)==>#{postage},#{coupon},
	 * #{shippingInsurance}, #{note}
	 * ,#{invoice},#{finalMoney},#{createTime}.GENERATE==>
	 * #{orderNumber},#{dealPoint},#{payNumber}
	 * @return new orderform's id after inserting
	 * @author Chenyongsheng
	 */
	long newOrderform(String json,HttpServletRequest req);
	
	/**
	 * if user confirm he got his good, exe this method to update this
	 * orderform by id.  status=3
	 * @param json #{order id},#{endTime}
	 * @author Chenyongsheng
	 */
	void endOrderform(String json);
	
	
	/**
	 * if user do not finish cashiering in 30min, or, he applies to refund(
	 * successfully) before seller sending good or after confirming
	 *  getting good.  status=-3
	 * @param id id of orderform will be canceled
	 * @author Chenyongsheng
	 */
	void cancelOrderform(long id);
}
