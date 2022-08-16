package com.cys.boot.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.manager.GoodManager;
import com.cys.boot.manager.ShoppingCartItemManager;
import com.cys.boot.service.CouponService;
import com.cys.boot.service.GoodService;
import com.cys.boot.service.ShoppingCartItemService;
import com.cys.boot.typeNeedHandle.CouponEnum;
import com.cys.boot.entity.Good;
import com.cys.boot.entity.ShoppingCartItem;
@Service
public class ShoppingCartItemServiceImp 
							implements ShoppingCartItemService {
	private ShoppingCartItemManager manager;
	private GoodManager goodmanager;
	private CouponService couponservice;
	
	@Autowired
	public void setManager(ShoppingCartItemManager manager) {
		this.manager = manager;
	}
	@Autowired
	public void setGoodmanager(GoodManager goodmanager) {
		this.goodmanager = goodmanager;
	}

	@Autowired
	public void setCouponservice(CouponService couponservice) {
		this.couponservice = couponservice;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String selectItem(HttpServletRequest hsr, int index) {
		//
		HttpSession session=hsr.getSession();
		
		HashMap<Integer,ShoppingCartItem> scimap=
				(HashMap<Integer, ShoppingCartItem>) session.getAttribute("sciMap");
		ShoppingCartItem sci=scimap.get(index);
		sci.setSelected(true);	
		//
		long goodId= sci.getGoodId();
		long storeId=goodmanager.getStoreid(goodId);
		float price=goodmanager.getGood(goodId).getPrice();
		String json=null;
		CouponEnum coupon=couponservice.
				getCouponByTotalPriceInOneStore(hsr, storeId, price);
		if(coupon!=null) {
			String s="您可使用店铺满"+coupon.getPrice()+
					"减"+coupon.getDecrement()+"优惠券";
			json="{\"coupon\":\""+s+"\"}";
		}else {
			json="{\"coupon\":null}";
		}
		return json;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<String> getTyp(HttpServletRequest hsr, int index) {
		HashMap<Integer,ShoppingCartItem> scimap=
				(HashMap<Integer, ShoppingCartItem>) hsr.getSession().getAttribute("sciMap");
		ShoppingCartItem sci=scimap.get(index);
		Good good=goodmanager.getGood(sci.getGoodId());
		return good.getTyps();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateType(
			HttpServletRequest hsr, int index,int typIndex) {
		//
		HashMap<Integer,ShoppingCartItem> scimap=
				(HashMap<Integer, ShoppingCartItem>) hsr.getSession().getAttribute("sciMap");
		ShoppingCartItem sci=scimap.get(index);
		Good good=goodmanager.getGood(sci.getGoodId());
		sci.setTyp(good.getTyps().get(typIndex));
		sci.setChangeFlag(2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateAmount(HttpServletRequest hsr, int index
			,int amount) {
		//
		HashMap<Integer,ShoppingCartItem> scimap=
				(HashMap<Integer, ShoppingCartItem>) hsr.getSession().getAttribute("sciMap");
		ShoppingCartItem sci=scimap.get(index);
		sci.setAmount(amount);
		sci.setChangeFlag(2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteItem(HttpServletRequest hsr, int index) {
		//
		HashMap<Integer,ShoppingCartItem> scimap=
				(HashMap<Integer, ShoppingCartItem>) hsr.getSession().getAttribute("sciMap");
		//�����Ƴ��Ự��scimap.remove(index);
		//Ӧ������ɾ����ǣ�������ݿ���������ǳ־�ɾ��
		scimap.get(index).setChangeFlag(-1);
	}
	
	@Override
	public ArrayList<ShoppingCartItem> getShoppingCartItemByShoppingCartId(long scid) {
		return manager.getShoppingCartItemByShoppingCartId(scid);
	}
	

	@Override
	public void insertShoppingCartItem(ShoppingCartItem sci) {
		//
		manager.insertShoppingCartItem(sci);
	}

	@Override
	public void updateShoppingCartItem(ShoppingCartItem sci) {
		//
		manager.updateShoppingCartItem(sci);
	}

	@Override
	public void deleteShoppingCartItem(long id) {
		//
		manager.deleteShoppingCartItem(id);
	}

}
