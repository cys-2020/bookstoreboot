package com.cys.boot.manager;

import com.cys.boot.entity.DealEvidence;

public interface DealEvidenceManager {
	DealEvidence getDealEvidence(long id);
	void insertDealEvidence(DealEvidence de);
	void deleteDealEvidence(long id);
}
