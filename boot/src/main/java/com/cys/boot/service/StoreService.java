package com.cys.boot.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cys.boot.entity.Store;

public interface StoreService {
	Store getStore(long id);
	String getStoreAndAllGood(long id);
	String getStoreName(long id);
	String addStore(HttpServletRequest hsr, Store store);
	void updateStore(Store store);
	/**
	 * get store list by store_name's key
	 * @param nameKey store_name's key
	 * @return store list
	 * @author Chenyongsheng
	 */
	ArrayList<Store> getStoreByName(String nameKey);
	String getStoreBySellerId(HttpServletRequest hsr);
	ArrayList<Long> getStoreIdBySellerId(long sellerId);
	/**
	 * @param json [storeid,,,]
	 */
	void removeStores(String json);
	
	
	
	/**
	 * get two refs string list(t and b) after saving good resource 
	 * @param topRefsFiles files 1
	 * @param bottomRefsFiles files 2
	 * @param folderName path need be ordered
	 * @return {top:[toprefs123456],bot:[bottomrefs123456]}
	 */
	String getGoodResourceAddressesAfterUpload(
			MultipartFile[] topRefsFiles,MultipartFile[] bottomRefsFiles
			,String folderName);
	
	/**
	 * 3 jsons   {good:{},goodParam:{},goodPAL:{}}
	 * @param jsons
	 */
	void addGood(String jsons);
}
