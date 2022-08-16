package com.cys.boot.service.impl;
import java.util.ArrayList;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.cys.boot.manager.ChatManager;
import com.cys.boot.manager.ChatReceivedManager;
import com.cys.boot.manager.ChatSrcvUManager;
import com.cys.boot.manager.ChatStoUManager;
import com.cys.boot.manager.ChatUrcvSManager;
import com.cys.boot.manager.ChatUtoSManager;
import com.cys.boot.service.ChatService;
import com.cys.boot.service.CustomerServiceStaffService;
import com.cys.boot.service.StoreService;
import com.cys.boot.service.UserService;
import com.cys.boot.typeNeedHandle.ChatRecord;
import com.cys.boot.entity.Chat;
import com.cys.boot.entity.ChatReceived;
import com.cys.boot.entity.ChatSrcvU;
import com.cys.boot.entity.ChatStoU;
import com.cys.boot.entity.ChatUrcvS;
import com.cys.boot.entity.ChatUtoS;
import com.cys.boot.entity.Store;
import com.cys.boot.entity.User;
import com.cys.boot.utils.Convert;
import com.cys.boot.utils.Models;
@Service
public class ChatServiceImp implements ChatService {
	private ChatManager chatmanager;
	private ChatReceivedManager chatrcvmanager;
	private UserService userservice;
	private CustomerServiceStaffService cssservice;
	private StoreService storeservice;
	private ChatUtoSManager utosmanager;
	private ChatStoUManager stoumanager;
	private ChatUrcvSManager urcvsmanager;
	private ChatSrcvUManager srcvumanager;
	
	public ChatServiceImp(ChatManager chatmanager, ChatReceivedManager chatrcvmanager, UserService userservice,
			CustomerServiceStaffService cssservice, StoreService storeservice, ChatUtoSManager utosmanager,
			ChatStoUManager stoumanager, ChatUrcvSManager urcvsmanager, ChatSrcvUManager srcvumanager) {
		super();
		this.chatmanager = chatmanager;
		this.chatrcvmanager = chatrcvmanager;
		this.userservice = userservice;
		this.cssservice = cssservice;
		this.storeservice = storeservice;
		this.utosmanager = utosmanager;
		this.stoumanager = stoumanager;
		this.urcvsmanager = urcvsmanager;
		this.srcvumanager = srcvumanager;
	}
	
	private void updateChat(long userId, long targetUserid,
			ChatRecord cr) {
		Chat chat=new Chat();
		Object[] idandrindex=getUpdateRindexInChat(userId,targetUserid);
		if(idandrindex==null) {//can't update
			insertChat(userId,targetUserid,cr);
			return;
		}
		long availUpdateChatid=(long) idandrindex[0];
		chat.setId(availUpdateChatid);
		int rindex=(int) idandrindex[1];
		if(rindex==2) {
			chat.setR2(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==3) {
			chat.setR3(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==4) {
			chat.setR4(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==5) {
			chat.setR5(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==6) {
			chat.setR6(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==7) {
			chat.setR7(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==8) {
			chat.setR8(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==9) {
			chat.setR9(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==10) {
			chat.setR10(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==11) {
			chat.setR11(cr);
			chatmanager.updateChat(chat);
			return;
		}
		if(rindex==12) {
			chat.setR12(cr);
			chatmanager.updateChat(chat);
			return;
		}
	}
	private void updateUtoSChat(long userId, long targetStoreid,
			ChatRecord cr) {
		ChatUtoS chat=new ChatUtoS();
		Object[] idandrindex=getUpdateRindexInUtoSChat(userId,targetStoreid);
		if(idandrindex==null) {//can't update
			insertUtoSChat(userId,targetStoreid,cr);
			return;
		}
		long availUpdateChatid=(long) idandrindex[0];
		chat.setId(availUpdateChatid);
		int rindex=(int) idandrindex[1];
		if(rindex==2) {
			chat.setR2(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==3) {
			chat.setR3(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==4) {
			chat.setR4(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==5) {
			chat.setR5(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==6) {
			chat.setR6(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==7) {
			chat.setR7(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==8) {
			chat.setR8(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==9) {
			chat.setR9(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==10) {
			chat.setR10(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==11) {
			chat.setR11(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
		if(rindex==12) {
			chat.setR12(cr);
			utosmanager.updateChatUtoS(chat);
			return;
		}
	}
	private void updateStoUChat(long storeId, long targetUserid,
			ChatRecord cr) {
		ChatStoU chat=new ChatStoU();
		Object[] idandrindex=this.getUpdateRindexInStoUChat(storeId, targetUserid);
		if(idandrindex==null) {//can't update
			insertStoUChat(storeId,targetUserid,cr);
			return;
		}
		long availUpdateChatid=(long) idandrindex[0];
		chat.setId(availUpdateChatid);
		int rindex=(int) idandrindex[1];
		if(rindex==2) {
			chat.setR2(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==3) {
			chat.setR3(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==4) {
			chat.setR4(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==5) {
			chat.setR5(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==6) {
			chat.setR6(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==7) {
			chat.setR7(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==8) {
			chat.setR8(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==9) {
			chat.setR9(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==10) {
			chat.setR10(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==11) {
			chat.setR11(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
		if(rindex==12) {
			chat.setR12(cr);
			stoumanager.updateChatStoU(chat);
			return;
		}
	}
	
	private void updateChatReceived(long userId, 
			long targetUserid,ChatRecord cr) {
		ChatReceived chatRcv=new ChatReceived();
		Object[] idandrindex=getUpdateRindexInChatReceived(userId,targetUserid);
		if(idandrindex==null) {//can't update
			insertChatReceived(userId, targetUserid, cr);
			return;
		}
		long availUpdateChatReceivedid=(long) idandrindex[0];
		chatRcv.setId(availUpdateChatReceivedid);
		int rindex=(int) idandrindex[1];
		if(rindex==2) {
			chatRcv.setR2(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==3) {
			chatRcv.setR3(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==4) {
			chatRcv.setR4(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==5) {
			chatRcv.setR5(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==6) {
			chatRcv.setR6(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==7) {
			chatRcv.setR7(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==8) {
			chatRcv.setR8(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==9) {
			chatRcv.setR9(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==10) {
			chatRcv.setR10(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==11) {
			chatRcv.setR11(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
		if(rindex==12) {
			chatRcv.setR12(cr);
			chatrcvmanager.updateChatReceived(chatRcv);
			return;
		}
	}
	
	private void updateUrcvSChat(long userId, 
			long targetStoreid,ChatRecord cr) {
		ChatUrcvS chatRcv=new ChatUrcvS();
		Object[] idandrindex=getUpdateRindexInUrcvSChat(userId,targetStoreid);
		if(idandrindex==null) {//can't update
			insertUrcvSChat(userId, targetStoreid, cr);
			return;
		}
		long availUpdateChatReceivedid=(long) idandrindex[0];
		chatRcv.setId(availUpdateChatReceivedid);
		int rindex=(int) idandrindex[1];
		if(rindex==2) {
			chatRcv.setR2(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==3) {
			chatRcv.setR3(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==4) {
			chatRcv.setR4(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==5) {
			chatRcv.setR5(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==6) {
			chatRcv.setR6(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==7) {
			chatRcv.setR7(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==8) {
			chatRcv.setR8(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==9) {
			chatRcv.setR9(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==10) {
			chatRcv.setR10(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==11) {
			chatRcv.setR11(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
		if(rindex==12) {
			chatRcv.setR12(cr);
			urcvsmanager.updateChatUrcvS(chatRcv);
			return;
		}
	}
	
	private void updateSrcvUChat(long storeId, long userId, ChatRecord cr) {
		//
		ChatSrcvU chat=new ChatSrcvU();
		Object[] idandrindex=this.getUpdateRindexInSrcvUChat(storeId, userId);
		if(idandrindex==null) {//can't update
			this.insertSrcvUChat(storeId, userId, cr);
			return;
		}
		long availUpdateChatReceivedid=(long) idandrindex[0];
		chat.setId(availUpdateChatReceivedid);
		int rindex=(int) idandrindex[1];
		if(rindex==2) {
			chat.setR2(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==3) {
			chat.setR3(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==4) {
			chat.setR4(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==5) {
			chat.setR5(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==6) {
			chat.setR6(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==7) {
			chat.setR7(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==8) {
			chat.setR8(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==9) {
			chat.setR9(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==10) {
			chat.setR10(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==11) {
			chat.setR11(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
		if(rindex==12) {
			chat.setR12(cr);
			srcvumanager.updateChatSrcvU(chat);
			return;
		}
	}
	
	/**
	 * get avail-update Chat id and CR index.(in t_chat)
	 * @param userId
	 * @param targetUserid
	 * @return [0]avail-update chat id, [1] index CR will be set
	 */
	private Object[] getUpdateRindexInChat(long userId,long targetUserid) {
		Object[] idandrindex=new Object[2];
		ArrayList<Chat> chats=chatmanager.getChats(userId, targetUserid);
		int size=chats.size();
		/*
		no index can update in the chat, 
		need to insert a new chat.
		*/
		if(size==0||chats.get(size-1).getR12()!=null) 
			return null;
		else {
			Chat chat=chats.get(size-1);
			idandrindex[0]=chat.getId();
			int rindex=0;
			if(chat.getR2()==null) {
				rindex=2;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			if(chat.getR3()==null) {
				rindex=3;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR4()==null) {
				rindex=4;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR5()==null) {
				rindex=5;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR6()==null) {
				rindex=6;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR7()==null) {
				rindex=7;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR8()==null) {
				rindex=8;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR9()==null) {
				rindex=9;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR10()==null) {
				rindex=10;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR11()==null){
				rindex=11;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			else{
				rindex=12;
				idandrindex[1]=rindex;
				return idandrindex;
			}
		}	
	}
	private Object[] getUpdateRindexInUtoSChat(long userId, long targetStoreid) {
		//
		Object[] idandrindex=new Object[2];
		ArrayList<ChatUtoS> chats=utosmanager.getChatUtoSs(userId, targetStoreid);
		int size=chats.size();
		/*
		no index can update in the chat, 
		need to insert a new chat.
		*/
		if(size==0||chats.get(size-1).getR12()!=null) 
			return null;
		else {
			ChatUtoS chat=chats.get(size-1);
			idandrindex[0]=chat.getId();
			int rindex=0;
			if(chat.getR2()==null) {
				rindex=2;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			if(chat.getR3()==null) {
				rindex=3;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR4()==null) {
				rindex=4;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR5()==null) {
				rindex=5;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR6()==null) {
				rindex=6;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR7()==null) {
				rindex=7;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR8()==null) {
				rindex=8;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR9()==null) {
				rindex=9;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR10()==null) {
				rindex=10;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR11()==null){
				rindex=11;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			else{
				rindex=12;
				idandrindex[1]=rindex;
				return idandrindex;
			}
		}	
	}
	private Object[] getUpdateRindexInStoUChat(long storeId, long targetUserId) {
		//
		Object[] idandrindex=new Object[2];
		ArrayList<ChatStoU> chats=stoumanager.getChatStoUs(storeId, targetUserId);
		int size=chats.size();
		/*
		no index can update in the chat, 
		need to insert a new chat.
		*/
		if(size==0||chats.get(size-1).getR12()!=null) 
			return null;
		else {
			ChatStoU chat=chats.get(size-1);
			idandrindex[0]=chat.getId();
			int rindex=0;
			if(chat.getR2()==null) {
				rindex=2;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			if(chat.getR3()==null) {
				rindex=3;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR4()==null) {
				rindex=4;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR5()==null) {
				rindex=5;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR6()==null) {
				rindex=6;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR7()==null) {
				rindex=7;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR8()==null) {
				rindex=8;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR9()==null) {
				rindex=9;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR10()==null) {
				rindex=10;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR11()==null){
				rindex=11;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			else{
				rindex=12;
				idandrindex[1]=rindex;
				return idandrindex;
			}
		}	
	}
	private Object[] getUpdateRindexInChatReceived(long userId,long targetUserid) {
		Object[] idandrindex=new Object[2];
		ArrayList<ChatReceived> chats=chatrcvmanager.getChatsReceived(userId, targetUserid);
		int size=chats.size();
		/*
		no index can update in the chat, 
		need to insert a new chat.
		*/
		if(size==0||chats.get(size-1).getR12()!=null) 
			return null;
		else {
			ChatReceived chat=chats.get(size-1);
			idandrindex[0]=chat.getId();
			int rindex=0;
			if(chat.getR2()==null) {
				rindex=2;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			if(chat.getR3()==null) {
				rindex=3;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR4()==null) {
				rindex=4;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR5()==null) {
				rindex=5;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR6()==null) {
				rindex=6;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR7()==null) {
				rindex=7;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR8()==null) {
				rindex=8;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR9()==null) {
				rindex=9;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR10()==null) {
				rindex=10;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR11()==null){
				rindex=11;
				idandrindex[1]=rindex;
				return idandrindex;
			}else{
				rindex=12;
				idandrindex[1]=rindex;
				return idandrindex;
			}
		}	
	}
	private Object[] getUpdateRindexInUrcvSChat(long userId,long targetStoreid) {
		Object[] idandrindex=new Object[2];
		ArrayList<ChatUrcvS> chats=urcvsmanager.getChatUrcvSs(userId, targetStoreid);
		int size=chats.size();
		/*
		no index can update in the chat, 
		need to insert a new chat.
		*/
		if(size==0||chats.get(size-1).getR12()!=null) 
			return null;
		else {
			ChatUrcvS chat=chats.get(size-1);
			idandrindex[0]=chat.getId();
			int rindex=0;
			if(chat.getR2()==null) {
				rindex=2;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			if(chat.getR3()==null) {
				rindex=3;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR4()==null) {
				rindex=4;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR5()==null) {
				rindex=5;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR6()==null) {
				rindex=6;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR7()==null) {
				rindex=7;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR8()==null) {
				rindex=8;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR9()==null) {
				rindex=9;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR10()==null) {
				rindex=10;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR11()==null){
				rindex=11;
				idandrindex[1]=rindex;
				return idandrindex;
			}else{
				rindex=12;
				idandrindex[1]=rindex;
				return idandrindex;
			}
		}	
	}
	private Object[] getUpdateRindexInSrcvUChat(long storeId,long targetUserid) {
		Object[] idandrindex=new Object[2];
		ArrayList<ChatSrcvU> chats=srcvumanager.getChatSrcvUs(storeId, targetUserid);
		int size=chats.size();
		/*
		no index can update in the chat, 
		need to insert a new chat.
		*/
		if(size==0||chats.get(size-1).getR12()!=null) 
			return null;
		else {
			ChatSrcvU chat=chats.get(size-1);
			idandrindex[0]=chat.getId();
			int rindex=0;
			if(chat.getR2()==null) {
				rindex=2;
				idandrindex[1]=rindex;
				return idandrindex;
			}
			if(chat.getR3()==null) {
				rindex=3;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR4()==null) {
				rindex=4;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR5()==null) {
				rindex=5;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR6()==null) {
				rindex=6;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR7()==null) {
				rindex=7;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR8()==null) {
				rindex=8;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR9()==null) {
				rindex=9;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR10()==null) {
				rindex=10;
				idandrindex[1]=rindex;
				return idandrindex;
			}if(chat.getR11()==null){
				rindex=11;
				idandrindex[1]=rindex;
				return idandrindex;
			}else{
				rindex=12;
				idandrindex[1]=rindex;
				return idandrindex;
			}
		}	
	}
	/**
	 * exe insert if chat cant be update
	 * @param userId
	 * @param targetUserid
	 * @param r1 new row must has first chatRecord
	 */
	private void insertChat(long userId,long targetUserid,ChatRecord r1) {
		Chat inserted=new Chat();
		inserted.setUserId(userId);
		inserted.setTargetUserid(targetUserid);
		inserted.setR1(r1);
		chatmanager.insertChat(inserted);
	}
	private void insertUtoSChat(long userId, long targetStoreid, ChatRecord cr) {
		//
		ChatUtoS chat=new ChatUtoS();
		chat.setUserId(userId);
		chat.setStoreId(targetStoreid);
		chat.setR1(cr);
		utosmanager.insertChatUtoS(chat);
	}
	private void insertStoUChat(long storeId, long targetUserid, ChatRecord cr) {
		//
		ChatStoU chat=new ChatStoU();
		chat.setUserId(targetUserid);
		chat.setStoreId(storeId);
		chat.setR1(cr);
		stoumanager.insertChatStoU(chat);
	}
	private void insertChatReceived(long userId,long targetUserid,ChatRecord r1) {
		ChatReceived inserted=new ChatReceived();
		inserted.setUserId(userId);
		inserted.setTargetUserid(targetUserid);
		inserted.setR1(r1);
		chatrcvmanager.insertChatReceived(inserted);
	}
	private void insertUrcvSChat(long userId, long storeId, ChatRecord cr) {
		//
		ChatUrcvS chat=new ChatUrcvS();
		chat.setUserId(userId);
		chat.setStoreId(storeId);
		chat.setR1(cr);
		urcvsmanager.insertChatUrcvS(chat);
	}
	private void insertSrcvUChat(long storeId,long userId,ChatRecord r1) {
		ChatSrcvU chat=new ChatSrcvU();
		chat.setUserId(userId);
		chat.setStoreId(storeId);
		chat.setR1(r1);
		srcvumanager.insertChatSrcvU(chat);
	}
	
	@Override
	public String getAllTargetUsersAndLatestOneMessage(
			HttpServletRequest hsr) {
		//
		Models model=new Models();
		Convert conv=new Convert();
		HashMap<String, ArrayList<Object>> result=new HashMap<>();
		ArrayList<Object> targetUsers=new ArrayList<>(),
				crs=new ArrayList<>();
		long userId=((User)hsr.getSession().getAttribute("user"))
				.getId();
		ArrayList<Long> targetsInchat=
				chatmanager.getAllTargetUserIdInChat(userId),
				targetsInchatReceived=
				chatrcvmanager.getAllTargetUserIdInChatReceived(userId);
		int len2=targetsInchat.size();
		//list1 add list2 no repeat
		for(int i=0;i<len2;i++) {
			long oneTarget=targetsInchatReceived.get(i);
			if(!targetsInchat.contains(oneTarget))
				targetsInchat.add(oneTarget);
		}
		//targetsInchat has all targetUserid
		targetsInchat.forEach(v->{
			//get all chats, then get latest chat id
			User targetUser=userservice.getUser(v);
			targetUsers.add(targetUser);
			ArrayList<Chat> chatsSent= 
					chatmanager.getChats(userId, v);
			ArrayList<ChatReceived> chatsReceived=
					chatrcvmanager.getChatsReceived(userId, v);
			long latestChatId=
					chatsSent.get(chatsSent.size()-1).getId();
			long latestChatReceivedId=
					chatsReceived.get(chatsReceived.size()-1).getId();
			ChatRecord cr1=conv.toChatRecordFromString(
				latestChatId, chatmanager
						.getLatestChatRecordInChat(latestChatId))
				,cr2=conv.toChatRecordFromString(
						latestChatReceivedId,chatrcvmanager
							.getLatestChatRecordInChatReceived(
								latestChatReceivedId));
			//the latest message is sent? or received?
			if(cr1.getChatTime().after(cr2.getChatTime())) 
				crs.add(cr1);
			else
				crs.add(cr2);
		});
		result.put("targetUsers", targetUsers);
		result.put("crs", crs);
		System.err.println("getAllTargetUsersAndLastestOneMessage==>"+
				model.getJsonStringFromObject(result));
		return model.getJsonStringFromObject(result);
	}
	@Override
	public String getAllTargetStoresAndLatestOneMessage(
			HttpServletRequest hsr) {
		//
		Models model=new Models();
		Convert conv=new Convert();
		HashMap<String, ArrayList<Object>> result=new HashMap<>();
		ArrayList<Object> targetStoreNames=new ArrayList<>(),
				crs=new ArrayList<>();
		long userId=((User)hsr.getSession().getAttribute("user"))
				.getId();
		ArrayList<Long> targetStoreidsInUtoS=
				utosmanager.getAllTargetUserIdInChatUtoS(userId),
				targetStoreidsInUrcvS=
				urcvsmanager.getAllTargetUserIdInChatUrcvS(userId);
		int len1=targetStoreidsInUtoS.size();
		int len2=targetStoreidsInUrcvS.size();
		//no chats, return empty map
		if(len1+len2==0) 
			return model.getJsonStringFromObject(result);
		//list1 add list2 no repeat
		for(int i=0;i<len2;i++) {
			long oneTarget=targetStoreidsInUrcvS.get(i);
			if(!targetStoreidsInUtoS.contains(oneTarget))
				targetStoreidsInUtoS.add(oneTarget);
		}
		//targetsInUtoS has all targetStores' id
		targetStoreidsInUtoS.forEach(v->{
			String storename=storeservice.getStoreName(v);
			targetStoreNames.add(storename);
			ArrayList<ChatUtoS> chatsSent= 
					utosmanager.getChatUtoSs(userId, v);
			ArrayList<ChatUrcvS> chatsReceived=
					urcvsmanager.getChatUrcvSs(userId, v);
			long latestUtoSChatId=0,
					latestUrcvSChatId=0;
			ChatRecord cr1=null,cr2=null;
			int chatsSentLen=chatsSent.size(),
					chatsRcvLen=chatsReceived.size();
			if(chatsSentLen!=0&&chatsRcvLen!=0) {
				latestUtoSChatId=chatsSent.get(chatsSentLen-1).getId();
				latestUrcvSChatId=chatsReceived.get(chatsRcvLen-1).getId();
				cr1=conv.toChatRecordFromString(
						latestUtoSChatId, utosmanager.getLatestChatUtoSRecordInChatUtoS(latestUtoSChatId));
				cr2=conv.toChatRecordFromString(
						latestUrcvSChatId,urcvsmanager.getLatestChatUrcvSRecordInChatUrcvS(latestUrcvSChatId));
				//the latest message is sent? or received?
				if(cr1.getChatTime().after(cr2.getChatTime())) 
					crs.add(cr1);
				else
					crs.add(cr2);
			}else {
				if(chatsSentLen==0) {
					//only urcvs chats
					latestUrcvSChatId=chatsReceived.get(chatsRcvLen-1).getId();
					cr2=conv.toChatRecordFromString(
							latestUrcvSChatId,urcvsmanager.getLatestChatUrcvSRecordInChatUrcvS(latestUrcvSChatId));
					crs.add(cr2);
				}else {
					//only utos chats
					latestUtoSChatId=chatsSent.get(chatsSentLen-1).getId();
					cr1=conv.toChatRecordFromString(
							latestUtoSChatId, utosmanager.getLatestChatUtoSRecordInChatUtoS(latestUtoSChatId));
					crs.add(cr1);
				}
			}
		});
		result.put("targetStoreNames", targetStoreNames);
		result.put("crs", crs);
		System.err.println("getAllTargetStoresAndLatestOneMessage==>"+
				model.getJsonStringFromObject(result));
		return model.getJsonStringFromObject(result);
	}
	
	
	
	
	
	
	@Override
	public String getSentAndReceivedChatRecordListAboutTargetUser(
			HttpServletRequest hsr, long targetUserid) {
		Models m=new Models();
		//get all cr
		ArrayList<ChatRecord> crsent=
				this.getSentChatRecordListAboutTargetUser(hsr, targetUserid)
											,crrcv=
				this.getReceivedChatRecordListAboutTargetUser(hsr, targetUserid);
		//compare time, from late to early
		crsent.addAll(crrcv);
		ArrayList<ChatRecord> all=crsent;
		all.sort((a,b)->{
			return b.getChatTime().compareTo(a.getChatTime());
		});
		System.err.println("getSentAndReceivedChatRecordListAboutTargetUser==>"+all);
		return m.getJsonStringFromObject(all);
	}
	@Override
	public String getSentAndReceivedChatRecordListAboutTargetStore(
			HttpServletRequest hsr, long targetStoreid) {
		//
		Models m=new Models();
		//get all cr
		ArrayList<ChatRecord> crsent=
				this.getSentChatRecordListAboutTargetStore(hsr, targetStoreid)
											,crrcv=
				this.getReceivedChatRecordListAboutTargetStore(hsr, targetStoreid);
		//compare time, from late to early
		crsent.addAll(crrcv);
		ArrayList<ChatRecord> all=crsent;
		all.sort((a,b)->{
			return b.getChatTime().compareTo(a.getChatTime());
		});
		System.err.println("getSentAndReceivedChatRecordListAboutTargetStore==>"+all);
		return m.getJsonStringFromObject(all);
	}
	
	
	
	
	
	
	@Override
	public ArrayList<ChatRecord> getReceivedChatRecordListAboutTargetUser(
			HttpServletRequest hsr, long targetUserid) {
		//sender is target user
		User sender=userservice.getUser(targetUserid);
		long userId=((User)hsr.getSession().getAttribute("user")).getId();
		ArrayList<ChatRecord> list=new ArrayList<>();
		ArrayList<ChatReceived> chats=chatrcvmanager.getChatsReceived(userId,targetUserid);
		int size=chats.size();
		ChatReceived chat=null;
		long id=0;
		//multi chat rows between two users
		for(int i=0;i<size;i++) {
			chat=chats.get(i);
			id=chat.getId();
			if(i!=size-1) {//full(12CR) in chat
				ChatRecord r1=chat.getR1(),r2=chat.getR2(),r3=chat.getR3(),r4=chat.getR4(),r5=chat.getR5(),r6=chat.getR6(),r7=chat.getR7(),r8=chat.getR8(),r9=chat.getR9(),r10=chat.getR10(),r11=chat.getR11(),r12=chat.getR12();
				r1.setSender(sender);
				list.add(r1);
				r2.setSender(sender);
				list.add(r2);
				r3.setSender(sender);
				list.add(r3);
				r4.setSender(sender);
				list.add(r4);
				r5.setSender(sender);
				list.add(r5);
				r6.setSender(sender);
				list.add(r6);
				r7.setSender(sender);
				list.add(r7);
				r8.setSender(sender);
				list.add(r8);
				r9.setSender(sender);
				list.add(r9);
				r10.setSender(sender);
				list.add(r10);
				r11.setSender(sender);
				list.add(r11);
				r12.setSender(sender);
				list.add(r12);
			}else {//may be CR="" in this latest chat
				//r1 is exist
				ChatRecord r1=chat.getR1(),r2=null,r3=null,r4=null,r5=null,r6=null,r7=null,r8=null,r9=null,r10=null,r11=null,r12=null;
				r1.setSender(sender);
				list.add(r1);
				r2=chat.getR2();
				//if rn!="", add into list
				if(r2!=null) {
					r2.setSender(sender);
					list.add(r2);
					r3=chat.getR3();
				}else
					return list;
				if(r3!=null) {
					r3.setSender(sender);
					list.add(r3);
					r4=chat.getR4();
				}else
					return list;
				if(r4!=null) {
					r4.setSender(sender);
					list.add(r4);
					r5=chat.getR5();
				}else
					return list;
				if(r5!=null) {
					r5.setSender(sender);
					list.add(r5);
					r6=chat.getR6();
				}else
					return list;
				if(r6!=null) {
					r6.setSender(sender);
					list.add(r6);
					r7=chat.getR7();
				}else
					return list;
				if(r7!=null) {
					r7.setSender(sender);
					list.add(r7);
					r8=chat.getR8();
				}else
					return list;
				if(r8!=null) {
					r8.setSender(sender);
					list.add(r8);
					r9=chat.getR9();
				}else
					return list;
				if(r9!=null) {
					r9.setSender(sender);
					list.add(r9);
					r10=chat.getR10();
				}else
					return list;
				if(r10!=null) {
					r10.setSender(sender);
					list.add(r10);
					r11=chat.getR11();
				}else
					return list;
				if(r11!=null) {
					r11.setSender(sender);
					list.add(r11);
					r12=chat.getR12();
				}else
					return list;
				if(r12!=null) {
					r12.setSender(sender);
					list.add(r12);
				}
			}
		}
		System.err.println("getReceivedChatRecordListAboutTargetUser==>"+list);
		return list;
	}
	@Override
	public ArrayList<ChatRecord> getReceivedChatRecordListAboutTargetStore
		(HttpServletRequest hsr, long targetStoreid) {
			//sender is target store
				Store sender=storeservice.getStore(targetStoreid);
				long userId=((User)hsr.getSession().getAttribute("user")).getId();
				ArrayList<ChatRecord> list=new ArrayList<>();
				ArrayList<ChatUrcvS> chats=urcvsmanager.getChatUrcvSs(userId, sender.getId());
				int size=chats.size();
				ChatUrcvS chat=null;
				long id=0;
				//multi chat rows between two users
				for(int i=0;i<size;i++) {
					chat=chats.get(i);
					id=chat.getId();
					if(i!=size-1) {//full(12CR) in chat
						ChatRecord r1=chat.getR1(),r2=chat.getR2(),r3=chat.getR3(),r4=chat.getR4(),r5=chat.getR5(),r6=chat.getR6(),r7=chat.getR7(),r8=chat.getR8(),r9=chat.getR9(),r10=chat.getR10(),r11=chat.getR11(),r12=chat.getR12();
						r1.setSender(sender);
						list.add(r1);
						r2.setSender(sender);
						list.add(r2);
						r3.setSender(sender);
						list.add(r3);
						r4.setSender(sender);
						list.add(r4);
						r5.setSender(sender);
						list.add(r5);
						r6.setSender(sender);
						list.add(r6);
						r7.setSender(sender);
						list.add(r7);
						r8.setSender(sender);
						list.add(r8);
						r9.setSender(sender);
						list.add(r9);
						r10.setSender(sender);
						list.add(r10);
						r11.setSender(sender);
						list.add(r11);
						r12.setSender(sender);
						list.add(r12);
					}else {//may be CR="" in this latest chat
						//r1 is exist
						ChatRecord r1=chat.getR1(),r2=null,r3=null,r4=null,r5=null,r6=null,r7=null,r8=null,r9=null,r10=null,r11=null,r12=null;
						r1.setSender(sender);
						list.add(r1);
						r2=chat.getR2();
						//if rn!="", add into list
						if(r2!=null) {
							r2.setSender(sender);
							list.add(r2);
							r3=chat.getR3();
						}else
							return list;
						if(r3!=null) {
							r3.setSender(sender);
							list.add(r3);
							r4=chat.getR4();
						}else
							return list;
						if(r4!=null) {
							r4.setSender(sender);
							list.add(r4);
							r5=chat.getR5();
						}else
							return list;
						if(r5!=null) {
							r5.setSender(sender);
							list.add(r5);
							r6=chat.getR6();
						}else
							return list;
						if(r6!=null) {
							r6.setSender(sender);
							list.add(r6);
							r7=chat.getR7();
						}else
							return list;
						if(r7!=null) {
							r7.setSender(sender);
							list.add(r7);
							r8=chat.getR8();
						}else
							return list;
						if(r8!=null) {
							r8.setSender(sender);
							list.add(r8);
							r9=chat.getR9();
						}else
							return list;
						if(r9!=null) {
							r9.setSender(sender);
							list.add(r9);
							r10=chat.getR10();
						}else
							return list;
						if(r10!=null) {
							r10.setSender(sender);
							list.add(r10);
							r11=chat.getR11();
						}else
							return list;
						if(r11!=null) {
							r11.setSender(sender);
							list.add(r11);
							r12=chat.getR12();
						}else
							return list;
						if(r12!=null) {
							r12.setSender(sender);
							list.add(r12);
						}
					}
				}
				System.err.println("getReceivedChatRecordListAboutTargetStore==>"+list);
				return list;
		
	}
	
	
	
	
	
	
	
	@Override
	public ArrayList<ChatRecord> getSentChatRecordListAboutTargetUser
			(HttpServletRequest hsr, long targetUserid) {
		User sender=(User)hsr.getSession().getAttribute("user");
		long userId=sender.getId();
		ArrayList<ChatRecord> list=new ArrayList<>();
		ArrayList<Chat> chats=chatmanager.getChats(userId,targetUserid);
		int size=chats.size();
		Chat chat=null;
		long id=0;
		//multi chat rows between two users
		for(int i=0;i<size;i++) {
			chat=chats.get(i);
			id=chat.getId();
			if(i!=size-1) {//full(12CR) in chat
				ChatRecord r1=chat.getR1(),r2=chat.getR2(),r3=chat.getR3(),r4=chat.getR4(),r5=chat.getR5(),r6=chat.getR6(),r7=chat.getR7(),r8=chat.getR8(),r9=chat.getR9(),r10=chat.getR10(),r11=chat.getR11(),r12=chat.getR12();
				r1.setSender(sender);
				list.add(r1);
				r2.setSender(sender);
				list.add(r2);
				r3.setSender(sender);
				list.add(r3);
				r4.setSender(sender);
				list.add(r4);
				r5.setSender(sender);
				list.add(r5);
				r6.setSender(sender);
				list.add(r6);
				r7.setSender(sender);
				list.add(r7);
				r8.setSender(sender);
				list.add(r8);
				r9.setSender(sender);
				list.add(r9);
				r10.setSender(sender);
				list.add(r10);
				r11.setSender(sender);
				list.add(r11);
				r12.setSender(sender);
				list.add(r12);
			}else {//may be CR="" in this latest chat
				//r1 is exist
				ChatRecord r1=chat.getR1(),r2=null,r3=null,r4=null,r5=null,r6=null,r7=null,r8=null,r9=null,r10=null,r11=null,r12=null;
				r1.setSender(sender);
				list.add(r1);
				r2=chat.getR2();
				//if rn!="", add into list
				if(r2!=null) {
					r2.setSender(sender);
					list.add(r2);
					r3=chat.getR3();
				}else
					return list;
				if(r3!=null) {
					r3.setSender(sender);
					list.add(r3);
					r4=chat.getR4();
				}else
					return list;
				if(r4!=null) {
					r4.setSender(sender);
					list.add(r4);
					r5=chat.getR5();
				}else
					return list;
				if(r5!=null) {
					r5.setSender(sender);
					list.add(r5);
					r6=chat.getR6();
				}else
					return list;
				if(r6!=null) {
					r6.setSender(sender);
					list.add(r6);
					r7=chat.getR7();
				}else
					return list;
				if(r7!=null) {
					r7.setSender(sender);
					list.add(r7);
					r8=chat.getR8();
				}else
					return list;
				if(r8!=null) {
					r8.setSender(sender);
					list.add(r8);
					r9=chat.getR9();
				}else
					return list;
				if(r9!=null) {
					r9.setSender(sender);
					list.add(r9);
					r10=chat.getR10();
				}else
					return list;
				if(r10!=null) {
					r10.setSender(sender);
					list.add(r10);
					r11=chat.getR11();
				}else
					return list;
				if(r11!=null) {
					r11.setSender(sender);
					list.add(r11);
					r12=chat.getR12();
				}else
					return list;
				if(r12!=null) {
					r12.setSender(sender);
					list.add(r12);
				}
			}
		}
		return list;
	}
	@Override
	public ArrayList<ChatRecord> getSentChatRecordListAboutTargetStore
	(HttpServletRequest hsr, long targetStoreid) {
		//
		User sender=(User)hsr.getSession().getAttribute("user");
		long userId=sender.getId();
		Convert conv=new Convert();
		ArrayList<ChatRecord> list=new ArrayList<>();
		ArrayList<ChatUtoS> chats=utosmanager.getChatUtoSs(userId, targetStoreid);
		int size=chats.size();
		ChatUtoS chat=null;
		long id=0;
		//multi chat rows between two users
		for(int i=0;i<size;i++) {
			chat=chats.get(i);
			id=chat.getId();
			if(i!=size-1) {//full(12CR) in chat
				ChatRecord r1=chat.getR1(),r2=chat.getR2(),r3=chat.getR3(),r4=chat.getR4(),r5=chat.getR5(),r6=chat.getR6(),r7=chat.getR7(),r8=chat.getR8(),r9=chat.getR9(),r10=chat.getR10(),r11=chat.getR11(),r12=chat.getR12();
				r1.setSender(sender);
				list.add(r1);
				r2.setSender(sender);
				list.add(r2);
				r3.setSender(sender);
				list.add(r3);
				r4.setSender(sender);
				list.add(r4);
				r5.setSender(sender);
				list.add(r5);
				r6.setSender(sender);
				list.add(r6);
				r7.setSender(sender);
				list.add(r7);
				r8.setSender(sender);
				list.add(r8);
				r9.setSender(sender);
				list.add(r9);
				r10.setSender(sender);
				list.add(r10);
				r11.setSender(sender);
				list.add(r11);
				r12.setSender(sender);
				list.add(r12);
			}else {//may be CR="" in this latest chat
				//r1 is exist
				ChatRecord r1=chat.getR1(),r2=null,r3=null,r4=null,r5=null,r6=null,r7=null,r8=null,r9=null,r10=null,r11=null,r12=null;
				r1.setSender(sender);
				list.add(r1);
				r2=chat.getR2();
				//if rn!="", add into list
				if(r2!=null) {
					r2.setSender(sender);
					list.add(r2);
					r3=chat.getR3();
				}else
					return list;
				if(r3!=null) {
					r3.setSender(sender);
					list.add(r3);
					r4=chat.getR4();
				}else
					return list;
				if(r4!=null) {
					r4.setSender(sender);
					list.add(r4);
					r5=chat.getR5();
				}else
					return list;
				if(r5!=null) {
					r5.setSender(sender);
					list.add(r5);
					r6=chat.getR6();
				}else
					return list;
				if(r6!=null) {
					r6.setSender(sender);
					list.add(r6);
					r7=chat.getR7();
				}else
					return list;
				if(r7!=null) {
					r7.setSender(sender);
					list.add(r7);
					r8=chat.getR8();
				}else
					return list;
				if(r8!=null) {
					r8.setSender(sender);
					list.add(r8);
					r9=chat.getR9();
				}else
					return list;
				if(r9!=null) {
					r9.setSender(sender);
					list.add(r9);
					r10=chat.getR10();
				}else
					return list;
				if(r10!=null) {
					r10.setSender(sender);
					list.add(r10);
					r11=chat.getR11();
				}else
					return list;
				if(r11!=null) {
					r11.setSender(sender);
					list.add(r11);
					r12=chat.getR12();
				}else
					return list;
				if(r12!=null) {
					r12.setSender(sender);
					list.add(r12);
				}
			}
		}
		return list;
	}

	
	
	
	
	
	
	@Override
	public void chatToUser(
			HttpServletRequest hsr,long targetUserid,ChatRecord cr){
		//
		long userId=((User)hsr.getSession().getAttribute("user")).getId();
		cr.setDeletedFlag(0);
		cr.setReadFlag(0);
		//into mysql dosen't need sender
		this.updateChat(userId, targetUserid, cr);
		this.updateChatReceived(targetUserid,userId, cr);
	}
	@Override
	public void chatToStore(
			HttpServletRequest hsr,long targetStoreid,ChatRecord cr) {
		long userId=((User)hsr.getSession().getAttribute("user")).getId();
		cr.setDeletedFlag(0);
		cr.setReadFlag(0);
		System.err.println("chatToStore: CR===>"+cr);
		this.updateUtoSChat(userId, targetStoreid, cr);
		this.updateSrcvUChat(targetStoreid, userId, cr);
	}

	
	
	
	
	
	

	@Override
	public void cleanChatAboutTargetUser(
			HttpServletRequest hsr,long targetUserid) {
		long userId=(long) hsr.getSession().getAttribute("userId");
		Chat chat=new Chat();
		ChatReceived chatrcv=new ChatReceived();
		chat.setUserId(userId);
		chat.setTargetUserid(targetUserid);
		chatrcv.setUserId(userId);
		chatrcv.setTargetUserid(targetUserid);
		chatmanager.deleteChat(chat);
		chatrcvmanager.deleteChatReceived(chatrcv);
	}
	@Override
	public void cleanChatAboutTargetStore(
			HttpServletRequest hsr, long targetStoreid) {
		//
		long userId=(long) hsr.getSession().getAttribute("userId");
		ChatUtoS utoschat=new ChatUtoS();
		ChatUrcvS urcvs=new ChatUrcvS();
		utoschat.setUserId(userId);
		utoschat.setStoreId(targetStoreid);
		urcvs.setUserId(userId);
		urcvs.setStoreId(targetStoreid);
		utosmanager.deleteChatUtoS(utoschat);
		urcvsmanager.deleteChatUrcvS(urcvs);
	}

	

	@Override
	public String getAllTargetUsersAndLatestOneMessageInOneStore(
			long storeId) {
		Models model=new Models();
		Convert conv=new Convert();
		HashMap<String, ArrayList<Object>> result=new HashMap<>();
		ArrayList<Object> targetUsers=new ArrayList<>(),
				crs=new ArrayList<>();
		ArrayList<Long> targetUseridsInStoU=
			stoumanager.getAllTargetUserIdInChatStoU(storeId)
									,targetUseridsInSrcvU=
			srcvumanager.getAllTargetUserIdInChatSrcvU(storeId);
		int len2=targetUseridsInStoU.size();
			//list1 add list2 no repeat
			for(int i=0;i<len2;i++) {
				long oneTarget=targetUseridsInSrcvU.get(i);
				if(!targetUseridsInStoU.contains(oneTarget))
					targetUseridsInStoU.add(oneTarget);
			}
			//targetuseridsinstou has all target user ids
		targetUseridsInStoU.forEach(k->{
				User targetuser=userservice.getUser(k);
				targetUsers.add(targetuser);
				ArrayList<ChatStoU> chatsSent= 
						stoumanager.getChatStoUs(storeId, k);
				ArrayList<ChatSrcvU> chatsReceived=
						srcvumanager.getChatSrcvUs(storeId,k);
				long latestStoUChatId=
						chatsSent.get(chatsSent.size()-1).getId();
				long latestSrcvUChatId=
						chatsReceived.get(chatsReceived.size()-1).getId();
				//get latest two CR
				ChatRecord cr1=conv.toChatRecordFromString(
					latestStoUChatId, stoumanager.getLatestChatStoURecordInChatStoU(latestStoUChatId))
					,cr2=conv.toChatRecordFromString(
							latestSrcvUChatId,srcvumanager.getLatestChatSrcvURecordInChatSrcvU(latestSrcvUChatId));
				//the latest CR is sent? or received?
				if(cr1.getChatTime().after(cr2.getChatTime())) 
					crs.add(cr1);
				else
					crs.add(cr2);
		});
		result.put("targetUsers", targetUsers);
		result.put("crs", crs);
		System.err.println("getAllTargetUsersAndLatestOneMessage==>"+
				model.getJsonStringFromObject(result));
		return model.getJsonStringFromObject(result);
	}


	@Override
	public ArrayList<ChatRecord> getStoreReceivedChatRecordList(
			long storeId, long targetUserid) {
		//user->store
		User sender=userservice.getUser(targetUserid);
		Convert conv=new Convert();
		ArrayList<ChatRecord> list=new ArrayList<>();
		ArrayList<ChatSrcvU> chats=srcvumanager.getChatSrcvUs(storeId, targetUserid);
		int size=chats.size();
		ChatSrcvU chat=null;
		long id=0;
		//multi chat rows
		for(int i=0;i<size;i++) {
					chat=chats.get(i);
					id=chat.getId();
					if(i!=size-1) {//full(12CR) in chat
						ChatRecord r1=chat.getR1(),r2=chat.getR2(),r3=chat.getR3(),r4=chat.getR4(),r5=chat.getR5(),r6=chat.getR6(),r7=chat.getR7(),r8=chat.getR8(),r9=chat.getR9(),r10=chat.getR10(),r11=chat.getR11(),r12=chat.getR12();
						r1.setSender(sender);
						list.add(r1);
						r2.setSender(sender);
						list.add(r2);
						r3.setSender(sender);
						list.add(r3);
						r4.setSender(sender);
						list.add(r4);
						r5.setSender(sender);
						list.add(r5);
						r6.setSender(sender);
						list.add(r6);
						r7.setSender(sender);
						list.add(r7);
						r8.setSender(sender);
						list.add(r8);
						r9.setSender(sender);
						list.add(r9);
						r10.setSender(sender);
						list.add(r10);
						r11.setSender(sender);
						list.add(r11);
						r12.setSender(sender);
						list.add(r12);
					}else {//may be CR="" in this latest chat
						//r1 is exist
						ChatRecord r1=chat.getR1(),r2=null,r3=null,r4=null,r5=null,r6=null,r7=null,r8=null,r9=null,r10=null,r11=null,r12=null;
						r1.setSender(sender);
						list.add(r1);
						r2=chat.getR2();
						//if rn!="", add into list
						if(r2!=null) {
							r2.setSender(sender);
							list.add(r2);
							r3=chat.getR3();
						}else
							return list;
						if(r3!=null) {
							r3.setSender(sender);
							list.add(r3);
							r4=chat.getR4();
						}else
							return list;
						if(r4!=null) {
							r4.setSender(sender);
							list.add(r4);
							r5=chat.getR5();
						}else
							return list;
						if(r5!=null) {
							r5.setSender(sender);
							list.add(r5);
							r6=chat.getR6();
						}else
							return list;
						if(r6!=null) {
							r6.setSender(sender);
							list.add(r6);
							r7=chat.getR7();
						}else
							return list;
						if(r7!=null) {
							r7.setSender(sender);
							list.add(r7);
							r8=chat.getR8();
						}else
							return list;
						if(r8!=null) {
							r8.setSender(sender);
							list.add(r8);
							r9=chat.getR9();
						}else
							return list;
						if(r9!=null) {
							r9.setSender(sender);
							list.add(r9);
							r10=chat.getR10();
						}else
							return list;
						if(r10!=null) {
							r10.setSender(sender);
							list.add(r10);
							r11=chat.getR11();
						}else
							return list;
						if(r11!=null) {
							r11.setSender(sender);
							list.add(r11);
							r12=chat.getR12();
						}else
							return list;
						if(r12!=null) {
							r12.setSender(sender);
							list.add(r12);
						}
					}
		}
		System.err.println("getReceivedChatRecordListAboutTargetUser==>"+list);
		return list;
	}
	@Override
	public ArrayList<ChatRecord> getStoreSentChatRecordList(
			long storeId, long targetUserid) {
		//store->user
		Store sender=storeservice.getStore(storeId);
		Convert conv=new Convert();
		ArrayList<ChatRecord> list=new ArrayList<>();
		ArrayList<ChatStoU> chats=stoumanager.getChatStoUs(storeId, targetUserid);
		int size=chats.size();
		ChatStoU chat=null;
		long id=0;
		//multi chat rows between two users
		for(int i=0;i<size;i++) {
			chat=chats.get(i);
			id=chat.getId();
			if(i!=size-1) {//full(12CR) in chat
				ChatRecord r1=chat.getR1(),r2=chat.getR2(),r3=chat.getR3(),r4=chat.getR4(),r5=chat.getR5(),r6=chat.getR6(),r7=chat.getR7(),r8=chat.getR8(),r9=chat.getR9(),r10=chat.getR10(),r11=chat.getR11(),r12=chat.getR12();
				r1.setSender(sender);
				list.add(r1);
				r2.setSender(sender);
				list.add(r2);
				r3.setSender(sender);
				list.add(r3);
				r4.setSender(sender);
				list.add(r4);
				r5.setSender(sender);
				list.add(r5);
				r6.setSender(sender);
				list.add(r6);
				r7.setSender(sender);
				list.add(r7);
				r8.setSender(sender);
				list.add(r8);
				r9.setSender(sender);
				list.add(r9);
				r10.setSender(sender);
				list.add(r10);
				r11.setSender(sender);
				list.add(r11);
				r12.setSender(sender);
				list.add(r12);
			}else {//may be CR="" in this latest chat
				//r1 is exist
				ChatRecord r1=chat.getR1(),r2=null,r3=null,r4=null,r5=null,r6=null,r7=null,r8=null,r9=null,r10=null,r11=null,r12=null;
				r1.setSender(sender);
				list.add(r1);
				r2=chat.getR2();
				//if rn!="", add into list
				if(r2!=null) {
					r2.setSender(sender);
					list.add(r2);
					r3=chat.getR3();
				}else
					return list;
				if(r3!=null) {
					r3.setSender(sender);
					list.add(r3);
					r4=chat.getR4();
				}else
					return list;
				if(r4!=null) {
					r4.setSender(sender);
					list.add(r4);
					r5=chat.getR5();
				}else
					return list;
				if(r5!=null) {
					r5.setSender(sender);
					list.add(r5);
					r6=chat.getR6();
				}else
					return list;
				if(r6!=null) {
					r6.setSender(sender);
					list.add(r6);
					r7=chat.getR7();
				}else
					return list;
				if(r7!=null) {
					r7.setSender(sender);
					list.add(r7);
					r8=chat.getR8();
				}else
					return list;
				if(r8!=null) {
					r8.setSender(sender);
					list.add(r8);
					r9=chat.getR9();
				}else
					return list;
				if(r9!=null) {
					r9.setSender(sender);
					list.add(r9);
					r10=chat.getR10();
				}else
					return list;
				if(r10!=null) {
					r10.setSender(sender);
					list.add(r10);
					r11=chat.getR11();
				}else
					return list;
				if(r11!=null) {
					r11.setSender(sender);
					list.add(r11);
					r12=chat.getR12();
				}else
					return list;
				if(r12!=null) {
					r12.setSender(sender);
					list.add(r12);
				}
			}
		}
		return list;
		
	}

	

	


	@Override
	public String getStoreSentAndReceivedChatRecordList(
			long storeId, long targetUserid) {
		//
		Models m=new Models();
		//get all cr
		ArrayList<ChatRecord> crsent=
				this.getStoreSentChatRecordList(storeId, targetUserid)
											,crrcv=
				this.getStoreReceivedChatRecordList(storeId, targetUserid);
		//compare time, from late to early
		crsent.addAll(crrcv);
		ArrayList<ChatRecord> all=crsent;
		all.sort((a,b)->{
			return b.getChatTime().compareTo(a.getChatTime());
		});
		System.err.println("ChatForCSSService:getSentAndReceivedChatRecordList==>"+all);
		return m.getJsonStringFromObject(all);
	}


	


	@Override
	public void storeChatToUser(long storeId, long targetUserid, ChatRecord cr) {
		//
		cr.setDeletedFlag(0);
		cr.setReadFlag(0);
		//into mysql dosen't need sender
		System.err.println("storeChatToUser: CR===>"+cr);
		this.updateStoUChat(storeId, targetUserid, cr);
		this.updateUrcvSChat(targetUserid, storeId, cr);
	}


	@Override
	public void storeCleanChatAboutOneUser(long storeId, long targetUserid) {
		//store delete about user chat in two table
		ChatStoU stou=new ChatStoU();
		ChatSrcvU srcvu=new ChatSrcvU();
		stou.setUserId(targetUserid);
		stou.setStoreId(storeId);
		srcvu.setUserId(targetUserid);
		srcvu.setStoreId(storeId);
		stoumanager.deleteChatStoU(stou);
		srcvumanager.deleteChatSrcvU(srcvu);
	}

	
	
	
	public static void main(String[] args) {
		ArrayList<Object> objs=new ArrayList<>();
		User user=new User();
		user.setId(1L);
		user.setNiceName("小明");
		//可以添加子类进入列表
		objs.add(user);
	}
	@Override
	public void lookupAboutUser(long userId) {
		//
	}
	@Override
	public void lookupAboutStore(long storeId) {
		//
	}
	@Override
	public void storeLookupAboutUser(long userId) {
		//
	}
	
	
	
	
}