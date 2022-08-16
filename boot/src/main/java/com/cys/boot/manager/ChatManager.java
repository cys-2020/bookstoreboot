package com.cys.boot.manager;

import java.util.ArrayList;


import com.cys.boot.entity.Chat;

public interface ChatManager {
	ArrayList<Chat> getChats(long userId, long targetUserid);
	ArrayList<Long> getAllTargetUserIdInChat(long userId);
	String getLatestChatRecordInChat(long id);
	void insertChat(Chat chat);
	void updateChat(Chat chat);
	void deleteChat(Chat chat);
}
