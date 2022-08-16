package com.cys.boot.service;

import java.util.ArrayList;

import com.cys.boot.entity.Good;

/**
 *@description searching good by key and in store
 *@author Chenyongsheng
 *@date 2022/5/17
 */
public interface SearchGoodService {
	/**
	 * search good by key of good's title and store_id 
	 * @param key key of good'title
	 * @param storeId good's store_id
	 * @return good list
	 * @author Chenyongsheng
	 */
	ArrayList<Good> searchGoodInStore(String titleKey,long storeId);
	/**
	 * search good by key of good's title
	 * @param key key of good'title
	 * @return good list
	 * @author Chenyongsheng
	 */
	ArrayList<Good> searchGoodInAll(String titleKey);
	
	
}