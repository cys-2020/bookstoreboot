package com.cys.boot.entity;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cys.boot.typeNeedHandle.CouponEnum;
import com.cys.boot.typeNeedHandle.GoodShippingInsuranceEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *@description Orderform's info devided into some phases according
 *to its schedule(flow). Data will be filled with progress. fk(user_id/de_id)
 *@author Chenyongsheng
 *@date 2022/5/20
 */
public class Orderform {
	private long id;
	private long userId;
	private long deId;
	private int address;
	private float postage;
	private GoodShippingInsuranceEnum shippingInsurance;
	private CouponEnum coupon;
	private String note;
	private int invoice;
	private String orderformNumber;
	private float finalMoney;
	private int dealPoint;
	private String payNumber;
	@DateTimeFormat(iso=ISO.DATE_TIME, pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	@DateTimeFormat(iso=ISO.DATE_TIME, pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date payTime;
	@DateTimeFormat(iso=ISO.DATE_TIME, pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date sendTime;
	@DateTimeFormat(iso=ISO.DATE_TIME, pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;
	private int orderformStatus;
	private DealEvidence de;
	public Orderform() {
		//
	}
	public static int getDealPoint(float money) {
		return Math.round(money);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getDeId() {
		return deId;
	}
	public void setDeId(long deId) {
		this.deId = deId;
	}
	public float getPostage() {
		return postage;
	}
	public void setPostage(float postage) {
		this.postage = postage;
	}
	
	public GoodShippingInsuranceEnum getShippingInsurance() {
		return shippingInsurance;
	}
	public void setShippingInsurance(GoodShippingInsuranceEnum shippingInsurance) {
		this.shippingInsurance = shippingInsurance;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getInvoice() {
		return invoice;
	}
	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public String getOrderformNumber() {
		return orderformNumber;
	}
	public void setOrderformNumber(String orderformNumber) {
		this.orderformNumber = orderformNumber;
	}
	public float getFinalMoney() {
		return finalMoney;
	}
	public void setFinalMoney(float finalMoney) {
		this.finalMoney = finalMoney;
	}
	public int getDealPoint() {
		return dealPoint;
	}
	public void setDealPoint(int dealPoint) {
		this.dealPoint = dealPoint;
	}
	public String getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public CouponEnum getCoupon() {
		return coupon;
	}
	public void setCoupon(CouponEnum coupon) {
		this.coupon = coupon;
	}

	public int getOrderformStatus() {
		return orderformStatus;
	}
	public void setOrderformStatus(int orderformStatus) {
		this.orderformStatus = orderformStatus;
	}
	
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Orderform [id=" + id + ", userId=" + userId + ", deId=" + deId + ", address=" + address + ", postage="
				+ postage + ", shippingInsurance=" + shippingInsurance + ", coupon=" + coupon + ", note=" + note
				+ ", invoice=" + invoice + ", orderformNumber=" + orderformNumber + ", finalMoney=" + finalMoney
				+ ", dealPoint=" + dealPoint + ", payNumber=" + payNumber + ", createTime=" + createTime + ", payTime="
				+ payTime + ", sendTime=" + sendTime + ", endTime=" + endTime + ", orderformStatus=" + orderformStatus
				+ "]";
	}
	public DealEvidence getDe() {
		return de;
	}
	public void setDe(DealEvidence de) {
		this.de = de;
	}

	
	
}
