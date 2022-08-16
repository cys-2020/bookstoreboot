package com.cys.boot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.Good;

public interface GoodDAO {
	Good getGood(long id);
	void insertGood(Good good);
	void updateGood(Good good);
	void deleteGood(Good good);
	long getStoreid(long id);
	ArrayList<Good> getGoodByStoreId(long storeId);
	ArrayList<Good> getGoodByName(@Param("nameKey")String nameKey);
	ArrayList<Good> getGoodByNameInStore(@Param("key") String key,
			@Param("storeId")long storeId);
	ArrayList<Good> getAllGood(long userId);
}
