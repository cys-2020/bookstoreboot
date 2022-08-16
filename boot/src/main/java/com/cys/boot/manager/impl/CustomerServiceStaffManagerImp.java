package com.cys.boot.manager.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.CustomerServiceStaffDAO;
import com.cys.boot.entity.CustomerServiceStaff;
import com.cys.boot.manager.CustomerServiceStaffManager;

/**
 *	@description 
 *	@author Chenyongsheng
 * 	@date 2022/5/4
 */
@Service
public class CustomerServiceStaffManagerImp implements CustomerServiceStaffManager {
	private CustomerServiceStaffDAO dao;
	
	public CustomerServiceStaffManagerImp(CustomerServiceStaffDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public CustomerServiceStaff getCustomerServiceStaff(long id) {
		//
		return dao.getCustomerServiceStaff(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertCustomerServiceStaff(CustomerServiceStaff css) {
		//
		dao.insertCustomerServiceStaff(css);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateCustomerServiceStaff(CustomerServiceStaff css) {
		//
		dao.updateCustomerServiceStaff(css);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteCustomerServiceStaff(CustomerServiceStaff css) {
		//
		dao.deleteCustomerServiceStaff(css);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<CustomerServiceStaff> getCustomerServiceStaffByUserId(long userId) {
		//'
		return dao.getCustomerServiceStaffByUserId(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Long> getCssingStoreids(long userId) {
		//
		return dao.getCssingStoreids(userId);
	}

}
