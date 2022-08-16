package com.cys.boot.utils;

import java.util.Random;

/**
 *@description include some methods for all kinds of 
 *(id)number(need random) generation.
 *@author Chenyongsheng
 *@date 2022/5/23
 */
public class Generater {
	public String getRandomString(int len,int phone3) {
		String phone=String.valueOf(phone3);
		StringBuffer sb=new StringBuffer();
		Random r=new Random();
		for(int i=0;i<len;i++) {
			if(i==1)
			sb.append(phone.charAt(0));
			if(i==3)
			sb.append(phone.charAt(1));
			if(i==5)
			sb.append(phone.charAt(2));
			sb.append(r.nextInt(10));
			}
		return sb.toString();
	}
	/**
	 * generate account number(unique key) by given Y&M(int like 2205)
	 * and Last 3 digits of user's phone number.
	 * @param yearandmonth 2205==>2022-05
	 * @param phone3 LAST 3
	 * @return unique number String
	 * @author Chenyongsheng
	 */
	public String getAccountNumber(int yearandmonth,int phone3) {
		StringBuffer sb=new StringBuffer();
		sb.append("ssm"+yearandmonth)
			.append(getRandomString(5, phone3));
		return sb.toString();
	}
	
	/**
	 * generate order number(unique key) by given Y&M(int like 2205)
	 * and Last 3 digits of user's phone number.
	 * @param yearandmonth 2205==>2022-05
	 * @param phone3 LAST 3
	 * @return unique order_number String
	 * @author Chenyongsheng
	 */
	public String getOrderNumber(int yearandmonth,int phone3) {
		StringBuffer sb=new StringBuffer();
		sb.append(yearandmonth)
			.append(getRandomString(12, phone3));
		return sb.toString();
	}
	/**
	 * generate pay_number(unique key) by given Y&M(int like 202205)
	 * and Suffix 3 digits of user's phone number.
	 * @param yearandmonth 202205==>2022-05
	 * @param phone3 LAST 3
	 * @return unique pay_number String
	 * @author Chenyongsheng
	 */
	public String getPayNumber(int yearandmonth,int phone3) {
		StringBuffer sb=new StringBuffer();
		sb.append(yearandmonth)
			.append(getRandomString(18, phone3));
		return sb.toString();
	}
	/**
	 * generate refund_number(unique key) by given Y&M(int like 202205)
	 * and Suffix 3 digits of user's phone number.
	 * @param yearandmonth 202205==>2022-05
	 * @param phone3 LAST 3
	 * @return unique pay_number String
	 * @author Chenyongsheng
	 */
	public String getRefundNumber(int yearandmonth,int phone3) {
		StringBuffer sb=new StringBuffer();
		sb.append(yearandmonth)
			.append(getRandomString(11, phone3));
		return sb.toString();
	}
	/**
	 * generate verify code
	 * @param len vc length
	 * @return vc string
	 */
	public String getRandomNumber(int len) {
		Random r=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<len;i++) {
			sb.append(r.nextInt());
		}
		return sb.toString();
	}
	
	public String getNiceName() {
		//可爱 的 小老虎
		String [] 
				s1= {"可爱","靓丽","快乐","奇葩","伟大","卑微","憨憨",
						"呆呆","爱哭"},
				s2= {"小老虎","小奶狗","大沙雕","大老鼠","臭猴子",
						"小熊熊","小牛牛","癞皮狗","树墩子"};
		StringBuffer sb=new StringBuffer();
		Random r=new Random();
		return sb.append(s1[r.nextInt(9)]).append("的")
				.append(s2[r.nextInt(9)]).toString();
				
		
	}
	
	/**
	 * generate a random int as hashmap's key
	 * , range in keyfrom->keyto(not include keyto)
	 * @param keyfrom
	 * @param keyto 
	 * @return random key(try until avail)
	 */
	public int getAvailKeyForHashMap(int keyfrom,int keyto) {
		Random r=new Random();
		return keyfrom==0 ? r.nextInt(keyto) 
				:r.nextInt(keyto)+keyfrom;
	}
	
	
	public int getSubstringAmountFromString(String string,
			String substring) {
		if(!string.contains(substring)) {
			return 0;
		}
		String divideString=string.substring(
				string.indexOf(substring)+substring.length());
		return 1+this.getSubstringAmountFromString(divideString
				, substring);
	}
	
	public int getSubstringAmountFromString1(String string,
			String substring) {
		if(!string.contains(substring)) {
			return 0;
		}
		int counter=0;
		while(string.contains(substring)) {
			/*string=sb.delete(0,sb.indexOf(substring)+substring.length()).toString();
			be sub*/
			string=string.substring(string.indexOf(substring)+
					substring.length());
			counter++;
		}
		return counter;
	}
	public static void main(String[] args) {
		Generater g=new Generater();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<5000;i++) {
			sb.append("3");
		}
		String s=sb.toString();
		/**/
		double start1=System.currentTimeMillis();
		System.err.println(g.getSubstringAmountFromString(s, "3"));
		System.err.println("递归用时："+(System.currentTimeMillis()-start1));
		double start2=System.currentTimeMillis();
		System.err.println(g.getSubstringAmountFromString1(s, "3"));
		System.err.println("循环用时："+(System.currentTimeMillis()-start2));
	}
}
