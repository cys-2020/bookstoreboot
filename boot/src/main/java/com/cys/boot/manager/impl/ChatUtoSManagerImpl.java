package com.cys.boot.manager.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.ChatUtoSDAO;
import com.cys.boot.entity.ChatUtoS;
import com.cys.boot.manager.ChatUtoSManager;
@Service
public class ChatUtoSManagerImpl implements ChatUtoSManager{
	private ChatUtoSDAO dao;
	
	public ChatUtoSManagerImpl(ChatUtoSDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<ChatUtoS> getChatUtoSs(long userId, long targetUserid) {
		//
		return dao.getChatUtoSs(userId, targetUserid);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Long> getAllTargetUserIdInChatUtoS(long userId) {
		//
		return dao.getAllTargetUserIdInChatUtoS(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public String getLatestChatUtoSRecordInChatUtoS(long id) {
		//
		return dao.getLatestChatUtoSRecordInChatUtoS(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertChatUtoS(ChatUtoS chatUtoS) {
		//
		dao.insertChatUtoS(chatUtoS);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateChatUtoS(ChatUtoS chatUtoS) {
		//
		dao.updateChatUtoS(chatUtoS);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteChatUtoS(ChatUtoS chatUtoS) {
		//
		dao.deleteChatUtoS(chatUtoS);
	}

}
