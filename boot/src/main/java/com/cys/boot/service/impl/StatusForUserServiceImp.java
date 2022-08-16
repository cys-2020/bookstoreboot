package com.cys.boot.service.impl;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.service.CashierService;
import com.cys.boot.service.DealEvidenceService;
import com.cys.boot.service.GoodService;
import com.cys.boot.service.OrderformService;
import com.cys.boot.service.RefundService;
import com.cys.boot.service.StatusForUser;
import com.cys.boot.service.StatusForUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cys.boot.entity.Orderform;
import com.cys.boot.entity.Refund;
@Service
@StatusForUser
public class StatusForUserServiceImp implements StatusForUserService {
	private OrderformService orderformservice;
	private CashierService cashierservice;
	private GoodService goodservice;
	private DealEvidenceService deservice;
	private RefundService refundservice;
	@Autowired
	public void setOrderformservice(OrderformService orderformservice) {
		this.orderformservice = orderformservice;
	}@Autowired
	public void setCashierservice(CashierService cashierservice) {
		this.cashierservice = cashierservice;
	}@Autowired
	public void setGoodservice(GoodService goodservice) {
		this.goodservice = goodservice;
	}@Autowired
	public void setDeservice(DealEvidenceService deservice) {
		this.deservice = deservice;
	}@Autowired
	public void setRefundservice(RefundService refundservice) {
		this.refundservice = refundservice;
	}
	
	
	
	@Override
	public void payForOrderform(String json) {
		Orderform orderform=null;
		ObjectMapper mapper=new ObjectMapper();
		try {
			orderform=mapper.readValue(json, Orderform.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		orderform.setOrderformStatus(1);
		orderformservice.updateOrderform(orderform);
		Orderform oldorderform=orderformservice.getOrderform(
				orderform.getId());
		long userId=oldorderform.getUserId();
		long storeId=goodservice.getStoreid(
		(deservice.getDealEvidence(oldorderform.getDeId())).getGoodId());
		float flowMoney=oldorderform.getFinalMoney();
		cashierservice.payforCashier(userId, storeId, flowMoney);
	}
	@Override
	public void applyRefundForOrderform(
				HttpServletRequest hsr,String json) {
		//
		Refund refund=null;
		ObjectMapper mapper=new ObjectMapper();
		try {
			refund=mapper.readValue(json, Refund.class);
		} catch (IOException e) {
			//
			System.err.println("readValue err.at StatusForUserServiceImp:69");
		}	/**/
		refundservice.applyRefund(hsr,refund);
		Orderform o=new Orderform();
		o.setId(refund.getOrderformId());
		o.setOrderformStatus(-1);
		orderformservice.updateOrderform(o);
	}
	
}
