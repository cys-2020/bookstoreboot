package com.cys.boot.service.impl;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.service.CashierService;
import com.cys.boot.service.DealEvidenceService;
import com.cys.boot.service.GoodService;
import com.cys.boot.service.OrderformService;
import com.cys.boot.service.StatusForBothUserAndSeller;
import com.cys.boot.service.StatusService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cys.boot.entity.DealEvidence;
import com.cys.boot.entity.Good;
import com.cys.boot.entity.Orderform;
import com.cys.boot.entity.User;
import com.cys.boot.utils.*;
@Service
@StatusForBothUserAndSeller
public class StatusServiceImp implements StatusService {
	private OrderformService orderformservice;
	private DealEvidenceService deservice;
	private GoodService goodservice;
	private CashierService cashierservice;
	
	@Autowired
	public void setOrderformservice(OrderformService orderformservice) {
		this.orderformservice = orderformservice;
	}
	@Autowired
	public void setDeservice(DealEvidenceService deservice) {
		this.deservice = deservice;
	}
	@Autowired
	public void setGoodservice(GoodService goodservice) {
		this.goodservice = goodservice;
	}
	@Autowired
	public void setCashierservice(CashierService cashierservice) {
		this.cashierservice = cashierservice;
	}

	@Override
	public long newOrderform(String jsonstr,HttpServletRequest req) {
/*			{"de":{"goodId":1,"goodType":"","goodAmount":2},
"order":{"postage":6.0,"shippingInsurance":1,"invoice":1,
"finalMoney":79.0,"createTime":"2022-06-29"}}*/
		User user=(User) req.getSession().getAttribute("user");
		Generater ge=new Generater();
		Convert cv=new Convert();
		ObjectMapper mapper = new ObjectMapper();
		ObjectMapper demapper = new ObjectMapper(),
				orderformmapper=new ObjectMapper();
		JsonNode node=null;
		try {
			node = mapper.readTree(jsonstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<String> keys = node.fieldNames();
		String dejson=keys.next();//����1��{gooditem���ֶ�..}
		String orderformjson=keys.next();//����2��{orderform���ֶ�..}
		 /*JsonNode childnode1=mapper.readTree(gooditem);
		 Iterator<String> childkey1 = childnode1.fieldNames();
		 JsonNode childnode2=mapper.readTree(orderform);
		 Iterator<String> childkey2 = childnode2.fieldNames();
		 */
		DealEvidence de=null;
		Orderform orderform=null;
		try {
			de=demapper
				 .readValue(node.path(dejson).toString(), DealEvidence.class);
			 orderform=orderformmapper
				 .readValue(node.path(orderformjson).toString(), Orderform.class);
			 }
		catch(Exception e) {
			 e.printStackTrace();
		}
		//填充de对象（除了id,amount,type，都自己查good）
		Good good=goodservice
				.getGood(de.getGoodId());
		de.setGoodTitle(good.getTitle());
		de.setTopRef(good.getTopRef().get(0));
		de.setBottomRef(good.getBottomRef());
		de.setGoodParam(good.getParam().toString());
		deservice.insertDealEvidence(de);
		long deid=de.getId();
		long userId=user.getId();
		//long userid=(Long)session.getAttribute("userid");
		orderform.setUserId(userId);
		//����order_number
		orderform.setOrderformNumber(ge
				.getOrderNumber(cv.getYM(orderform.getCreateTime().toString()),
						cv.getPhoneSuffix(user.getPhoneNumber(), 3)));
		//����pay_number
		orderform.setPayNumber(ge
			.getPayNumber(cv.getYM(orderform.getCreateTime().toString()),
					cv.getPhoneSuffix(user.getPhoneNumber(), 3)));
		//����deal_point
		orderform.setDealPoint(Orderform.getDealPoint(
				orderform.getFinalMoney()-orderform.getPostage()));
		//����de_id��status
		orderform.setDeId(deid);
		orderform.setOrderformStatus(0);
		System.err.println("neworderform收到的orderform->"+orderform);
		orderformservice.insertOrderform(orderform);
		//����order_id
		return orderform.getId();
	}

	@Override
	public void endOrderform(String json) {
		//�����¶�������status
		Orderform orderform=new Models().
				getObjectFromJsonString(json, Orderform.class);
		orderform.setOrderformStatus(3);
		orderformservice.updateOrderform(orderform);
		//ͨ����֪id��ȡ�ö�������
		Orderform oldorderform=orderformservice
				.getOrderform(orderform.getId());
		//��ȡ�ö�����final_money��Ϊ����������money
		float finishedMoney=oldorderform.getFinalMoney();
		long deId=oldorderform.getDeId();
		long userId=oldorderform.getUserId();
		long storeId=goodservice.getStoreid(
			(deservice.getDealEvidence(deId)).getGoodId());
		
		cashierservice.endforCashier(userId, storeId, finishedMoney);
	}
	@Override
	public void cancelOrderform(long id) {
		//
		Orderform o=new Orderform();
		o.setId(id);
		o.setOrderformStatus(-2);
		orderformservice.updateOrderform(o);
	}
	
	
	public static void main(String[]args) throws 
		JsonParseException, JsonMappingException, IOException {
		//ǰ��json�ַ���
		//String json="[{\"u\":1},{\"t\":2},{\"p1\":1}]";
		String json= "{\"username\":\"zhangsan\",\"�Ա�\":\"��\",\"company\":{\"companyName\":\"�л�\",\"address\":\"����\"},\"cars\":[\"����\",\"����\"]}"; 
		ObjectMapper mapper=new ObjectMapper();
		
		//ӳ��Ϊ���pojo
		//Orderform o=mapper.readValue(json, Orderform.class);
		JsonNode rootNode = mapper.readTree(json);
        Iterator<String> keys = rootNode.fieldNames();
        System.out.println(rootNode.path(keys.next()));
        /*while(keys.hasNext()){
            String fieldName = keys.next();
            System.out.println(fieldName + ": " + rootNode.path(fieldName).toString());
        }*/
        //JsonNode ----> JSON
		
	}
}
