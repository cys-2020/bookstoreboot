package com.cys.boot.controller;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cys.boot.service.OrderformService;
import com.cys.boot.service.StatusForBothUserAndSeller;
import com.cys.boot.service.StatusForSeller;
import com.cys.boot.service.StatusForSellerService;
import com.cys.boot.service.StatusForUser;
import com.cys.boot.service.StatusForUserService;
import com.cys.boot.service.StatusService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class OrderformController {
	private OrderformService orderformservice;
	private StatusService statusService;
	private StatusForUserService sfu;
	private StatusForSellerService sfs;
	private HttpServletRequest hsr;
	
	
	public OrderformController(OrderformService orderformservice, HttpServletRequest req) {
		super();
		this.orderformservice = orderformservice;
		this.hsr = req;
	}
	@Autowired
	@StatusForBothUserAndSeller 
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}
	@Autowired
	@StatusForUser
	public void setSfu(StatusForUserService sfu) {
		this.sfu = sfu;
	}
	@Autowired
	@StatusForSeller
	public void setSfs(StatusForSellerService sfs) {
		this.sfs = sfs;
	}
	
	@RequestMapping(value="/getOrderform"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public String getOrderform(
			@RequestBody long id) throws JsonProcessingException {
		return new ObjectMapper()
				.writeValueAsString(orderformservice
						.getOrderform(id)) ;
	}
	
	
	
	@RequestMapping(value="/getUserOrderformList"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public String getUserOrderformList() throws JsonProcessingException {
		return orderformservice.getOrderformByUserid(hsr);
	}
	
	
	
	@RequestMapping(value="/newOrderform"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public long newOrderform(
			@RequestBody String json) {
		
		return statusService.newOrderform(json, hsr);
	}
	
	
	@RequestMapping(value="/payForOrderform",method=RequestMethod.POST)
	@ResponseBody
	public void payforOrderform(@RequestBody String json) {
		sfu.payForOrderform(json);
	}
	@RequestMapping(value="/sendForOrderform",method=RequestMethod.POST)
	@ResponseBody
	public String sendForOrderform(@RequestBody String json) {
		json="{\"id\":19,\"sendTime\":\"2022-07-04 09:48:44\"}";
		System.err.println(json);
		sfs.sendForOrderform(json);
		return "1";
	}
	@RequestMapping(value="/endOrderform",method=RequestMethod.POST)
	@ResponseBody
	public String endOrderform(@RequestBody String json) {
		json="{\"id\":19,\"endTime\":\"2022-07-06 11:28:44\"}";
		System.err.println(json);
		statusService.endOrderform(json);
		return "1";
	}
	@RequestMapping(value="/applyRefundForOrderform",method=RequestMethod.POST)
	@ResponseBody
	public String applyRefundOrderform(@RequestBody String json)  {
		json="{\"orderId\":19,\"applyTime\":\"2022-08-04 18:16:59\",\"refundOption\":1,\"refundDescription\":\"description......\",\"flag\":0}";
		System.err.println(json);
		sfu.applyRefundForOrderform(hsr,json);
		return "1";
	}
	@RequestMapping(value="/okRefundForOrderform",method=RequestMethod.POST)
	@ResponseBody
	public String okRefundForOrderform(
			@RequestBody String json) {
		json="{\"id\":5,\"okTime\":\"2022-07-05 14:11:55\"}";
		sfs.okRefundForOrderform(json);
		return "1";
	}
	@RequestMapping(value="/refuseRefundForOrderform",method=RequestMethod.POST)
	@ResponseBody
	public String refuseRefundForOrderform(
			@RequestBody long id) {
		sfs.refuseRefundForOrderform(id);
		return "1";
	}
	@RequestMapping(value="/cancelOrderform",method=RequestMethod.POST)
	@ResponseBody
	public String cancelOrderform(@RequestBody long id) {
		statusService.cancelOrderform(id);
		return "1";
	}
}
