package com.cys.boot.manager;

import java.util.ArrayList;
import com.cys.boot.entity.Cashier;

public interface CashierManager {
	Cashier getCashier(long id);
	Cashier getCashierByBothId(long userId,long storeId);
	ArrayList<Cashier> getCashierByStoreid(long storeId);
	ArrayList<Cashier> getCashierByUserid(long userId);
	void insertCashier(Cashier cashier);
	void updateCashier(Cashier cashier);
	void deleteCashier(Cashier cashier);
}
