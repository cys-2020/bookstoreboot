package com.cys.boot.typeNeedHandle;

import java.util.ArrayList;

import java.util.HashMap;

import com.cys.boot.entity.GoodPostageAboutLv;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * @description different company has different areasMAPlv(
 * get from this enum's methods)
 * @author ChenYongsheng
 * @date 2022/7/21
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ShippingCompanyEnum {
	SF(1,"顺丰快递"),EMS(2,"中国邮政"),YTO(3,"圆通速递"),
	ZTO(4,"中通快递"),STO(5,"申通快递"),YUNDA(6,"韵达快递");
	private int code;
	private String name;
	private ShippingCompanyEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
	@JsonCreator
	public static ShippingCompanyEnum getShippingCompanyEnum(
			int code) {
		switch(code) {
		case 1:return SF;
		case 2:return EMS;
		case 3:return YTO;
		case 4:return ZTO;
		case 5:return STO;
		default: return YUNDA;
		}
	}
	/**
	 * get postage by ordering a shippingTo address.
	 * @param postageMAPlv good.getPAL
	 * @param shpTo user.getAdd
	 * @param com good.getCom
	 * @return linked(lian dong de) postage
	 */
	public static float getPostage(GoodPostageAboutLv
			postageMAPlv,String shpTo
			,ShippingCompanyEnum com) {
		switch(com) {
			case SF:{
				HashMap<Integer,ArrayList<String>> areaMAPlv=
					ShippingCompanyEnum.getPostageClassOfSF();
				if(areaMAPlv.get(1).contains(shpTo)) {//cheap=lv1
					return postageMAPlv.getLv1();
				}else if(areaMAPlv.get(2).contains(shpTo)) {//lv2
					return postageMAPlv.getLv2();
				}else return postageMAPlv.getLv3();//lv3
			}
			case EMS:{
				HashMap<Integer,ArrayList<String>> areaMAPlv=
					ShippingCompanyEnum.getPostageClassOfEMS();
					if(areaMAPlv.get(1).contains(shpTo)) {//cheap=lv1
						return postageMAPlv.getLv1();
					}else if(areaMAPlv.get(2).contains(shpTo)) {//lv2
						return postageMAPlv.getLv2();
					}else return postageMAPlv.getLv3();//lv3
			}
			case YTO:{
				HashMap<Integer,ArrayList<String>> areaMAPlv=
					ShippingCompanyEnum.getPostageClassOfYTO();
					if(areaMAPlv.get(1).contains(shpTo)) {//cheap=lv1
						return postageMAPlv.getLv1();
					}else if(areaMAPlv.get(2).contains(shpTo)) {//lv2
						return postageMAPlv.getLv2();
					}else return postageMAPlv.getLv3();//lv3
			}
			case ZTO:{
				HashMap<Integer,ArrayList<String>> areaMAPlv=
					ShippingCompanyEnum.getPostageClassOfZTO();
					if(areaMAPlv.get(1).contains(shpTo)) {//cheap=lv1
						return postageMAPlv.getLv1();
					}else if(areaMAPlv.get(2).contains(shpTo)) {//lv2
						return postageMAPlv.getLv2();
					}else return postageMAPlv.getLv3();//lv3
			}
			case STO:{
				HashMap<Integer,ArrayList<String>> areaMAPlv=
					ShippingCompanyEnum.getPostageClassOfSTO();
					if(areaMAPlv.get(1).contains(shpTo)) {//cheap=lv1
						return postageMAPlv.getLv1();
					}else if(areaMAPlv.get(2).contains(shpTo)) {//lv2
						return postageMAPlv.getLv2();
					}else return postageMAPlv.getLv3();//lv3
			}
			default :{
				HashMap<Integer,ArrayList<String>> areaMAPlv=
				ShippingCompanyEnum.getPostageClassOfYUNDA();
					if(areaMAPlv.get(1).contains(shpTo)) {//cheap=lv1
						return postageMAPlv.getLv1();
					}else if(areaMAPlv.get(2).contains(shpTo)) {//lv2
						return postageMAPlv.getLv2();
					}else return postageMAPlv.getLv3();//lv3
			}
		}
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public static HashMap<Integer,ArrayList<String>> 
						getPostageClassOfSF(){
		HashMap<Integer,ArrayList<String>> lvMapAreas
				=new HashMap<>();
		//lv1(cheap
		ArrayList<String> chAreas=new ArrayList<>(5);
		chAreas.add("江苏省");chAreas.add("浙江省");
		chAreas.add("上海市");chAreas.add("广东省");
		//lv2(expensive
		ArrayList<String> exAreas=new ArrayList<>(5);
		exAreas.add("新疆维吾尔族自治区");
		exAreas.add("西藏自治区");
		//default lv3......
		lvMapAreas.put(1, chAreas);
		lvMapAreas.put(2, exAreas);
		return lvMapAreas;
	}
	public static HashMap<Integer,ArrayList<String>> 
		getPostageClassOfEMS(){
		HashMap<Integer,ArrayList<String>> lvMapAreas
				=new HashMap<>();
		//lv1(cheap
		ArrayList<String> chAreas=new ArrayList<>(5);
		chAreas.add("江苏省");chAreas.add("浙江省");
		chAreas.add("上海市");chAreas.add("广东省");
		//lv2(expensive
		ArrayList<String> exAreas=new ArrayList<>(5);
		exAreas.add("新疆维吾尔族自治区");
		exAreas.add("西藏自治区");
		//default lv3......
		lvMapAreas.put(1, chAreas);
		lvMapAreas.put(2, exAreas);
		return lvMapAreas;
	}
	public static HashMap<Integer,ArrayList<String>> 
		getPostageClassOfYTO(){
		HashMap<Integer,ArrayList<String>> lvMapAreas
				=new HashMap<>();
		//lv1(cheap
		ArrayList<String> chAreas=new ArrayList<>(5);
		chAreas.add("江苏省");chAreas.add("浙江省");
		chAreas.add("上海市");chAreas.add("广东省");
		//lv2(expensive
		ArrayList<String> exAreas=new ArrayList<>(5);
		exAreas.add("新疆维吾尔族自治区");
		exAreas.add("西藏自治区");
		//default lv3......
		lvMapAreas.put(1, chAreas);
		lvMapAreas.put(2, exAreas);
		return lvMapAreas;
	}
	public static HashMap<Integer,ArrayList<String>> 
		getPostageClassOfZTO(){
		HashMap<Integer,ArrayList<String>> lvMapAreas
				=new HashMap<>();
		//lv1(cheap
		ArrayList<String> chAreas=new ArrayList<>(5);
		chAreas.add("江苏省");chAreas.add("浙江省");
		chAreas.add("上海市");chAreas.add("广东省");
		//lv2(expensive
		ArrayList<String> exAreas=new ArrayList<>(5);
		exAreas.add("新疆维吾尔族自治区");
		exAreas.add("西藏自治区");
		//default lv3......
		lvMapAreas.put(1, chAreas);
		lvMapAreas.put(2, exAreas);
		return lvMapAreas;
	}
	public static HashMap<Integer,ArrayList<String>> 
	getPostageClassOfSTO(){
		HashMap<Integer,ArrayList<String>> lvMapAreas
				=new HashMap<>();
		//lv1(cheap
		ArrayList<String> chAreas=new ArrayList<>(5);
		chAreas.add("江苏省");chAreas.add("浙江省");
		chAreas.add("上海市");chAreas.add("广东省");
		//lv2(expensive
		ArrayList<String> exAreas=new ArrayList<>(5);
		exAreas.add("新疆维吾尔族自治区");
		exAreas.add("西藏自治区");
		//default lv3......
		lvMapAreas.put(1, chAreas);
		lvMapAreas.put(2, exAreas);
		return lvMapAreas;
	}
	public static HashMap<Integer,ArrayList<String>>  getPostageClassOfYUNDA(){
		HashMap<Integer,ArrayList<String>> lvMapAreas
				=new HashMap<>();
		//lv1(cheap
		ArrayList<String> chAreas=new ArrayList<>(5);
		chAreas.add("江苏省");chAreas.add("浙江省");
		chAreas.add("上海市");chAreas.add("广东省");
		//lv2(expensive
		ArrayList<String> exAreas=new ArrayList<>(5);
		exAreas.add("新疆维吾尔族自治区");
		exAreas.add("西藏自治区");
		//default lv3......
		lvMapAreas.put(1, chAreas);
		lvMapAreas.put(2, exAreas);
		return lvMapAreas;
	}
	
}
