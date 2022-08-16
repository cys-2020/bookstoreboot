package com.cys.boot.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cys.boot.service.CustomerServiceStaffService;
import com.cys.boot.service.SellerService;
import com.cys.boot.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.cys.boot.entity.Address;
import com.cys.boot.entity.User;
@RestController
public class AccountController {
	private HttpServletRequest hsr;
	private HttpServletResponse hsrp;
	private UserService userservice;
	private SellerService ss;
	private CustomerServiceStaffService csss;
	public AccountController(HttpServletRequest hsr, HttpServletResponse hsrp, UserService userservice,
			SellerService ss, CustomerServiceStaffService csss) {
		super();
		this.hsr = hsr;
		this.hsrp = hsrp;
		this.userservice = userservice;
		this.ss = ss;
		this.csss = csss;
	}



	@RequestMapping(value="/register1",
			method=RequestMethod.POST)
	@ResponseBody
	public int register1(@RequestBody String json) {
		return userservice.register1(json);
	}
	
	
	
	@RequestMapping(value="/register2",
			method=RequestMethod.POST)
	@ResponseBody
	public void register2() {
		userservice.register2();
	}
	
	
	@RequestMapping(value="/register3",
			method=RequestMethod.POST)
	@ResponseBody
	public int register3(@RequestBody String usermvc) {
		
		return userservice.register3(usermvc);
	}
	
	@PostMapping("/login")
	public int login(@RequestBody String json) {
		return userservice.login(hsr, json,hsrp);
	}
	
	
	@RequestMapping(value="/initIndex",
			method=RequestMethod.POST)
	@ResponseBody
	public void initIndex() {
		userservice.initUserInfoIntoSession(hsr);
	}
	

	@RequestMapping(value="/registerToSeller"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public int registerToSeller(
			@RequestBody String json) throws JsonProcessingException {
		return ss.registerToSeller(hsr, json);
	}
	@PostMapping("/registerToCss")
	public void registerToCss(@RequestBody String json) {
		csss.registerToCustomerServiceStaff(hsr, json);
	}
	
	
	@RequestMapping(value="/getAddressesList"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public String getAddressesList(){
		String s=new com.cys.boot.utils.Models().getJsonStringFromObject(
				((User)hsr.getSession().getAttribute("user"))
							.getAddresses());
		System.err.println("get addresses==>"+s);
		return s;
	}
	
	
	
	@RequestMapping(value="/removeAddresses"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public void removeAddresses(@RequestBody String list){
		userservice.deleteAddresses(hsr,list);
	}
	
	
	
	@RequestMapping(value="/addAddress"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public void addAddress(
			@RequestBody String json){
		userservice.addAddress(hsr, json);
	}
	
	@PostMapping("/setDefaultAddress")
	public void setDefaultAddress(long aid) {
		userservice.setDefaultAddress(hsr, aid);
	}
	@PostMapping("/addAndSetDefaultAddress")
	public void addAndSetDefaultAddress(@RequestBody String json) {
		Address a= userservice.addAddress(hsr, json);
		userservice.setDefaultAddress(hsr, a.getId());
	}
	
	@PostMapping("/initSellerAndCssInfo")
	public void initSellerAndCssInfo() {
		userservice.initSellerAndCssIntoSeesion(hsr);
	}
	
}
