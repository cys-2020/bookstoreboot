package com.cys.boot.service;

import java.util.ArrayList;
import com.cys.boot.entity.Cashier;
/**
 *@description deal money between user and store
 *@author Chenyongsheng
 *@date 2022/5/27
 */
public interface CashierService {
	Cashier getCashier(long id);
	/**
	 * select one cashier note by userid and storeid
	 * @param userId 
	 * @param storeId
	 * @return a Cashier obj
	 * @author Chenyongsheng
	 */
	Cashier getCashierByBothId(long userId,long storeId);
	/**
	 * select all cashier notes about given store(id)
	 * @param storeId
	 * @return all cashier obj(list) about given store(all deals)
	 * @author Chenyongsheng
	 */
	ArrayList<Cashier> getCashierByStoreid(long storeId);
	/**
	 * select all cashier notes about given user(id)
	 * @param userId
	 * @return all cashier obj(list) about user(in all store)
	 * @author Chenyongsheng
	 */
	ArrayList<Cashier> getCashierByUserid(long userId);
	void insertCashier(Cashier cashier);
	/**
	 * update one cashier's flow money,userid and storeid are used to
	 * get one cashier.
	 * @param userId 
	 * @param storeId
	 * @param flowMoney money need to transfer from staged_money 
	 * to finished_money.
	 * @author Chenyongsheng
	 */
	void endforCashier(long userId,long storeId,float flowMoney);
	/**
	 * update one cashier's flow money,userid and storeid are used to
	 * get one cashier.
	 * @param userId
	 * @param storeId
	 * @param flowMoney money which will be increm into staged_money
	 * @author Chenyongsheng
	 */
	void payforCashier(long userId,long storeId,float flowMoney);
	void deleteCashier(Cashier cashier);
}
