package com.cys.boot.service.impl;

import org.springframework.stereotype.Service;

import com.cys.boot.manager.GoodParamManager;
import com.cys.boot.service.GoodParamService;
import com.cys.boot.entity.GoodParam;
@Service
public class GoodParamServiceImp implements GoodParamService {
	private GoodParamManager m;
	
	public GoodParamServiceImp(GoodParamManager m) {
		super();
		this.m = m;
	}

	@Override
	public GoodParam getGoodParam(long id) {
		//
		return m.getGoodParam(id);
	}

	@Override
	public GoodParam getGoodParamByGoodId(long goodId) {
		//
		return m.getGoodParamByGoodId(goodId);
	}

	@Override
	public void insertGoodParam(GoodParam goodParam) {
		//
		m.insertGoodParam(goodParam);
	}

	@Override
	public void updateGoodParam(GoodParam goodParam) {
		//
		m.updateGoodParam(goodParam);
	}

}
