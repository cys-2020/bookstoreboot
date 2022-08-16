package com.cys.boot.manager.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.AddressDAO;
import com.cys.boot.entity.Address;
import com.cys.boot.manager.AddressManager;
@Service
public class AddressManagerImp implements AddressManager {
	private AddressDAO dao;
	
	public AddressManagerImp(AddressDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public Address getAddress(long id) {
		//
		return dao.getAddress(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Address> getAddressByUserId(long userId) {
		//
		return dao.getAddressByUserId(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertAddress(Address address) {
		//
		dao.insertAddress(address);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateAddress(Address address) {
		//
		dao.updateAddress(address);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteAddress(long id) {
		//
		dao.deleteAddress(id);
	}

}
