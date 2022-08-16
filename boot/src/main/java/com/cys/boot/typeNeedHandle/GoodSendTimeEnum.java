package com.cys.boot.typeNeedHandle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GoodSendTimeEnum {
	TIME1(1,"当天下午"),TIME2(2,"两天内"),
	TIME3(3,"三天内"),TIME4(4,"三十天内");
	private int c;
	private String v;
	private GoodSendTimeEnum(int c, String v) {
		this.c = c;
		this.v = v;
	}
	@JsonCreator
	public static GoodSendTimeEnum getGoodSendTimeEnum
								(int code) {
		switch(code) {
			case 1:return TIME1;
			case 2:return TIME2;
			case 3:return TIME3;
			default :return TIME4;
		}
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	
}
