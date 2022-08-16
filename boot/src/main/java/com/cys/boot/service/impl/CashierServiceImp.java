package com.cys.boot.service.impl;

import java.util.ArrayList;



import org.springframework.stereotype.Service;

import com.cys.boot.manager.CashierManager;
import com.cys.boot.service.CashierService;
import com.cys.boot.entity.Cashier;

/**
 *@description 
 *@author Chenyongsheng
 *@date 2022/6/23
 */
@Service
public class CashierServiceImp implements CashierService {
	private CashierManager manager;
	
	public CashierServiceImp(CashierManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public Cashier getCashier(long id) {
		//
		return manager.getCashier(id);
	}

	@Override
	public Cashier getCashierByBothId(long userId, long storeId) {
		//
		return manager.getCashierByBothId(userId, storeId);
	}

	@Override
	public ArrayList<Cashier> getCashierByStoreid(long storeId) {
		//
		return manager.getCashierByStoreid(storeId);
	}

	@Override
	public ArrayList<Cashier> getCashierByUserid(long userId) {
		//
		return manager.getCashierByUserid(userId);
	}

	@Override
	public void insertCashier(Cashier cashier) {
		//
		manager.insertCashier(cashier);
	}



	@Override
	public void deleteCashier(Cashier cashier) {
		//
		manager.deleteCashier(cashier);
	}

	@Override
	public void endforCashier(long userId, long storeId, float flowMoney)
	{
		////��ȡ��cashier����
		Cashier oldcashier=manager	.getCashierByBothId(userId, storeId);
		//�������ڸ��µ�cashier����
		Cashier cashier=new Cashier();
		cashier.setUserId(userId);
		cashier.setStoreId(storeId);
		cashier.setId(oldcashier.getId());
		//ת�Ƹ���������money
		float oldfinishedmoney=oldcashier.getFinishedMoney();
		float oldstagedmoney=oldcashier.getStagedMoney();
		cashier.setFinishedMoney(flowMoney+oldfinishedmoney);
		cashier.setStagedMoney(oldstagedmoney-flowMoney);
		manager.updateCashier(cashier);
	}

	@Override
public void payforCashier(long userId, long storeId, float flowMoney)
	{
		////��ȡ��cashier����
		Cashier oldcashier=manager	.getCashierByBothId(userId, storeId);
		Cashier cashier=new Cashier();
		cashier.setUserId(userId);
		cashier.setStoreId(storeId);
		if(oldcashier!=null) {
			//�������ڸ��µ�cashier����
			cashier.setId(oldcashier.getId());
			//��ʶ�����Ǯ�����ݴ�
			cashier.setStagedMoney(
					flowMoney+oldcashier.getStagedMoney());
			manager.updateCashier(cashier);
		}
		else{//û�����store����������
			cashier.setStagedMoney(flowMoney);
			manager.insertCashier(cashier);
		}
	}
}