package com.cys.boot.typeNeedHandle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StoreLvEnum {
	LV1(1,"爱心",0),LV2(2,"爱心",1000),
	LV3(3,"爱心",3000),LV4(4,"爱心",5000),
	LV5(5,"爱心",10000),LV6(6,"钻石",30000),
	LV7(7,"钻石",50000),LV8(8,"钻石",80000),
	LV9(9,"钻石",120000),LV10(10,"钻石",150000),
	LV11(11,"皇冠",200000),LV12(12,"皇冠",300000),
	LV13(13,"皇冠",400000),LV14(14,"皇冠",500000),
	LV15(15,"皇冠",1000000);
	private int lv;
	private String lvValue;
	private long income;
	
	private StoreLvEnum(int lv, String lvValue, long income) {
		this.lv = lv;
		this.lvValue = lvValue;
		this.setIncome(income);
	}
	@JsonCreator
	public static StoreLvEnum getStoreLvEnum(int lv) {
		switch(lv) {
		case 1:return LV1;
		case 2:return LV2;
		case 3:return LV3;
		case 4:return LV4;
		case 5:return LV5;
		case 6:return LV6;
		case 7:return LV7;
		case 8:return LV8;
		case 9:return LV9;
		case 10:return LV10;
		case 11:return LV11;
		case 12:return LV12;
		case 13:return LV13;
		case 14:return LV14;
		default:return LV15;
		}
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public String getLvValue() {
		return lvValue;
	}
	public void setLvValue(String lvValue) {
		this.lvValue = lvValue;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	
}
