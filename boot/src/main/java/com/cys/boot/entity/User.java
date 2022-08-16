package com.cys.boot.entity;

import java.util.ArrayList;
import com.cys.boot.typeNeedHandle.UserLvEnum;

/**
 *	@description User has user info
 *	@author Chenyongsheng
 * 	@date 2022/4/24
 */
public class User {
	private long id;
	private long phoneNumber;
	private String eMail;
	private String pswd;
	private String accountNumber;
	private String niceName;
	private String idNumber;
	private int baobao;
	private UserLvEnum lv;
	
	private ArrayList<Address>  addresses;
	
	public User() {
		//
		
	}
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getPswd() {
		return pswd;
	}


	public void setPswd(String pswd) {
		this.pswd = pswd;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getNiceName() {
		return niceName;
	}


	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}

	/**
	 * 
	 * @return ���֤����
	 */
	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public int getBaobao() {
		return baobao;
	}


	public void setBaobao(int baobao) {
		this.baobao = baobao;
	}



	public UserLvEnum getLv() {
		return lv;
	}
	public void setLv(UserLvEnum lv) {
		this.lv = lv;
	}
	
	
	public ArrayList<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", phoneNumber=" + phoneNumber + ", eMail=" + eMail + ", pswd=" + pswd
				+ ", accountNumber=" + accountNumber + ", niceName=" + niceName + ", idNumber=" + idNumber + ", baobao="
				+ baobao + ", addresses=" + addresses + ", lv=" + lv + "]";
	}
	
}
