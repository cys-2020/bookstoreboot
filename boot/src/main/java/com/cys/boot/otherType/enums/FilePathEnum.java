package com.cys.boot.otherType.enums;
/**
 * FilePathEnum includes MediaResourcesEnum,,,,
 * @param value
 */
public enum FilePathEnum {
	MEDIA_RESOURCES_PATH(
			1,FilePath_MediaResourcesEnum.ROOT_PATH);
	private int code;
	private FilePath_MediaResourcesEnum value;
	
	
	private FilePathEnum(int code, FilePath_MediaResourcesEnum value) {
		this.code = code;
		this.value = value;
	}
	public static FilePathEnum getFilePathEnum(int code) {
		switch(code) {
			case 1:return MEDIA_RESOURCES_PATH;
			
			default: return MEDIA_RESOURCES_PATH;
		}
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public FilePath_MediaResourcesEnum getValue() {
		return value;
	}
	public void setValue(FilePath_MediaResourcesEnum value) {
		this.value = value;
	}
	
}

