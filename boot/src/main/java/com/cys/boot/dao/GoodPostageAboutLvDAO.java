package com.cys.boot.dao;

import com.cys.boot.entity.GoodPostageAboutLv;

public interface GoodPostageAboutLvDAO {
	GoodPostageAboutLv getGoodPostageAboutLv(long id);
	GoodPostageAboutLv 
			getGoodPostageAboutLvByGoodId(long goodId);
	void insertGoodPostageAboutLv(GoodPostageAboutLv gpal);
	void updateGoodPostageAboutLv(GoodPostageAboutLv gpal);
}
