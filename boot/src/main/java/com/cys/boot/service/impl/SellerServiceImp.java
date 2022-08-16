package com.cys.boot.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.manager.SellerManager;
import com.cys.boot.service.SellerService;
import com.cys.boot.service.UserService;
import com.cys.boot.entity.Seller;
import com.cys.boot.entity.User;
import com.cys.boot.utils.Models;

@Service
public class SellerServiceImp implements SellerService {
	private SellerManager manager;
	private UserService userservice;
	
	@Autowired
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	@Autowired
	public void setManager(SellerManager manager) {
		this.manager = manager;
	}
	

	@Override
	public Seller getSeller(long id) {
		//
		return manager.getSeller(id);
	}

	@Override
	public int registerToSeller(HttpServletRequest hsr,String json) {
		//
		String[] values=
				new Models().getValuesFromCommonJson(json, 2);
		long phoneNumber=Long.parseLong(values[0]) ;
		String idNumber=values[1];
		User user=(User)hsr.getSession().getAttribute("user");
		long userId=user.getId();
		if(phoneNumber!=user.getPhoneNumber()
				||manager.getSellerByUserId(userId)!=null) {
			//if user is already a seller
			return 0;
		}
		Seller seller=new Seller();
		seller.setUserId(userId);
		//init seller
		seller.setCredibility(90);
		seller.setScore(0f);
		seller.setStoreNumber(0);
		//update user
		User willupdateuser=new User();
		willupdateuser.setId(userId);
		willupdateuser.setIdNumber(idNumber);
		userservice.updateUser(willupdateuser);
		manager.insertSeller(seller);
		return 1;
	}

	@Override
	public void updateSeller(Seller seller) {
		//
		manager.updateSeller(seller);
	}

	@Override
	public void deleteSeller(Seller seller) {
		//
		manager.deleteSeller(seller);
	}

	@Override
	public Seller getSellerByUserId(long userId) {
		//
		return manager.getSellerByUserId(userId);
	}
	
	@Override
	public int initSellerInfoIntoSeesion(HttpServletRequest hsr) {
		//
		HttpSession session=hsr.getSession();
		long userId=((User)session.getAttribute("user")).getId();
		Seller ifseller=manager.getSellerByUserId(userId);
		if(ifseller!=null) {
			session.setAttribute("seller", ifseller);
			return 1;
		}
		return 0;
	}

}
