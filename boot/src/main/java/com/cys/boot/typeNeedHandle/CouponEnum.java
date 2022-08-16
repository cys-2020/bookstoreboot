package com.cys.boot.typeNeedHandle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *@description
 *@author Chenyongsheng
 *@date 2022/7/7
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CouponEnum {
	MANJIAN1(1,50,5),MANJIAN2(2,100,12),
	MANJIAN3(3,100,15),MANJIAN4(4,150,20),
	MANJIAN5(5,200,25),MANJIAN6(6,300,30),
	MANJIAN7(7,500,40),MANJIAN8(8,800,60),
	MANJIAN9(9,1000,80),MANJIAN10(10,2000,150),
	MANJIAN11(11,3000,250),MANJIAN12(12,4000,350),
	MANJIAN13(13,5000,450),MANJIAN14(14,8000,700),
	MANJIAN15(15,10000,900),MANJIAN16(16,20000,1500);
	private int flag;
	private int price;
	private int decrement;
	private CouponEnum(int flag, int price, int decrement) {
		this.flag = flag;
		this.price = price;
		this.decrement = decrement;
	}
	public static CouponEnum getCouponEnumByPrice(float goodPrice) {
		if(goodPrice<MANJIAN1.price) {
			return null;
		}else {
			if(goodPrice<MANJIAN2.price)
				return MANJIAN1;
			else if(goodPrice<MANJIAN3.price)
				return MANJIAN2;
			else if(goodPrice<MANJIAN4.price)
				return MANJIAN3;
			else if(goodPrice<MANJIAN5.price)
				return MANJIAN4;
			else if(goodPrice<MANJIAN6.price)
				return MANJIAN5;
			else if(goodPrice<MANJIAN7.price)
				return MANJIAN6;
			else if(goodPrice<MANJIAN8.price)
				return MANJIAN7;
			else if(goodPrice<MANJIAN9.price)
				return MANJIAN8;
			else if(goodPrice<MANJIAN10.price)
				return MANJIAN9;
			else if(goodPrice<MANJIAN11.price)
				return MANJIAN10;
			else if(goodPrice<MANJIAN12.price)
				return MANJIAN11;
			else if(goodPrice<MANJIAN13.price)
				return MANJIAN12;
			else if(goodPrice<MANJIAN14.price)
				return MANJIAN13;
			else if(goodPrice<MANJIAN15.price)
				return MANJIAN14;
			else if(goodPrice<MANJIAN16.price)
				return MANJIAN15;
			else
				return MANJIAN16;
		}
	}
	@JsonCreator
	public static CouponEnum getCouponEnum(int flag) {
		if(flag==MANJIAN1.flag) return MANJIAN1;
		if(flag==MANJIAN2.flag) return MANJIAN2;
		if(flag==MANJIAN3.flag) return MANJIAN3;
		if(flag==MANJIAN4.flag) return MANJIAN4;
		if(flag==MANJIAN5.flag) return MANJIAN5;
		if(flag==MANJIAN6.flag) return MANJIAN6;
		if(flag==MANJIAN7.flag) return MANJIAN7;
		if(flag==MANJIAN8.flag) return MANJIAN8;
		if(flag==MANJIAN9.flag) return MANJIAN9;
		if(flag==MANJIAN10.flag) return MANJIAN10;
		if(flag==MANJIAN11.flag) return MANJIAN11;
		if(flag==MANJIAN12.flag) return MANJIAN12;
		if(flag==MANJIAN13.flag) return MANJIAN13;
		if(flag==MANJIAN14.flag) return MANJIAN14;
		if(flag==MANJIAN15.flag) return MANJIAN15;
		if(flag==MANJIAN16.flag) return MANJIAN16;
		return null;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDecrement() {
		return decrement;
	}
	public void setDecrement(int decrement) {
		this.decrement = decrement;
	}
	public static void main(String[] args) {
		System.err.print(CouponEnum.MANJIAN1.decrement);
	}
}
