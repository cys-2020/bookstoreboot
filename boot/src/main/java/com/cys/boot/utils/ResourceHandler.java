package com.cys.boot.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;

import com.cys.boot.otherType.enums.FilePathEnum;
import com.cys.boot.typeNeedHandle.ChatRecord;

public class ResourceHandler {
	/**
	 * MF[]->refs String list, 
	 * @param mf
	 * @param path folder name you need order
	 * @return arraylist(refs)
	 */
	public ArrayList<String> getMultiPartFilePathAfterSave(
			MultipartFile[] mf,String folderName){
		ArrayList<String> rs=new ArrayList<>();
		int filecounter=0;
		for(MultipartFile v:mf) {
			//get file name
			String oldFileName = v.getOriginalFilename();
			//file name suffix
			String fileNameSuffix=oldFileName.substring(oldFileName.lastIndexOf("."));
			//re name(1,2,3,... .jpg)
			String reFileName=filecounter+fileNameSuffix;
			//random filename
			String niceFileName=new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+reFileName;
			//get direct path prefix(root path,  const)
			String targetFilePathPrefix="D:\\java\\workspace\\bootResources\\";
			String targetFilePath =folderName+"\\" +niceFileName;
			File dest = new File(targetFilePathPrefix+ targetFilePath);
			//filepath is exist?
			if (!dest.getParentFile().exists()) {
				//if filepath is not exist, make
				dest.getParentFile().mkdirs();
			}
			try {
				v.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			//filename len=20, but foldername len is uncertain
			//sum max=20+20=40, 9 imgs=360B in mysql cell
			rs.add(targetFilePath);
			filecounter++;
		}
		return rs;
	}
	@SuppressWarnings("unchecked")
	/**
	 * produce a CR and save resources into a path
	 * @param files
	 * @param textsJson
	 * @param chatTime
	 * @param path
	 * @return
	 */
	public ChatRecord resolveAndSaveChatMultipart(MultipartFile[] files,
		String textsJson,String chatTime,String folderName) {
		//textsJson{"0":"t1","3":"t2"}	
				Models model=new Models();
				ChatRecord cr=new ChatRecord();
				int filesLen=files.length;
				System.err.println("文件个数："+filesLen);
				StringBuffer sb=new StringBuffer();
				for(int i=0;i<filesLen;i++) {
					sb.append(files[i].getOriginalFilename()+"     ");
				}
				System.err.println("分别为："+sb.toString());
				/*   Handle Textsmap (original key is "0", not 0)*/
				HashMap<String,String>textsStrMap=model.getObjectFromJsonString(
								textsJson, HashMap.class);
				int textsLen=textsStrMap.size();
				HashMap<Integer, String> refsMap=
						new HashMap<>(filesLen),
						textsMap=new HashMap<>(textsLen);
				textsStrMap.forEach((k,v)->{
					textsMap.put(Integer.parseInt(k), v);
					try {//decode utf8
						v=new String(v.getBytes("ISO-8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				});
				Set<Integer> textsKeys =textsMap.keySet();
				
				/*   Handle Refsmap*/
				ArrayList<String> pathListSaved=this.getMultiPartFilePathAfterSave(files, folderName);
				Iterator<String> iter=pathListSaved.iterator();
				//put refs by keys(except keys in textsMap)
				int totalLen=filesLen+textsLen;
				for(int i=0;i<totalLen;i++) {
						//if it is not belong to texts keys, it is refs' key
					if(!textsKeys.contains(i)) {
						refsMap.put(i, iter.next());
					}
				}
				/*   Handle ChatTime*/
				SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
				/* OK,  Handle CR, then chatservice*/
				cr.setChatRefs(refsMap);
				cr.setChatText(textsMap);
				try {
					cr.setChatTime(sdf.parse(chatTime));
				} catch (ParseException e) {
					e.printStackTrace();
				}
		System.err.println("ResourceHandler.resolveAndSaveChatMultipart===>"+cr);
		return cr;
	}
	
	
	
	
	
	
	
	public byte[] getResourceByte(String relativePath) {
		String p=FilePathEnum.MEDIA_RESOURCES_PATH.getValue().getValue()+relativePath;
		System.err.println("ResourceHandler.getRB==>"+p);
		InputStream fis=null;
		byte[] bs=new byte[2*1024*1024];// < 2MB
		try {
			fis = new FileInputStream(new File(p));
			fis.read(bs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bs;
	}
	
}
