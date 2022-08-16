package com.cys.boot.dao;

import com.cys.boot.entity.GoodParam;

public interface GoodParamDAO {
	GoodParam getGoodParam(long id);
	GoodParam getGoodParamByGoodId(long goodId);
	void insertGoodParam(GoodParam goodParam);
	void updateGoodParam(GoodParam goodParam);
}
