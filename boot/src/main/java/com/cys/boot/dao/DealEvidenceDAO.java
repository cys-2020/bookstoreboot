package com.cys.boot.dao;

import com.cys.boot.entity.DealEvidence;

public interface DealEvidenceDAO {
	DealEvidence getDealEvidence(long id);
	void insertDealEvidence(DealEvidence de);
	void deleteDealEvidence(long id);
}
