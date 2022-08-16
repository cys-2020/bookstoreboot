package com.cys.boot.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cys.boot.service.ShoppingCartItemService;
import com.cys.boot.service.ShoppingCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cys.boot.entity.ShoppingCartItem;

@Controller
public class ShoppingCartController {
	private HttpServletRequest hsr;
	private ShoppingCartService shoppingCartService;
	private ShoppingCartItemService	shoppingCartItemService;
	
	public ShoppingCartController(HttpServletRequest hsr, ShoppingCartService shoppingCartService,
			ShoppingCartItemService shoppingCartItemService) {
		super();
		this.hsr = hsr;
		this.shoppingCartService = shoppingCartService;
		this.shoppingCartItemService = shoppingCartItemService;
	}
	
	
	
	@RequestMapping(value="/getUserShoppingCartItemMap",
			method=RequestMethod.POST)
	@ResponseBody
	public String getUserShoppingCartItemMap() {
		ObjectMapper mapper=new ObjectMapper();
		String s=null;
		try {
			 s=mapper.writeValueAsString(
			 shoppingCartService.getUserShoppingCartItemMap(hsr)) ;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	
	
	
	@RequestMapping(value="/insertShoppingCart",
			method=RequestMethod.POST)
	@ResponseBody
	public String insertShoppingCart() {
		shoppingCartService.insertShoppingCart(1);
		return "1";
	}
	@RequestMapping(value="/insertShoppingCartItem",
			method=RequestMethod.POST)
	@ResponseBody
	public String insertShoppingCartItem() {
		ShoppingCartItem sci=new ShoppingCartItem();
		sci.setAmount(2);
		sci.setGoodId(1);
		sci.setGoodName("java");
		sci.setPrice(79.0F);
		sci.setShoppingcartId(1);
		sci.setTyp("");
		shoppingCartItemService.insertShoppingCartItem(sci);
		return "1";
	}
	@RequestMapping(value="/updateShoppingCartItem",
			method=RequestMethod.POST)
	@ResponseBody
	public String updateShoppingCartItem() {
		ShoppingCartItem sci=new ShoppingCartItem();
		sci.setId(1);
		sci.setAmount(1);
		shoppingCartItemService.updateShoppingCartItem(sci);
		return "1";
	}
	@RequestMapping(value="/deleteShoppingCartItem",
			method=RequestMethod.POST)
	@ResponseBody
	public String deleteShoppingCartItem() {
		shoppingCartItemService.deleteShoppingCartItem(1);
		return "1";
	}
	@RequestMapping(value="/getShoppingCartItemByShoppingCartId",
			method=RequestMethod.POST)
	@ResponseBody
	public String getShoppingCartItemByShoppingCartId() {
		System.err.println(new com.cys.boot.utils.CommonConvert().getHashMapFromArrayList(shoppingCartItemService. getShoppingCartItemByShoppingCartId(1)));
		return "1";
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		HashMap<Integer, Integer> map=new HashMap<>();
		map.put(1, 2);
		
		ObjectMapper mapper=new ObjectMapper();
		
		System.err.print(mapper.writeValueAsString(map));
	}
}
