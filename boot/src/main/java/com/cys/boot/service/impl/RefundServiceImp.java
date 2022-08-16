package com.cys.boot.service.impl;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.service.CashierService;
import com.cys.boot.service.DealEvidenceService;
import com.cys.boot.manager.RefundManager;
import com.cys.boot.service.GoodService;
import com.cys.boot.service.OrderformService;
import com.cys.boot.service.RefundService;
import com.cys.boot.entity.Cashier;
import com.cys.boot.entity.Orderform;
import com.cys.boot.entity.Refund;
import com.cys.boot.entity.User;
import com.cys.boot.utils.*;

/**
 *@description
 *@author Chenyongsheng
 *@date 2022/6/24
 */
@Service
public class RefundServiceImp implements RefundService {
	private RefundManager manager;
	private OrderformService orderformService;
	private DealEvidenceService deService;
	private GoodService goodService;
	private CashierService cashierService;

	@Autowired
	public void setManager(RefundManager manager) {
		this.manager = manager;
	}
	@Autowired
	public void setOrderformService(OrderformService orderformService) {
		this.orderformService = orderformService;
	}
	@Autowired
	public void setDeService(DealEvidenceService deService) {
		this.deService = deService;
	}
	@Autowired
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	@Autowired
	public void setCashierService(CashierService cashierService) {
		this.cashierService = cashierService;
	}

	@Override
	public void applyRefund(HttpServletRequest hsr, Refund r) {
		//
		User user=(User) hsr.getSession().getAttribute("user");
		Convert conv=new Convert();
		r.setRefundNumber(new Generater().
				getRefundNumber(conv.getYM(r.getApplyTime().toString())
						,conv.getPhoneSuffix(user.getPhoneNumber(), 3)));
		manager.insertRefund(r);
	}

	@Override
	public void okRefund(Refund r) {
		//
		long orderid=manager.getRefund(r.getId()).getOrderformId();
		Orderform orderform=orderformService.getOrderform(orderid);
		long userId=orderform.getUserId();
		float finalMoney=orderform.getFinalMoney();
		long storeId=goodService.getStoreid(
				(deService.getDealEvidence(orderform.getDeId())).getGoodId());
		Cashier c=cashierService.getCashierByBothId(userId, storeId);
		c.setFinishedMoney(c.getFinishedMoney()-finalMoney);
		//��Ǯ���û�Ǯ��...
		
		r.setFlag(1);
		manager.updateRefund(r);
		orderform.setOrderformStatus(-3);
		orderformService.updateOrderform(orderform);
	}

	@Override
	public void refuseRefund(long id) {
		//����refund flag
		Refund r=new Refund();
		r.setId(id);
		r.setFlag(-1);
		manager.updateRefund(r);
		//����order status
		long orderid=	manager.getRefund(id).getOrderformId();
		Orderform o=new Orderform();
		o.setId(orderid);
		o.setOrderformStatus(-2);
		orderformService.updateOrderform(o);
	}

}
