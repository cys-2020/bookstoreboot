package com.cys.boot.manager.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.ChatStoUDAO;
import com.cys.boot.entity.ChatStoU;
import com.cys.boot.manager.ChatStoUManager;
@Service
public class ChatStoUManagerImpl implements ChatStoUManager {
	private ChatStoUDAO dao;
	
	public ChatStoUManagerImpl(ChatStoUDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<ChatStoU> getChatStoUs(long userId, long targetUserid) {
		//
		return dao.getChatStoUs(userId, targetUserid);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Long> getAllTargetUserIdInChatStoU(long userId) {
		//
		return dao.getAllTargetUserIdInChatStoU(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public String getLatestChatStoURecordInChatStoU(long id) {
		//
		return dao.getLatestChatStoURecordInChatStoU(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertChatStoU(ChatStoU chatStoU) {
		//
		dao.insertChatStoU(chatStoU);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateChatStoU(ChatStoU chatStoU) {
		//
		dao.updateChatStoU(chatStoU);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteChatStoU(ChatStoU chatStoU) {
		//
		dao.deleteChatStoU(chatStoU);
	}

}
