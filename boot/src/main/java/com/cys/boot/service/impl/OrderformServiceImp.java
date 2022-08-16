package com.cys.boot.service.impl;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.manager.OrderformManager;
import com.cys.boot.service.DealEvidenceService;
import com.cys.boot.service.OrderformService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cys.boot.entity.Orderform;
import com.cys.boot.entity.User;
@Service
public class OrderformServiceImp implements OrderformService {
	private OrderformManager manager;
	private DealEvidenceService deservice;

	@Autowired
	public void setManager(OrderformManager manager) {
		this.manager = manager;
	}
	@Autowired
	public void setDeservice(DealEvidenceService deservice) {
		this.deservice = deservice;
	}

	@Override
	public Orderform getOrderform(long id) {
		//
		Orderform o= manager.getOrderform(id);
		o.setDe(deservice.getDealEvidence(o.getDeId()));
		return o;
	}

	@Override
	public void insertOrderform(Orderform o) {
		//
		manager.insertOrderform(o);
	}

	@Override
	public void updateOrderform(Orderform o) {
		//
		manager.updateOrderform(o);
	}


	@Override
	public String getOrderformByUserid(HttpServletRequest hsr) throws JsonProcessingException {
		//
		long userId=((User)hsr.getSession().getAttribute("user"))
				.getId();
		ObjectMapper mapper=new ObjectMapper();
		ArrayList<Orderform> o= manager.getOrderformByUserid(userId);
		o.forEach(v->{
			v.setDe(deservice.getDealEvidence(v.getDeId()));
		});
		return mapper.writeValueAsString(o);
	}
}
