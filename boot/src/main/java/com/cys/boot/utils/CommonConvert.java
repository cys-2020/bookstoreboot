package com.cys.boot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *	@description ͨ�����ݸ�ʽת��
 *	@author cys(ChenYongsheng)
 * 	@date 2022/5/5
 */
public class CommonConvert {
	public ArrayList<? extends Object> convertArrayToArrayList(Object[] arr){
		ArrayList<Object> list=new ArrayList<>();
		int len=arr.length;
		for(int i=0;i<len;i++) {
			list.add(arr[i]);
		}
		return list;
	}
	
	
	/**
	 * lastest item should be first(0) in list(stack top)
	 * @param stack top is lastest
	 * @return list first(0) elem is lastest
	 * @author Chenyongsheng
	 */
	public <T> ArrayList<T> getArrayListFromStack(Stack<T> stack){
		int len=stack.size();
		ArrayList<T> list=new ArrayList<>(len);
		for(int i=0;i<len;i++) {
			list.add(stack.pop());
		}
		return list;
	}
	/**
	 * stack top should be lastest
	 * @param list ArrayList which first(0) elem is lastest
	 * @return stack lastest elem is at top
	 * @author Chenyongsheng
	 */
	public <T> Stack<T> getStackFromArrayListMinToMax
																			(ArrayList<T> list){
		int len=list.size();
		Stack<T> stack=new Stack<>();
		for(int i=len-1;i>=0;i--) {
			stack.push(list.get(i));
		}
		return stack;
	}
	
	
	/**
	 * stack top should be lastest
	 * @param list ArrayList which first(0) elem is oldest
	 * @return stack lastest elem is at top
	 * @author Chenyongsheng
	 */
	public <T> Stack<T> getStackFromArrayListMaxToMin
																			(ArrayList<T> list){
		int len=list.size();
		Stack<T> stack=new Stack<>();
		for(int i=0;i<len;i++) {
			stack.push(list.get(i));
		}
		return stack;
	}
	
	
	public <T> HashMap<Integer, T> getHashMapFromArrayList(
			ArrayList<T> list){
		HashMap<Integer, T> map=new HashMap<>();
		int len=list.size();
		for(int i=0;i<len;i++) {
			map.put(i, list.get(i));
		}
		return map;
	}
	
	
	public static void main(String[]args) {
		
	}
}
