package com.cys.boot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cys.boot.typeNeedHandle.GoodSendTimeEnum;
import com.cys.boot.typeNeedHandle.GoodShippingInsuranceEnum;
import com.cys.boot.typeNeedHandle.ShippingCompanyEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *	@description Good(detail) has good info,fk(Store)
 *	@author Chenyongsheng
 * 	@date 2022/5/17
 */
@JsonIgnoreProperties(value = "handler")
public class Good {
	private long id;
	private long storeId;
	private ArrayList<String> topRef;
	private String title;
	//if this good "in"ing an activity
	private int actFlag;
	private float price;
	private int saleAmount;
	private ArrayList<String> typs;
	private ShippingCompanyEnum shippingCompany;
	private String shippingFrom;
	private GoodShippingInsuranceEnum shippingInsurance;
	private GoodSendTimeEnum sendTime;
	private int repoNumber;
	private ArrayList<String> bottomRef;
	//need association auto
	private GoodPostageAboutLv postageAboutLv;
	//need association store but can't auto by mybatis 
	private Store store;
	//need association goodParam, auto
	private HashMap<String, Object> param;

	public Good() {
		//
	}
	
	public ArrayList<String> getTopRef() {
		return topRef;
	}

	public void setTopRef(ArrayList<String> topRef) {
		this.topRef = topRef;
	}

	public ArrayList<String> getTyps() {
		return typs;
	}

	public void setTyps(ArrayList<String> typs) {
		this.typs = typs;
	}

	public ArrayList<String> getBottomRef() {
		return bottomRef;
	}

	public void setBottomRef(ArrayList<String> bottomRef) {
		this.bottomRef = bottomRef;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getActFlag() {
		return actFlag;
	}
	public void setActFlag(int actFlag) {
		this.actFlag = actFlag;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}
	
	
	public String getShippingFrom() {
		return shippingFrom;
	}
	public void setShippingFrom(String shippingFrom) {
		this.shippingFrom = shippingFrom;
	}
	
	public GoodShippingInsuranceEnum getShippingInsurance() {
		return shippingInsurance;
	}

	public void setShippingInsurance(GoodShippingInsuranceEnum shippingInsurance) {
		this.shippingInsurance = shippingInsurance;
	}

	public GoodSendTimeEnum getSendTime() {
		return sendTime;
	}

	public void setSendTime(GoodSendTimeEnum sendTime) {
		this.sendTime = sendTime;
	}

	public int getRepoNumber() {
		return repoNumber;
	}
	public void setRepoNumber(int repoNumber) {
		this.repoNumber = repoNumber;
	}


	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	





	public HashMap<String, Object> getParam() {
		return param;
	}

	public void setParam(HashMap<String, Object> param) {
		this.param = param;
	}


	public GoodPostageAboutLv getPostageAboutLv() {
		return postageAboutLv;
	}

	public void setPostageAboutLv(GoodPostageAboutLv postageAboutLv) {
		this.postageAboutLv = postageAboutLv;
	}

	public ShippingCompanyEnum getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(ShippingCompanyEnum shippingCompany) {
		this.shippingCompany = shippingCompany;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", storeId=" + storeId + ", topRef=" + topRef + ", title=" + title + ", actFlag="
				+ actFlag + ", price=" + price + ", saleAmount=" + saleAmount + ", typs=" + typs + ", shippingCompany="
				+ shippingCompany + ", shippingFrom=" + shippingFrom + ", shippingInsurance=" + shippingInsurance
				+ ", sendTime=" + sendTime + ", repoNumber=" + repoNumber + ", bottomRef=" + bottomRef
				+ ", postageAboutLv=" + postageAboutLv + ", store=" + store + ", param=" + param + "]";
	}



	
}
