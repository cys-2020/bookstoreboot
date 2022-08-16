package com.cys.boot.service;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.entity.Refund;

public interface RefundService {
	/**
	 * if one orderform need refund
	 * @param json orderid,applytime,refundoption,refunddescri
	 * @author Chenyongsheng
	 */
	void applyRefund(HttpServletRequest hsr, Refund r);
	
	/**
	 * if seller ok to refund, cancel the order, flag=1, orderform status=-3
	 * return money to user(in cashier)
	 * @param r id and ok_time
	 * @author Chenyongsheng
	 */
	void okRefund(Refund r);
	/**
	 * if seller refuse to refund,change flag to -1,orderform status=-2
	 * @param id refund's id
	 * @author Chenyongsheng
	 */
	void refuseRefund(long id);
}
