package com.cys.boot.manager;

import com.cys.boot.entity.Refund;

public interface RefundManager {
	Refund getRefund(long id);
	void insertRefund(Refund r);
	void updateRefund(Refund r);
	void deleteRefund(Refund r);
}
