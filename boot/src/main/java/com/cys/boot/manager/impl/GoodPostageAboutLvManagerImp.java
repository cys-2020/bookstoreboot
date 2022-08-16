package com.cys.boot.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.GoodPostageAboutLvDAO;

import com.cys.boot.entity.GoodPostageAboutLv;
import com.cys.boot.manager.GoodPostageAboutLvManager;
@Service
public class GoodPostageAboutLvManagerImp implements GoodPostageAboutLvManager {
	private GoodPostageAboutLvDAO dao;

	public GoodPostageAboutLvManagerImp(GoodPostageAboutLvDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public GoodPostageAboutLv getGoodPostageAboutLv(long id) {
		//
		return dao.getGoodPostageAboutLv(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public GoodPostageAboutLv getGoodPostageAboutLvByGoodId(long goodId) {
		//
		return dao.getGoodPostageAboutLvByGoodId(goodId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertGoodPostageAboutLv(GoodPostageAboutLv gpal) {
		//
		dao.insertGoodPostageAboutLv(gpal);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateGoodPostageAboutLv(GoodPostageAboutLv gpal) {
		//
		dao.updateGoodPostageAboutLv(gpal);
	}
	
}
