package com.cys.boot.dao;

import com.cys.boot.entity.Refund;

public interface RefundDAO {
	Refund getRefund(long id);
	void insertRefund(Refund r);
	void updateRefund(Refund r);
	void deleteRefund(Refund r);
}
