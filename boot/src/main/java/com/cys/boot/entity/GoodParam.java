package com.cys.boot.entity;

public class GoodParam {
	private long id;
	private long goodId;
	private String pName;
	private String srcPlace;
	private String comName;
	private String shelfLife;
	private String pId;
	private String pStandard;
	private String material;
	private String size;
	private String surface;
	
	private String typs;
	
	public GoodParam() {
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
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getSrcPlace() {
		return srcPlace;
	}
	public void setSrcPlace(String srcPlace) {
		this.srcPlace = srcPlace;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpStandard() {
		return pStandard;
	}
	public void setpStandard(String pStandard) {
		this.pStandard = pStandard;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTyps() {
		return typs;
	}
	public void setTyps(String typs) {
		this.typs = typs;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	@Override
	public String toString() {
		return "GoodParam [id=" + id + ", goodId=" + goodId + ", pName=" + pName + ", srcPlace=" + srcPlace
				+ ", comName=" + comName + ", shelfLife=" + shelfLife + ", pId=" + pId + ", pStandard=" + pStandard
				+ ", material=" + material + ", typs=" + typs + ", size=" + size + ", surface=" + surface + "]";
	}
	
	
}
