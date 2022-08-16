package com.cys.boot.service.impl;

import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.cys.boot.manager.CouponManager;
import com.cys.boot.service.CouponService;
import com.cys.boot.typeNeedHandle.CouponEnum;
import com.cys.boot.entity.Coupon;
import com.cys.boot.entity.User;

/**
 *@description
 *@author Chenyongsheng
 *@date 2022/7/7
 */
@Service
public class CouponServiceImp implements CouponService {
	private CouponManager manager;
	private ArrayList<Integer> couponFlagsInstore;
	
	public CouponServiceImp(CouponManager manager) {
		super();
		this.manager = manager;
	}
	
	
	//
	private boolean hasCouponFlagInstore(int checkedFlag) {
		
		int size=couponFlagsInstore.size();
		for(int i=0;i<size;i++) {
			if(couponFlagsInstore.get(i)==checkedFlag) 
				return true;
		}
		return false;
	}

	
	//
	private int getAvailCouponAmount(Coupon c,int flag) {
		int availCouponAmount=0;
		//n1*n2*n3*n4*......n10*( they are the amount for each
		// coupon flag)
		String[] numberArr=c.getAmountStr().split("\\*");
		int numberArrLen=numberArr.length;
		for(int i=0;i<numberArrLen;i++) {
			int num=Integer.parseInt(numberArr[i]);
			if(flag==(i+1)) {
				availCouponAmount=num;
				break;
			}
		}
		return availCouponAmount;
	}
	
	/**
	 * get user-avail coupon's flag and amount by good price.
	 * @param userId
	 * @param storeId
	 * @param price item's good's price
	 * @return coupon [0]flag and [1]amount, or null if no avail coupon
	 * @author Chenyongsheng
	 */
	private int[] getUserCouponFlagAndAmount(
			long userId, long storeId, float price) {
		int []flagAndAmount=new int[2];
		Coupon c=manager.getCouponByBothId(userId, storeId);
		//get avail coupon by price
		int checkedFlag=
				CouponEnum.getCouponEnumByPrice(price).getFlag();
		//manjian(n) is coupon's flag
		couponFlagsInstore=new ArrayList<>();
		if(c.getManjian1()!=0)couponFlagsInstore.add(c.getManjian1());
		if(c.getManjian2()!=0)couponFlagsInstore.add(c.getManjian2());
		if(c.getManjian3()!=0)couponFlagsInstore.add(c.getManjian3());
		if(c.getManjian4()!=0)couponFlagsInstore.add(c.getManjian4());
		if(c.getManjian5()!=0)couponFlagsInstore.add(c.getManjian5());
		if(c.getManjian6()!=0)couponFlagsInstore.add(c.getManjian6());
		if(c.getManjian7()!=0)couponFlagsInstore.add(c.getManjian7());
		if(c.getManjian8()!=0)couponFlagsInstore.add(c.getManjian8());
		if(c.getManjian9()!=0)couponFlagsInstore.add(c.getManjian9());
		if(c.getManjian10()!=0)couponFlagsInstore.add(c.getManjian10());
		while(true) {
			//�������������Ż�ȯ
			if(this.hasCouponFlagInstore(checkedFlag)) {
				//�ͼ����û������Ż�ȯʣ������
				int availAmount=this.getAvailCouponAmount(c, checkedFlag);
				//�������Ż�ȯ�㹻���ã��ͷ���flag��amount
				if(availAmount>0) {
					flagAndAmount[0]=checkedFlag;
					flagAndAmount[1]=availAmount;
					return flagAndAmount;
				//����������ҵͼۣ�Сflag�����Ż�ȯ���ٴ��ж�����������
				}else {
					checkedFlag--;
				}
			//�������û������Ż�ȯ
			}else {
				//���������ͼ��Ż�ȯ�ˣ�flag=1������û���Ż�ȯ������
				if(checkedFlag==1) 
					return null;
				//flag-1����ƥ�䡢�ж�
				else
					checkedFlag--;
			}
		}
	}

	@Override
	public void initCoupon(HttpServletRequest hsr, long storeId) {
		//
		long userId=((User)hsr.getSession().getAttribute("user")).getId();
		if(manager.getCouponByBothId(userId, storeId)!=null) {
			return;
		}
		//先select store设置的 coupon得到map......还没写
		//这里自己设置一下store设置的coupon都是5张
		HashMap<Integer,Integer> couponMap=
				new HashMap<>();
		for(int i=1;i<11;i++) {
			couponMap.put(i, 5);
		}
		Coupon coupon=new Coupon();
		coupon.setUserId(userId);
		coupon.setStoreId(storeId);
		StringBuffer sb=new StringBuffer();
		couponMap.forEach((k,v)->{
			sb.append(v+"*");
			if(coupon.getManjian1()==0)
				coupon.setManjian1(k);
			else if(coupon.getManjian2()==0)
				coupon.setManjian2(k);
			else if(coupon.getManjian3()==0)
				coupon.setManjian3(k);
			else if(coupon.getManjian4()==0)
				coupon.setManjian4(k);
			else if(coupon.getManjian5()==0)
				coupon.setManjian5(k);
			else if(coupon.getManjian6()==0)
				coupon.setManjian6(k);
			else if(coupon.getManjian7()==0)
				coupon.setManjian7(k);
			else if(coupon.getManjian8()==0)
				coupon.setManjian8(k);
			else if(coupon.getManjian9()==0)
				coupon.setManjian9(k);
			else if(coupon.getManjian10()==0)
				coupon.setManjian10(k);
		});
		coupon.setAmountStr(sb.toString());
		manager.insertCoupon(coupon);
	}

	@Override
	public void decreCouponAmount(long userId, long storeId, int flag) {
		//
		Coupon c=manager.getCouponByBothId(userId, storeId);
		String[]amountstr=c.getAmountStr().split("*");
		int len =amountstr.length;
		int[]amounts=new int [len];
		for(int i=0;i<len;i++) {
			amounts[i]=Integer.parseInt(amountstr[i]);
		}
		if(c.getManjian1()==flag) amounts[0]--;
		if(c.getManjian2()==flag) amounts[1]--;
		if(c.getManjian3()==flag) amounts[2]--;
		if(c.getManjian4()==flag) amounts[3]--;
		if(c.getManjian5()==flag)amounts[4]--;
		if(c.getManjian6()==flag)amounts[5]--;
		if(c.getManjian7()==flag) amounts[6]--;
		if(c.getManjian8()==flag) amounts[7]--;
		if(c.getManjian9()==flag)amounts[8]--;
		if(c.getManjian10()==flag) amounts[9]--;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<len;i++) {
			sb.append(amounts[i]+"*");
		}
		c.setAmountStr(sb.toString());
		manager.updateCoupon(c);
	}



	@Override
	public CouponEnum getCouponByTotalPriceInOneStore(
			HttpServletRequest hsr, long storeId, float totalPrice) {
		//
		long userId=((User)hsr.getSession().getAttribute("user"))
				.getId();
		int [] arr=this.getUserCouponFlagAndAmount(
				userId, storeId, totalPrice);
		if(arr!=null)
			return CouponEnum.getCouponEnum(arr[0]);
		else
			return null;
	}
}
