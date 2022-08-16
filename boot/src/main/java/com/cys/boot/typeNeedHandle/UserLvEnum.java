package com.cys.boot.typeNeedHandle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserLvEnum {
	LV1(1,"爱心",0),LV2(2,"爱心",100),
	LV3(3,"爱心",300),LV4(4,"爱心",500),
	LV5(5,"爱心",1000),LV6(6,"钻石",1500),
	LV7(7,"钻石",2000),LV8(8,"钻石",3000),
	LV9(9,"钻石",4000),LV10(10,"钻石",5000),
	LV11(11,"皇冠",8000),LV12(12,"皇冠",10000),
	LV13(13,"皇冠",15000),LV14(14,"皇冠",20000),
	LV15(15,"皇冠",30000);
	private int code;
	private String lvValue;
	private int consumption;

	private UserLvEnum(int code, String lvValue, int consumption) {
		this.code = code;
		this.lvValue = lvValue;
		this.consumption = consumption;
	}
	@JsonCreator
	public static UserLvEnum getUserLvEnum(int lv) {
		switch(lv) {
			case 1:return UserLvEnum.LV1;
			case 2:return UserLvEnum.LV2;
			case 3:return UserLvEnum.LV3;
			case 4:return UserLvEnum.LV4;
			case 5:return UserLvEnum.LV5;
			case 6:return UserLvEnum.LV6;
			case 7:return UserLvEnum.LV7;
			case 8:return UserLvEnum.LV8;
			case 9:return UserLvEnum.LV9;
			case 10:return UserLvEnum.LV10;
			case 11:return UserLvEnum.LV11;
			case 12:return UserLvEnum.LV12;
			case 13:return UserLvEnum.LV13;
			case 14:return UserLvEnum.LV14;
			case 15:return UserLvEnum.LV15;
		}
		return UserLvEnum.LV1;
	}
	public static UserLvEnum getUserLvEnumByConsumption(
			int con) {
		if(con>=0&&con<100) return UserLvEnum.LV1;
		else if(con<300) return UserLvEnum.LV2;
		else if(con<500) return UserLvEnum.LV3;
		else if(con<1000) return UserLvEnum.LV4;
		else if(con<1500) return UserLvEnum.LV5;
		else if(con<2000) return UserLvEnum.LV6;
		else if(con<3000) return UserLvEnum.LV7;
		else if(con<4000) return UserLvEnum.LV8;
		else if(con<5000) return UserLvEnum.LV9;
		else if(con<8000) return UserLvEnum.LV10;
		else if(con<10000) return UserLvEnum.LV11;
		else if(con<15000) return UserLvEnum.LV12;
		else if(con<20000) return UserLvEnum.LV13;
		else if(con<30000) return UserLvEnum.LV14;
		else return UserLvEnum.LV15;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLvValue() {
		return lvValue;
	}
	public void setLvValue(String lvValue) {
		this.lvValue = lvValue;
	}

	public int getConsumption() {
		return consumption;
	}
	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}
	
}
