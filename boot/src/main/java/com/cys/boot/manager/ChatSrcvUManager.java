package com.cys.boot.manager;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.ChatSrcvU;

public interface ChatSrcvUManager {
	ArrayList<ChatSrcvU> getChatSrcvUs(@Param(value = "userId") long userId,
			@Param("targetUserid") long targetUserid);
	ArrayList<Long> getAllTargetUserIdInChatSrcvU(long storeId);
	String getLatestChatSrcvURecordInChatSrcvU(long id);
	void insertChatSrcvU(ChatSrcvU chatSrcvU);
	void updateChatSrcvU(ChatSrcvU chatSrcvU);
	void deleteChatSrcvU(ChatSrcvU chatSrcvU);
}
