package com.cys.boot.service;

import java.util.ArrayList;

import com.cys.boot.entity.Store;
public interface SearchStoreService{
	/**
	 * search stores list by store_name key
	 * @param key store_name's key
	 * @return match-storename store list
	 * @author Chenyongsheng
	 */
	ArrayList<Store> searchStore(String nameKey);
}