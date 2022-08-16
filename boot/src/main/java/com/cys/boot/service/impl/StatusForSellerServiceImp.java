package com.cys.boot.service.impl;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.cys.boot.entity.Orderform;
import com.cys.boot.entity.Refund;
import com.cys.boot.service.OrderformService;
import com.cys.boot.service.RefundService;
import com.cys.boot.service.StatusForSeller;
import com.cys.boot.service.StatusForSellerService;
@Service
@StatusForSeller
public class StatusForSellerServiceImp implements StatusForSellerService {
	private OrderformService orderformservice;
	private RefundService refundservice;
	

	public void setOrderformservice(OrderformService orderformservice) {
		this.orderformservice = orderformservice;
	}

	public void setRefundservice(RefundService refundservice) {
		this.refundservice = refundservice;
	}

	@Override
	public void sendForOrderform(String json) {
		//
		Orderform orderform=null;
		ObjectMapper mapper=new ObjectMapper();
		try {
			orderform=mapper.readValue(json, Orderform.class);
		} catch (IOException e) {
			//
			System.err.println("readValue error.at StatusForUserServiceImp:32");
		}
		orderform.setOrderformStatus(2);
		orderformservice.updateOrderform(orderform);
	}

	@Override
	public void okRefundForOrderform(String json) {
		//
		Refund r=new com.cys.boot.utils.Models().getObjectFromJsonString(
				json,Refund.class);
		refundservice.okRefund(r);
	}

	@Override
	public void refuseRefundForOrderform(long id) {
		//
		refundservice.refuseRefund(id);
	}
}
