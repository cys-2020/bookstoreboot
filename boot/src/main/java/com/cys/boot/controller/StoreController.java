package com.cys.boot.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cys.boot.entity.Store;
import com.cys.boot.service.CouponService;
import com.cys.boot.service.GoodService;
import com.cys.boot.service.StoreService;
import com.cys.boot.utils.Models;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class StoreController {
	private HttpServletRequest hsr;
	private StoreService storeservice;
	private GoodService goodservice;
	private CouponService couponservice;
	
	
	public StoreController(HttpServletRequest hsr, StoreService storeservice, GoodService goodservice,
			CouponService couponservice) {
		super();
		this.hsr = hsr;
		this.storeservice = storeservice;
		this.goodservice = goodservice;
		this.couponservice = couponservice;
	}
	//改接口 只要id+storename
	@PostMapping("/loadAllStore")
	public String loadAllStore() {
		return storeservice.getStoreBySellerId(hsr);
	}
	@PostMapping("/loadStoreAndAllGood")
	public String loadStoreAndAllGood(@RequestParam("storeId") long storeId) {
		
		return new Models().getJsonStringFromObject(storeservice.getStoreAndAllGood(storeId)) ;
	}
	@PostMapping("/openStore")
	public String openStore(@RequestBody String json) {
		return storeservice.addStore(hsr,new Models().getObjectFromJsonString(json, Store.class));
	}
	@PostMapping("/removeStores")
	public void removeStores(@RequestBody String json) {
		storeservice.removeStores(json);
	}
	
	
	@PostMapping(value="/getGoodResourceRefs")
	public String getGoodResourceRefs(//formdata
			@RequestPart("topRefsFiles") MultipartFile[] topRefsFiles,
			@RequestPart("bottomRefsFiles") MultipartFile[] bottomRefsFiles) {
		return storeservice.getGoodResourceAddressesAfterUpload(
				topRefsFiles, bottomRefsFiles,"store\\good");
	}
	@PostMapping(value="/addGood")
	//{good,gp,gpal,toplist}
	public void addGood(@RequestBody String jsons) {
		System.err.println("控制器addGoods==>"+jsons);
		storeservice.addGood(jsons);
	}
	
	
	
	@RequestMapping(value="/loadAllGood",
			method=RequestMethod.POST,
			produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public String loadAllGood() throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		String list=
				mapper.writeValueAsString(goodservice.getAllGood(hsr));
		return list;
	}
	@PostMapping(value="/loadGood")
	public String loadGood(@RequestBody long id) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		String list=mapper.writeValueAsString(
						goodservice.getGoodForDetail(hsr, id));
		return list;
	}
	@PostMapping(value="/loadGoodResources")
	public String loadGoodResources(@RequestBody String json) throws JsonProcessingException {
		System.err.println("loadGoodResources json==>"+json);
		return goodservice.getGoodResources(json);
	}
	@PostMapping(value="/loadGoodPostage")
	public String loadGoodPostage(@RequestBody String json){
		System.err.println("loadGoodPostage控制器收到"+json);
		String s=goodservice.getPostageByAddress(json);
		System.err.println("loadGoodPostage控制器返回"+s);
		return s ;
	}
	
	
	
	
	@PostMapping(value="/getCoupon")
	public void getCoupon(@RequestBody long storeId) {
		couponservice.initCoupon(hsr,storeId);
	}
	@RequestMapping(value="/getBuyNowJsonForPreOrderform",
			method=RequestMethod.POST,
			produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public String getBuyNowJsonForPreOrderform(
			@RequestBody String json
					) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		String resultJson=
				mapper.writeValueAsString(goodservice
						.getBuyNowJsonForPreOrderform(hsr, json));
		return resultJson;
	}

}
