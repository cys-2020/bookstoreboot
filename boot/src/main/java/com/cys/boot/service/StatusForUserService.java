package com.cys.boot.service;
import javax.servlet.http.HttpServletRequest;
/**
 *@description update orderform status only by user action(control)
 *@author Chenyongsheng
 *@date 2022/5/21
 */
public interface StatusForUserService extends StatusService {
	@Override
	default long newOrderform(String json,HttpServletRequest req) {
		return 0;
	}
	
	@Override
	default void endOrderform(String json) {
		//
	}

	@Override
	default void cancelOrderform(long id) {
		//
	}

	/**
	 * if user finish cashiering after commiting orderform(in 30min), 
	 * exe this method to update this orderform by id.  status=1
	 * JSON(order)==>#{id},#{payTime}
	 * @param json orderform id and paytime
	 * @author Chenyongsheng
	 */
	void payForOrderform(String json);
	
	/**
	 * if user applied to refund and seller has not handled it yet.  status=-1
	 * @param json refund(orderid,time,whystr,flag)
	 * @author Chenyongsheng
	 */
	void applyRefundForOrderform(HttpServletRequest hsr,String json);
	
}
