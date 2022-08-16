package com.cys.boot.otherType;

import java.util.ArrayList;

/**
 *@description good info(simple) user will buy 
 *and as condition of DealEvidence. But this.topRef need 
 *send  (0) to json only, and this.bottomRef dosen't send to 
 *json, because they are used to  show **simple** good and 
 * generate DealEvidence.
 *@author Chenyongsheng
 *@date 2022/5/25
 */
public class GoodItem {
	protected long goodId;
	protected String goodTitle;
	protected String goodType;
	protected int goodAmount;
	protected String topRef;
	private String note;
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

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getTopRef() {
		return topRef;
	}
	public void setTopRef(String topRef) {
		this.topRef = topRef;
	}
	@Override
	public String toString() {
		return "GoodItem [goodId=" + goodId + ", goodTitle=" + goodTitle + ", goodType=" + goodType + ", goodAmount="
				+ goodAmount + ", topRef=" + topRef + ", note=" + note + "]";
	}
	
}
