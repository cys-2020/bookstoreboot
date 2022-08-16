package com.cys.boot.typeNeedHandle;

import java.util.Date;

import java.util.HashMap;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cys.boot.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *	@description ChatRecord packages(divides)
 *	 rN's detail in Chat
 *	@author Chenyongsheng
 * 	@date 2022/5/7
 */
public class ChatRecord {
	
	
	/**
	 * t_chat's id, refers one chat(row)
	 */
	private long id;
	
	
	/*
	 * their keys(will merge) are used to be a id(orderby)
	 */
	private HashMap<Integer, String>  chatText;
	private  HashMap<Integer, String> chatRefs;
	
	@DateTimeFormat(iso=ISO.DATE_TIME, pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date chatTime;
	/*
	 *target user has read?
	 */
	private int readFlag;
	private int deletedFlag;
	
	private Object sender;
	
	public ChatRecord() {
		//
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	
	public HashMap<Integer, String> getChatText() {
		return chatText;
	}
	public void setChatText(HashMap<Integer, String> chatText) {
		this.chatText = chatText;
	}
	public HashMap<Integer, String> getChatRefs() {
		return chatRefs;
	}
	public void setChatRefs(HashMap<Integer, String> chatRefs) {
		this.chatRefs = chatRefs;
	}
	
	public Object getSender() {
		return sender;
	}
	public void setSender(Object sender) {
		this.sender = sender;
	}
	public int getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(int readFlag) {
		this.readFlag = readFlag;
	}
	public int getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(int deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	@Override
	public String toString() {
		return "ChatRecord [id=" + id + ", chatText=" + chatText + ", chatRefs=" + chatRefs + ", chatTime=" + chatTime
				+ ", readFlag=" + readFlag + ", deletedFlag=" + deletedFlag + ", sender=" + sender + "]";
	}
	
	
	
}
