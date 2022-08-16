package com.cys.boot.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.cys.boot.typeNeedHandle.ChatRecord;

/**
 *	@description 该工具类包含数据结构转换
 *	@author cys(ChenYongsheng)
 * 	@date 2022/5/5
 */
public class Convert {
	/**
	 * a string splitted by &&  converts into a ArrayList
	 * @param s A string splitted by &&
	 * @return A list without &&
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> toArrayListFromString(String s){
		return  (ArrayList<String>) new CommonConvert()
				.convertArrayToArrayList(s.split("&&"));
	}
	/**
	 * a ArrayList converts into a string splitted by &&
	 * @param l ArrayList including string items
	 * @return A string splitted by &&
	 */
	public String toStringFromArrayList(ArrayList<String> l) {
		StringBuffer sb=new StringBuffer();
		int len=l.size();
		for(int i=0;i<len;i++) {
			sb.append(l.get(i)+"&&");
		}
		String s=sb.toString();
		return s.substring(0,s.length()-2);
	}
	/**
	 * ChatRecord--> "t[[   ]]tr[[   ]]rd[[   rf[[   df[["
	 * @param cr A ChatRecord will be converted
	 * @return A final string will be into table
	 */
	public String toStringFromChatRecord(ChatRecord cr) {
		StringBuffer sb=new StringBuffer();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateandflags="d[["+sdf.format(cr.getChatTime())+"rf[["+cr.getReadFlag()+"df[["+cr.getDeletedFlag();//必备的
		HashMap<Integer, String> ts=cr.getChatText();
		HashMap<Integer, String> rs=cr.getChatRefs();
		//when chatRecord include Text.
		if(ts!=null) {
			if(rs==null) {//no ref, only one text
				ts.forEach((k,v)->{
					sb.append("t[["+v+"]]t");
				});
			}else {
				int totalKeysLen=ts.size()+rs.size();
				for(int i=0;i<totalKeysLen;i++) {
					//if i(key)->text, else->ref
					if(ts.get(i)!=null) {
						sb.append("t[["+ts.get(i)+"]]t");
					}else {//  i(key)->ref
						sb.append("r[["+rs.get(i)+"]]r");
					}
				}
			}
		}else {//when chatRecord has only refs
			rs.forEach((k,v)->{
				sb.append("r[["+v+"]]r");
			});
		}
		sb.append(dateandflags);
		return sb.toString();
	}
	/**
	 * t[[]]tr[[]]rd[[rf[[  -->  CR.
	 * CR has both texts and refs, when text+refs or refs+text 
	 * or refs+refs, (each)map's key(id) changes (+1),  and
	 *	their keys(total) are used to be a id(**orderby**).
	 * @param id Id(line number in table) of this Record
	 * @param s A string in t_chat rN
	 * @return A ChatRecord obj
	 * @throws ParseException 
	 */
	public ChatRecord toChatRecordFromString(
			long id,String s) {
		if(s.equals("")) {
			return null;
		}
		ChatRecord cr=new ChatRecord();
		HashMap<Integer, String> ts=new HashMap<>()
				,rs=new HashMap<>();
		int dateBegin=s.indexOf("d[[");
		int readFlagBegin=s.indexOf("rf[[");
		int deletedFlagBegin=s.indexOf("df[[");
		cr.setId(id);
		//str==>date
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		try {
			cr.setChatTime(sdf.parse(
					s.substring(dateBegin+3,readFlagBegin)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cr.setReadFlag(Integer.parseInt(
				s.substring(readFlagBegin+4,deletedFlagBegin)));
		cr.setDeletedFlag(Integer.parseInt(
				s.substring(deletedFlagBegin+4)));
		String content=s.substring(0,s.indexOf("d[["));
		System.err.println("Convert.toChatRecordFromString: CR内容==>"+content);
		System.err.println("Convert.toChatRecordFromString: CRd[[==>"+s.substring(dateBegin+3,readFlagBegin));
		System.err.println("Convert.toChatRecordFromString: CRrf[[==>"+s.substring(readFlagBegin+4,deletedFlagBegin));
		System.err.println("Convert.toChatRecordFromString: CRdf[[==>"+s.substring(deletedFlagBegin+4));
		
		int flagLen="t[[".length();
		
		if(content.contains("t[[")) {
			//both text and refs****************
			if(content.contains("r[[")) {
				int counter=0;
				//content(t or a) is remanent
				while(content.length()!=0) {
					//first flag is t[[
					if(content.substring(0,flagLen).equals("t[[")) {
						ts.put(counter,content.substring(flagLen ,
								content.indexOf("]]t")));
						//kill first t[[ ]]t, next get new t[[ or r[[ at index(0)
						content=content.substring(
								content.indexOf("]]t")+flagLen);
					}else {
						rs.put(counter, content.substring(flagLen ,
								content.indexOf("]]r")));
						//kill first r[[ ]]r, next get new t[[ or r[[ at index(0)
						content=content.substring(
								content.indexOf("]]r")+flagLen);
					}
					counter++;
				}
				cr.setChatText(ts);
				cr.setChatRefs(rs);
			}else {//only t[[, (only <one> t[[........)
				cr.setChatRefs(null);
				//only (0:text)
				ts.put(0, content.substring(
						flagLen,content.length()-flagLen));
				cr.setChatText(ts);
			}
		//only refs	 r[[  ]]rr[[  ]]r
		}else {
			cr.setChatText(null);
			int counter=0;
			//if the last ]]r is killed, content.len=0("")
			while(content.length()!=0) {
				rs.put(counter, content.substring(
						flagLen,content.indexOf("]]r")));
				content=content.substring(
						content.indexOf("]]r")+flagLen);
				counter++;
			}
			cr.setChatRefs(rs);
		}
		return cr;
	}
	/**
	 * get year(2) and month(2) int like 2205 
	 * @param time a string like "Mon Jul 04 18:16:59 GMT+08:00 2022"
	 * @return ym like 2207(int)
	 * @author Chenyongsheng
	 */
	public int getYM(String time) {
		HashMap<String, String> map=new HashMap<>();
		map.put("Jan","01");map.put("Feb","02");map.put("Mar","03");map.put("Apr","04");map.put("May","05");map.put("Jun","06");map.put("Jul","07");map.put("Aug","08");map.put("Sep","09");map.put("Oct","10");map.put("Nov","11");map.put("Dec","12");
		String year=time.substring(32,34);
		String month=map.get(time.substring(4,7));
		return Integer.parseInt(year+month);
	}
	/**
	 * get phone's suffix(len)
	 * @param phone user's phone
	 * @param suffixLen len you need
	 * @return suffix(len)
	 * @author Chenyongsheng
	 */
	public int getPhoneSuffix(long phone,int suffixLen) {
		String s1=String.valueOf(phone);
		String s2=s1.substring(11-suffixLen);
		return Integer.parseInt(s2);
	}
	
	/*public String reg(MultipartFile file) throws IOException {
        String result = "";
        String filename = file.getOriginalFilename();
        File save = new File(System.getProperty("user.dir")+"\\"+filename);
        if (!save.exists()){
            save.createNewFile();
        }
        file.transferTo(save);
        String cmd = String.format("tesseract %s stdout -l %s",System.getProperty("user.dir")+"\\"+filename,"chi_sim");
        result = cmd(cmd);
        return result;
    }*/
	 public String cmd(String cmd) {
	        BufferedReader br = null;
	        Process p=null;
			try {
				p = Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				//
				e.printStackTrace();
			}
	        br = new BufferedReader(
	            		new InputStreamReader(p.getInputStream()));
	        String line = null;
	        StringBuilder sb = new StringBuilder();
	        try {
				while ((line = br.readLine()) != null) 
				        sb.append(line + "\n");
			} catch (IOException e) {
				//
				e.printStackTrace();
			}
	        
	        return null;
	 }
	
	
	
	public static void main(String[] args) throws ParseException {
		
		String s="2022-07-30 23:46:46";
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		//String==>Date
		Date date=sdf.parse(s);
		//Date==>String
		
		String dateStr=sdf.format(date);
		Convert con=new Convert();
		ChatRecord cr=new ChatRecord();
		HashMap<Integer, String> texts=new HashMap<>()
				,refs=new HashMap<>();
		texts.put(0, "文本消息");
		refs.put(1, "ref1");
		refs.put(2, "ref2");
		texts.put(3, "文本信息2");
		cr.setChatText(texts);
		cr.setChatRefs(refs);
		cr.setDeletedFlag(0);
		cr.setReadFlag(0);
		cr.setChatTime(date);
		System.err.println(con.toStringFromChatRecord(cr));
		
		
		String crstr="t[[hhh]]tr[[ref1]]rt[[jjj]]tr[[ref2]]rd[[2022-07-31 00:28:00rf[[0df[[0";
		System.err.println(con.toChatRecordFromString(1, crstr));
		
		
	}
}
