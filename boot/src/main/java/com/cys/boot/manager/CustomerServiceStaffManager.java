package com.cys.boot.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.entity.CustomerServiceStaff;

public interface CustomerServiceStaffManager {
	CustomerServiceStaff getCustomerServiceStaff(long id);
	ArrayList<CustomerServiceStaff>  getCustomerServiceStaffByUserId(long userId);
	ArrayList<Long> getCssingStoreids(long userId);
	void insertCustomerServiceStaff(CustomerServiceStaff css);
	void updateCustomerServiceStaff(CustomerServiceStaff css);
	void deleteCustomerServiceStaff(CustomerServiceStaff css);
}
