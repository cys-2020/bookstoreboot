package com.cys.boot.controller;

import java.io.IOException;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cys.boot.service.SearchGoodService;
import com.cys.boot.service.SearchStoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SearchController {
	private SearchGoodService searchGoodService;
	private SearchStoreService searchStoreService;
	
	public SearchController(SearchGoodService searchGoodService, SearchStoreService searchStoreService) {
		super();
		this.searchGoodService = searchGoodService;
		this.searchStoreService = searchStoreService;
	}

	
	@RequestMapping(value="/searchGoodInAll"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public String searchGoodInAll(@RequestBody String titleKey) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		String list=
				mapper.writeValueAsString(searchGoodService.searchGoodInAll(titleKey));
		System.err.print(list);
		return list;
	}
	
	
	
	@RequestMapping(value="/searchGoodInStore"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public String searchGoodInStore(@RequestBody String json) {
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=null;
		try {
			node = mapper.readTree(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<String> keys = node.fieldNames();
		String titleKey=node.path(keys.next()).toString();
		long storeId=Long.parseLong(node.path(keys.next()).toString()) ;
		return searchGoodService.searchGoodInStore(titleKey, storeId).toString();
	}
	
	
	
	@RequestMapping(value="/searchStore"
			,method=RequestMethod.POST
			,produces = { "application/json;charset=utf-8"})
	@ResponseBody
	public String searchStore(@RequestBody String nameKey) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		String list=
				mapper.writeValueAsString(searchStoreService.searchStore(nameKey));
		System.err.print(list);
		return list;
	}
	
	
	
}

