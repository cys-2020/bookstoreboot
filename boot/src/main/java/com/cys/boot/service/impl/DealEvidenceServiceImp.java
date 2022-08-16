package com.cys.boot.service.impl;

import org.springframework.stereotype.Service;
import com.cys.boot.manager.DealEvidenceManager;
import com.cys.boot.service.DealEvidenceService;
import com.cys.boot.entity.DealEvidence;
@Service
public class DealEvidenceServiceImp implements DealEvidenceService {
	private DealEvidenceManager manager;
	
	public DealEvidenceServiceImp(DealEvidenceManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public DealEvidence getDealEvidence(long id) {
		//
		return manager.getDealEvidence(id);
	}

	@Override
	public void insertDealEvidence(DealEvidence de) {
		//
		manager.insertDealEvidence(de);
	}

	@Override
	public void deleteDealEvidence(long id) {
		//
		manager.deleteDealEvidence(id);
	}



}
