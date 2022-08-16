package com.cys.boot.entity;

/**
 *	@description Seller fk(User)
 *	@author Chenyongsheng
 * 	@date 2022/4/28/
 */
public class Seller {
	private long id;
	private long userId;
	private float score;
	private int credibility;
	private int storeNumber;
	
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
	
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getCredibility() {
		return credibility;
	}
	public void setCredibility(int credibility) {
		this.credibility = credibility;
	}
	public int getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	@Override
	public String toString() {
		return "Seller [id=" + id + ", userId=" + userId + ", score=" + score + ", credibility=" + credibility
				+ ", storeNumber=" + storeNumber + "]";
	}
	
}
