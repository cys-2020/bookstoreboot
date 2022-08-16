package com.cys.boot.manager;

import com.cys.boot.entity.Seller;

public interface SellerManager {
	Seller getSeller(long id);
	Seller getSellerByUserId(long userId);
	long getSellerIdByUserId(long userId);
	void insertSeller(Seller seller);
	void updateSeller(Seller seller);
	void deleteSeller(Seller seller);
}
