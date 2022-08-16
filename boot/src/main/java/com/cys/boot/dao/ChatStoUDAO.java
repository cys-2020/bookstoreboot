package com.cys.boot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.ChatStoU;

public interface ChatStoUDAO {
	ArrayList<ChatStoU> getChatStoUs(@Param(value = "storeId") long storeId,
			@Param("userId") long userId);
	ArrayList<Long> getAllTargetUserIdInChatStoU(long userId);
	String getLatestChatStoURecordInChatStoU(long id);
	void insertChatStoU(ChatStoU chatStoU);
	void updateChatStoU(ChatStoU chatStoU);
	void deleteChatStoU(ChatStoU chatStoU);
}
