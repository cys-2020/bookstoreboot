package com.cys.boot.manager;

import java.util.ArrayList;

import com.cys.boot.entity.Store;

public interface StoreManager {
	Store getStore(long id);
	Store getStoreAndAllGood(long id);
	String getStoreName(long id);
	ArrayList<Store> getStoreBySellerId(long sellerId);
	ArrayList<Long> getStoreIdBySellerId(long sellerId);
	void insertStore(Store store);
	void updateStore(Store store);
	void deleteStore(long storeId);
	ArrayList<Store> getStoreByName(String nameKey);
}
