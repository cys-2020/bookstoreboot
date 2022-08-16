package com.cys.boot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.ChatSrcvU;

public interface ChatSrcvUDAO {
	ArrayList<ChatSrcvU> getChatSrcvUs(@Param(value = "storeId") long storeId,
			@Param("userId") long userId);
	ArrayList<Long> getAllTargetUserIdInChatSrcvU(long userId);
	String getLatestChatSrcvURecordInChatSrcvU(long id);
	void insertChatSrcvU(ChatSrcvU chatSrcvU);
	void updateChatSrcvU(ChatSrcvU chatSrcvU);
	void deleteChatSrcvU(ChatSrcvU chatSrcvU);
}
