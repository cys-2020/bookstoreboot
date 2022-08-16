package com.cys.boot.manager;

import com.cys.boot.entity.GoodPostageAboutLv;

public interface GoodPostageAboutLvManager {
	GoodPostageAboutLv getGoodPostageAboutLv(long id);
	GoodPostageAboutLv 
			getGoodPostageAboutLvByGoodId(long goodId);
	void insertGoodPostageAboutLv(GoodPostageAboutLv gpal);
	void updateGoodPostageAboutLv(GoodPostageAboutLv gpal);
}
