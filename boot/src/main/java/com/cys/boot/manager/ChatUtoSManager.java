package com.cys.boot.manager;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.ChatUtoS;

public interface ChatUtoSManager {
	ArrayList<ChatUtoS> getChatUtoSs(@Param(value = "userId") long userId,
			@Param("targetUserid") long targetUserid);
	ArrayList<Long> getAllTargetUserIdInChatUtoS(long userId);
	String getLatestChatUtoSRecordInChatUtoS(long id);
	void insertChatUtoS(ChatUtoS chatUtoS);
	void updateChatUtoS(ChatUtoS chatUtoS);
	void deleteChatUtoS(ChatUtoS chatUtoS);
}
