package com.cys.boot.manager.impl;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.DealEvidenceDAO;
import com.cys.boot.entity.DealEvidence;
import com.cys.boot.manager.DealEvidenceManager;
@Service
public class DealEvidenceManagerImp implements DealEvidenceManager {
	private DealEvidenceDAO dao;
	
	public DealEvidenceManagerImp(DealEvidenceDAO dao) {
		super();
		this.dao = dao;
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.SUPPORTS)
	public DealEvidence getDealEvidence(long id) {
		//
		return dao.getDealEvidence(id);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void insertDealEvidence(DealEvidence de) {
		//
		dao.insertDealEvidence(de);
	}

	@Transactional(rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED)
	public void deleteDealEvidence(long id) {
		//
		dao.deleteDealEvidence(id);
	}


}
