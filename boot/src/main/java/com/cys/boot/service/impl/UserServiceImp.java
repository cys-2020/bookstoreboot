package com.cys.boot.service.impl;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.cys.boot.manager.AddressManager;
import com.cys.boot.manager.CustomerServiceStaffManager;
import com.cys.boot.manager.SellerManager;
import com.cys.boot.manager.UserManager;
import com.cys.boot.entity.Address;
import com.cys.boot.entity.ShoppingCart;
import com.cys.boot.entity.ShoppingCartItem;
import com.cys.boot.entity.User;
import com.cys.boot.service.CustomerServiceStaffService;
import com.cys.boot.service.ShoppingCartItemService;
import com.cys.boot.service.ShoppingCartService;
import com.cys.boot.service.UserService;
import com.cys.boot.thirdpartservice.ThirdPartyVerifyService;
import com.cys.boot.utils.CommonConvert;
import com.cys.boot.utils.Convert;
import com.cys.boot.utils.Generater;
import com.cys.boot.utils.Models;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class UserServiceImp implements UserService {
	private UserManager manager;
	private SellerManager sellerservice;
	private CustomerServiceStaffManager cssservice;
	private AddressManager addressmanager;
	private ShoppingCartService scservice;
	private ShoppingCartItemService sciservice;
	private ThirdPartyVerifyService thirdservice;
	
	private User waitingRegisterUser;
	private String stagedMvc;
	


	public UserServiceImp(UserManager manager, SellerManager sellerservice, CustomerServiceStaffManager cssservice,
			AddressManager addressmanager, ShoppingCartService scservice, ShoppingCartItemService sciservice,
			ThirdPartyVerifyService thirdservice) {
		super();
		this.manager = manager;
		this.sellerservice = sellerservice;
		this.cssservice = cssservice;
		this.addressmanager = addressmanager;
		this.scservice = scservice;
		this.sciservice = sciservice;
		this.thirdservice = thirdservice;
	}

	@Override
	public User getUser(long id) {
		//handle...
		return manager.getUser(id);
	}

	@Override
	public void insertUser(User user) {
		//
		manager.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		//
		manager.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		//
		manager.deleteUser(user);
	}

	@Override
	public User getUserByPhoneNumber(long phoneNumber) {
		//
		return manager.getUserByPhoneNumber(phoneNumber);
	}


	
	public void initUserInfoIntoSession(
			HttpServletRequest hsr) {
		HttpSession session=hsr.getSession();
		User user=(User) session.getAttribute("user");
		//����sc session
		ShoppingCart sc=scservice.getShoppingCart(user.getId());
		session.setAttribute("sc", sc);
		//����sciMap session
		ArrayList<ShoppingCartItem> sciList=sciservice.
				getShoppingCartItemByShoppingCartId(sc.getId());
		HashMap<Integer, ShoppingCartItem> map=
				new CommonConvert().getHashMapFromArrayList(sciList);
		session.setAttribute("sciMap", map);
		
	}
	

	
	
	
	@Override
	public User verify(User checkedUser) {
		User user=manager.getUserByPhoneNumber(
				checkedUser.getPhoneNumber());
		if(user!=null) {
			if(user.getPswd().equals(checkedUser.getPswd())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public int login(HttpServletRequest hsr, String json,HttpServletResponse hsrp) {
		//
		ObjectMapper mapper=new ObjectMapper();
		User checkedUser=null;
		try {
			checkedUser = mapper.readValue(json, User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		User user=verify(checkedUser);
		if(user!=null){
			hsr.getSession().setAttribute("user",user);
			Cookie sessionID=new Cookie("SESSIONID", hsr.getSession().getId());
			hsrp.addCookie(sessionID);
			Cookie usernamecookie=new Cookie("phoneNumber"
					, String.valueOf(user.getPhoneNumber()));
			Cookie pswdcookie=new Cookie("pswd", user.getPswd());
			usernamecookie.setMaxAge(60*60);
			pswdcookie.setMaxAge(3600);
			hsrp.addCookie(usernamecookie);
			hsrp.addCookie(pswdcookie);
			return 1;
		}
		return 0;
	}

	@Override
	public String loginByPhoneMessage(long phoneNumber) {
		
		return thirdservice.getMessageVerifyCode(phoneNumber);
	}
	
	
	private void initUserInfoAfterRegister(User user) {
		Date date = new Date();
		SimpleDateFormat dft = new SimpleDateFormat("yyMM");
		int fourDate = Integer.parseInt(dft.format(date));
		/*
		 * Calendar date=Calendar.getInstance(); date.get(Calendar.YEAR);//--->int
		 */
		Generater gen = new Generater();
		Convert conv = new Convert();
		// insert user
		
		user.setAccountNumber(gen.getAccountNumber(fourDate, conv.getPhoneSuffix(user.getPhoneNumber(), 3)));
		user.setNiceName(gen.getNiceName());
		this.insertUser(user);
		long userId = user.getId();
		// insert user sc
		scservice.insertShoppingCart(userId);
		//insert other
		
	}

	@Override
	public String getVerifyCode() {
		//
		return new Generater().getRandomNumber(4);
	}

	@Override
	public int register1(String json) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(json, User.class);
		} catch (IOException e) {
			System.err.println("json read value err at RegisterImp:50");
		}
		if (manager.getUserByPhoneNumber(user.getPhoneNumber()) == null) {
			waitingRegisterUser = user;
			return 1;
		}
		return 0;
	}

	@Override
	public void register2() {
		//
		stagedMvc = thirdservice.getMessageVerifyCode(waitingRegisterUser.getPhoneNumber());
	}

	@Override
	public int register3(String mvc) {
		//
		if (mvc.equals(stagedMvc)) {
			this.initUserInfoAfterRegister(waitingRegisterUser);
			return 1;
		}
		return 0;
	}

	@Override
	public void realNameAuthentication(String json) {
		//
	}
	
	
	
	
	@Override
	public Address getAddress(long id) {
		//
		return addressmanager.getAddress(id);
	}

	@Override
	public ArrayList<Address> getAddressByUserId(HttpServletRequest hsr) {
		//
		return addressmanager.getAddressByUserId(((User)hsr.getSession().getAttribute("user")).getId());
	}

	@Override
	public Address addAddress(HttpServletRequest hsr,String json) {
		//into session
		Models m=new Models();
		Address a=m.getObjectFromJsonString(json, Address.class);
		a.setUserId(((User)hsr.getSession().getAttribute("user")).getId());
		((User)hsr.getSession().getAttribute("user")).getAddresses()
			.add(a);
		return a;
	}

	@Override
	public void flushAddresses(User user) {
		//
		ArrayList<Address> list=user.getAddresses();
		ArrayList<Address> oldlist=addressmanager.getAddressByUserId(user.getId());
		//update or insert      . list is quite different from oldlist, 
		//only can compare address's id
		for(int u=0;u<list.size();u++) {
			Address theNow=list.get(u);
			for(int i=0;i<oldlist.size();i++) {
				Address theOld=oldlist.get(i);
				if(theOld.equals(theNow)) {
					//exclude it, do not handle in mysql
					oldlist.remove(i);
					list.remove(u);
					//because of u is removed, next elem move to pre
					u--;
					//  i will be inited after break FOR, don't handle
					break;
				}else {
					if(theOld.getId()==theNow.getId()) {
						//need update by v
						addressmanager.updateAddress(theNow);
						oldlist.remove(i);
						list.remove(u);
						u--;
						break;
					}
				}
			}
		}
		//remanent(remaining) address in list, will be insert into myql
		//and that in oldlist, will be delete in mysql
		list.forEach(v->{
			addressmanager.insertAddress(v);
		});
		oldlist.forEach(v->{
			addressmanager.deleteAddress(v.getId());
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAddresses(HttpServletRequest hsr,String listjson) {
		Models m=new Models();
		ArrayList<Integer> list=m.getObjectFromJsonString(listjson, ArrayList.class);
		ArrayList<Long> list2=new ArrayList<>(list.size());
		list.forEach(v->{
			list2.add(Long.parseLong(v.toString()));
		});
		//into session
		ArrayList<Address> addresses=((User)hsr.getSession().getAttribute("user"))
				.getAddresses();
		int len=addresses.size();
		for(int i=0;i<len;i++) {
			if(list2.contains(addresses.get(i).getId())) {
				addresses.remove(i);
			}
		}
	}
	

	@Override
	public String getDefaultAddress(long userId) {
		//
		User user=manager.getUser(userId);
		ArrayList<Address> list=user.getAddresses();
		int len=list.size();
		String result=null;
		for(int i=0;i<len;i++) {
			Address a=list.get(i);
			if(a.getFlag()==1)
				result=a.getAddress();
		}
		return result;
	}

	

	@Override
	public void setDefaultAddress(HttpServletRequest hsr,long aid) {
		//
		ArrayList<Address> list=((User)hsr.getSession().getAttribute("user")).getAddresses();
		list.forEach(v->{
			if(v.getId()==aid)
				v.setFlag(1);
			else
				v.setFlag(0);
		});
	}

	@Override
	public void initSellerAndCssIntoSeesion(HttpServletRequest hsr) {
		//
		HttpSession session=hsr.getSession();
		long userId=((User)session.getAttribute("user")).getId();
		session.setAttribute("seller", sellerservice.getSellerByUserId(userId));
		session.setAttribute("css", cssservice.getCustomerServiceStaffByUserId(userId));
	}


	

	
}
