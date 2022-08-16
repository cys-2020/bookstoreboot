package com.cys.boot.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.entity.CustomerServiceStaff;
public interface CustomerServiceStaffService {
	
	
	/**
	 * if user want to be a css, he needs to provide json.
	 * if user is a seller, he can only be css for the stores he owns.
	 * and, one user can only be css limitting 5
	 * @param hsr
	 * @param json {storeId,niceName}
	 * @return 1 if user can register
	 */
	int registerToCustomerServiceStaff(
			HttpServletRequest hsr, String json);
	
	
	
	int initCSSInfoIntoSession(HttpServletRequest hsr);
	
	
	CustomerServiceStaff getCustomerServiceStaff(long id);
	ArrayList<CustomerServiceStaff>  getCustomerServiceStaffByUserId(long userId);
	ArrayList<Long> getCssingStoreids(HttpServletRequest hsr);
	
	
	
	void insertCustomerServiceStaff(CustomerServiceStaff css);
	void updateCustomerServiceStaff(CustomerServiceStaff css);
	void deleteCustomerServiceStaff(CustomerServiceStaff css);
}
