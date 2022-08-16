package com.cys.boot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.ChatReceived;

public interface ChatReceivedDAO {
	ArrayList<ChatReceived> getChatsReceived(@Param(value = "userId") long userId,
			@Param("targetUserid") long targetUserid);
	ArrayList<Long> getAllTargetUserIdInChatReceived(long userId);
	String getLatestChatRecordInChatReceived(long id);
	void insertChatReceived(ChatReceived chatRcv);
	void updateChatReceived(ChatReceived chatRcv);
	void deleteChatReceived(ChatReceived chatRcv);
}
