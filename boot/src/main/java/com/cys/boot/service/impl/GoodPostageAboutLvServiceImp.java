package com.cys.boot.service.impl;

import org.springframework.stereotype.Service;

import com.cys.boot.manager.GoodPostageAboutLvManager;
import com.cys.boot.service.GoodPostageAboutLvService;
import com.cys.boot.entity.GoodPostageAboutLv;
@Service
public class GoodPostageAboutLvServiceImp 
			implements GoodPostageAboutLvService {
	private GoodPostageAboutLvManager manager;
	
	public GoodPostageAboutLvServiceImp(GoodPostageAboutLvManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public GoodPostageAboutLv getGoodPostageAboutLv(long id) {
		//
		return manager.getGoodPostageAboutLv(id);
	}

	@Override
	public GoodPostageAboutLv getGoodPostageAboutLvByGoodId(long goodId) {
		//
		return manager.getGoodPostageAboutLvByGoodId(goodId);
	}

	@Override
	public void insertGoodPostageAboutLv(GoodPostageAboutLv gpal) {
		//
		manager.insertGoodPostageAboutLv(gpal);
	}

	@Override
	public void updateGoodPostageAboutLv(GoodPostageAboutLv gpal) {
		//
		manager.updateGoodPostageAboutLv(gpal);
	}

}
