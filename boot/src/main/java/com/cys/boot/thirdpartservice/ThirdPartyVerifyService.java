package com.cys.boot.thirdpartservice;

public interface ThirdPartyVerifyService {
	/**
	 * dispatch third party api(send verify code to phonenumber) and
	 * get this verify which will be used to check. 
	 * @param phoneNumber
	 * @return third party verify code they returned
	 * @author Chenyongsheng
	 */
	String getMessageVerifyCode(long phoneNumber);
	
	
	
}
