package com.cys.boot.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.GoodParamDAO;

import com.cys.boot.entity.GoodParam;
import com.cys.boot.manager.GoodParamManager;
@Service
public class GoodParamManagerImp implements GoodParamManager {
	private GoodParamDAO dao;
	
	public GoodParamManagerImp(GoodParamDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public GoodParam getGoodParam(long id) {
		//
		return dao.getGoodParam(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public GoodParam getGoodParamByGoodId(long goodId) {
		//
		return dao.getGoodParamByGoodId(goodId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertGoodParam(GoodParam goodParam) {
		//
		dao.insertGoodParam(goodParam);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateGoodParam(GoodParam goodParam) {
		//
		dao.updateGoodParam(goodParam);
	}

}
