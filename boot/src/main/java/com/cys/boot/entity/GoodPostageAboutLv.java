package com.cys.boot.entity;

public class GoodPostageAboutLv {
	private long id;
	private long goodId;
	private float lv1;
	private float lv2;
	private float lv3;
	public GoodPostageAboutLv() {
		//
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getGoodId() {
		return goodId;
	}
	public void setGoodId(long goodId) {
		this.goodId = goodId;
	}
	public float getLv1() {
		return lv1;
	}
	public void setLv1(float lv1) {
		this.lv1 = lv1;
	}
	public float getLv2() {
		return lv2;
	}
	public void setLv2(float lv2) {
		this.lv2 = lv2;
	}
	public float getLv3() {
		return lv3;
	}
	public void setLv3(float lv3) {
		this.lv3 = lv3;
	}
	@Override
	public String toString() {
		return "GoodPostageAboutLv [id=" + id + ", goodId=" + goodId + ", lv1=" + lv1 + ", lv2=" + lv2 + ", lv3=" + lv3
				+ "]";
	}
	
}
