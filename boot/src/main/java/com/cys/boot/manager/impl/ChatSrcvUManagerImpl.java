package com.cys.boot.manager.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.ChatSrcvUDAO;
import com.cys.boot.entity.ChatSrcvU;
import com.cys.boot.manager.ChatSrcvUManager;
@Service
public class ChatSrcvUManagerImpl implements ChatSrcvUManager{
	private ChatSrcvUDAO dao;
	
	public ChatSrcvUManagerImpl(ChatSrcvUDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<ChatSrcvU> getChatSrcvUs(long userId, long targetUserid) {
		//
		return dao.getChatSrcvUs(userId, targetUserid);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Long> getAllTargetUserIdInChatSrcvU(long userId) {
		//
		return dao.getAllTargetUserIdInChatSrcvU(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public String getLatestChatSrcvURecordInChatSrcvU(long id) {
		//
		return dao.getLatestChatSrcvURecordInChatSrcvU(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertChatSrcvU(ChatSrcvU chatSrcvU) {
		//
		dao.insertChatSrcvU(chatSrcvU);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateChatSrcvU(ChatSrcvU chatSrcvU) {
		//
		dao.updateChatSrcvU(chatSrcvU);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteChatSrcvU(ChatSrcvU chatSrcvU) {
		//
		dao.deleteChatSrcvU(chatSrcvU);
	}

}
