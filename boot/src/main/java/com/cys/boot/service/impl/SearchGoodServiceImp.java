package com.cys.boot.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cys.boot.service.GoodService;
import com.cys.boot.service.SearchGoodService;
import com.cys.boot.entity.Good;
@Service
public class SearchGoodServiceImp implements SearchGoodService {
	private GoodService goodService;
	@Autowired
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	@Override
	public ArrayList<Good> searchGoodInStore(String titleKey, long storeId) {
		//
		return goodService.getGoodByNameInStore(titleKey, storeId);
	}

	@Override
	public ArrayList<Good> searchGoodInAll(String titleKey) {
		//
		return goodService.getGoodByName(titleKey);
		//�����б�
	}

}
