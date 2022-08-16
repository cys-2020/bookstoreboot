package com.cys.boot.typeNeedHandle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RefundOptionEnum {
	//refund before send
	BEFORESEND1(1,"突然不想要了"),
	BEFORESEND2(2,"不小心买错宝贝了"),
	BEFORESEND3(3,"发货太慢了，等不及"),
	BEFORESEND4(4,"突然想换个型号"),
	//refund with good
	MONEYANDGOOD1(5,"不喜欢"),
	MONEYANDGOOD2(6,"宝贝与描述不符"),
	MONEYANDGOOD3(7,"退运费"),
	MONEYANDGOOD4(8,"质量问题"),
	MONEYANDGOOD5(9,"包装/商品 破损/污渍"),
	MONEYANDGOOD6(10,"假冒品牌"),
	MONEYANDGOOD7(11,"发票问题"),
	MONEYANDGOOD8(12,"卖家发错货"),
	//refund only money
		//1,before seeing good
	ONLYMONEY1(13,"不想要了"),
	ONLYMONEY2(14,"收到了空包裹"),
		//2,after seeing  good
	ONLYMONEY3(15,"宝贝是坏的/缺少零件"),
	ONLYMONEY4(16,"宝贝实物与描述不符"),
	ONLYMONEY5(17,"退我运费"),
	ONLYMONEY6(18,"质量问题"),
	ONLYMONEY7(19,"包装/商品 破损/污渍"),
	ONLYMONEY8(20,"发票问题"),
	ONLYMONEY9(21,"卖家发错货");
	private int code;
	private String optionValue;
	private RefundOptionEnum(int code, String optionValue) {
		this.code = code;
		this.optionValue = optionValue;
	}
	@JsonCreator
	public static RefundOptionEnum getRefundOptionEnum(
			int code) {
		switch(code) {
			case 1:return BEFORESEND1;
			case 2:return BEFORESEND2;
			case 3:return BEFORESEND3;
			case 4:return BEFORESEND4;
			case 5:return MONEYANDGOOD1;
			case 6:return MONEYANDGOOD2;
			case 7:return MONEYANDGOOD3;
			case 8:return MONEYANDGOOD4;
			case 9:return MONEYANDGOOD5;
			case 10:return MONEYANDGOOD6;
			case 11:return MONEYANDGOOD7;
			case 12:return MONEYANDGOOD8;
			case 13:return ONLYMONEY1;
			case 14:return ONLYMONEY2;
			case 15:return ONLYMONEY3;
			case 16:return ONLYMONEY4;
			case 17:return ONLYMONEY5;
			case 18:return ONLYMONEY6;
			case 19:return ONLYMONEY7;
			case 20:return ONLYMONEY8;
			default:return ONLYMONEY9;
		}
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	
}
