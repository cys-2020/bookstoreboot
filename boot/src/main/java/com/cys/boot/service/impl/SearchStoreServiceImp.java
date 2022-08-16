package com.cys.boot.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.service.SearchStoreService;
import com.cys.boot.service.StoreService;

import com.cys.boot.entity.Store;
@Service
public class SearchStoreServiceImp implements SearchStoreService {
	private StoreService storeService;
	
	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}


	@Override
	public ArrayList<Store> searchStore(String nameKey) {
		//
		return storeService.getStoreByName(nameKey);
	}

}
