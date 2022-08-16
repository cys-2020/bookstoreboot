package com.cys.boot.service;

import javax.servlet.http.HttpServletRequest;
/**
 *@description update orderform status only by seller action(control)
 *@author Chenyongsheng
 *@date 2022/5/21
 */
public interface StatusForSellerService extends StatusService {
	/**
	 * if seller send good to wait shipping, exe this method to update this
	 * orderform by id.  status=2
	 * @param json order id,sendtime
	 * @author Chenyongsheng
	 */
	void sendForOrderform(String json);
	/**
	 * seller ok to refund. the orderform is canceled,  status=-3
	 * @param json refund id,ok_time
	 * @author Chenyongsheng
	 */
	void okRefundForOrderform(String json);
	
	/**
	 * seller refuse to refund,  status=-2
	 * @param id refund id
	 * @author Chenyongsheng
	 */
	void refuseRefundForOrderform(long id);
	@Override
	default long newOrderform(String json,HttpServletRequest req) {
		//
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

	
}
