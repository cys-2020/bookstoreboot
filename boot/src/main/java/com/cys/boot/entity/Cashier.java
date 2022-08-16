package com.cys.boot.entity;

/**
 *@description include staged money and finished money 
 *@author Chenyongsheng
 *@date 2022/5/27
 */
public class Cashier {
	private long id;
	private long userId;
	private long storeId;
	private float stagedMoney;
	private float finishedMoney;
	public Cashier() {
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
	public float getStagedMoney() {
		return stagedMoney;
	}
	public void setStagedMoney(float stagedMoney) {
		this.stagedMoney = stagedMoney;
	}
	public float getFinishedMoney() {
		return finishedMoney;
	}
	public void setFinishedMoney(float finishedMoney) {
		this.finishedMoney = finishedMoney;
	}
	@Override
	public String toString() {
		return "Cashier [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", stagedMoney=" + stagedMoney
				+ ", finishedMoney=" + finishedMoney + "]";
	}
	
	
	
}
