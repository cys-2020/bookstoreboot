package com.cys.boot.manager;

import java.util.ArrayList;

import com.cys.boot.entity.Good;
public interface GoodManager {
	Good getGood(long id);
	void insertGood(Good good);
	void updateGood(Good good);
	void deleteGood(Good good);
	long getStoreid(long id);
	ArrayList<Good> getGoodByStoreId(long storeId);
	ArrayList<Good> getGoodByName(String nameKey);
	ArrayList<Good> getGoodByNameInStore(String key,long storeId);
	ArrayList<Good> getAllGood(long userId);
}
