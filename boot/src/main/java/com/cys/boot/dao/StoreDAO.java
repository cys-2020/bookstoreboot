package com.cys.boot.dao;

import java.util.ArrayList;

import com.cys.boot.entity.Store;

public interface StoreDAO {
	Store getStore(long id);
	Store getStoreAndAllGood(long id);
	String getStoreName(long id);
	ArrayList<Store> getStoreByName(String nameKey);
	ArrayList<Store> getStoreBySellerId(long sellerId);
	ArrayList<Long> getStoreIdBySellerId(long sellerId);
	void insertStore(Store store);
	void updateStore(Store store);
	void deleteStore(long storeId);
	
}
