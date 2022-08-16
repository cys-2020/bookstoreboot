package com.cys.boot.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cys.boot.manager.GoodManager;
import com.cys.boot.manager.GoodParamManager;
import com.cys.boot.manager.GoodPostageAboutLvManager;
import com.cys.boot.manager.SellerManager;
import com.cys.boot.manager.StoreManager;
import com.cys.boot.service.StoreService;
import com.cys.boot.typeNeedHandle.GoodSendTimeEnum;
import com.cys.boot.typeNeedHandle.GoodShippingInsuranceEnum;
import com.cys.boot.typeNeedHandle.SaleActivityEnum;
import com.cys.boot.typeNeedHandle.ShippingCompanyEnum;
import com.cys.boot.typeNeedHandle.StoreLvEnum;
import com.cys.boot.utils.Models;
import com.cys.boot.utils.ResourceHandler;
import com.cys.boot.entity.Good;
import com.cys.boot.entity.GoodParam;
import com.cys.boot.entity.GoodPostageAboutLv;
import com.cys.boot.entity.Seller;
import com.cys.boot.entity.Store;
@Service
public class StoreServiceImp implements StoreService {
	private StoreManager manager;
	private GoodManager goodmanager;
	private SellerManager sellerservice;
	private GoodPostageAboutLvManager goodpalservice;
	private GoodParamManager goodparamservice;


	public StoreServiceImp(StoreManager manager, GoodManager goodmanager, SellerManager sellerservice,
			GoodPostageAboutLvManager goodpalservice, GoodParamManager goodparamservice) {
		super();
		this.manager = manager;
		this.goodmanager = goodmanager;
		this.sellerservice = sellerservice;
		this.goodpalservice = goodpalservice;
		this.goodparamservice = goodparamservice;
	}

	@Override
	public Store getStore(long id) {
		//
		return manager.getStore(id);
	}

	@Override
	public String addStore(HttpServletRequest hsr, Store store){
		//
		Seller seller=(Seller)hsr.getSession().getAttribute("seller");
		store.setSellerId(seller.getId());
		store.setLv(StoreLvEnum.getStoreLvEnum(1));
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			store.setRegisterTime(sdf.parse(sdf.format(System.currentTimeMillis())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		manager.insertStore(store);
		seller.setStoreNumber(seller.getStoreNumber()+1);
		sellerservice.updateSeller(seller);
		return new Models().getJsonStringFromObject(store) ;
	}

	@Override
	public void updateStore(Store store) {
		//
		manager.updateStore(store);
	}


	@Override
	public ArrayList<Store> getStoreByName(String nameKey) {
		//
		return manager.getStoreByName(nameKey);
	}

	@Override
	public String getStoreBySellerId(HttpServletRequest hsr) {
		//
		Seller seller=(Seller)hsr.getSession().getAttribute("seller");
		if(seller==null) {
			return null;//user is not a seller
		}
		long sellerId=seller.getId();
		return new Models().getJsonStringFromObject(manager.getStoreBySellerId(sellerId)) ;
	}

	@Override
	public ArrayList<Long> getStoreIdBySellerId(long sellerId) {
		//
		return manager.getStoreIdBySellerId(sellerId);
	}

	@Override
	public String getStoreName(long id) {
		//
		return manager.getStoreName(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void removeStores( String json) {
		//
		ArrayList<Integer> willremovestoreids=new Models().getObjectFromJsonString(json, ArrayList.class);
		willremovestoreids.forEach(v->{
			long theid=Long.parseLong(v.toString());
			manager.deleteStore(theid);
		});
	}

	@Override
	public String getStoreAndAllGood(long id) {
		//
		Store st=manager.getStoreAndAllGood(id);
		return new Models().getJsonStringFromObject(st) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addGood(String jsons) {
		Models m=new Models();
		//0 good, 1 goodparam, 2 goodPal
		String []jsonValues=m.getValuesFromCommonJson(jsons, 6);
		System.err.println("addGood====>");
		System.err.println("goodjson "+jsonValues[0]);
		Good good=m.getObjectFromJsonString(jsonValues[0], Good.class) ;
		ArrayList<String> goodtoprefs=m.getObjectFromJsonString(jsonValues[1], ArrayList.class) ;
		ArrayList<String> goodtyps=m.getObjectFromJsonString(jsonValues[2], ArrayList.class) ;
		ArrayList<String> goodbottomrefs =m.getObjectFromJsonString(jsonValues[3], ArrayList.class) ;
		good.setTopRef(goodtoprefs);
		good.setTyps(goodtyps);
		good.setBottomRef(goodbottomrefs);
		System.err.println("completed good==>"+good);
		GoodParam gp=m.getObjectFromJsonString(jsonValues[4],GoodParam.class);
		GoodPostageAboutLv gpal=m.getObjectFromJsonString(jsonValues[5], GoodPostageAboutLv.class);
		System.err.println("gp"+gp);
		System.err.println("gpal"+gpal);
		goodmanager.insertGood(good);
		//good id got
		gp.setGoodId(good.getId());
		gpal.setGoodId(good.getId());
		goodparamservice.insertGoodParam(gp);
		goodpalservice.insertGoodPostageAboutLv(gpal);
	}

	@Override
	public String getGoodResourceAddressesAfterUpload(MultipartFile[] topRefsFiles,MultipartFile[] bottomRefsFiles,String folderName) {
		ResourceHandler rh=new ResourceHandler();
		Models m=new Models();
		ArrayList<String> topRefs=rh.getMultiPartFilePathAfterSave(topRefsFiles, folderName)
				,bottomRefs=rh.getMultiPartFilePathAfterSave(bottomRefsFiles, folderName);
		return "{\"topRefs\":"+m.getJsonStringFromObject(topRefs)+",\"bottomRefs\":"+m.getJsonStringFromObject(bottomRefs)+"}";
	}
	
}
