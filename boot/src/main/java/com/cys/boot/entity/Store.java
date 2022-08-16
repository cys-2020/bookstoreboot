package com.cys.boot.entity;

import java.util.ArrayList;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.cys.boot.typeNeedHandle.SaleActivityEnum;
import com.cys.boot.typeNeedHandle.StoreLvEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *@description Store has store info,fk(Seller)
 *@author Chenyongsheng
 *@date 2022/5/17
 */
@JsonIgnoreProperties(value = {"handler"})
public class Store {
	private long id;
	private long sellerId;
	private String storeName;
	private StoreLvEnum lv;
	private float goodScore;
	private float serviceScore;
	private float shippingScore;
	private ArrayList<String> classes;
	private SaleActivityEnum saleActivity;
	private int fans;
	@DateTimeFormat(iso=ISO.DATE_TIME, pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date registerTime;
	public ArrayList<Good> goods;
	public Store() {
		//
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public StoreLvEnum getLv() {
		return lv;
	}
	public void setLv(StoreLvEnum lv) {
		this.lv = lv;
	}
	public float getGoodScore() {
		return goodScore;
	}
	public void setGoodScore(float goodScore) {
		this.goodScore = goodScore;
	}
	public float getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(float serviceScore) {
		this.serviceScore = serviceScore;
	}
	public float getShippingScore() {
		return shippingScore;
	}
	public void setShippingScore(float shippingScore) {
		this.shippingScore = shippingScore;
	}
	
	public SaleActivityEnum getSaleActivity() {
		return saleActivity;
	}
	public void setSaleActivity(SaleActivityEnum saleActivity) {
		this.saleActivity = saleActivity;
	}
	public ArrayList<String> getClasses() {
		return classes;
	}
	public void setClasses(ArrayList<String> classes) {
		this.classes = classes;
	}

	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}

	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "Store [id=" + id + ", sellerId=" + sellerId + ", storeName=" + storeName + ", lv=" + lv + ", goodScore="
				+ goodScore + ", serviceScore=" + serviceScore + ", shippingScore=" + shippingScore 
				+ ", classes=" + classes + ", saleActivity=" + saleActivity + ", fans=" + fans + ", registerTime="
				+ registerTime + "]";
	}
	public ArrayList<Good> getGoods() {
		return goods;
	}
	public void setGoods(ArrayList<Good> goods) {
		this.goods = goods;
	}

	
}
