package com.cys.boot.entity;

/**
 *	@description CustomerServiceStaff fk(User)
 *	@author Chenyongsheng
 * 	@date 2022/4/28
 */
public class CustomerServiceStaff {
	private long id;
	private long userId;
	private long storeId;
	private String niceName;
	private int active;
	public CustomerServiceStaff() {
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
	public String getNiceName() {
		return niceName;
	}
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}

	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "CustomerServiceStaff [id=" + id + ", userId=" + userId + ", storeId=" + storeId + ", niceName="
				+ niceName + ", active=" + active + "]";
	}
	
}
