package com.cys.boot.typeNeedHandle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SaleActivityEnum {
	SA1(1,"国庆节促销活动",0.85f,"2022-10-01 00:00:00","2022-10-08 00:00:00");
	private int code;
	private String activityName;
	private float discount;
	private String beginTime;
	private String endTime;
	private SaleActivityEnum(int code, String activityName, float discount, String beginTime, String endTime) {
		this.code = code;
		this.activityName = activityName;
		this.discount = discount;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}
	@JsonCreator
	public static SaleActivityEnum getActivityEnum(int code) {
		switch(code) {
		case 1:return SA1;
		default:return SA1;
		}
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
