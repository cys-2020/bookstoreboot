package com.cys.boot.manager.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.ChatReceivedDAO;
import com.cys.boot.manager.ChatReceivedManager;

import com.cys.boot.entity.ChatReceived;
@Service
public class ChatReceivedManagerImp implements ChatReceivedManager {
	private ChatReceivedDAO dao;
	
	public ChatReceivedManagerImp(ChatReceivedDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<ChatReceived> getChatsReceived(long userId, long targetUserid) {
		//
		return dao.getChatsReceived(userId, targetUserid);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Long> getAllTargetUserIdInChatReceived(long userId) {
		//
		return dao.getAllTargetUserIdInChatReceived(userId);
	}


	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertChatReceived(ChatReceived chatRcv) {
		//
		dao.insertChatReceived(chatRcv);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateChatReceived(ChatReceived chatRcv) {
		//
		dao.updateChatReceived(chatRcv);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteChatReceived(ChatReceived chatRcv) {
		//
		dao.deleteChatReceived(chatRcv);
	}

	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public String getLatestChatRecordInChatReceived(long id) {
		//
		return dao.getLatestChatRecordInChatReceived(id);
	}

	
	
	
}
