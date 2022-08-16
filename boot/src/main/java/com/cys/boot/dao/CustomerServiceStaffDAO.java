package com.cys.boot.dao;

import java.util.ArrayList;

import com.cys.boot.entity.CustomerServiceStaff;

public interface CustomerServiceStaffDAO {
	CustomerServiceStaff getCustomerServiceStaff(long id);
	ArrayList<CustomerServiceStaff>  getCustomerServiceStaffByUserId(long userId);
	ArrayList<Long> getCssingStoreids(long userId);
	void insertCustomerServiceStaff(CustomerServiceStaff css);
	void updateCustomerServiceStaff(CustomerServiceStaff css);
	void deleteCustomerServiceStaff(CustomerServiceStaff css);
}
