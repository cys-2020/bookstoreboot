package com.cys.boot.service;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cys.boot.typeNeedHandle.ChatRecord;

/**
 *	@description 
 *	@author cys(ChenYongsheng)
 * 	@date 2022/4/25
 */
public interface ChatService {
	
	void lookupAboutUser(long userId);
	void lookupAboutStore(long storeId);
	void storeLookupAboutUser(long userId);
	/**
	 * get all target user and the 
	 * latest message(CR)(maybe user sent or received
	 * ,need to compare chat record's date time ) in chat index
	 * @param hsr
	 * @return json[{target1:(),latestmessage1:()},{t2:(),lm2()}].
	 */
	String getAllTargetUsersAndLatestOneMessage(
			HttpServletRequest hsr);
	String getAllTargetStoresAndLatestOneMessage(
			HttpServletRequest hsr);
	String getAllTargetUsersAndLatestOneMessageInOneStore(
			long storeId);
	
	
	
	/**
	 * get after-merge CR list that user sent to and received 
	 * from one target user.
	 * @param hsr
	 * @param targetUserid
	 * @return [cr1,cr2,cr3...]
	 */
	String getSentAndReceivedChatRecordListAboutTargetUser(
			HttpServletRequest hsr,long targetUserid);
	String getSentAndReceivedChatRecordListAboutTargetStore(
			HttpServletRequest hsr,long targetStoreid);
	String getStoreSentAndReceivedChatRecordList(
			long storeId,long targetUserid);
	
	
	
	
	/**
	 * get all chat records user received from a targetUser
	 * @param hsr
	 * @param targetUserid
	 * @return CR list in chats user received from a target user
	 * @author Chenyongsheng
	 */
	ArrayList<ChatRecord> getReceivedChatRecordListAboutTargetUser(
			HttpServletRequest hsr,long targetUserid);
	ArrayList<ChatRecord> getReceivedChatRecordListAboutTargetStore(
			HttpServletRequest hsr,long targetStoreid);
	ArrayList<ChatRecord> getStoreReceivedChatRecordList(
			long storeId,long targetUserid);
	
	
	
	
	
	/**
	 * get all chat records user sent to a targetUser
	 * @param hsr
	 * @param targetUserid
	 * @return CR list in chats user sent to a target user
	 * @author Chenyongsheng
	 */
	ArrayList<ChatRecord> getSentChatRecordListAboutTargetUser(
			HttpServletRequest hsr,long targetUserid);
	ArrayList<ChatRecord> getSentChatRecordListAboutTargetStore(
			HttpServletRequest hsr,long targetStoreid);
	ArrayList<ChatRecord> getStoreSentChatRecordList(
			long storeId,long targetUserid);
	
	
	
	
	
	
	
	void chatToUser(
			HttpServletRequest hsr,long targetUserid,ChatRecord cr);
	void chatToStore(
			HttpServletRequest hsr,long targetStoreid,ChatRecord cr);
	void storeChatToUser(
			long storeId,long targetUserid,ChatRecord cr);
	
	
	
	
	
	

	
	
	
	/**
	 * delete user's all chats about target user 
	 * @param hsr
	 * @param targetUserid
	 */
	void cleanChatAboutTargetUser(
			HttpServletRequest hsr,long targetUserid);
	/**
	 * delete user's all chats about target store
	 * @param hsr
	 * @param targetStoreid
	 */
	void cleanChatAboutTargetStore(
			HttpServletRequest hsr,long targetStoreid);
	
	void storeCleanChatAboutOneUser(long storeId,long targetUserid);
	
}