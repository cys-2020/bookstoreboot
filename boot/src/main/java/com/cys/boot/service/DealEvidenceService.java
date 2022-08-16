package com.cys.boot.service;

import com.cys.boot.entity.DealEvidence;

public interface DealEvidenceService {
	DealEvidence getDealEvidence(long id);
	void insertDealEvidence(DealEvidence de);
	void deleteDealEvidence(long id);
}
