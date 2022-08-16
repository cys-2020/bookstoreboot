package com.cys.boot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.cys.boot.entity.ChatUrcvS;

public interface ChatUrcvSDAO {
	ArrayList<ChatUrcvS> getChatUrcvSs(@Param(value = "userId") long userId,
			@Param("storeId") long storeId);
	ArrayList<Long> getAllTargetUserIdInChatUrcvS(long userId);
	String getLatestChatUrcvSRecordInChatUrcvS(long id);
	void insertChatUrcvS(ChatUrcvS chatUrcvS);
	void updateChatUrcvS(ChatUrcvS chatUrcvS);
	void deleteChatUrcvS(ChatUrcvS chatUrcvS);
}
