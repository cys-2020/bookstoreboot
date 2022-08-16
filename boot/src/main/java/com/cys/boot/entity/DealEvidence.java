package com.cys.boot.entity;

import java.util.ArrayList;

import com.cys.boot.otherType.GoodItem;

/**
 *@description Deal evidence(in orderform),fk(good_id)
 *@author Chenyongsheng
 *@date 2022/5/20
 */
public class DealEvidence extends GoodItem{
	//top_ref is list in GoodItem, but de need string(only 1 ref)
	private long id;
	private String goodParam;
	private ArrayList<String> bottomRef;
	public DealEvidence() {
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
	public String getGoodTitle() {
		return goodTitle;
	}
	public void setGoodTitle(String goodTitle) {
		this.goodTitle = goodTitle;
	}
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public int getGoodAmount() {
		return goodAmount;
	}
	public void setGoodAmount(int goodAmount) {
		this.goodAmount = goodAmount;
	}
	public String getGoodParam() {
		return goodParam;
	}
	public void setGoodParam(String goodParam) {
		this.goodParam = goodParam;
	}

	@Override
	public String getTopRef() {
		//
		return this.topRef;
	}
	@Override
	public void setTopRef(String topRef) {
		//
		this.topRef=topRef;
	}
	public ArrayList<String> getBottomRef() {
		return bottomRef;
	}
	public void setBottomRef(ArrayList<String> bottomRef) {
		this.bottomRef = bottomRef;
	}
	@Override
	public String toString() {
		return "DealEvidence [id=" + id + ", goodParam=" + goodParam + ", bottomRef=" + bottomRef + "]";
	}
	
	
	
}
