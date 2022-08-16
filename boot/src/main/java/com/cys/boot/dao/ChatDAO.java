package com.cys.boot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.Chat;

public interface ChatDAO {
	ArrayList<Chat> getChats(@Param(value = "userId") long userId,
			@Param("targetUserid") long targetUserid);
	ArrayList<Long> getAllTargetUserIdInChat(long userId);
	String getLatestChatRecordInChat(long id);
	void insertChat(Chat chat);
	void updateChat(Chat chat);
	void deleteChat(Chat chat);
	
}
