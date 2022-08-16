package com.cys.boot.service;

import com.cys.boot.entity.GoodParam;

public interface GoodParamService {
	GoodParam getGoodParam(long id);
	GoodParam getGoodParamByGoodId(long goodId);
	void insertGoodParam(GoodParam goodParam);
	void updateGoodParam(GoodParam goodParam);
}
