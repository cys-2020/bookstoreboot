package com.cys.boot.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cys.boot.typeNeedHandle.RefundOptionEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 *@description 
 *@author Chenyongsheng
 *@date 2022/6/24
 */
public class Refund {
	private long id;
	private long orderformId;
	private String refundNumber;
	@DateTimeFormat(iso=ISO.DATE_TIME, pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date applyTime;
	@DateTimeFormat(iso=ISO.DATE_TIME,pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date okTime;
	//interface   enum !!!!!!!!!!!!!!!! dont know
	private RefundOptionEnum refundOption;
	private String refundDescription;
	private int flag;
	public Refund() {
		//
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getOrderformId() {
		return orderformId;
	}
	public void setOrderformId(long orderformId) {
		this.orderformId = orderformId;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	

	public RefundOptionEnum getRefundOption() {
		return refundOption;
	}
	public void setRefundOption(RefundOptionEnum refundOption) {
		this.refundOption = refundOption;
	}
	public String getRefundDescription() {
		return refundDescription;
	}
	public void setRefundDescription(String refundDescription) {
		this.refundDescription = refundDescription;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Date getOkTime() {
		return okTime;
	}
	public void setOkTime(Date okTime) {
		this.okTime = okTime;
	}
	public String getRefundNumber() {
		return refundNumber;
	}
	public void setRefundNumber(String refundNumber) {
		this.refundNumber = refundNumber;
	}
	@Override
	public String toString() {
		return "Refund [id=" + id + ", orderformId=" + orderformId + ", refundNumber=" + refundNumber + ", applyTime="
				+ applyTime + ", okTime=" + okTime + ", refundOption=" + refundOption + ", refundDescription="
				+ refundDescription + ", flag=" + flag + "]";
	}
	
}
