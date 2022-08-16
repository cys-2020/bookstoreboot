package com.cys.boot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.ChatUtoS;

public interface ChatUtoSDAO {
	ArrayList<ChatUtoS> getChatUtoSs(@Param(value = "userId") long userId,
			@Param("storeId") long storeId);
	ArrayList<Long> getAllTargetUserIdInChatUtoS(long userId);
	String getLatestChatUtoSRecordInChatUtoS(long id);
	void insertChatUtoS(ChatUtoS chatUtoS);
	void updateChatUtoS(ChatUtoS chatUtoS);
	void deleteChatUtoS(ChatUtoS chatUtoS);
}
