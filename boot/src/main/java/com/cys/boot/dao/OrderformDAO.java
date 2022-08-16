package com.cys.boot.dao;

import java.util.ArrayList;

import com.cys.boot.entity.Orderform;

public interface OrderformDAO {
	Orderform getOrderform(long id);
	void insertOrderform(Orderform o);
	void updateOrderform(Orderform o);
	/**
	 * user check out his orderforms(and status) by user_id(fk)
	 * @param userId user_id
	 * @return user's orderform list
	 * @author Chenyongsheng
	 */
	ArrayList<Orderform> getOrderformByUserid(long userId);
}
