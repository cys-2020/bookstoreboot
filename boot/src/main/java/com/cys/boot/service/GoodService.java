package com.cys.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.entity.Good;

public interface GoodService {
	
	/**
	 * need user(addresses) and good detail
	 * @param hsr
	 * @param id good id
	 * @return {user:user, good:good}
	 */
	HashMap<String, Object> getGoodForDetail(
			HttpServletRequest hsr,long id);
	/**
	 * get good's top and bottom resources(img) bytes
	 * @param json {toprefs:[],botrefs:[]}
	 * @return {topResources:[bytes1[],bytes2[]], bottomResources:[bytes1[],bytes2[]]}
	 */
	String getGoodResources(String json);
	
	
	
	/**
	 * all info about "buy now",
	 *   need GoodItem ,and user info(addresses)
	 * @param hsr
	 * @param json {goodId,goodAmount,goodType}
	 * @return {"user":{user...},"good":{good...}}
	 */
	HashMap<String, Object> getBuyNowJsonForPreOrderform(HttpServletRequest hsr,
			String json);
	
	
	
	Good getGood(long id);
	void insertGood(Good good);
	void updateGood(Good good);
	void deleteGood(Good good);
	long getStoreid(long id);
	
	
	
	
	/**
	 * get store id by good id
	 * @param id good id
	 * @return store id which include the good
	 * @author Chenyongsheng
	 */
	ArrayList<Good> getGoodByStoreId(long storeId);
	
	
	
	ArrayList<Good> getGoodByName(String nameKey);
	
	
	
	
	/**
	 * get good list by good's title key,and limit result by storeId
	 * @param key good's tilte key
	 * @param storeId one store's id
	 * @return good list in this store
	 * @author Chenyongsheng
	 */
	ArrayList<Good> getGoodByNameInStore(String key,long storeId);
	
	
	/**
	 * load all good user loves
	 * @param hsr
	 * @return good list user loves
	 */
	ArrayList<Good> getAllGood(HttpServletRequest hsr);
	
	
	
	/**
	 * load all good in store user loves
	 * @param hsr
	 * @param storeId
	 * @return all good in store
	 */
	ArrayList<Good> getAllGoodInstore(HttpServletRequest hsr,long storeId);
	
	
	
	/**
	 * postage is changed because of user select different address
	 * @param json {goodid,address}
	 * @return {postage:()}
	 */
	String getPostageByAddress(String json);
}
