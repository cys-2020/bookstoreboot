package com.cys.boot.service;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.cys.boot.entity.Orderform;

public interface OrderformService {
	Orderform getOrderform(long id);
	
	void insertOrderform(Orderform o);
	void updateOrderform(Orderform o);
	/**
	 * user check out his orderforms(and status) by user_id(fk)
	 * @param hsr
	 * @return user's orderform list
	 * @author Chenyongsheng
	 * @throws JsonProcessingException 
	 */
	String getOrderformByUserid(HttpServletRequest hsr) throws JsonProcessingException;
	
	
}
