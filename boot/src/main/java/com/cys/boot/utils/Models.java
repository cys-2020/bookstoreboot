package com.cys.boot.utils;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *@description some repeated methods' models
 *@author Chenyongsheng
 *@date 2022/7/4
 */
public class Models {
	/**
	 * 
	 * @param <T> any class
	 * @param json must be a string can map to a(only) obj.
	 * @param c obj's class
	 * @return mapped(finishly) obj
	 */
	public  <T> T getObjectFromJsonString(
			String json,Class<T> c) {
		T obj=null;
		ObjectMapper mapper=new ObjectMapper();
		try {
			obj=mapper.readValue(json, c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	
	/**
	 * get json string from obj
	 * @param obj only one obj
	 * @return
	 */
	public String getJsonStringFromObject(Object obj) {
		ObjectMapper mapper=new ObjectMapper();
		String s="";
		try {
			s=mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * input a json(common k:v, can't map to be **one** exist obj)
	 *  and get its values(k:v==>v)
	 * @param json common k:v (multi)like {k1:v1, k2:v2}
	 * @param number how many values(k:v==>v) you need
	 * @return values Arr(v==>String)
	 */
	public String[] getValuesFromCommonJson(String json,
			int number){
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		try {
			node = mapper.readTree(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<String> keys = node.fieldNames();
		String[]valueArr=new String[number];
		for(int i=0;i<number;i++) {
			valueArr[i]=node.path(keys.next()).toString();
		}
		return valueArr;
	}
	

}
