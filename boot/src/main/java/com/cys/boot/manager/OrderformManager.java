package com.cys.boot.manager;

import java.util.ArrayList;

import com.cys.boot.entity.Orderform;

public interface OrderformManager {
	Orderform getOrderform(long id);
	void insertOrderform(Orderform o);
	void updateOrderform(Orderform o);
	ArrayList<Orderform> getOrderformByUserid(long userId);
}
