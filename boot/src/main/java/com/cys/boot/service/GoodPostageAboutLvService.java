package com.cys.boot.service;

import com.cys.boot.entity.GoodPostageAboutLv;

public interface GoodPostageAboutLvService {
	GoodPostageAboutLv getGoodPostageAboutLv(long id);
	GoodPostageAboutLv 
			getGoodPostageAboutLvByGoodId(long goodId);
	void insertGoodPostageAboutLv(GoodPostageAboutLv gpal);
	void updateGoodPostageAboutLv(GoodPostageAboutLv gpal);
}
