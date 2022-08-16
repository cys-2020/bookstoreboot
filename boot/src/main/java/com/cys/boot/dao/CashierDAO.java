package com.cys.boot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.Cashier;

public interface CashierDAO {
	Cashier getCashier(long id);
	Cashier getCashierByBothId(@Param("userId")long userId,
			@Param("storeId")long storeId);
	ArrayList<Cashier> getCashierByStoreid(long storeId);
	ArrayList<Cashier> getCashierByUserid(long userId);
	void insertCashier(Cashier cashier);
	void updateCashier(Cashier cashier);
	void deleteCashier(Cashier cashier);
}
