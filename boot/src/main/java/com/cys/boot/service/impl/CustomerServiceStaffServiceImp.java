package com.cys.boot.service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cys.boot.manager.CustomerServiceStaffManager;
import com.cys.boot.service.CustomerServiceStaffService;
import com.cys.boot.service.StoreService;
import com.cys.boot.utils.Models;
import com.cys.boot.entity.CustomerServiceStaff;
import com.cys.boot.entity.Seller;
import com.cys.boot.entity.User;

@Service
public class CustomerServiceStaffServiceImp implements CustomerServiceStaffService {
	private CustomerServiceStaffManager manager;
	private StoreService storeservice;
	

	
	@Autowired
	public void setManager(CustomerServiceStaffManager manager) {
		this.manager = manager;
	}
	@Autowired
	public void setStoreservice(StoreService storeservice) {
		this.storeservice = storeservice;
	}

	@Override
	public CustomerServiceStaff getCustomerServiceStaff(long id) {
		//
		return manager.getCustomerServiceStaff(id);
	}
	
	private int getCssNumberForStoresUserBelongto(long userId) {
		return manager.getCustomerServiceStaffByUserId(userId).size();
	}
	
	@Override
	public void insertCustomerServiceStaff(CustomerServiceStaff css) {
		//
		manager.insertCustomerServiceStaff(css);
	}

	@Override
	public void updateCustomerServiceStaff(CustomerServiceStaff css) {
		//
		manager.updateCustomerServiceStaff(css);
	}

	@Override
	public void deleteCustomerServiceStaff(CustomerServiceStaff css) {
		//
		manager.deleteCustomerServiceStaff(css);
	}

	@Override
	public int registerToCustomerServiceStaff(HttpServletRequest hsr, String json) {
		//
		Models model=new Models();
		CustomerServiceStaff csswanted=model.getObjectFromJsonString(json, CustomerServiceStaff.class);
		long userId=((User)hsr.getSession().getAttribute("user")).getId();
		Seller ifseller=(Seller)hsr.getSession().getAttribute("seller");
		
		if(this.getCssNumberForStoresUserBelongto(userId)<5) {
			if(ifseller!=null) {
				//if willstore  is belong to seller's store, ok
				if(storeservice.getStoreIdBySellerId(ifseller.getId())
						.contains(csswanted.getStoreId())) {
					manager.insertCustomerServiceStaff(csswanted);
					return 1;
				}
			}else {//ok
				manager.insertCustomerServiceStaff(csswanted);
				return 1;
			}
		}
		
		return 0;
	}

	
	
	@Override
	public int initCSSInfoIntoSession(HttpServletRequest hsr) {
		//
		HttpSession session=hsr.getSession();
		long userId=((User)session.getAttribute("user")).getId();
		ArrayList<CustomerServiceStaff> ifcss=this
				.getCustomerServiceStaffByUserId(userId);
		if(ifcss.size()!=0) {
			session.setAttribute("storeIdList",
					this.getCssingStoreids(hsr));
			return 1;
		}
		return 0;
	}
	@Override
	public ArrayList<CustomerServiceStaff> getCustomerServiceStaffByUserId(long userId) {
		//
		return manager.getCustomerServiceStaffByUserId(userId);
	}

	@Override
	public ArrayList<Long> getCssingStoreids(HttpServletRequest hsr) {
		//
		return manager.getCssingStoreids(((User)hsr.getSession().getAttribute("css")).getId());
	}

}
