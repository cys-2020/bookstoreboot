package com.cys.boot.entity;

public class Coupon {
	private long id;
	private long userId;
	private long storeId;
	private int manjian1;
	private int manjian2;
	private int manjian3;
	private int manjian4;
	private int manjian5;
	private int manjian6;
	private int manjian7;
	private int manjian8;
	private int manjian9;
	private int manjian10;
	private String amountStr;
	public Coupon() {
		//
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
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public int getManjian1() {
		return manjian1;
	}
	public void setManjian1(int manjian1) {
		this.manjian1 = manjian1;
	}
	public int getManjian2() {
		return manjian2;
	}
	public void setManjian2(int manjian2) {
		this.manjian2 = manjian2;
	}
	public int getManjian3() {
		return manjian3;
	}
	public void setManjian3(int manjian3) {
		this.manjian3 = manjian3;
	}
	public int getManjian4() {
		return manjian4;
	}
	public void setManjian4(int manjian4) {
		this.manjian4 = manjian4;
	}
	public int getManjian5() {
		return manjian5;
	}
	public void setManjian5(int manjian5) {
		this.manjian5 = manjian5;
	}
	public int getManjian6() {
		return manjian6;
	}
	public void setManjian6(int manjian6) {
		this.manjian6 = manjian6;
	}
	public int getManjian7() {
		return manjian7;
	}
	public void setManjian7(int manjian7) {
		this.manjian7 = manjian7;
	}
	public int getManjian8() {
		return manjian8;
	}
	public void setManjian8(int manjian8) {
		this.manjian8 = manjian8;
	}
	public int getManjian9() {
		return manjian9;
	}
	public void setManjian9(int manjian9) {
		this.manjian9 = manjian9;
	}
	public int getManjian10() {
		return manjian10;
	}
	public void setManjian10(int manjian10) {
		this.manjian10 = manjian10;
	}
	
	public String getAmountStr() {
		return amountStr;
	}
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", manjian1=" + manjian1
				+ ", manjian2=" + manjian2 + ", manjian3=" + manjian3 + ", manjian4=" + manjian4 + ", manjian5="
				+ manjian5 + ", manjian6=" + manjian6 + ", manjian7=" + manjian7 + ", manjian8=" + manjian8
				+ ", manjian9=" + manjian9 + ", manjian10=" + manjian10 + ", amount=" + amountStr + "]";
	}
	
	
}
