package com.cys.boot.entity;

public class Address {
	private long id;
	private long userId;
	private String who;
	private long phoneNumber;
	private String address;
	private String addressDetail;
	private int flag;
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
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Address() {
		//
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", who=" + who + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", addressDetail=" + addressDetail + ", flag=" + flag + "]";
	}
	@Override
	public boolean equals(Object oo) {
		Address o=(Address)oo;
		return
				this.getAddress().equals(o.getAddress())&&
				this.getAddressDetail().equals(o.getAddressDetail())&&
				this.getFlag()==o.getFlag()&&
				this.getPhoneNumber()==o.getPhoneNumber()&&
				this.getWho().equals(o.getWho());
	}
	
	
}
