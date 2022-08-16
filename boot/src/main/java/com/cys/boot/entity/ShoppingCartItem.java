package com.cys.boot.entity;
/**
 *@description 
 *@author Chenyongsheng
 *@date 2022-07-06
 */
public class ShoppingCartItem{
	private long id;
	private long shoppingcartId;
	private long goodId;
	private String goodName;
	private int amount;
	private float price;
	private String typ;
	private boolean selected;
	//delete=-1, nochange=0, change=1, add=2
	private int changeFlag=0;
	public ShoppingCartItem() {
		//
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getShoppingcartId() {
		return shoppingcartId;
	}
	public void setShoppingcartId(long shoppingcartId) {
		this.shoppingcartId = shoppingcartId;
	}
	public long getGoodId() {
		return goodId;
	}
	public void setGoodId(long goodId) {
		this.goodId = goodId;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public int getChangeFlag() {
		return changeFlag;
	}
	public void setChangeFlag(int changeFlag) {
		this.changeFlag = changeFlag;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	@Override
	public String toString() {
		return "ShoppingCartItem [id=" + id + ", shoppingcartId=" + shoppingcartId + ", goodId=" + goodId
				+ ", goodName=" + goodName + ", amount=" + amount + ", price=" + price + ", typ=" + typ + ", selected="
				+ selected + ", changeFlag=" + changeFlag + "]";
	}
	
}
