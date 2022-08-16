package com.cys.boot.aop;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import com.cys.boot.entity.Address;
import com.cys.boot.entity.Orderform;
import com.cys.boot.service.ChatService;
import com.cys.boot.service.DealEvidenceService;
import com.cys.boot.service.GoodService;
import com.cys.boot.service.OrderformService;
import com.cys.boot.service.StoreService;
import com.cys.boot.service.UserService;
import com.cys.boot.typeNeedHandle.ChatRecord;
import com.cys.boot.utils.Models;

/**
 *@description if user finish cashier, these methods will exe
 *@author Chenyongsheng
 *@date 
 */
@Service
@Aspect
public class PayListener {
	private UserService userservice;
	private StoreService storeservice;
	private DealEvidenceService deservice;
	private GoodService goodservice;
	private OrderformService orderformservice;
	private ChatService chatservice;
	
		public PayListener(UserService userservice, StoreService storeservice, DealEvidenceService deservice,
			GoodService goodservice, OrderformService orderformservice, ChatService chatservice) {
		super();
		this.userservice = userservice;
		this.storeservice = storeservice;
		this.deservice = deservice;
		this.goodservice = goodservice;
		this.orderformservice = orderformservice;
		this.chatservice = chatservice;
	}
		@Pointcut("execution(* com.cys.boot.service.StatusForUserService.payForOrderform(String)) "
					+ "&&args(json)")
		public void point(String json) {}
		@AfterReturning("point(String) && args(json)")
		public void storeChatToUserAfterPaying(String json) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Models m=new Models();
			Orderform jsonorderform=m.getObjectFromJsonString(json, Orderform.class);
			//completed orderform
			Orderform o=orderformservice.getOrderform(jsonorderform.getId());
			long storeId=goodservice.getStoreid(deservice.getDealEvidence(o.getDeId()).getGoodId());
			ChatRecord cr=new ChatRecord();
			HashMap<Integer, String> texts=new HashMap<>(),
					refs=new HashMap<>();
			Address a =userservice.getAddress(o.getAddress());
			texts.put(0, "亲，请核对订单信息~~");
			texts.put(2, o.getDe().getGoodTitle()+"共"+o.getDe().getGoodAmount()+"件宝贝，合计￥"+o.getFinalMoney()+"\r\n姓名："+a.getWho()+"\r\n电话："+String.valueOf(a.getPhoneNumber())+"\r\n地址："+a.getAddress());
			//top ref
			refs.put(1, o.getDe().getTopRef());
			cr.setSender(storeservice.getStore(storeId));
			cr.setChatText(texts);
			cr.setChatRefs(refs);
			try {
				cr.setChatTime(sdf.parse(sdf.format(System.currentTimeMillis())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			chatservice.storeChatToUser(storeId,o.getUserId(),cr);
		}
		
		
		
		public static void main(String[] args) throws ParseException {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.err.println(sdf.format(sdf.parse(sdf.format(System.currentTimeMillis()))) );
			
		}
}
