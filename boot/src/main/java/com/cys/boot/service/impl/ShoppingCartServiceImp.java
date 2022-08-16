package com.cys.boot.service.impl;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.manager.GoodManager;
import com.cys.boot.manager.ShoppingCartManager;
import com.cys.boot.service.CouponService;
import com.cys.boot.service.GoodService;
import com.cys.boot.service.ShoppingCartItemService;
import com.cys.boot.service.ShoppingCartService;
import com.cys.boot.typeNeedHandle.CouponEnum;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cys.boot.entity.ShoppingCart;
import com.cys.boot.entity.ShoppingCartItem;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService {
	private ShoppingCartManager manager;
	private ShoppingCartItemService sciService;
	private CouponService couponservice;
	private GoodManager goodmanager;
	
	public ShoppingCartServiceImp(ShoppingCartManager manager) {
		super();
		this.manager = manager;
	}
	@Autowired
	public void setGoodmanager(GoodManager goodmanager) {
		this.goodmanager = goodmanager;
	}

	@Autowired
	public void setSciService(ShoppingCartItemService sciService) {
		this.sciService = sciService;
	}
	@Autowired
	public void setCouponservice(CouponService couponservice) {
		this.couponservice = couponservice;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<Integer, ShoppingCartItem> getUserShoppingCartItemMap(HttpServletRequest hsr) {
		//
		return (HashMap<Integer, ShoppingCartItem>) 
				hsr.getSession().getAttribute("sciMap");
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public void selectAllItem(HttpServletRequest hsr) {
		//
		HashMap<Integer,ShoppingCartItem> scimap=
				(HashMap<Integer, ShoppingCartItem>) hsr.getSession().getAttribute("sciMap");
		scimap.forEach((k,v)->{
			v.setSelected(true);
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public void buySelectedItem(HttpServletRequest hsr) {
		//
		HttpSession session=hsr.getSession();
		HashMap<Integer,ShoppingCartItem> scimap=
				(HashMap<Integer, ShoppingCartItem>) session.getAttribute("sciMap");
		scimap.forEach((k,v)->{
			if(v.isSelected()) {
				long userId=(long) session.getAttribute("userId");
				long storeId=goodmanager.getStoreid(v.getGoodId());
				float price=v.getPrice();
				//������Ż�ȯ����
				CouponEnum coupon=couponservice
						.getCouponByTotalPriceInOneStore(hsr, storeId, price);
				if(coupon!=null) {
					couponservice.decreCouponAmount(
							userId, storeId, coupon.getFlag());
				}
			}
		});
	}

	
	@Override
	public void insertShoppingCart(long userId) {
		//
		ShoppingCart sc=new ShoppingCart();
		sc.setUserId(userId);
		manager.insertShoppingCart(sc);
	}
	@Override
	public void deleteShoppingCart(long userId) {
		//
		manager.deleteShoppingCart(userId);
	}

	@Override
	public void addItemIntoShoppingCart(HttpServletRequest hsr,
			String json) {
		//
		HttpSession session=hsr.getSession();
		ObjectMapper mapper=new ObjectMapper();
		ShoppingCartItem sci=null;
		try {
			sci=mapper.readValue(json, ShoppingCartItem.class);
		} catch (IOException e) {
			//
			System.err.println("at ShoppincCartServiceImp:114");
		}
		ShoppingCart sc=(ShoppingCart) session.getAttribute("sc");
		HashMap<Integer, ShoppingCartItem> repo=sc.getRepo();
		int len=repo.size();
		//���ǰ���Ѿ�����(equals)���Ƴ���
		for(int i=0;i<len;i++) {
			if(repo.get(i).equals(sci)) {
				repo.remove(i);
			}
		}
		//��ʶΪ����
		sci.setChangeFlag(1);
		repo.put(len, sci);
		
	}

	@Override
	public ShoppingCart getShoppingCart(long userId) {
		//
		return manager.getShoppingCart(userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void persistItems(HttpServletRequest hsr) {
		//
		HashMap<Integer,ShoppingCartItem> scimap=
				(HashMap<Integer, ShoppingCartItem>) hsr.getSession().getAttribute("sciMap");
		//����changeFlag�������ݿ�
		scimap.forEach((k,v)->{
			switch(v.getChangeFlag()) {//int,short,byte,char,enum,String
				case -1: sciService.deleteShoppingCartItem(v.getId());break;
				case 1: sciService.insertShoppingCartItem(v);break;
				case 2: sciService.updateShoppingCartItem(v);break;
				default:
			}
		});
		
	}
	
	public static void main(String[]args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		HashMap<Integer, String> map=mapper.readValue("{\"1\":\"A\",\"2\":\"B\"}", HashMap.class);
		System.err.println(map.values());
	}
}
