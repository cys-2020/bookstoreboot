package com.cys.boot.otherType.enums;

public enum FilePath_MediaResourcesEnum {
	ROOT_PATH(1,"D:\\java\\workspace\\bootResources\\");
	private int code;
	private String value;
	private FilePath_MediaResourcesEnum(int code, String value) {
		this.code = code;
		this.value = value;
	}
	public static FilePath_MediaResourcesEnum getFilePath_MediaResourcesEnum(int code) {
		switch(code) {
			case 1:return ROOT_PATH;
			
			default: return ROOT_PATH;
		}
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
