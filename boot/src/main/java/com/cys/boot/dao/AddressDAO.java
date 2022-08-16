package com.cys.boot.dao;

import java.util.ArrayList;

import com.cys.boot.entity.Address;

public interface AddressDAO {
	Address getAddress(long id);
	ArrayList<Address> getAddressByUserId(long userId);
	void insertAddress(Address address);
	void updateAddress(Address address);
	void deleteAddress(long id);
}
