package com.cys.boot.service;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.entity.Seller;

public interface SellerService {
	
	int initSellerInfoIntoSeesion(HttpServletRequest hsr);
	/**
	 * after getting user's idNumber and checking phoneNumber,
	 * this user can be a seller(insert seller).
	 * @param hsr check user phonenumber if same to json
	 * @param json {phoneNumber,idNumber}
	 * @return 1 if register ok
	 */
	int registerToSeller(HttpServletRequest hsr, String json);
	
	
	
	
	
	Seller getSeller(long id);
	Seller getSellerByUserId(long userId);
	
	
	
	
	void updateSeller(Seller seller);
	void deleteSeller(Seller seller);
}
