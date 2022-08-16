package com.cys.boot.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.manager.GoodManager;
import com.cys.boot.otherType.GoodItem;
import com.cys.boot.otherType.enums.FilePathEnum;
import com.cys.boot.service.CouponService;
import com.cys.boot.service.GoodService;
import com.cys.boot.service.StoreService;
import com.cys.boot.service.UserService;
import com.cys.boot.typeNeedHandle.CouponEnum;
import com.cys.boot.typeNeedHandle.ShippingCompanyEnum;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cys.boot.entity.Address;
import com.cys.boot.entity.Good;
import com.cys.boot.entity.User;
import com.cys.boot.utils.*;
@Service
public class GoodServiceImp implements GoodService {
	private GoodManager manager;
	private StoreService storeservice;
	private CouponService couponservice;
	private UserService userservice;
	

	public GoodServiceImp(GoodManager manager, StoreService storeservice, CouponService couponservice,
			UserService userservice) {
		super();
		this.manager = manager;
		this.storeservice = storeservice;
		this.couponservice = couponservice;
		this.userservice = userservice;
	}



	
	
	@Override
	public HashMap<String,Object> 
		getBuyNowJsonForPreOrderform(HttpServletRequest hsr, 
			String json) {
		//
		HashMap<String,Object> resultJson=new HashMap<>();
		ObjectMapper mapper=new ObjectMapper();
		GoodItem paramGoodItem=null;
		try {
			paramGoodItem = mapper.readValue(json, 
					GoodItem.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//1,put user
		User user=(User)hsr.getSession().getAttribute("user");
		resultJson.put("user",user );
		
		//2,put good
		Good good=manager.getGood(paramGoodItem.getGoodId());
		//set store
		good.setStore(storeservice.getStore(good.getStoreId()));
		resultJson.put("good", good);
		//3,put coupon
		CouponEnum coupon=couponservice.
			getCouponByTotalPriceInOneStore(hsr,good.getStoreId(),
				good.getPrice()*paramGoodItem.getGoodAmount());
		resultJson.put("coupon", coupon);
		return resultJson;
	}

	
	
	@Override
	public void insertGood(Good good) {
		//
		manager.insertGood(good);
	}

	@Override
	public void updateGood(Good good) {
		//
		manager.updateGood(good);
	}

	@Override
	public void deleteGood(Good good) {
		//
		manager.deleteGood(good);
	}

	@Override
	public long getStoreid(long id) {
		//
		return manager.getStoreid(id);
	}

	@Override
	public ArrayList<Good> getGoodByNameInStore(String key, long storeId) {
		//
		return manager.getGoodByNameInStore(key, storeId);
	}

	@Override
	public ArrayList<Good> getGoodByName(String nameKey) {
		//
		ArrayList<Good> list=	manager.getGoodByName(nameKey);
		list.forEach(v->{
			v.setStore(storeservice.getStore(v.getStoreId()));
		});
		return list;
	}

	@Override
	public ArrayList<Good> getAllGood(HttpServletRequest hsr) {
		ArrayList<Good>list= manager.getAllGood(((User)
				hsr.getSession().getAttribute("user")).getId());
		list.forEach(v->{
			v.setStore(storeservice.getStore(v.getStoreId()));
		});
		return list;
	}

	@Override
	public ArrayList<Good> getAllGoodInstore(HttpServletRequest hsr, long storeId) {
		return null;
	}

	@Override
	public ArrayList<Good> getGoodByStoreId(long storeId) {
		return manager.getGoodByStoreId(storeId);
	}



	@Override
	public String getPostageByAddress(String json) {
		//
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=null;
		try {
			node = mapper.readTree(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<String> keys = node.fieldNames();
		long id=Long.parseLong(node.path(keys.next()).toString());
		long addressid=Long.parseLong(node.path(keys.next()).toString());
		String address=userservice.getAddress(addressid).getAddress();
		Good good=manager.getGood(id);
		return "{\"postage\":"+ShippingCompanyEnum.getPostage(
				good.getPostageAboutLv(),
							address, good.getShippingCompany())+"}";
	}

	
	
	
	@Override
	public HashMap<String, Object> getGoodForDetail(
			HttpServletRequest hsr, long id) {
		HashMap<String,Object> resultJson=new HashMap<>();
		//1,put user
		User user=(User)hsr.getSession().getAttribute("user");
		resultJson.put("user",user );
		//2,put good
		Good good=manager.getGood(id);
		good.setStore(storeservice.getStore(good.getStoreId()));
		resultJson.put("good", good);
		System.err.println("goodDetail--->"+resultJson);
		return resultJson;
	}

	@Override
	public Good getGood(long id) {
		//
		return manager.getGood(id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public String getGoodResources(String json) {
		Models m=new Models();
		ResourceHandler rh=new ResourceHandler();
		//byte[] is obj
		HashMap<String, LinkedList<byte[]>> rs=new HashMap<>(2);
		LinkedList<byte[]> topresources=new LinkedList<>()
				,bottomresources=new LinkedList<>();
		
		String values[]=m.getValuesFromCommonJson(json, 2);
		ArrayList<String> topRefs=m.getObjectFromJsonString(values[0], ArrayList.class)
				,bottomRefs=m.getObjectFromJsonString(values[1], ArrayList.class);
		topRefs.forEach(v->{
			topresources.add(rh.getResourceByte(v));
		});
		bottomRefs.forEach(v->{
			bottomresources.add(rh.getResourceByte(v));
		});
		rs.put("topResources", topresources);
		rs.put("bottomResources", bottomresources);
		System.err.println("getGoodResources====>topssize="+rs.get("topResources").size()+"bottomssize="+rs.get("bottomResources").size());
		return m.getJsonStringFromObject(rs);
	}
	
	
}
