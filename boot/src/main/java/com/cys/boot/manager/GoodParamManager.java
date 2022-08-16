package com.cys.boot.manager;

import com.cys.boot.entity.GoodParam;

public interface GoodParamManager {
	GoodParam getGoodParam(long id);
	GoodParam getGoodParamByGoodId(long goodId);
	void insertGoodParam(GoodParam goodParam);
	void updateGoodParam(GoodParam goodParam);
}
