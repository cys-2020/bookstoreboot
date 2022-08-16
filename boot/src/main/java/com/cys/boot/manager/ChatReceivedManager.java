package com.cys.boot.manager;

import java.util.ArrayList;

import com.cys.boot.entity.ChatReceived;

public interface ChatReceivedManager {
	ArrayList<ChatReceived> getChatsReceived(long userId, long targetUserid);
	ArrayList<Long> getAllTargetUserIdInChatReceived(long userId);
	String getLatestChatRecordInChatReceived(long id);
	void insertChatReceived(ChatReceived chatRcv);
	void updateChatReceived(ChatReceived chatRcv);
	void deleteChatReceived(ChatReceived chatRcv);
}
