package com.cys.boot.manager.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.ChatUrcvSDAO;
import com.cys.boot.entity.ChatUrcvS;
import com.cys.boot.manager.ChatUrcvSManager;
@Service
public class ChatUrcvSManagerImpl implements ChatUrcvSManager {
	private ChatUrcvSDAO dao;
	
	public ChatUrcvSManagerImpl(ChatUrcvSDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<ChatUrcvS> getChatUrcvSs(long userId, long targetUserid) {
		//
		return dao.getChatUrcvSs(userId, targetUserid);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Long> getAllTargetUserIdInChatUrcvS(long userId) {
		//
		return dao.getAllTargetUserIdInChatUrcvS(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public String getLatestChatUrcvSRecordInChatUrcvS(long id) {
		//
		return dao.getLatestChatUrcvSRecordInChatUrcvS(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertChatUrcvS(ChatUrcvS chatUrcvS) {
		//
		dao.insertChatUrcvS(chatUrcvS);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateChatUrcvS(ChatUrcvS chatUrcvS) {
		//
		dao.updateChatUrcvS(chatUrcvS);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteChatUrcvS(ChatUrcvS chatUrcvS) {
		//
		dao.deleteChatUrcvS(chatUrcvS);
	}

}
