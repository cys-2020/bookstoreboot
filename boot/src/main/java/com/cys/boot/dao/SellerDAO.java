package com.cys.boot.dao;

import com.cys.boot.entity.Seller;

public interface SellerDAO {
	Seller getSeller(long id);
	Seller getSellerByUserId(long userId);
	long getSellerIdByUserId(long userId);
	
	void insertSeller(Seller seller);
	void updateSeller(Seller seller);
	void deleteSeller(Seller seller);
}
