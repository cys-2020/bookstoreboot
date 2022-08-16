package com.cys.boot.manager.impl;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cys.boot.dao.ChatDAO;

import com.cys.boot.entity.Chat;
import com.cys.boot.manager.ChatManager;
@Service
public class ChatManagerImp implements ChatManager{
	private ChatDAO dao;
	
	public ChatManagerImp(ChatDAO dao) {
		this.dao = dao;
	}
	@Transactional(rollbackFor=Exception.class,
		propagation=Propagation.SUPPORTS)
	public ArrayList<Chat> getChats(long userId, long targetUserid) {
		//
		return dao.getChats(userId, targetUserid);
	}
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertChat(Chat chat) {
		//
		dao.insertChat(chat);
	}
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateChat(Chat chat) {
		//
		dao.updateChat(chat);
	}
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteChat(Chat chat) {
		//
		dao.deleteChat(chat);
	}
	
	
	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public ArrayList<Long> getAllTargetUserIdInChat(long userId) {
		//
		return dao.getAllTargetUserIdInChat(userId);
	}
	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public String getLatestChatRecordInChat(long id) {
		//
		return dao.getLatestChatRecordInChat(id);
	}


	
}
