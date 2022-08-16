package com.cys.boot.controller;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cys.boot.entity.User;
import com.cys.boot.service.ChatService;
import com.cys.boot.utils.Models;
import com.cys.boot.utils.ResourceHandler;
@RestController
public class ChatController {
	private ChatService cs;
	private HttpServletRequest hsr;
	
	public ChatController(ChatService cs, HttpServletRequest hsr) {
		super();
		this.cs = cs;
		this.hsr = hsr;
	}
	@PostMapping("/chatToUser")
	public void chatToUser (@RequestPart("files") MultipartFile[] files,
            @RequestPart("texts") String textsJson,
            @RequestPart("targetUserid") long targetUserid,
            @RequestPart("chatTime") String chatTime) {
		cs.chatToUser(hsr, targetUserid, new ResourceHandler()
				.resolveAndSaveChatMultipart(
						files, textsJson, chatTime, "chat\\userToUser\\"+((User)hsr.getSession().getAttribute("user")).getId()+"\\"+targetUserid));
	}
	@PostMapping("/chatToStore")
	public void chatToStore(@RequestPart("files") MultipartFile[] files,
            @RequestPart("texts") String textsJson,
            @RequestPart("targetStoreid") long targetStoreid,
            @RequestPart("chatTime") String chatTime) {
		cs.chatToStore(hsr, targetStoreid, new ResourceHandler()
				.resolveAndSaveChatMultipart(
						files, textsJson, chatTime, "chat\\userToStore\\"+((User)hsr.getSession().getAttribute("user")).getId()+"\\"+targetStoreid));
	}
	@PostMapping("/storeChatToUser")
	public void storeChatToUser(@RequestPart("files") MultipartFile[] files,
            @RequestPart("texts") String textsJson,
            @RequestPart("storeId") long storeId,
            @RequestPart("targetUserid") long targetUserid,
            @RequestPart("chatTime") String chatTime) {
		cs.storeChatToUser(storeId, targetUserid, 
				new ResourceHandler().resolveAndSaveChatMultipart(
						files, textsJson, chatTime, "chat\\storeToUser\\"+storeId+"\\"+targetUserid));
	}
		
	
	
	
	
	
	@PostMapping("/getTargetsAndLatestMessageUserToUser")
	public String getTargetsAndLatestMessageUserToUser() {
		return cs.getAllTargetUsersAndLatestOneMessage(hsr);
	}
	@PostMapping("/getTargetsAndLatestMessageUserToStore")
	public String getTargetsAndLatestMessageUserToStore() {
		return cs.getAllTargetStoresAndLatestOneMessage(hsr);
	}
	@PostMapping("/getTargetsAndLatestMessageStoreToUser")
	public String getTargetsAndLatestMessageStoreToUser() {
		return cs.getAllTargetStoresAndLatestOneMessage(hsr);
	}
	
	
	
	@PostMapping("/getAllChatRecordUserToUser")
	public String getUserSentAndReceivedChatRecordList(
			@RequestParam("targetUserid") long targetUserid) {
		return cs.getSentAndReceivedChatRecordListAboutTargetUser(hsr, targetUserid);
	}
	@PostMapping("/getAllChatRecordUserToStore")
	public String getAllChatRecordUserToStore(
			@RequestParam("targetStoreid") long targetStoreid) {
		return cs.getSentAndReceivedChatRecordListAboutTargetStore(hsr, targetStoreid);
	}
	@PostMapping("/getAllChatRecordStoreToUser")
	public String getAllChatRecordStoreToUser(
			@RequestParam("storeId") long storeId,
			@RequestParam("targetUserid") long targetUserid) {
		return cs.getStoreSentAndReceivedChatRecordList(storeId, targetUserid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String map="{\"0\":\"t1\",\"3\":\"t2\"}";
		HashMap<Integer, String> good=new HashMap<>();
		good.put(0, "hhh");
		HashMap<Integer,String> hm= 
				new Models().getObjectFromJsonString(map, HashMap.class);
		//but key is only string, not integer
		System.err.println(hm.get("0"));
		
		
		String strmap=new Models().getJsonStringFromObject(good);
		System.err.println(new Models().getJsonStringFromObject(strmap));
	}
}
