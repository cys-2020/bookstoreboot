package com.cys.boot.typeNeedHandle;

import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GoodShippingInsuranceEnum {
	YES(1,"赠运费险"),NO(2,"不赠运费险");
	private int code;
	private String value;
	private GoodShippingInsuranceEnum(int code, String value) {
		this.code = code;
		this.value = value;
	}
	@JsonCreator
	public static GoodShippingInsuranceEnum 
		getGoodShippingInsuranceEnum(int code) {
		switch(code) {
		case 1:return YES;
		default:return NO;
		}
	}
	public static float getGoodShippingInsurance(
			float goodPrice) {
		DecimalFormat df= new DecimalFormat("0.00");
		float si=Float.parseFloat(df.format(goodPrice*100/10000));
		return si;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public static void main(String[] args) {
		float a=88.99f;
		System.err.print(a*100/10000);
	}
}
