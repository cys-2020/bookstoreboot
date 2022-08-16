package com.cys.boot.manager;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.ChatStoU;

public interface ChatStoUManager {
	ArrayList<ChatStoU> getChatStoUs(@Param(value = "userId") long userId,
			@Param("targetUserid") long targetUserid);
	ArrayList<Long> getAllTargetUserIdInChatStoU(long storeId);
	String getLatestChatStoURecordInChatStoU(long id);
	void insertChatStoU(ChatStoU chatStoU);
	void updateChatStoU(ChatStoU chatStoU);
	void deleteChatStoU(ChatStoU chatStoU);
}
